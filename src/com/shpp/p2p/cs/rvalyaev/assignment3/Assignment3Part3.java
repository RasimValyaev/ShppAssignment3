package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Частина 3 — Піднесення до степеня
 * Ваше завдання — написати метод:
 * private double raiseToPower(double base, int exponent)
 * Цей метод буде приймати два параметри і обчислювати значення першого параметра,
 * піднесеного до степеня параметра 2. тобто raiseToPower(2.0, 3) дасть 2^3 = 8
 * Другий параметр може бути не тільки додатнім, але і від’ємним. Наприклад 0.5 в степені -2 це 4.
 * Для спрощення вашого життя вважатимемо, що все, що підноситься до степеня 0, стане 1, тобто 0 в степені 0 буде 1 😃
 * Оскільки double не вміє зберігати в собі нескінченно довгі дробові числа (як ми обговорювали),
 * то при маніпуляції з даблами можливі всілякі дрібні похибки. Це ок.
 *
 * Також, вам не дозволено в цьому підзавданні використовувати Math.pow, Math.exp,
 * Math.log та інші зручні методи із Math, інакше який тоді сенс, в написанні одного метода, чи не так? 😃
 */

public class Assignment3Part3 extends TextProgram {

    public void run() {
        final double base = readDouble("enter you number: ");
        final int exponent = readInt("enter you exponent: ");
        System.out.println(raiseToPower(base, exponent));
    }

    // Raise number base to power exponent.
    private double raiseToPower(double base, int exponent) {
        double result = base;
        int exponentNew = exponent;

        //the power(exponent) of the number must be positive
        if (exponentNew == 0) {
            return 1;
        } else if (exponentNew < 0) {
            exponentNew *= -1;
        }

        for (int i = 0; i < exponentNew - 1; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }


}
