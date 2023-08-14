package ParkingLot.Interfaces;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.ParkingSlot;

public interface ParkingStrategy {
    ParkingSlot getAvailableSlot(ParkingLot parkingLot, VehicleType type);
}
