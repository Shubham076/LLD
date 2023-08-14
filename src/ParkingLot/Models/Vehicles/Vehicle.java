package ParkingLot.Models.Vehicles;

import ParkingLot.Enums.VehicleType;

public abstract class Vehicle {
    protected String regNo;
    protected String color;

    public Vehicle(String regNo, String color) {
        this.regNo = regNo;
        this.color = color;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }

    public abstract VehicleType getType();
}
