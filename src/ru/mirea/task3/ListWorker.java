package ru.mirea.task3;

import java.util.List;

public class ListWorker implements Runnable{
    private final List<Integer> list;

    public ListWorker(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
        list.remove(4);
    }
}
