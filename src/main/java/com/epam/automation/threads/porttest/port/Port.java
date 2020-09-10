package com.epam.automation.threads.porttest.port;


import java.util.ArrayList;
import java.util.List;


public class Port {

    final List<Pier> piers;
    int storageLoad;
    int shipsQuantity;

    public Port() {
        piers = new ArrayList<>();
        {
            {
                piers.add(new Pier(this, "Northern"));
                piers.add(new Pier(this, "Western"));
                piers.add(new Pier(this, "Southern"));
                piers.add(new Pier(this, "Eastern"));

            }
        }
        this.shipsQuantity = 0;
        this.storageLoad = 200;
    }

    public void startPort() {
        for (Pier pier : piers) {
            pier.start();
        }
    }

    public synchronized void receiveShip(Ship ship) throws InterruptedException {
        while (shipsQuantity + 1 > piers.size()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }
        }
        shipsQuantity++;
        System.out.println("\nNew ship has arrived");
        Thread.sleep(1000);
        if (ship.containersLoad == 0) {
            System.out.println("Let's upload this empty boy...");
            Thread.sleep(3000);
            storageLoad -= 50;
            System.out.println("The ship is full now! Containers left in storage: " + storageLoad);
            Thread.sleep(2000);
        }
        if (ship.containersLoad == 25) {
            System.out.println("Let's unload and upload some cargo...");
            Thread.sleep(3000);
            System.out.println("The ship is ready now! Containers left in storage: " + storageLoad);
            Thread.sleep(2000);
        }
        if (ship.containersLoad == 50) {
            System.out.println("Let's unload a full ship");
            Thread.sleep(3000);
            storageLoad += 50;
            System.out.println("The ship is empty now! Containers left in storage: " + storageLoad);
            Thread.sleep(2000);
        }
        notify();
    }

    public synchronized void sendShipToSea() {
        while (shipsQuantity == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }
        }
        shipsQuantity--;
        System.out.println("Ship has left the pier!");
        notify();
    }
}


