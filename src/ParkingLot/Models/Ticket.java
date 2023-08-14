package ParkingLot.Models;

import ParkingLot.Enums.PaymentStatus;
import ParkingLot.Interfaces.ChargingStrategy;
import ParkingLot.Interfaces.PaymentMethod;
import ParkingLot.Models.Vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSlot slot;

    private ParkingFloor floor;
    private User user;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amountDue;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;

    public Ticket(String id, Vehicle vehicle, ParkingSlot slot,ParkingFloor floor,  ChargingStrategy chargingStrategy) {
        this.id = id;
        this.vehicle = vehicle;
        this.slot = slot;
        this.floor = floor;
        this.entryTime = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
        this.chargingStrategy = chargingStrategy;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    private ChargingStrategy chargingStrategy;

    public PaymentStatus makePayment(PaymentMethod method) {
        this.paymentMethod = method;
        this.exitTime = LocalDateTime.now();
        this.amountDue = chargingStrategy.calculateCharge(entryTime, exitTime);
        return this.paymentStatus = paymentMethod.pay(this.amountDue);
    }

    public ChargingStrategy getChargingStrategy() {
        return chargingStrategy;
    }

    public void setChargingStrategy(ChargingStrategy chargingStrategy) {
        this.chargingStrategy = chargingStrategy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
