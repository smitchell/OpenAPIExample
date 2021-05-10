package com.example.gateway.controller;

import com.example.backend.client.api.NoteApi;
import com.example.backend.client.model.Note;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

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

    public ResponseEntity<Note> getNote(
            @Parameter(description = "${doc.NoteController.getNote.id}", required = true)
            @PathVariable("id") String id) {
        return restTemplate.getForEntity(BASE_URL.concat("/note/").concat(id), Note.class);
    }

    public ResponseEntity<Void> deleteNote(
            @Parameter(description = "${doc.NoteController.deleteNote.id}", required = true)
            @PathVariable String id) {
        restTemplate.delete(BASE_URL.concat("/note/").concat(id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
