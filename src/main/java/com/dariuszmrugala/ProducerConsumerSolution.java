package com.dariuszmrugala;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class ProducerConsumerSolution {
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

        Producer producer1 = new Producer(sharedQueue);
        Producer producer2 = new Producer(sharedQueue);
        Producer producer3 = new Producer(sharedQueue);
        MyConsumer myConsumer = new MyConsumer(sharedQueue);

        //github synchro test
        //check in in the linux
        //check out in the windows

        producer1.start();
        producer2.start();
        producer3.start();
        myConsumer.start();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (producer1.getState() == Thread.State.TERMINATED && producer2.getState() == Thread.State.TERMINATED) {
//            myConsumer.notify();
//        }
    }
}
