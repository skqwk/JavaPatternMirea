package ru.mirea.task6.fabric_method;

public abstract class Repository {
    public abstract void create(String key, String value);
    public abstract String read(String key);
    public abstract void update(String key, String value);
    public abstract void delete(String key);
}
