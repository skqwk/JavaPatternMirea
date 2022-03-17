package ru.mirea.task6.builder;

interface HouseBuilder {
    HouseBuilder buildEntrance(int entrance);
    HouseBuilder buildWindows(int windows);
    HouseBuilder buildDoors(int doors);
    HouseBuilder buildFloors(int floors);
    HouseBuilder buildWalls(int walls);
    House getResult();
}
