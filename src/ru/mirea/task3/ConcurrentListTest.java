package ru.mirea.task3;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentListTest {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1 = new ConcurrentList<>();
        List<Integer> list2 = new ArrayList<>();

        Thread t1 = new Thread(new ListWorker(list1));
        Thread t2 = new Thread(new ListWorker(list1));

        t1.start();
        for (int i =1; i < 5; ++i) list1.add( 10 * i);
        t2.start();

        t2.join();
        t1.join();

        System.out.println(list1);

        t1 = new Thread(new ListWorker(list2));
        t2 = new Thread(new ListWorker(list2));

        t1.start();
        for (int i =1; i < 5; ++i) list2.add( 10 * i);
        t2.start();

        t1.join();
        t2.join();

        System.out.println(list2);

    }
}
