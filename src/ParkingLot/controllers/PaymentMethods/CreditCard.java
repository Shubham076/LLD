package ParkingLot.controllers.PaymentMethods;

import ParkingLot.Enums.PaymentStatus;
import ParkingLot.Interfaces.PaymentMethod;

public class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String cvv;

    public CreditCard(String cardNumber, String cvv) {
        this.cvv = cvv;
        this.cardNumber = cardNumber;
    }
    @Override
    public PaymentStatus pay(double amount) {
        return PaymentStatus.SUCCESS;
    }
}
