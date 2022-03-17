package ru.mirea.task6.fabric_method;

import java.util.HashMap;
import java.util.Map;

public class Redis extends Repository{
    Map<String, String> db = new HashMap<>();

    @Override
    public void create(String key, String value) {
        db.put(key, value);
        System.out.println("Redis create");
    }

    @Override
    public String read(String key) {
        String value = db.get(key);
        System.out.println("Redis read");
        return value;

    }

    @Override
    public void update(String key, String value) {
        db.put(key, value);
        System.out.println("Redis update");

    }

    @Override
    public void delete(String key) {
        db.remove(key);
        System.out.println("Redis delete");

    }
}
