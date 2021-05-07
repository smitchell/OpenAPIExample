/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.backend.client;

import com.milan.example.backend.client.model.Note;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Api(value = "note", description = "the note API")
public interface NoteApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /note
     * Adds a new Note.
     *
     * @param note The note to be created. (required)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "addNote", notes = "Adds a new Note.", response = Note.class, tags={ "note", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Note.class) })
    @PostMapping(
        value = "/note",
        produces = { "*/*" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Note> addNote(@ApiParam(value = "The note to be created." ,required=true )  @Valid @RequestBody Note note) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                    String exampleString = "{ \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "*/*", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /note/{id}
     * Deletes a note by id.
     *
     * @param id The UUID of the note to delete. (required)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "deleteNote", notes = "Deletes a note by id.", tags={ "note", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @DeleteMapping(
        value = "/note/{id}"
    )
    default ResponseEntity<Void> deleteNote(@ApiParam(value = "The UUID of the note to delete.",required=true) @PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /note/{id}
     * Retrives a note by id.
     *
     * @param id The UUID of the note to retrieve. (required)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "getNote", notes = "Retrives a note by id.", response = Note.class, tags={ "note", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Note.class) })
    @GetMapping(
        value = "/note/{id}",
        produces = { "*/*" }
    )
    default ResponseEntity<Note> getNote(@ApiParam(value = "The UUID of the note to retrieve.",required=true) @PathVariable("id") String id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                    String exampleString = "{ \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "*/*", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}