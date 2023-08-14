package ParkingLot.Models;
import ParkingLot.Enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingFloor {
    private int id;
    private List<ParkingSlot> slots;
    private HashMap<VehicleType, Integer> freeSlots;
    private HashMap<VehicleType, Integer> occupiedSlots;

    public ParkingFloor(int id, HashMap<VehicleType, Integer> slots) {
        this.id = id;
        this.initializeFloor(slots);
    }

    private void initializeFloor(HashMap<VehicleType, Integer> slots) {
        this.slots = new ArrayList<>();
        freeSlots = new HashMap<>();
        occupiedSlots = new HashMap<>();
        for(VehicleType type: slots.keySet()) {
            int cnt = slots.get(type);
            freeSlots.put(type, cnt);
            occupiedSlots.put(type, 0);
            for (int i = 0; i < cnt; i++) {
                int nextSlotNumber = this.slots.size() + 1;
                this.slots.add(new ParkingSlot(type, nextSlotNumber, id));
            }
        }
    }

    public HashMap<VehicleType, Integer> getFreeSlots() {
        return this.freeSlots;
    }

    public HashMap<VehicleType, Integer> getOccupiedSlots() {
        return this.occupiedSlots;
    }

    public void showOccupiedSlots() {
        System.out.println("Occupied Slots:");
        for (VehicleType vehicleType: occupiedSlots.keySet()) {
            int cnt = occupiedSlots.get(vehicleType);
            System.out.println(vehicleType.name() + " : " + cnt);
        }
    }

    public void showFreeSlots() {
        System.out.println("Free Slots:");
        for (VehicleType vehicleType: freeSlots.keySet()) {
            int cnt = freeSlots.get(vehicleType);
            System.out.println(vehicleType.name() + " : " + cnt);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

}
