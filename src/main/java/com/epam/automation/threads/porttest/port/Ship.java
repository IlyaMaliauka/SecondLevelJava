package com.epam.automation.threads.porttest.port;

public class Ship implements Runnable {

    Port p;
    int containersLoad;

    public Ship(Port p, int containersLoad) {
        this.p = p;
        this.containersLoad = containersLoad;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }
            try {
                p.receiveShip(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}