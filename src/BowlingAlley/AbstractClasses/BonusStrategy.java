package BowlingAlley.AbstractClasses;
import BowlingAlley.Enums.BonusStrategyType;
import BowlingAlley.Models.Frame;
public abstract class  BonusStrategy {

    private BonusStrategyType bonusType;

    public BonusStrategy(BonusStrategyType bonusType) {
        this.bonusType = bonusType;
    }

    public BonusStrategyType getBonusType() {
        return bonusType;
    }
    public abstract boolean applies(Frame framer);
    public abstract int computeBonus(Frame frame);
}
