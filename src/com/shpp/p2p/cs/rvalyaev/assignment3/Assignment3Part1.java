package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * comments cyr: <a href="https://discord.com/channels/534496884849639455/634339132386312212/1004817047630385182">...</a>
 *
 * Ваше завдання: написати програму, яка запитує у користувача кількість хвилин,
 * потрачених останні сім днів на вправи, і відповідно, репортить наступне:
 *
 * чи було достатньо часу приділено вправам для кардіоваскулярного здоров’я, і, якщо ні,
 * виводить: скільки днів правильного життя (с заняттями більше 30 хвилин) не вистачає для рекомендованого графіку.
 *
 * чи було достатньо вправ для зменшення кров’яного тиску і холестерину, і, якщо ні,
 * виводить: скільки днів користувач не дотягнув з заняттями по 40 хвилин на день.
 * How many minutes did you do on day 1? 40
 * How many minutes did you do on day 2? 30
 * ...
 * Cardiovascular health:
 *   Great job! You've done enough exercise for cardiovascular health.
 * Blood pressure:
 *   You needed to train hard for at least 1 more day(s) a week!
 * Cardiovascular health:
 *   You needed to train hard for at least 2 more day(s) a week!
 * Blood pressure:
 *   Great job! You've done enough exercise to keep a low blood pressure.
 */

public class Assignment3Part1 extends TextProgram {
    // minutes of aerobic exercise
    private int totalTrainingsMinutes;

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

        controlMinutesForNegative();
        incompletePeriod(DAYS_FOR_CARDIOVASCULAR, MINUTES_FOR_CARDIOVASCULAR, true);
        incompletePeriod(DAYS_PRESSURE, MINUTE_PRESSURE, false);
    }

    // if enter minutes is negative - exit program
    private void controlMinutesForNegative() {
        totalTrainingsMinutes = readInt("How many minutes have you worked out in the last 7 days: ");
        while (totalTrainingsMinutes < 0) {
            System.out.println("number of days must be positive!");
            totalTrainingsMinutes = readInt("How many minutes have you worked out in the last 7 days: ");
        }
    }

    /* training comments. output recommendations depending on the number of minutes of training*/
    private void incompletePeriod(int amountDaysNorm, int amountMinutesNorm, boolean isCardiovascular) {
        int countFullMinutesNorm = amountDaysNorm * amountMinutesNorm; //how minutes need
        int incompleteMinutes = countFullMinutesNorm - totalTrainingsMinutes; //How many minutes are missing
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
