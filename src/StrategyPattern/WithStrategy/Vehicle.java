package StrategyPattern.WithStrategy;

public class Vehicle {

    DriveInterface d;
    public Vehicle(DriveInterface d) {
        this.d = d;
    }

    public void drive() {
        d.drive();
    }
}
