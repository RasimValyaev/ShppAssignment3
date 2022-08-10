package com.shpp.p2p.cs.rvalyaev.assignment3;

import com.shpp.cs.a.console.TextProgram;

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

public class Assignment3Part5 extends TextProgram {

    @Override
    public void run() {
        petersburgParadox();
    }

    private void petersburgParadox() {
        boolean isEagle = true;
        Random random = new Random();
        int totalMoney = 0;
        int countGames = 0;
        while (totalMoney <= 20) {
            int money = 1;
            while (isEagle == random.nextBoolean()) {
                countGames++;
                println("This game, you earned $" + money);
                totalMoney += money;
                println("Your total is $" + totalMoney);
                money *= 2;
            }
        }
        print("It took " + countGames + " games to earn $20");
    }
}
