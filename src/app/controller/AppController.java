package app.controller;

import app.config.Config;
import app.threads.FruitThreads;
import app.threads.VegetableThreads;

import java.util.concurrent.CountDownLatch;

public class AppController {

    public static void Processing() {
//        This used for blocking the threads until they finish their work.
        CountDownLatch latch = new CountDownLatch(1);

//        This creates a thread for Fruit and Vegetable.
//        The first parameter is the list of the items, the second parameter is for blocking the threads until they finish their work.
//        The third parameter is for blocking the threads until they finish their work.
        FruitThreads fruitThread = new FruitThreads(Config.fruitList, true, latch);
        VegetableThreads vegetableThread = new VegetableThreads(Config.vegetableList, false, latch);

        //This starts the threads.
        fruitThread.start();
        vegetableThread.start();
    }
}
