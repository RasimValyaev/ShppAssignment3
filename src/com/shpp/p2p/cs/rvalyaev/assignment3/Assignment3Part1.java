package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part1 extends TextProgram {
    // minutes of aerobic exercise
    private final int TOTAL_TRAININGS_MINITES = readInt("How many minutes have you worked out in the last 7 days: ");

    @Override
    public void run() {

        // Cardiovascular system - the norm of days per week
        final int DAYS_FOR_CARDIOVASCULAR = 5;
        // Cardiovascular system - the norm of minutes a day
        final int MINUTES_FOR_CARDIOVASCULAR = 30;
        // blood pressure, the norm of days per week
        final int DAYS_PRESSURE = 3;
        // Blood pressure, rate of minutes per day
        final int MINUTE_PRESSURE = 40;

        incompletePeriod(DAYS_FOR_CARDIOVASCULAR, MINUTES_FOR_CARDIOVASCULAR, true);
        controlMinutesForNegative();
        incompletePeriod(DAYS_PRESSURE, MINUTE_PRESSURE, false);
    }

    // if enter minutes is negative - exit program
    private void controlMinutesForNegative() {
        if (TOTAL_TRAININGS_MINITES < 0) {
            System.out.println("number of days must be positive!");
            System.exit(0); // program exit
        }
    }

    /* training comments. output recommendations depending on the number of minutes of training*/
    private void incompletePeriod(int amountDaysNorm, int amountMinutesNorm, boolean isCardiovascular) {
        int countFullMinutesNorm = amountDaysNorm * amountMinutesNorm; //how minutes need
        int incompleteMinutes = countFullMinutesNorm - TOTAL_TRAININGS_MINITES; //How many minutes are missing
        int incompleteDays = incompleteMinutes / amountMinutesNorm; //How many days are missing
        int incompleteMinuteOneDay = incompleteMinutes % amountMinutesNorm;
        int numberDay = 0;

        if (incompleteMinutes <= 0) {
            trainingComment(isCardiovascular, true);
        } else {
            while (numberDay < incompleteDays) {
                numberDay++;
                System.out.println("How many minutes did you do on day " + numberDay + "? " + amountMinutesNorm);
            }

            if (incompleteMinuteOneDay > 0) {
                System.out.println("How many minutes did you do on day " + ++numberDay + "? " + incompleteMinuteOneDay);
            }

            trainingComment(isCardiovascular, false);
            System.out.println("You needed to train hard for at least " + numberDay + " more day(s) a week!\n");
        }
    }

    //commentary on the trainings
    private void trainingComment(boolean isCardiovascular, boolean isComplete) {
        if (isCardiovascular) {
            System.out.println("Cardiovascular health:");
            if(isComplete){
                System.out.println("Great job! You've done enough exercise for cardiovascular health. \n");
            }
        } else {
            System.out.println("Blood pressure:");
            if(isComplete){
                System.out.println("Great job! You've done enough exercise to keep a low blood pressure.");
            }
        }
    }
}
