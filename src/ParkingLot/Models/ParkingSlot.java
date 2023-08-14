package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Models.Vehicles.Vehicle;

public class ParkingSlot {
    private VehicleType vehicleType;
    private Vehicle vehicle;
    private int id;
    private int floorId;

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public ParkingSlot(VehicleType vehicleType, int id, int floorId) {
        this.vehicleType = vehicleType;
        this.id = id;
        this.floorId = floorId;
    }

    public boolean isOccupied() {
        return vehicle != null;
    }

    public VehicleType getVehicle() {
        return vehicleType;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle unPark() {
        this.vehicle = null;
        return this.vehicle;
    }
}
