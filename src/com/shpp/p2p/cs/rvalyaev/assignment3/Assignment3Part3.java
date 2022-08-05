package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.Arrays;

public class Assignment3Part3 extends TextProgram {
    int[] arr = new int[4];

    public void run() {
        double base = 2.25;
        int exponent = 2;
        arr = convertNumber(base);
        arr = numberToInt();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(numberToInt()));
        System.out.println(raiseToPower(base, exponent));
    }

    // Raise number base to power exponent. Etape 1
    private double raiseToPower(double base, int exponent) {
//        arr = numberToInt();
        double result;
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            exponent = exponent * -1;
        }

        if (arr[1] == 0) {
            // type base - int
            result = exponentiate(arr[0], exponent);
        } else {
            // type base - double
            result = exponentiate(arr[3], exponent) / exponentiate(arr[2], exponent);
        }
        return result;
    }

    // Raise number base to power exponent. Etape 2
    private int exponentiate(int base, int exponent) {
        int result = base;
        for (int i = 0; i < exponent - 1; i++) {
            result *= base;
        }
        return result;
    }


    // number double convert to array
    private int[] convertNumber(double base) {
        arr = new int[4];
        arr[0] = (int) base; //whole number
        arr[1] = Integer.parseInt(String.valueOf(base).substring(2)); //Numerator
        arr[2] = (int) exponentiate(10, String.valueOf(arr[1]).length()); //denominator
        return arr;
    }


    /* divides the numerator and denominator by a common divisor
     * if there is an integer, add it to the numerator
     * and store it as the fourth element of the array
     */
    public int[] numberToInt() {
        for (int i = arr[2]; i > 1; i--) {
            if ((arr[1] % i == 0) && (arr[2] % i == 0)) {
                arr[1] /= i;
                arr[2] /= i;
            }
        }
        arr[3] = arr[0] * arr[2] + arr[1];
        return arr;
    }

}
