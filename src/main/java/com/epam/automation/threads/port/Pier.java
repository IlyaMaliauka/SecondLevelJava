package com.epam.automation.threads.port;

public class Pier extends Thread {

    Port port;

    Pier(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println("Start Pier " + Thread.currentThread().getName());
        while (true) {
            try {
                port.removeCargoTime();
            } catch (InterruptedException ex) {
            }
        }
    }

}
