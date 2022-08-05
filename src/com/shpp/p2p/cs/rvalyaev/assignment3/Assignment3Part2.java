package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part2 extends TextProgram {

    private int enteredNumber;

    public void run() {
        ControlEnteredNumber();
        comToOne();
    }

    // the program works when the number > 0
    public void ControlEnteredNumber(){
        enteredNumber = readInt("Enter a number: > 0 ");
        while (enteredNumber < 1){
            System.out.println("enter the number > 0");
            enteredNumber = readInt("Enter a number: ");
        }
    }

    // loop call the method until the result = 1
    private void comToOne(){
        while (enteredNumber != 1){
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
        }else{
            result = number / 2;
            System.out.println(number +  " is even so I take half: " + result);
        }
        return result;
    }
}
