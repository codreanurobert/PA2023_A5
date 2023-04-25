package org.example;

import static org.example.Exploration.explore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }
}