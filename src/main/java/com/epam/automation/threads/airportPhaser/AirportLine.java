package com.epam.automation.threads.airportPhaser;


import java.util.concurrent.Phaser;

public class AirportLine implements Runnable {

    Phaser phaser;
    String name;
    int planesToLand;


    AirportLine(Phaser p, String n, int planesToLand) {

        this.phaser = p;
        this.name = n;
        this.planesToLand = planesToLand;
        phaser.register();
    }

    public void run() {
        System.out.println("Полоса " + name + " приняла самолет ");
        phaser.arrive();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Самолет начал выходить на полосу " + name);
        phaser.arrive();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Самолет взлетел с полосы " + name);
        phaser.arrive();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Полоса " + name + " освободилась.");
        phaser.arrive();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        planesToLand--;
        if (planesToLand >= 1)
            run();
        phaser.arriveAndDeregister();
    }
}