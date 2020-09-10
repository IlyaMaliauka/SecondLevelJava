package com.epam.automation.threads.port;

public class Main {

    public static void main(String[] args) {

        Port p = new Port();            //Create a port
        Ship sh1 = new Ship(p, 0);
        Ship sh2 = new Ship(p, 25);     //Creating 2 ships

        p.startPort();                  //Start a port
        Thread threadShip2 = new Thread(sh2);
        Thread threadShip = new Thread(sh1);
        threadShip.start();
        threadShip2.start();


    }
}