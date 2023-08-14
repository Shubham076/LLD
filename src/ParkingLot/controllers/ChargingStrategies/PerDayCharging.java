package ParkingLot.controllers.ChargingStrategies;

import ParkingLot.Interfaces.ChargingStrategy;
import java.time.Duration;
import java.time.LocalDateTime;

public class PerDayCharging implements ChargingStrategy {
    private static final double RATE_PER_DAY = 20.00; // Example rate

    @Override
    public double calculateCharge(LocalDateTime entryTime, LocalDateTime exitTime) {
        long days = Duration.between(entryTime, exitTime).toDays();
        return days * RATE_PER_DAY;
    }
}
