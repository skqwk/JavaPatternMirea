package ru.mirea.task6.builder;

import java.util.List;

public class House {
    private List<Window> windows;
    private List<Floor> numberOfFloors;
    private List<Door> doors;
    private List<Wall> walls;
    private List<Entrance> entrance;

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public void setFloors(List<Floor> numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setEntrance(List<Entrance> entrance) {
        this.entrance = entrance;
    }
}
