package RideApp;

import RideApp.Enums.RideStatus;
import RideApp.Exceptions.RideNotFoundException;
import RideApp.Exceptions.UserNotFoundException;
import RideApp.Exceptions.VehicleNotFoundException;
import RideApp.Interfaces.IRideSelector;
import RideApp.Models.Ride;
import RideApp.Models.User;
import RideApp.Models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RideAppService {
    private List<User> users;
    private List<Ride> rides;

    public  RideAppService() {
        users = new ArrayList<>();
        rides = new ArrayList<>();
    }

    public void addUser(String name, String gender, Integer age) {
        User user = users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
        if (user == null) {
            users.add(new User(name, gender, age));
            System.out.println("User: " + name + " added to the service");
        } else {
            System.out.println("User: " + name + " already added to the service");
        }
    }

    public void addVehicle(String username, String name, String registrationNo) {
        try {
            User user = users.stream().filter(u -> u.getName().equals(username)).findFirst().get();
            Vehicle vehicle = user.getVehicles().stream().filter(v -> v.getName().equals(name)).findFirst().orElse(null);
            if (vehicle == null) {
                user.addVehicle(new Vehicle(name, registrationNo));
                System.out.println("Vehicle: " + name + " added to user: " + username);
            } else {
                System.out.println("Vehicle: " + name + " already present for the user: " + username);
            }
        } catch (NoSuchElementException e) {
            System.out.println("User: " + username + " not found");
        }
    }

    public void offerRide(String userName, String src, int seats, String vehicleName, String dest) {
        try {
            User user = users.stream().filter(u -> u.getName().equals(userName)).findFirst().orElse(null);
            if (user == null) {
                throw new UserNotFoundException(userName + "not found");
            }
            Vehicle vehicle = user.getVehicles().stream().filter(v -> v.getName().equals(vehicleName)).findFirst().orElse(null);
            if (vehicle == null) {
                throw new VehicleNotFoundException(userName + " doesn't have any vehicle registered with name: " + vehicleName);
            }

            //check if ride already present or not
            Ride ride  = rides.stream().filter(r -> r.getDriver().getName().equals(userName) && r.getVehicle().getName().equals(vehicleName)).findFirst().orElse(null);
            if (ride == null) {
                int id = rides.size() + 1;
                Ride newRide = new Ride(id, user, src, dest, seats, vehicle);
                rides.add(newRide);
                user.addRidesOffered(newRide);
                System.out.println("Offered Ride successfully");
            } else {
                System.out.println("Ride already exists");
            }

        } catch (UserNotFoundException | VehicleNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectRide(String username, String src, String dest, int seats, String strategy) {
        try {
            User user = users.stream().filter(u -> u.getName().equals(username)).findFirst().orElse(null);
            if (user == null) {
                throw new UserNotFoundException(username + "not found");
            }
            List<Ride> validRides = rides.stream().filter(r -> r.getSrc().equals(src) &&
                        r.getDest().equals(dest)).collect(Collectors.toList());
            IRideSelector selector = RideSelectorFactory.getSelector(strategy);
            Ride selectedRide = selector.selectRide(validRides);
            if (selectedRide != null) {
                user.addRidesTaken(selectedRide);
                selectedRide.setStatus(RideStatus.ACTIVE);
                System.out.println("Selected ride: " + selectedRide.getId());
            } else {
                System.out.println("Ride not found");
            }

        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void endRide(int id) {
        try {
            Ride ride = rides.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
            if (ride == null) {
                throw new RideNotFoundException("Ride: " + id + " not found");
            }
            ride.setStatus(RideStatus.CLOSED);
            System.out.println("Ride: " + id + " ended");
        } catch(RideNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printRideStats() {
        for (User u: users) {
            System.out.println(u.getName() + ": " + u.getRidesTaken() + " Taken, " + u.getRidesOffered() + " Offered");
        }
    }
}
