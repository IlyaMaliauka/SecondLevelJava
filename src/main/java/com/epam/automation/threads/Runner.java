package com.epam.automation.threads;

public class Runner {
    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer, "1").start();
        new Thread(consumer, "1").start();
        new Thread(producer, "2").start();
        new Thread(consumer, "2").start();
    }
}
