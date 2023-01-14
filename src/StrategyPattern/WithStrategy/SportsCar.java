package StrategyPattern.WithStrategy;

public class SportsCar extends Vehicle {
    public SportsCar() {
        super(new SportsDrive());
    }
}
