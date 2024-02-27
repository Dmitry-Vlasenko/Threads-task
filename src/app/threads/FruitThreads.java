package app.threads;

import java.util.concurrent.CountDownLatch;

public class FruitThreads extends Thread {
    //    This variable
    private final String[] fruits;
    private final boolean await;
    private final CountDownLatch latch;
    //  This constructor for class
    public FruitThreads(String[] fruits, boolean await, CountDownLatch latch) {
        this.fruits = fruits;
        this.await = await;
        this.latch = latch;
    }

    public void run() {
        //        This use for await if await true.
        if (await) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Outputting fruits:");
        //        This circle for print fruit
        for (String fruit : fruits) {
            System.out.println(fruit);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        //        This is for latch count
        latch.countDown();
    }
}
