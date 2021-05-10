# OpenAPI Example

This project has three components.
* Backend Service
* Backend Client
* API Gateway

## Backend Service

The Backend API has a simple API for testing which includes OpenAPI annoations. Run this command from the root of that that project to regenerate the OpenAPI JSON.

```
./gradlew clean generateOpenApiDocs
```

The command above generates an OpeAPI specification here: $projectDir/src/main/resources/static/docs/

## Backend Client

The interfaces in the backend client are generated from the openapi.json created above. It assumes the backend services project was committed to Git. 
Gradle downloads the OpenAPI JSON file from here: 
     https://raw.githubusercontent.com/smitchell/OpenAPIExample/main/backend-service/src/main/resources/static/docs/openapi.json
     
Run this command to re-generate the API interfaces:
```
./gradlew clean openApiGenerate
```

It uses this configuration to do the generation:
```
openApiGenerate {
    generatorName = "spring"
    inputSpec = "$buildDir/backend-service-api.json".toString()
    outputDir = "$projectDir".toString()
    configOptions = [
            useOptional          : "true",
            swaggerDocketConfig  : "false",
            performBeanValidation: "false",
            useBeanValidation    : "false",
            useTags              : "true",
            singleContentTypes   : "true",
            groupId             : "com.example",
            basePackage          : "com.example.backend.client",
            configPackage        : "com.example.backend.client",
            title                : rootProject.name,
            java8                : "false",
            dateLibrary          : "java8",
            serializableModel    : "true",
            artifactId           : rootProject.name,
            apiPackage           : "com.example.backend.client.api",
            modelPackage         : "com.example.backend.client.model",
            invokerPackage       : "com.example.backend.client.api",
            interfaceOnly        : "true"
    ]
}
```

## API Gateway

The API Gateway includes the backend client in its Gradle dependencies, and since we aren't publishing the project to a maven repository, it must be in our local Maven repository.

```
implementation 'com.example:backend-client:1.0'

```

CONFESSION - I wasn't able to get the backend client to publish itself to my local maven repository using Gradle, so I cheated and used the generated pom.xml file.
Running "mvn clean install" made the dependency available to the API Gateway locally.

Finally, use the backend client to implement a rest controller for the gateway.

```
@RestController
public class GatewayController implements NoteApi {
    private static final String BASE_URL = "http://localhost:8080";
    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> getVersion() {
        return restTemplate.getForEntity(BASE_URL.concat("/version"), String.class);
    }

    public ResponseEntity<Note> addNote(@RequestBody(description="The note to be created.", required = true) final Note note) {
        Note aNote = restTemplate.postForObject(BASE_URL.concat("/note"), note, Note.class);
        return new ResponseEntity<>(aNote, HttpStatus.OK);
    }
```    
