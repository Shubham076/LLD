package ParkingLot.Models.Vehicles;

import ParkingLot.Enums.VehicleType;

public class Car extends Vehicle{
    public Car(String regNo, String color) {
        super(regNo, color);
    }
    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
