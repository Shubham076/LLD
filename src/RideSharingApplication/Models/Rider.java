package RideSharingApplication.Models;

import RideSharingApplication.Enums.RiderType;
import RideSharingApplication.Interfaces.Observable;
import RideSharingApplication.Interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Rider implements Observable {
    private List<Observer> observers;
    private String name;
    private int rides;
    private RiderType riderType;

    public RiderType getRiderType() {
        return riderType;
    }

    public void setRiderType(RiderType riderType) {
        this.riderType = riderType;
    }

    public Rider(String name, int rides) {
        this.name = name;
        this.rides = rides;
        this.observers = new ArrayList<>();
        this.riderType = RiderType.REGULAR;
    }

    public String getName() {
        return name;
    }

    public int getRides() {
        return rides;
    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void incrementRides() {
        this.rides++;
        if (this.rides >= 2) {
            this.notifyObserver();
        }
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o: this.observers) {
            o.updateRider(this);
        }
    }
}
