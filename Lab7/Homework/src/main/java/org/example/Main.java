package org.example;

import java.sql.Time;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Exploration explore = new Exploration(7);
        explore.addRobot(new Robot("A", 7));
        explore.addRobot(new Robot("B", 7));
        explore.addRobot(new Robot("C", 7));

        Thread t = new Thread(new TimeKeeper(explore, 200000));
        t.setDaemon(true);
        t.start();

        CommandLauncher launcher = new CommandLauncher(explore);
        launcher.run();

    }
}
