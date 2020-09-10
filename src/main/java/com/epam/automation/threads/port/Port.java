package com.epam.automation.threads.port;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Port {

    final int MAX_COUNT_CONTAINERS = 200;
    final LinkedList<Cargo> queueCargo;
    final List<Pier> piers;
    int countContainers;
    int countShips;

    public Port() {
        piers = new ArrayList<>();
        {
            {
                piers.add(new Pier(this));
                piers.add(new Pier(this));
                piers.add(new Pier(this));

            }
        }
        queueCargo = new LinkedList<>();
        this.countShips = 0;
        this.countContainers = 0;
    }

    public void startPort() {
        for (int i = 0; i < piers.size(); i++) {
            piers.get(i).start();
        }
    }

    public void addCargoTime(Ship ship) {
        synchronized (queueCargo) {
            while (countShips + 1 > piers.size()) {
                try {
                    queueCargo.wait();
                } catch (InterruptedException ex) {
                }
            }
            queueCargo.add(ship.cargo);
            countShips++;
            System.out.println("added ship time");
            queueCargo.notifyAll();
        }

    }

    public void removeCargoTime() throws InterruptedException {
        Cargo cargo = null;
        synchronized (queueCargo) {
            while (countShips == 0) {
                try {
                    queueCargo.wait();
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted");
                }
            }
            cargo = queueCargo.poll();
            if (cargo.countContainers == 0) {
                System.out.println("Start upload empty ship " + Thread.currentThread().getName());
                cargo.countContainers += 25;
                Thread.sleep(1000);
                System.out.println("Ship is uploaded! " + Thread.currentThread().getName());

            }
            if (cargo.countContainers == 25) {
                System.out.println("Start unload ship " + Thread.currentThread().getName());
                cargo.countContainers -= 25;
                Thread.sleep(1000);
                System.out.println("Ship is unloaded! " + Thread.currentThread().getName());
            }
            countShips--;
            System.out.println("remove ship time");
            queueCargo.notifyAll();
        }
    }

}