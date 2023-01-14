package StrategyPattern.WithStrategy;

public class Taxi extends Vehicle {

    public Taxi() {
        super(new NormalDrive());
    }
}
