package ru.mirea.task8.visitor;

public class Teenager implements Patient{
    @Override
    public void acceptDoctor(Doctor doctor) {
        doctor.treatTeenager(this);
    }
}
