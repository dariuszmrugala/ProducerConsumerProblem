package com.dariuszmrugala;

import java.util.concurrent.BlockingQueue;

public class MyConsumer extends Thread {

    private BlockingQueue<Integer> sharedQueue;

    public MyConsumer(BlockingQueue<Integer> _sharedQueue) {
        super("MYCONSUMER");
        this.sharedQueue = _sharedQueue;
    }

    public void run() {
        try {
            while(true) {
                Integer item = sharedQueue.take();
                System.out.println(getName() + " consumed " + item);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


}
