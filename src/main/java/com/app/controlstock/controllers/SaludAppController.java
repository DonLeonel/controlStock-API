package com.app.controlstock.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludAppController {
    @GetMapping("/ping")
    public String pong(){
        return "Pong";
    }
}
