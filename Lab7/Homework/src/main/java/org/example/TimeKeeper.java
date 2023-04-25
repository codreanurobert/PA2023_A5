package org.example;

/**
 * Clasa - manageriază timpul de execuție al explorării
 * - termina explorarea daca timpul a expirat
 */
public class TimeKeeper implements Runnable {
    private Exploration exp;
    private int timeLimit;

    TimeKeeper(Exploration exp2, int t) {
        timeLimit = t;
        exp = exp2;

    }

    @Override
    public void run() {
        boolean ok = false;
        long initTime = 0;
        long timeWhenDone = 0;
        while (true) {
            if (ok == false) {
                initTime = System.currentTimeMillis();
                exp.start();


                ok = true;
            }
            timeWhenDone = System.currentTimeMillis();
            if ((timeWhenDone - initTime) > timeLimit) {
                System.out.println("The final time passed from the start of the exploration: " + (timeWhenDone - initTime));
                exp.killAll();

                break;
            }
            ;
            if (exp.checkExplorationFinished() && exp.getFromPauseSignal() == false) {

                timeWhenDone = System.currentTimeMillis();
                System.out.println("The final time passed from the start of the exploration: " + (timeWhenDone - initTime));
                exp.setFromPauseSignal(false);
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }

    }
}
