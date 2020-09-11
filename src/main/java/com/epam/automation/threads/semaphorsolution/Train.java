package com.epam.automation.threads.semaphorsolution;

import java.util.concurrent.Semaphore;

class Train extends Thread {
    Semaphore sem;
    int num = 0;
    int id;

    Train(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3)
            {
                sem.acquire();
                System.out.println("Train " + id + " has entered the tunnel");
                sleep(2000);
                num++;

                System.out.println("Train " + id + " has left the tunnel");
                sem.release();

                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
