package ru.mirea.task8.visitor;

public class Adult implements Patient{
    @Override
    public void acceptDoctor(Doctor doctor) {
        doctor.treatAdult(this);
    }
}
