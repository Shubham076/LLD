package RideApp.Models;

import RideApp.Enums.RideStatus;

public class Ride {
    private int id;
    private String src;
    private String dest;
    private RideStatus status;
    private int seats;

    private User driver;
    private Vehicle vehicle;

    public Ride(int id, User driver, String src, String dest, int seats, Vehicle vehicle) {
        this.id = id;
        this.src = src;
        this.driver = driver;
        this.dest = dest;
        this.status = RideStatus.NOT_INITIATED;
        this.seats = seats;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isEnded() {
        return this.status.equals(RideStatus.CLOSED);
    }
}
