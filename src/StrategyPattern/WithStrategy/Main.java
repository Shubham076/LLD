package StrategyPattern.WithStrategy;

public class Main {

    public static void main(String[] args) {

        /*

        whenever we have multiple child classes using their own implementations which is
        common among childs we use strategyPattern
         */
        Vehicle taxi = new Taxi();
        Vehicle car = new Car();
        Vehicle sportsCar = new SportsCar();
        car.drive();
        taxi.drive();
        sportsCar.drive();
    }
}
