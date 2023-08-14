package ParkingLot.controllers.PaymentMethods;

import ParkingLot.Enums.PaymentStatus;
import ParkingLot.Interfaces.PaymentMethod;

public class Upi implements PaymentMethod {
    private String upiId;
    public Upi(String upiId) {
        this.upiId = upiId;
    }
    @Override
    public PaymentStatus pay(double amount) {
        return PaymentStatus.FAILED;
    }
}
