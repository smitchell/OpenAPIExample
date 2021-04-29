package com.example.backendservice.controllers;

import com.example.backendservice.models.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
public class NoteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NoteController noteController;

    @Test
    void versionShouldReturnVersionOne() throws Exception {
        when(noteController.getVersion()).thenReturn("V1.0");
        this.mockMvc.perform(get("/api/version"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("V1.0")));
    }

    @Test
    void addNoteShouldReturnTheAddedNote() throws Exception {
        String id = UUID.randomUUID().toString();
        final Note note = new Note();
        note.setId(id);
        note.setName(RandomStringUtils.random(25, true, false));
        note.setDescription("Now is the time for all good men to come to the aid of their country.");

        when(noteController.addNote(note)).thenReturn(note);
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(post("/api/note")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(note)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());;
    }

    @Test
    void getNoteShouldReturnTheNote() throws Exception {
        String id = UUID.randomUUID().toString();
        final Note note = new Note();
        note.setId(id);
        note.setName(RandomStringUtils.random(25, true, false));
        note.setDescription("Now is the time for all good men to come to the aid of their country.");
        when(noteController.getNote(id)).thenReturn(note);
        this.mockMvc.perform(get("/api/note/" + id))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());;
    }

}
