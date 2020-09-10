package com.epam.automation.threads.port;

public class Ship implements Runnable {

    final int MAX_COUNT_CONTAINERS = 25;
    Port p;
    Cargo cargo;

    public Ship(Port p, int countContainers) {
        this.p = p;
        this.cargo = new Cargo(countContainers);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);                 // Ship floats in sea
            } catch (InterruptedException ex) {
            }
            p.addCargoTime(this);
        }

    }
}