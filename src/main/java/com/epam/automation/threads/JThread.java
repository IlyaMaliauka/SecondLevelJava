package com.epam.automation.threads;

public class JThread implements Runnable {

    public synchronized void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Loop " + counter++);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " has been interrupted");
        }

        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

