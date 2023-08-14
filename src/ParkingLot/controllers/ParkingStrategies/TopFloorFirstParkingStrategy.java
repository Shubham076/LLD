package ParkingLot.controllers.ParkingStrategies;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Interfaces.ParkingStrategy;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.ParkingSlot;

public class TopFloorFirstParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlot getAvailableSlot(ParkingLot parkingLot, VehicleType type) {
        return null;
    }
}
