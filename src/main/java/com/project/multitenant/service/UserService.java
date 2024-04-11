package com.project.multitenant.service;

import com.project.multitenant.Enities.User;
import com.project.multitenant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EntityManager entityManager;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public Optional<User> getByName(String name) {
        return repository.findById(name);
    }

    public Iterable<User> getAll() {
        return repository.findAll();
    }

    public String save(User u){
        repository.save(u);
        return "User saved in db";
    }

}
