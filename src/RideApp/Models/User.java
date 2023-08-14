package RideApp.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String name;
    private String gender;
    private double age;
    private List<Vehicle> vehicles;
    private List<Ride> ridesOffered;
    private List<Ride> ridesTaken;

    public User(String name, String gender, double age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<>();
        this.ridesOffered = new ArrayList<>();
        this.ridesTaken = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public int getRidesTaken() {
        return ridesTaken.stream().filter(Ride::isEnded).collect(Collectors.toList()).size();
    }

    public int getRidesOffered() {
        return ridesOffered.stream().filter(Ride::isEnded).collect(Collectors.toList()).size();
    }

    public void addRidesTaken(Ride r) {
        this.ridesTaken.add(r);
    }

    public void addRidesOffered(Ride r) {
        this.ridesOffered.add(r);
    }
}
