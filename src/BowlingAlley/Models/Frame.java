package BowlingAlley.Models;
import BowlingAlley.AbstractClasses.BonusStrategy;

import java.util.*;
public class Frame {
    private List<Integer> ballThrows;
    private double bonus;

    public Frame() {
        this.ballThrows = new ArrayList<>();
    }

    public void addThrow(int pinsDown) {
        ballThrows.add(pinsDown);
    }

    public List<Integer> getBallThrows() {
        return ballThrows;
    }


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void calculateBonus(BonusStrategy strategy) {
        this.bonus += strategy.computeBonus(this);
    }

    public double getScore() {
        int total = ballThrows.stream().mapToInt(Integer::intValue).sum();
        return total + bonus;
    }
}
