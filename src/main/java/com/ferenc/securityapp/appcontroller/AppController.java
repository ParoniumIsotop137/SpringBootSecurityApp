package com.ferenc.securityapp.appcontroller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partszekhaz")
public class AppController {
    @GetMapping
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok("Üdvözöljük a pártszékházban!");
    }
}
