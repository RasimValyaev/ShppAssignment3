package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * comments cyr: <a href="https://discord.com/channels/534496884849639455/634339132386312212/1004817047630385182">...</a>
 *
 * Отже, вам потрібно написати програму, яка зчитує у користувача число і видає схоже на це:
 * Enter a number: 17
 * 17 is odd so I make 3n + 1: 52
 * 52 is even so I take half: 26
 */

public class Assignment3Part2 extends TextProgram {

    private int enteredNumber;

    public void run() {
        ControlEnteredNumber();
        comToOne();
    }

    // the program works when the number > 0
    public void ControlEnteredNumber() {
        String msgText = "Enter a number: > 0 and <= " + (Integer.MAX_VALUE / 2 - 1) + ": ";
        enteredNumber = readInt(msgText);
        while ((enteredNumber < 1) || (enteredNumber > (Integer.MAX_VALUE / 2 - 1))) {
            enteredNumber = readInt(msgText);
        }
    }

    // loop call the method until the result = 1
    private void comToOne() {
        while (enteredNumber != 1) {
            enteredNumber = getNumber(enteredNumber);
        }
        System.out.println("Finish");
    }

    // by even/odd numbers - makes calculations
    private int getNumber(int number) {
        int result;
        if ((number % 2) != 0) {
            result = (number * 3) + 1;
            System.out.println(number + " is odd so I make 3n + 1: " + result);
        } else {
            result = number / 2;
            System.out.println(number + " is even so I take half: " + result);
        }
        return result;
    }
}
