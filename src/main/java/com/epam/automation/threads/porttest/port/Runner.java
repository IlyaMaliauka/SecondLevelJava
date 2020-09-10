package com.epam.automation.threads.porttest.port;

public class Runner {

    public static void main(String[] args) {

        Port shanghaiPort = new Port();
        Ship emptyShip = new Ship(shanghaiPort, 0);
        Ship middleShip = new Ship(shanghaiPort, 25);
        Ship loadedShip = new Ship(shanghaiPort, 50);

        shanghaiPort.startPort();
        Thread ship2 = new Thread(middleShip);
        Thread ship1 = new Thread(emptyShip);
        Thread ship3 = new Thread(loadedShip);
        ship1.start();
        ship2.start();
        ship3.start();


    }
}