package com.dariuszmrugala;

import java.util.concurrent.BlockingQueue;

public class MyConsumer extends Thread {

    private BlockingQueue<Integer> sharedQueue;

    public MyConsumer(BlockingQueue<Integer> _sharedQueue) {
        super("MYCONSUMER");
        this.sharedQueue = _sharedQueue;
    }

    public void run() {
        int sum = 0;
        int count = 0;
        int max = 0;
        int min = 1000;
        try {
            while(true) {
                Integer item = sharedQueue.take();
                System.out.println(getName() + " consumed " + item);
                sum += item;
                count++;
                if(item > max) {
                    max = item;
                }
                if(item < min) {
                    min = item;
                }
                System.out.println("sum: " + sum + " avg: " + ((double)sum) / ((double) count) + " min: " + min + " max: " + max);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


}
