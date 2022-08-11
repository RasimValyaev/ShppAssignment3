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

    // The game continues until heads come up and ends when 20 is reached.
    private void petersburgParadox() {
        int sumMoneyEagle;
        int sumMoneyGame = 0;
        int countGames = 0;
        boolean isEagle = true;
        Random random = new Random();

        while (sumMoneyGame < 20) {
            sumMoneyEagle = 1;
            countGames++;
            while (isEagle == random.nextBoolean()) {
                sumMoneyEagle *= 2;
            }
            sumMoneyGame = sumMoneyGame + sumMoneyEagle;
            println("This game, you earned $" + sumMoneyEagle);
            println("Your total is $" + sumMoneyGame);
        }
        print("It took " + countGames + " games to earn $20");
    }
}
