package ParkingLot.controllers.ParkingStrategies;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Interfaces.ParkingStrategy;
import ParkingLot.Models.ParkingFloor;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.ParkingSlot;

import java.util.HashMap;
import java.util.Optional;


// "nearest" means the slot with the smallest floor number and
// smallest slot number within that floor for the given VehicleType
// "nearest" means the slot with the smallest floor number and smallest
// slot number within that floor for the given VehicleType
public class NearestFirstParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlot getAvailableSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor floor: parkingLot.getFloors()) {

            // all the floors are sorted by id (1...n)
            HashMap<VehicleType, Integer> freeSlots = floor.getFreeSlots();
            int cnt = freeSlots.getOrDefault(vehicleType, 0);
            if (cnt != 0) {

                //all the slots are sorted by id (1...n)
                Optional<ParkingSlot> lot = floor.getSlots().stream()
                        .filter(l -> l.getVehicle() == vehicleType)
                        .findFirst();

                HashMap<VehicleType, Integer> occupiedSlots = floor.getOccupiedSlots();
                occupiedSlots.put(vehicleType, occupiedSlots.get(vehicleType) + 1);
                freeSlots.put(vehicleType, freeSlots.get(vehicleType) - 1);
                return lot.get();
            }
        }
        return null;
    }
}
