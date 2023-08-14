package ParkingLot.Models.Vehicles;

import ParkingLot.Enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String regNo, String color) {
        super(regNo, color);
    }
    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
