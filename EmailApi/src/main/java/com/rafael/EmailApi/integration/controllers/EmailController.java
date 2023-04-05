package com.rafael.EmailApi.integration.controllers;

import com.rafael.EmailApi.domain.dtos.EmailDTO;
import com.rafael.EmailApi.domain.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    private ResponseEntity<?> postEmail(@RequestBody EmailDTO emailDTO) {
        emailService.send(emailDTO);
        return ResponseEntity.ok().body(null);
    }

}
