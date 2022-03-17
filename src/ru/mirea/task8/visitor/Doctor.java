package ru.mirea.task8.visitor;

public class Doctor {
    void treatChild(Child child) {
        System.out.println("Doctor treat child");
    }

    void treatTeenager(Teenager teenager) {
        System.out.println("Doctor treat teenager");
    }

    void treatAdult(Adult adult) {
        System.out.println("Doctor treat adult");
    }
 }
