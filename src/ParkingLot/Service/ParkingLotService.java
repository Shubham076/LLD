package ParkingLot.Service;
import ParkingLot.Enums.PaymentStatus;
import ParkingLot.Enums.VehicleType;
import ParkingLot.Interfaces.ChargingStrategy;
import ParkingLot.Interfaces.ParkingStrategy;
import ParkingLot.Interfaces.PaymentMethod;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ParkingLotService {
    private List<ParkingLot> parkingLots;

    public ParkingLotService(){
        this.parkingLots = new ArrayList<>();
    };

    public void addParkingLot(String id, int numberOfFloors, HashMap<VehicleType, Integer> slotsPerFloor) {
        this.parkingLots.add(new ParkingLot(id, numberOfFloors, slotsPerFloor));
    }

    public Ticket parkVehicle(String parkingLotId, Vehicle vehicle,
                              ParkingStrategy parkingStrategy, ChargingStrategy chargingStrategy) {
        Optional<ParkingLot> lot = this.parkingLots.stream()
                .filter(pl -> pl.getId() == parkingLotId)
                .findFirst();
        return lot.get().parkVehicle(vehicle, parkingStrategy, chargingStrategy);
    }

    public PaymentStatus unparkVehicle(String id, Ticket ticket, PaymentMethod paymentMethod) {
        Optional<ParkingLot> lot = this.parkingLots.stream()
                .filter(pl -> pl.getId() == id)
                .findFirst();
        return lot.get().unparkVehicle(ticket, paymentMethod);
    }

    public void display(String id) {
        Optional<ParkingLot> lot = this.parkingLots.stream()
                .filter(pl -> pl.getId() == id)
                .findFirst();
        lot.get().displaySlotStatus();
    }
}

