package com.example.task14.entities;

public class Manufacture {
    private String name;
    private String address;
    private Long id;

    public Manufacture(String name, String address, Long id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }
}
