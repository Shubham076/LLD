package RideSharingApplication.Models;

import RideSharingApplication.Enums.RideStatus;
import RideSharingApplication.IPriceFactory;
import RideSharingApplication.Interfaces.IRidePrice;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ride {

    private String id;
    private int start;
    private int end;
    private int seats;
    private RideStatus status;

    private String startTime;
    private String endTime;

    private IRidePrice priceStrategy;

    private Rider rider;

    public Ride(int start, int end, int seats, Rider rider) {
        this.id = UUID.randomUUID().toString();
        this.start = start;
        this.end = end;
        this.seats = seats;
        this.status = RideStatus.ACTIVE;
        this.startTime = LocalDateTime.now().toString();
        this.rider = rider;
        this.priceStrategy = IPriceFactory.getPriceStrategy(rider);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public IRidePrice getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(IRidePrice priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public double closeRide() {
        int kms = (end - start);
        return this.priceStrategy.calculatePrice(kms, this.seats);
    }
}
