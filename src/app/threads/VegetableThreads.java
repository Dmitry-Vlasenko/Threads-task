package app.threads;

import java.util.concurrent.CountDownLatch;

public class VegetableThreads extends Thread {
    private final String[] vegetables;
    private final boolean await;
    private final CountDownLatch latch;

    public VegetableThreads(String[] vegetables, boolean await, CountDownLatch latch) {
        this.vegetables = vegetables;
        this.await = await;
        this.latch = latch;
    }

    public void run() {
        if (await) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Outputting vegetables:");
        for (String vegetable : vegetables) {
            System.out.println(vegetable);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        latch.countDown();
    }
}