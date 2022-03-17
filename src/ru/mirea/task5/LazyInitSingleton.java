package ru.mirea.task5;

public class LazyInitSingleton {

    private static LazyInitSingleton singleton;
    private int field;

    private LazyInitSingleton() {
        this.field = 0;
    }

    public static LazyInitSingleton getInstance() {
        if (singleton == null) singleton = new LazyInitSingleton();
        return singleton;
    }


}
