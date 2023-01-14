package SnakesNLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int min = 1;
    int max = 6;
    int c;
    Dice(int c) {
        this.c = c;
    }

    public int rollDice() {
        int v = 0, i = 0;
        while(i < c) {
            v += ThreadLocalRandom.current().nextInt(min,max + 1);
            i++;
        }
        return v;
    }
}
