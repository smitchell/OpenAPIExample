package com.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/noteApi/version")
    public String getVersion() {
//        NoteApi noteApi = NoteApi();
        return "1.0";
    }
}
