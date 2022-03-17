package ru.mirea.task6.abstract_fabric;

public class RussianCuisine extends AbstractCuisine{
    @Override
    public Drink getDrink() {
        return new Kvass();
    }

    @Override
    public Soup getSoup() {
        return new Borsch();
    }

    @Override
    public MeatDish getMeatDish() {
        return new Shashlik();
    }
}
