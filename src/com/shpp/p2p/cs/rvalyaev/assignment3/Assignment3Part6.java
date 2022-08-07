package com.shpp.p2p.cs.rvalyaev.assignment3;

/**
 * Частина 6 — П’ять секунд слави
 * Ми, можливо, ще не розглядали анімації, але скоро розглянемо.
 * Ну, а поки що вам завдання: написати програму,
 * яка виводить на екран цілих 5 секунд будь-якої анімації (не взятої звідкись, а власноруч створеної).
 * Це може бути будь-яка анімація на ваш вибір з будь-яким сценарієм.
 * <p>
 * п’ять секунд, не більше і не менше. В кінці нашого курсу ми об’єднаємо всі ваші творіння в один кльовий ролик.
 * анімація повинна містити 50 фреймів принаймні. Якщо ж у вас 24 фрейми в секунду, то взагалі добре.
 * Проявіть свою креативність!) це — все, що ми просимо.
 */

public class Assignment3Part6 extends Assignment3Part4 {

    public void run() {
        christmasTree();
    }

    //The christmasTree method, which emulates a Christmas tree, is called in a loop
    public void christmasTree() {
        long currentMilliSec = System.currentTimeMillis() + 5000;
        int bricksCount = 1;
        while (System.currentTimeMillis() < currentMilliSec) {
            createPyramid(bricksCount++ % 10);
            pause(100);
        }
    }
}
