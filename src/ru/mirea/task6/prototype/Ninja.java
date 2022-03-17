package ru.mirea.task6.prototype;

public class Ninja {
    protected int strength;
    protected int power;
    protected int speed;


    public Ninja clone() {
        return new Ninja(strength, power, speed);
    }

    public Ninja(int strength, int power, int speed) {
        this.strength = strength;
        this.power = power;
        this.speed = speed;
    }
}

