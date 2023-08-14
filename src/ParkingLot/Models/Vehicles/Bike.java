package ParkingLot.Models.Vehicles;

import ParkingLot.Enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String regNo, String color) {
        super(regNo, color);
    }
    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
