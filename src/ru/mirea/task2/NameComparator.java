package ru.mirea.task2;

import java.util.Comparator;

public class NameComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return -1* h1.getLastName().compareTo(h2.getLastName());
    }
}
