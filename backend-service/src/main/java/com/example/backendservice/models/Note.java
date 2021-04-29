package com.example.backendservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Note implements Serializable {
    @Id
    private String id;

    @Column(unique = true) private String name;
    private String description;

    public Note() {
        this(null);
    }

    /**
     * Creates a new note instance.
     * @param id the note unique id to set
     */
    public Note(String id) {
        this.setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
