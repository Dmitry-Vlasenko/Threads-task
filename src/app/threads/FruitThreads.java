package app.threads;

import java.util.concurrent.CountDownLatch;

public class FruitThreads extends Thread {
    private final String[] fruits;
    private final boolean await;
    private final CountDownLatch latch;

    public FruitThreads(String[] fruits, boolean await, CountDownLatch latch) {
        this.fruits = fruits;
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
        System.out.println("Outputting fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        latch.countDown();
    }
}
