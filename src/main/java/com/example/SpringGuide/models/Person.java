package com.example.SpringGuide.models;

import lombok.Data;

import javax.annotation.security.DenyAll;

/**
 * @author Yauheni Minchanka
 * 9/19/22
 */
@Data
public class Person {
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}