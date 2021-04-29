package com.example.backendservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
public class SmokeTest {
    @Autowired
    NoteController noteController;

    @Test
    void testContextLoads() {
        assertThat(noteController, is(notNullValue()));
    }
}
