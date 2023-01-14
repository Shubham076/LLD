package StrategyPattern.WithoutStrategy;

public class Main {

    public static void main(String[] args) {

        /*

        Problem here is that even though both car and sportscar using there
        modified implementation of drive method but underlying implementation is same for both
        which is causing code duplication.

        If we have multiple child classes using their own implementations which is
        common among childs it creates the problem for code duplication.

        The solution is to use strategyPattern
         */
        Vehicle taxi = new Taxi();
        Vehicle car = new Car();
        Vehicle sportsCar = new SportsCar();
        car.drive();
        taxi.drive();
        sportsCar.drive();
    }
}
