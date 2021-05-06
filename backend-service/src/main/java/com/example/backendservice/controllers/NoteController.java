package com.example.backendservice.controllers;

import com.example.backendservice.models.Note;
import com.example.backendservice.repositories.NoteRepository;

import java.util.Optional;
import java.util.UUID;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@OpenAPIDefinition(
        info = @Info(
                title = "Notes REST API",
                version = "1.0",
                description = "${doc.NoteController.description}",
        contact = @Contact(
                name = "${doc.NoteController.contact.name}",
                url = "${doc.NoteController.contact.url}",
                email = "${doc.NoteController.contact.email}"
        ))
)
@Tag(name = "note", description = "Note API")
@RestController
public class NoteController {
        private final NoteRepository noteRepository;

        @Autowired
        public NoteController(final NoteRepository noteRepository) {
                this.noteRepository = noteRepository;
        }

        @Operation(
                description = "${doc.NoteController.getVersion.description}"
        )
        @GetMapping("/api/version")
        public String getVersion() {
                return "v1.0";
        }

        @Operation(
                description = "${doc.NoteController.addNote.description}"
        )
        @PostMapping("/api/note")
        public Note addNote(@RequestBody(description="The note to be created.", required = true) final Note note) {
                note.setId(UUID.randomUUID().toString());
                return noteRepository.save(note);
        }

        @Operation(
                description = "${doc.NoteController.getNote.description}"
        )
        @GetMapping("/api/note/{id}")
        public Note getNote(
                @Parameter(description = "${doc.NoteController.getNote.id}", required = true)
                @PathVariable("id") String id) {
                Optional<Note> result = noteRepository.findById(id);
                if (result.isPresent()) {
                        return result.get();
                }
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                );
        }

        @Operation(
                description = "${doc.NoteController.deleteNote.description}"
        )
        @DeleteMapping("/api/note/{id}")
        public void deleteNote(
                @Parameter(description = "${doc.NoteController.deleteNote.id}", required = true)
                @PathVariable String id) {
                Optional<Note> match = noteRepository.findById(id);
                match.ifPresent(noteRepository::delete);
        }
}
