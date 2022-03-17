package ru.mirea.task6.fabric_method;

public class RedisDriver extends RepositoryDriver{
    @Override
    public Repository createRepository() {
        return new Redis();
    }
}
