package ParkingLot.Models;
import ParkingLot.Enums.PaymentStatus;
import ParkingLot.Enums.VehicleType;
import ParkingLot.Interfaces.ChargingStrategy;
import ParkingLot.Interfaces.ParkingStrategy;
import ParkingLot.Interfaces.PaymentMethod;
import ParkingLot.Models.Vehicles.Vehicle;

import java.util.*;

public class ParkingLot {
    private String id;
    private List<ParkingFloor> floors;

    public ParkingLot(String id, int numOfFloors, HashMap<VehicleType, Integer> slotsPerFloor) {
        this.id = id;
        this.create(numOfFloors, slotsPerFloor);
    }

    private void create(int noOfFloors, HashMap<VehicleType, Integer> slots) {
        this.floors = new ArrayList<>();
        for (int i = 0; i < noOfFloors; i++) {
            int id = this.floors.size() + 1;
            this.floors.add(new ParkingFloor(id, slots));
        }
    }

    public String getId() {
        return id;
    }

    public List<ParkingFloor> getFloors() {
        return this.floors;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Ticket parkVehicle(Vehicle vehicle, ParkingStrategy parkingStrategy,
                              ChargingStrategy chargingStrategy) {
        ParkingSlot slot = parkingStrategy.getAvailableSlot(this, vehicle.getType());
        if (slot == null) {
            System.out.println("Parking slot full for vehicle of type: " + vehicle.getType());
            return null;
        }
        slot.park(vehicle);
        String ticketId = UUID.randomUUID().toString();
        int floorId = slot.getFloorId();
        Optional<ParkingFloor> parkingFloor = this.floors.stream()
                .filter(floor -> floor.getId() == floorId)
                .findFirst();
        Ticket ticket =  new Ticket(ticketId, vehicle, slot, parkingFloor.get(),chargingStrategy);
        System.out.println("Parked vehicle. TicketId: " + ticketId);
        return ticket;
    }

    public PaymentStatus unparkVehicle(Ticket ticket, PaymentMethod paymentMethod) {
        ticket.getSlot().setVehicle(null);
        ParkingFloor floor = ticket.getFloor();
        ticket.getSlot().unPark();
        HashMap<VehicleType, Integer> freeSlots = floor.getFreeSlots();
        HashMap<VehicleType, Integer> occupiedSlots = floor.getOccupiedSlots();
        Vehicle vehicle = ticket.getVehicle();
        freeSlots.put(vehicle.getType(), freeSlots.get(vehicle.getType()) + 1);
        occupiedSlots.put(vehicle.getType(), occupiedSlots.get(vehicle.getType()) - 1);
        System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegNo()
        + " and Color: " + vehicle.getColor());
        return ticket.makePayment(paymentMethod);
    }

    public void displaySlotStatus() {
        for (ParkingFloor floor : floors) {
            System.out.println("-----------------------------");
            System.out.println("Floor: " + floor.getId());
            floor.showOccupiedSlots();
            floor.showFreeSlots();
        }
    }
}
