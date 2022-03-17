package com.example.task12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Task12Application implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        SpringApplication.run(Task12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //--in="C:\C++ вывод\in.txt" --out="C:\C++ вывод\out.txt"
    }
}
