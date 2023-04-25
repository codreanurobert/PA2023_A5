package org.example;

import java.util.Scanner;

/**
 * Clasa - permite crearea unui thread care va primi comenzi de la utilizator si va executa comenzile respective.
 */

public class CommandLauncher {

    private Exploration explore;
    private Scanner scanner;

    private String commandName;

    private String robotName;

    private int secondsPause;

    public CommandLauncher(Exploration explore2) {

        explore = explore2;
    }

    public void run() {

        while (true) {

            scanner = new Scanner(System.in);
            commandName = scanner.next();
            if (commandName.equals("pause1")) {
                robotName = scanner.next();
                secondsPause = scanner.nextInt();

            }
            if (commandName.equals("start1")) {
                robotName = scanner.next();
            }
            if (commandName.equals("exit")) {

                break;
            }
            if (commandName.equals("pauseall")) {

                for (Robot robot : explore.getRobots()) {

                    robot.killRobot();
                    robot.setRestartFlag(1);
                    explore.setFromPauseSignal(true);
                }

            }
            if (commandName.equals("startall")) {
                Thread r;
                for (Robot robot : explore.getRobots()) {

                    r = new Thread(robot);
                    r.start();
                }
                explore.setFromPauseSignal(false);
            }
            if (commandName.equals("start1") && !robotName.equals(null)) {

                for (Robot robot : explore.getRobots()) {
                    if (robot.getName().equals(robotName)) {
                        Thread r = new Thread(robot);
                        robot.setWaitingTime(10000);
                        r.start();
                    }
                }

            }

            if (commandName.equals("pause1") && !robotName.equals(null) && secondsPause == -1) {
                for (Robot robot : explore.getRobots()) {
                    if (robot.getName().equals(robotName)) {
                        robot.killRobot();
                        robot.setRestartFlag(1);
                    }
                }

            }

            if (commandName.equals("pause1") && !robotName.equals(null) && secondsPause >= 0) {

                for (Robot robot : explore.getRobots()) {
                    if (robot.getName().equals(robotName)) {
                        robot.setWaitingTime(secondsPause);
                        robot.setRestartFlag(1);
                    }
                }

            }
            if (commandName.equals("displaytokens")) {
                explore.displayNrOfTokensExtractedForEachRobot();
            }
        }


    }


}
