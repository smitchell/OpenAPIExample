package com.example.backendservice.repositories;

import com.example.backendservice.models.Note;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.Optional;
import java.util.UUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DataJpaTest
public class NoteRepositoryTest {

    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private NoteRepository noteRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource, is(notNullValue()));
        assertThat(jdbcTemplate, is(notNullValue()));
        assertThat(entityManager, is(notNullValue()));
        assertThat(noteRepository, is(notNullValue()));
    }

    @Test
    void testAddNote() {
        final Note note = new Note();
        note.setId(UUID.randomUUID().toString());
        note.setName(RandomStringUtils.random(25, true, false));
        note.setDescription("Now is the time for all good men to come to the aid of their country.");
        final Note savedNote = noteRepository.save(note);
        assertThat(savedNote, is(notNullValue()));

        final Optional<Note> fetched = noteRepository.findById(note.getId());
        assertThat(fetched.isPresent(), is(true));
    }

    @Test
    void testGetNote() {
        final Note note = new Note();
        note.setId(UUID.randomUUID().toString());
        note.setName(RandomStringUtils.random(25, true, false));
        note.setDescription("Now is the time for all good men to come to the aid of their country.");
        final Note savedNote = noteRepository.save(note);
        assertThat(savedNote, is(notNullValue()));

        final Optional<Note> fetched = noteRepository.findById(note.getId());
        assertThat(fetched.isPresent(), is(true));

        Note theNote = fetched.get();
        assertThat(theNote.getId(), is(equalTo(note.getId())));
        assertThat(theNote.getName(), is(equalTo(note.getName())));
        assertThat(theNote.getDescription(), is(equalTo(note.getDescription())));
    }

    @Test
    void testDeleteNote() {
        String id = UUID.randomUUID().toString();
        final Note note = new Note();
        note.setId(id);
        note.setName(RandomStringUtils.random(25, true, false));
        note.setDescription("Now is the time for all good men to come to the aid of their country.");
        final Note savedNote = noteRepository.save(note);
        assertThat(savedNote, is(notNullValue()));

        Optional<Note> fetched = noteRepository.findById(id);
        assertThat(fetched.isPresent(), is(true));

        noteRepository.delete(note);
        fetched = noteRepository.findById(id);
        assertThat(fetched.isPresent(), is(false));
    }

}
