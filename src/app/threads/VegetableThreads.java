package app.threads;

import java.util.concurrent.CountDownLatch;

public class VegetableThreads extends Thread {
    //    This variable
    private final String[] vegetables;
    private final boolean await;
    private final CountDownLatch latch;
    //  This constructor for class
    public VegetableThreads(String[] vegetables, boolean await, CountDownLatch latch) {
        this.vegetables = vegetables;
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
        System.out.println("Outputting vegetables:");
        //        This circle for print vegetable
        for (String vegetable : vegetables) {
            System.out.println(vegetable);
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