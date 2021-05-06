package com.example.backendservice.docs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
public class OpenAPIDocumentationTest {

    MockMvc mockMvc;

    @BeforeEach
    public void setup(final WebApplicationContext webApplicationContext,
                      final RestDocumentationContextProvider restDocumentation) {
        if (mockMvc == null) {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                    .apply(documentationConfiguration(restDocumentation))
                    .build();
        }
    }

    @Test
    public void writeSwaggerJson() throws Exception {
        String outputDir = System.getProperty("openapi.outputDir", "./build/openapi");
        String json = mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/v3/api-docs")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (Writer writer = Files.newBufferedWriter(Paths.get(outputDir, "openapi.json"))) {
            writer.write(json);
        }
    }

    @Test
    public void getSwaggerHtml() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/swagger-ui/index.html?configUrl=/v3/api-docs"))
                .andExpect(status().isOk());
    }
}
