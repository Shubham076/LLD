package ParkingLot.Interfaces;
import java.time.LocalDateTime;

public interface ChargingStrategy {
    double calculateCharge(LocalDateTime entryTime, LocalDateTime exitTime);
}
