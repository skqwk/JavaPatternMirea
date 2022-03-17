package ru.mirea.task6.builder;

public class TestHouseBuilder {
    public static void main(String[] args) {
        House hat = new HatBuilder(new House())
                .buildDoors(2)
                .buildEntrance(3)
                .buildWalls(4)
                .getResult();
    }
}
