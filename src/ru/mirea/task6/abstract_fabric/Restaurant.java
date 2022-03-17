package ru.mirea.task6.abstract_fabric;

import java.util.Scanner;

public class Restaurant {
    AbstractCuisine cuisine;

    public Restaurant(AbstractCuisine cuisine) {
        this.cuisine = cuisine;

        System.out.println("Напиток: " + cuisine.getDrink());
        System.out.println("Второе: " + cuisine.getSoup());
        System.out.println("Мясное: " + cuisine.getMeatDish());
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractCuisine cuisine;
        String capital = sc.nextLine();
        switch (capital) {
            case "Киев":
                cuisine = new UkrainianCuisine();
                break;
            case "Москва":
                cuisine = new RussianCuisine();
                break;
            default:
                cuisine = new UkrainianCuisine();
                break;
        }
        new Restaurant(cuisine);
    }
}
