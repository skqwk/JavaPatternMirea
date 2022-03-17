package com.example.task13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student {
    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.lastname}")
    private String lastname;

    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    public void postConstruct() {
        System.out.println(name + " " + lastname + " " + group);
    }

}
