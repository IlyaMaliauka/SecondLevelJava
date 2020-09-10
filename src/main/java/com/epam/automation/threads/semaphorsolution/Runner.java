package com.epam.automation.threads.semaphorsolution;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Semaphore sem1 = new Semaphore(1);
        for (int i = 1; i < 6; i++)
            new Train(new Tunnel(), sem1, i).start();
        Semaphore sem2 = new Semaphore(1);
        for (int i = 1; i < 6; i++)
            new Train(new Tunnel(), sem2, i).start();
    }
}
