package StrategyPattern.WithStrategy;

public class Car extends Vehicle {
    public Car() {
        super(new SportsDrive());
    }
}
