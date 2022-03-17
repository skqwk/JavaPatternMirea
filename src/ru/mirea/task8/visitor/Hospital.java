package ru.mirea.task8.visitor;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    public Hospital() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Teenager());
        patients.add(new Child());
        patients.add(new Adult());
        patients.add(new Teenager());
        patients.add(new Adult());
        patients.add(new Teenager());
        patients.add(new Child());
        patients.add(new Adult());
        patients.add(new Child());

        Doctor doctor = new Doctor();
        for (Patient p : patients) p.acceptDoctor(doctor);
    }

    public static void main(String[] args) {
        new Hospital();
    }
}
