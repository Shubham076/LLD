package ParkingLot;
import ParkingLot.Enums.VehicleType;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicles.Car;
import ParkingLot.Service.ParkingLotService;
import ParkingLot.controllers.ChargingStrategies.PerHourCharging;
import ParkingLot.controllers.ParkingStrategies.NearestFirstParkingStrategy;
import ParkingLot.controllers.PaymentMethods.Upi;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ParkingLotService service = new ParkingLotService();
        HashMap<VehicleType, Integer> map = new HashMap<>(Map.of(
                VehicleType.CAR, 3,
                VehicleType.TRUCK, 2,
                VehicleType.BIKE, 1
        ));
        service.addParkingLot("abc", 2, map);
        for (int i = 0; i < 7; i++) {
            Ticket t = service.parkVehicle("abc",
                    new Car(String.valueOf(i + 1), "red"),
                    new NearestFirstParkingStrategy(),
                    new PerHourCharging());
        }

//        service.unparkVehicle("abc", t, new Upi("shubham@ybl"));
        service.display("abc");
    }
}
