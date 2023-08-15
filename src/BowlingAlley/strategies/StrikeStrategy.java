package BowlingAlley.strategies;

import BowlingAlley.AbstractClasses.BonusStrategy;
import BowlingAlley.Enums.BonusStrategyType;
import BowlingAlley.Models.Frame;

public class StrikeStrategy extends BonusStrategy {

    public StrikeStrategy(BonusStrategyType bonusType) {
        super(bonusType);
    }

    @Override
    public boolean applies(Frame frame) {
        return frame.getBallThrows().get(0) == 10;
    }

    @Override
    public int computeBonus(Frame frame) {
        return 10;
    }
}
