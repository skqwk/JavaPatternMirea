package ru.mirea.task6.builder;

import java.util.ArrayList;

public class HatBuilder implements HouseBuilder{
    private House house;

    public HatBuilder(House house) {
        this.house = house;
    }


    @Override
    public HouseBuilder buildEntrance(int amountEntrance) {
        ArrayList<Entrance> entrances = new ArrayList<>(amountEntrance);
        for (Entrance e : entrances) e = new Entrance();
        house.setEntrance(entrances);
        return this;
    }

    @Override
    public HouseBuilder buildWindows(int amountWindows) {
        ArrayList<Window> windows = new ArrayList<>(amountWindows);
        for (Window w : windows) w = new Window();
        house.setWindows(windows);
        return this;
    }

    @Override
    public HouseBuilder buildDoors(int amountDoors) {
        ArrayList<Door> doors = new ArrayList<>(amountDoors);
        for (Door d : doors) d = new Door();
        house.setDoors(doors);
        return this;
    }

    @Override
    public HouseBuilder buildFloors(int amountFloors) {
        ArrayList<Floor> floors = new ArrayList<>(amountFloors);
        for (Floor f : floors) f = new Floor();
        house.setFloors(floors);
        return this;
    }

    @Override
    public HouseBuilder buildWalls(int amountWalls) {
        ArrayList<Wall> walls = new ArrayList<>(amountWalls);
        for (Wall w : walls) w = new Wall();
        house.setWalls(walls);
        return this;
    }

    @Override
    public House getResult() {
        return house;
    }
}
