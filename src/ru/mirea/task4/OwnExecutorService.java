package ru.mirea.task4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class OwnExecutorService extends AbstractExecutorService {
    Thread[] threadPool;
    private boolean isShutdown = false;
    private boolean isTerminated = false;
    public OwnExecutorService(int threadAmount) {
        threadPool = new Thread[threadAmount];
    }
    private List<Runnable> awaitExecution = new ArrayList<>();



    @Override
    public void execute(Runnable command) {
        awaitExecution.add(command);
        if (!isShutdown) {
            while (true) {
                for (Thread t : threadPool) {
                    if (t != null && t.isAlive()) continue;
                    else {
                        awaitExecution.remove(command);
                        t = new Thread(command);
                        t.start();
                        return;
                    }
                }
            }
        }
    }


    @Override
    public void shutdown() {
        isShutdown = true;
    }

    @Override
    public List<Runnable> shutdownNow() {
        for (Thread t : threadPool) {
            if (t != null && t.isAlive()) {
                t.interrupt();
            }
        }
        return awaitExecution;
    }

    @Override
    public boolean isShutdown() {
        return isShutdown;
    }

    @Override
    public boolean isTerminated() {
        return isTerminated;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        synchronized (this) {
            while (true) {
                int count = 0;
                for (Thread t : threadPool) {
                    if (t == null || !t.isAlive()) ++count;
                }
                if (count == threadPool.length) break;
            }
        }
        isTerminated = true;
        return isTerminated;
    }


}
