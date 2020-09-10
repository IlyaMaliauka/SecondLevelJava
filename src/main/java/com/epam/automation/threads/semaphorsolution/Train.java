package com.epam.automation.threads.semaphorsolution;

import java.util.concurrent.Semaphore;

public class Train extends Thread {
    Tunnel tunnel;
    Semaphore sem1;
    int id;

    public Train(Tunnel tunnel, Semaphore sem1, int id) {
        this.tunnel = tunnel;
        this.sem1 = sem1;
        this.id = id;
    }

    public void run() {
        try {
            sem1.acquire();
            System.out.println("Поезд " + id + " заезжает в тоннель.");
            sleep(3000);


            System.out.println("Поезд " + id + " покидает тоннель.");
            sem1.release();
            sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
