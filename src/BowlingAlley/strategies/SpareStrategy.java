package BowlingAlley.strategies;

import BowlingAlley.AbstractClasses.BonusStrategy;
import BowlingAlley.Enums.BonusStrategyType;
import BowlingAlley.Models.Frame;

public class SpareStrategy extends BonusStrategy {

    public SpareStrategy(BonusStrategyType bonusType) {
        super(bonusType);
    }

    @Override
    public boolean applies(Frame frame) {
        if (frame.getBallThrows().size() != 2) return false;
        boolean isApplicable =  frame.getBallThrows().get(0) + frame.getBallThrows().get(1) == 10 && frame.getBallThrows().get(0) != 10;

        return isApplicable;
    }

    @Override
    public int computeBonus(Frame frame) {
        return 5;
    }
}
