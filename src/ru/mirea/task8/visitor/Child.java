package ru.mirea.task8.visitor;

public class Child implements Patient{
    @Override
    public void acceptDoctor(Doctor doctor) {
        doctor.treatChild(this);
    }
}
