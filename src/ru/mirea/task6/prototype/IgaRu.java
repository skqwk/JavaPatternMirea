package ru.mirea.task6.prototype;

public class IgaRu extends Ninja{
    private int lucky;

    public IgaRu(int strength, int power, int speed, int lucky) {
        super(strength, power, speed);
        this.lucky = lucky;
    }


    @Override
    public Ninja clone() {
        return new IgaRu(super.strength, super.power, super.speed, lucky);
    }

    @Override
    public String toString() {
        return "IgaRu{" +
                "lucky=" + lucky +
                ", strength=" + strength +
                ", power=" + power +
                ", speed=" + speed +
                '}';
    }
}
