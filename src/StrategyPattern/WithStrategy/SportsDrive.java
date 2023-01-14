package StrategyPattern.WithStrategy;

public class SportsDrive implements DriveInterface {

    @Override
    public void drive() {
        System.out.println("sports drive");
    }
}
