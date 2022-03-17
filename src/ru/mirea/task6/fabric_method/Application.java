package ru.mirea.task6.fabric_method;

import java.util.Scanner;

public class Application {
    Repository repository;
    RepositoryDriver repositoryDriver;

    public Application(RepositoryDriver repositoryDriver) {
        this.repositoryDriver = repositoryDriver;
        repository = repositoryDriver.createRepository();

        repository.create("date", "09/02/2003");
        System.out.println(repository.read("date"));

        repository.update("date", "09/02/2004");
        System.out.println(repository.read("date"));
        repository.delete("date");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String driver = sc.nextLine();
        RepositoryDriver repositoryDriver;
        switch (driver) {
            case "redis":
                repositoryDriver = new RedisDriver();
                break;
            case "postgres":
                repositoryDriver = new PostgresDriver();
                break;
            default:
                repositoryDriver = new PostgresDriver();
                break;
        }

        new Application(repositoryDriver);

    }
}
