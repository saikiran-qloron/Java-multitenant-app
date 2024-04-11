package com.project.multitenant.Enities;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @Column(name = "name", updatable = false, nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}