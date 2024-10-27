package com.health.model;

public class Patient {
    private int id;
    private String name;
    private String age;

    // Constructors, getters, and setters
    public Patient(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAge() { return age; }
}
