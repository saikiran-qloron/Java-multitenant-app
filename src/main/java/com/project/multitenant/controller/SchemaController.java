package com.project.multitenant.controller;

import com.project.multitenant.Enities.SchemaDTO;
import com.project.multitenant.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/schema")
public class SchemaController {
    @Autowired
    private SchemaService service;

    @PostMapping("/createSchema")
    public ResponseEntity<?> createNewSchema(@RequestBody SchemaDTO schemaDTO) throws IOException {
        return ResponseEntity.ok(service.createSchema(schemaDTO));
    }

}
