package com.epam.automation.threads.airportPhaser;

import java.util.concurrent.Phaser;

public class Runner {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(5);
        new Thread(new AirportLine(phaser, "1", 2)).start();
        new Thread(new AirportLine(phaser, "2", 2)).start();
        new Thread(new AirportLine(phaser, "3", 2)).start();
        new Thread(new AirportLine(phaser, "4", 2)).start();
        new Thread(new AirportLine(phaser, "5", 2)).start();

    }
}
