package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * comments cyr: <a href="https://discord.com/channels/534496884849639455/634339132386312212/1004817047630385182">...</a>
 * <p>
 * Ваше завдання: написати програму, яка запитує у користувача кількість хвилин,
 * потрачених останні сім днів на вправи, і відповідно, репортить наступне:
 * <p>
 * чи було достатньо часу приділено вправам для кардіоваскулярного здоров’я, і, якщо ні,
 * виводить: скільки днів правильного життя (с заняттями більше 30 хвилин) не вистачає для рекомендованого графіку.
 * <p>
 * чи було достатньо вправ для зменшення кров’яного тиску і холестерину, і, якщо ні,
 * виводить: скільки днів користувач не дотягнув з заняттями по 40 хвилин на день.
 * How many minutes did you do on day 1? 40
 * How many minutes did you do on day 2? 30
 * ...
 * Cardiovascular health:
 * Great job! You've done enough exercise for cardiovascular health.
 * Blood pressure:
 * You needed to train hard for at least 1 more day(s) a week!
 * Cardiovascular health:
 * You needed to train hard for at least 2 more day(s) a week!
 * Blood pressure:
 * Great job! You've done enough exercise to keep a low blood pressure.
 */

public class Assignment3Part1 extends TextProgram {
    private final int[] MINUTES_EVERY_DAY = new int[7];
    // Cardiovascular system - the norm of days per week
    final int DAYS_FOR_CARDIOVASCULAR = 5;
    // Cardiovascular system - the norm of minutes a day
    final int MINUTES_FOR_CARDIOVASCULAR = 30;
    // blood pressure, the norm of days per week
    final int DAYS_PRESSURE = 3;
    // Blood pressure, rate of minutes per day
    final int MINUTE_PRESSURE = 40;

    @Override
    public void run() {
        trainingMinutes();
        controlTrainings();
    }

    /* enter minutes every day*/
    private void trainingMinutes() {
        for (int i = 0; i < 7; i++) {
            controlMinutesForNegative(i);
        }
    }

    // check the entered minutes for correctness and add to array minutes for every day
    private void controlMinutesForNegative(int dayNumber) {
        String message = "How many minutes did you do on day " + (dayNumber + 1) + "?: ";
        int inputMinutes = readInt(message); // the number of minutes of training for the current day
        while (inputMinutes < 0) {
            System.out.println("number of days must be positive!");
            inputMinutes = readInt(message);
        }
        MINUTES_EVERY_DAY[dayNumber] = inputMinutes;
    }

    private void controlTrainings() {
        int countDayCardio = 0;
        int countDayPressure = 0;

        for (int j : MINUTES_EVERY_DAY) {
            if (j >= MINUTES_FOR_CARDIOVASCULAR) {
                countDayCardio++;
            }
            if (j >= MINUTE_PRESSURE) {
                countDayPressure++;
            }
        }
        trainingComment(true, (DAYS_FOR_CARDIOVASCULAR - countDayCardio));
        trainingComment(false, (DAYS_PRESSURE - countDayPressure));
    }

    //commentary on the trainings
    private void trainingComment(boolean isCardiovascular, int countDay) {
        if (isCardiovascular) {
            println("\nCardiovascular health:");
            if (countDay<=0) {
                println("Great job! You've done enough exercise for cardiovascular health.\n");
            }
        } else {
            println("Blood pressure:");
            if (countDay<=0) {
                println("Great job! You've done enough exercise to keep a low blood pressure.");
            }
        }

        if (countDay > 0) {
            println("You needed to train hard for at least " + countDay + " more day(s) a week!\n");
        }
    }
}
