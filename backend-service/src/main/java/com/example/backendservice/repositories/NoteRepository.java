package com.example.backendservice.repositories;

import com.example.backendservice.models.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends CrudRepository<Note, String> {

    Optional<Note> findByName(String name);

}
