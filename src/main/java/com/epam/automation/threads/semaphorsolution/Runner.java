package com.epam.automation.threads.semaphorsolution;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        for(int i=1;i<6;i++)
            new Train(sem,i).start();
    }
}
