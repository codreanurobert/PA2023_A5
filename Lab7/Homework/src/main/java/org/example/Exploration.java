package org.example;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class Exploration {
    private static SharedMemory mem;
    private static ExplorationMap map;
    private List<Robot> robots = new ArrayList<>();

    private Boolean fromPauseSignal;

    public void start() {
        for (Robot robot : robots) {
            Thread r = new Thread(robot);
            r.start();
        }
    }

    public void displayNrOfTokensExtractedForEachRobot() {

        for (Robot robot : robots) {
            System.out.println(robot.getName() + " extracted a total number of: " + robot.getNumberOfTokensExtracted() + " tokens");
        }


    }

    public void killAll() {
        for (Robot robot : robots) {
            robot.killRobot();
        }
    }

    public Exploration(int n) {

        this.mem = new SharedMemory(n);
        this.map = new ExplorationMap(n);
        fromPauseSignal = false;
    }

    public void addRobot(Robot r) {
        for (Robot r1 : robots) {
            if (r1.equals(r)) {
                return;
            }
        }
        robots.add(r);
    }

    public void setFromPauseSignal(Boolean nr) {

        fromPauseSignal = nr;
    }

    public boolean getFromPauseSignal() {

        return this.fromPauseSignal;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public ExplorationMap getMap() {
        return this.map;
    }

    public boolean display() {
        for (Robot r : robots) {
            if (r.getStatus()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExplorationFinished() {
        boolean done = true;
        for (Robot r : robots) {
            if (r.getStatus() == true) {
                done = false;
            }
        }
        return done;
    }


}