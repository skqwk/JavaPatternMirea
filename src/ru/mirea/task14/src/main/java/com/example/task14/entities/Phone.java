package com.example.task14.entities;

public class Phone {
    private String name;
    private String creationYear;
    private Long id;

    public Phone(String name, String creationYear, Long id) {
        this.id = id;
        this.name = name;
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public String getCreationYear() {
        return creationYear;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationYear(String creationYear) {
        this.creationYear = creationYear;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
