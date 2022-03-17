package ru.mirea.task5;

public enum EnumSingleton {
    instance;
    public static EnumSingleton getInstance() {
        return instance;
    }
}
