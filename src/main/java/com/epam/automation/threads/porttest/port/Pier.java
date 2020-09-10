package com.epam.automation.threads.porttest.port;

public class Pier extends Thread {

    Port port;
    String name;

    Pier(Port port, String name) {
        this.port = port;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " pier started working.");
        while (true) {
            port.sendShipToSea();
        }
    }

}
