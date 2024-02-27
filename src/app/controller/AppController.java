package app.controller;

import app.config.Config;
import app.threads.FruitThreads;
import app.threads.VegetableThreads;

import java.util.concurrent.CountDownLatch;

public class AppController {

    public static void Processing() {
        CountDownLatch latch = new CountDownLatch(1);

        FruitThreads fruitThread = new FruitThreads(Config.fruitList, true, latch);
        VegetableThreads vegetableThread = new VegetableThreads(Config.vegetableList, false, latch);

        fruitThread.start();
        vegetableThread.start();
    }
}
