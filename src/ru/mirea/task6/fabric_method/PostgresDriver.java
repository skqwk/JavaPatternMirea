package ru.mirea.task6.fabric_method;

public class PostgresDriver extends RepositoryDriver{
    @Override
    public Repository createRepository() {
        return new Postgres();
    }
}
