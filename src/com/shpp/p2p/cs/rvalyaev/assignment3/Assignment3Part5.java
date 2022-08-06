package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.graphics.WindowProgram;

import java.util.Random;
/**
 * Це гіпотетична гра для казино з простою ідеологією.
 * Грають дві людини: щасливчик і спітнілий.
 * Гра закінчується, коли перший заробляє $20 або більше. Спітнілий кладе $1 на стіл,
 * а щасливчик починає підкидати монетку.
 * Якщо орел — то спітнілий докладає до суми на столі точно таку ж суму.
 * Якщо решка — все, що на столі, переходить до щасливчика.
 * Якщо у щасливчика в результаті менше ніж $20, то гра повторюється.
 */

public class Assignment3Part5 extends WindowProgram {

    @Override
    public void run() {
        final int INPUT_SUM = readInt("the amount of your wager: ");
        petersburgParadox(INPUT_SUM);
    }

    private void petersburgParadox(int sumMoney) {
        boolean isEagle = true;
        Random random = new Random();
        int money = sumMoney;
        int gameCycle = 0;
        while (money < 21) {
            gameCycle++;
            money = sumMoney;
            while (isEagle == random.nextBoolean()) {
                money *= 2;
            }
        }
        System.out.println("gameCycle: " + gameCycle + "; sum: " + money);
    }
}
