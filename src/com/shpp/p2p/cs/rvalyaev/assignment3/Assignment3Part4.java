package com.shpp.p2p.cs.rvalyaev.assignment3;

import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Частина 4 — Піраміда
 * Отже, потрібно буде забацати пірамідку із цеглинок.
 * Кожен рядок містить на 1 цеглинку менше.
 * Піраміда має бути відцентрована по горизонталі та лежати на “дні” вікна.
 * Константи — BRICK_HEIGHT, BRICK_WIDTH, BRICKS_IN_BASE (скільки цеглинок в основі)
 */

public class Assignment3Part4 extends WindowProgram {
    private final int BRICK_HEIGHT = 30;
    private final int BRICK_WIDTH = 50;
    private final int BRICKS_IN_BASE = 10;

    @Override
    public void run() {
        controlWidth();
        createPyramid();
    }

    // create pyramid. rows count = BRICKS_IN_BASE
    // brick width and height are constants
    public void createPyramid() {
        int rowNumber = 0;
        int breaksLocationX;
        int breaksLocationY;

        while (rowNumber < BRICKS_IN_BASE) {
            breaksLocationX = getLocationX(BRICKS_IN_BASE - rowNumber);
            breaksLocationY = getLocationY(rowNumber + 1);
            cycleToRows(BRICKS_IN_BASE - rowNumber, breaksLocationX, breaksLocationY);
            rowNumber++;
        }
    }

    // check that the screen size is larger than the image size
    public void controlWidth(){
        if ((getWidth() < (BRICK_WIDTH*BRICKS_IN_BASE)) || (getHeight() < (BRICK_HEIGHT * BRICKS_IN_BASE))){
            System.out.println("screen size is smaller than picture size");
            System.exit(0);
        }
    }


    // current row start coordinate X
    private int getLocationX(int countBricks) {
        return (getWidth() - (countBricks * BRICK_WIDTH)) / 2;
    }

    // current row start coordinate Y
    private int getLocationY(int countBricks) {
        return (getHeight() - (countBricks * BRICK_HEIGHT));
    }

    //put a row of brick
    private void cycleToRows(int countBricks, int locationX, int locationY) {
        for (int i = 0; i < countBricks; i++) {
            draweBrick(locationX + i * BRICK_WIDTH, locationY);
        }
    }

    //create brick in bottom. color - random
    public void draweBrick(int locationX, int locationY) {
        RandomGenerator generator = new RandomGenerator(); //ArtScienceJava page 142
        GRect rect = new GRect(locationX, locationY, BRICK_WIDTH, BRICK_HEIGHT);
        rect.setFilled(true);
        rect.setColor(Color.BLACK);
        rect.setFillColor(generator.nextColor());
        add(rect);
    }
}
