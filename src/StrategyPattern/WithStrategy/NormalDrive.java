package StrategyPattern.WithStrategy;

public class NormalDrive implements DriveInterface{

    @Override
    public void drive() {
        System.out.println("normal drive");
    }
}
