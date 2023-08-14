package ParkingLot.Interfaces;

import ParkingLot.Enums.PaymentStatus;

public interface PaymentMethod {
    public PaymentStatus pay(double amount);
}
