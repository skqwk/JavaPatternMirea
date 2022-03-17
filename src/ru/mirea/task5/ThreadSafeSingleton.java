package ru.mirea.task5;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton singleton = new ThreadSafeSingleton();
    private ThreadSafeSingleton() {};

    public static ThreadSafeSingleton getInstance() {
        return singleton;
    }
}
