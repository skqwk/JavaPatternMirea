package ru.mirea.task6.fabric_method;

import java.util.*;

public class Postgres extends Repository{
    Map<String, ArrayList<String>> db = new HashMap<>();

    @Override
    public void create(String key, String value) {
        db.putIfAbsent(key, new ArrayList<>());
        List<String> list = db.get(key);
        list.add(value);

        System.out.println("Postgres create");
    }

    @Override
    public String read(String key) {
        List<String> list = db.get(key);
        String val = list.get(list.size()-1);
        System.out.println("Postgres read");
        return val;
    }

    @Override
    public void update(String key, String value) {
        db.putIfAbsent(key, new ArrayList<>());
        List<String> list = db.get(key);
        list.add(value);

        System.out.println("Postgres update");
    }

    @Override
    public void delete(String key) {
        db.remove(key);

        System.out.println("Postgres delete");
    }
}
