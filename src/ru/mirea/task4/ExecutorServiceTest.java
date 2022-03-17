package ru.mirea.task4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] data = new int[100_000_000];
        for (int i = 0; i < data.length; ++i) data[i] = i;

        checkParallel(data, 1);

        checkParallel(data, 2);

        checkSequentially(data);

    }

    public static void checkParallel(int[] data, int threads) throws ExecutionException, InterruptedException {
        int average = 0;
        for (int i = 0; i < 10; ++i) {
            long startTime = System.currentTimeMillis();
            int maxVal = maxParallel(data, threads);
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            average += duration;
            System.out.println("maxVal = " + maxVal + " duration = " + duration);
        }
        System.out.println("Average time = " + average / 10 + "\n");
    }

    public static void checkSequentially(int[] data) throws ExecutionException, InterruptedException {
        int average = 0;
        for (int i = 0; i < 10; ++i) {
            long startTime = System.currentTimeMillis();
            int maxVal = maxSequentially(data);
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            average += duration;
            System.out.println("maxVal = " + maxVal + " duration = " + duration);
        }
        System.out.println("Average time = " + average / 10 + "\n");
    }

    public static int maxParallel(int[] data, int threads) throws ExecutionException, InterruptedException {
        if (data.length == 1) return data[0];
        else if (data.length == 0) throw new IllegalArgumentException();

        // Разделяем работу на два потока - две задачи
        FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
        FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);

        // Размещаем потоки
        ExecutorService service = new OwnExecutorService(threads);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        return Math.max(future1.get(), future2.get());


    }

    public static int maxSequentially(int[] data)  {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; ++i) {
            if (data[i] > max) max = data[i];
        }
        return max;
    }
}
