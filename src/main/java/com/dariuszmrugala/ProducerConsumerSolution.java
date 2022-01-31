package com.dariuszmrugala;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class ProducerConsumerSolution {
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

        Producer producer = new Producer(sharedQueue);
        MyConsumer myConsumer = new MyConsumer(sharedQueue);

        producer.start();
        myConsumer.start();

    }
}
