package ParkingLot.controllers.ChargingStrategies;

import ParkingLot.Interfaces.ChargingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class PerHourCharging implements ChargingStrategy {
    private static final double RATE_PER_HOUR = 2.00; // Example rate

    @Override
    public double calculateCharge(LocalDateTime entryTime, LocalDateTime exitTime) {
        long hours = Duration.between(entryTime, exitTime).toHours();
        return hours * RATE_PER_HOUR;
    }
}
