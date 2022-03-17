package ru.mirea.task6.prototype;

public class KokaRu extends Ninja{
    private int manna;

    public KokaRu(int strength, int power, int speed, int manna) {
        super(strength, power, speed);
        this.manna = manna;
    }


    @Override
    public Ninja clone() {
        return new KokaRu(super.strength, super.power, super.speed, manna);
    }

    @Override
    public String toString() {
        return "KokaRu{" +
                "manna=" + manna +
                ", strength=" + strength +
                ", power=" + power +
                ", speed=" + speed +
                '}';
    }
}
