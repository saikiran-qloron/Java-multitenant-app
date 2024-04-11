package com.project.multitenant.controller;

import com.project.multitenant.Enities.User;
import com.project.multitenant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return service.getAll();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody String name){
        User u = new User();

        u.setName(name);
        return ResponseEntity.ok(service.save(u));
    }

}
