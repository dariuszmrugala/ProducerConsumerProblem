package com.dariuszmrugala;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{

    private BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> _sharedQueue) {
        super("PRODUCER");
        this.sharedQueue = _sharedQueue;

    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println(getName() + " produced " + i);
                sharedQueue.put(i);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Producer stop working");
    }

}
