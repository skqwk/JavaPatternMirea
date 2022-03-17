package ru.mirea.task6.abstract_fabric;

public class UkrainianCuisine extends AbstractCuisine{
    @Override
    public Drink getDrink() {
        return new Gorilka();
    }

    @Override
    public Soup getSoup() {
        return new Okroshka();
    }

    @Override
    public MeatDish getMeatDish() {
        return new Salo();
    }
}
