package RideSharingApplication;
import RideSharingApplication.Enums.RideStatus;
import RideSharingApplication.Models.Ride;
import RideSharingApplication.Models.Rider;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class RideService {
    List<Ride> rides;
    List<Rider> riders;

    public RideService() {
        rides = new ArrayList<>();
        riders = new ArrayList<>();
    }

    public void addUser(String name) {
        Rider r = new Rider(name, 0);
        r.addObserver(new PreferredRiderObserver());
        riders.add(r);

        System.out.println("Rider: " + name + " added to the service");
    }
    public String createRide(String name, int src, int dest, int seats) {
        Optional<Rider> rider = this.riders.stream().filter(r -> r.getName().equals(name)).findFirst();
        Ride r = new Ride(src, dest, seats, rider.get());
        this.rides.add(r);
        System.out.println("Ride created for user: " + name + " id: " + r.getId());
        return r.getId();
    }

    public void cancelRide(String rideId) {
        Optional<Ride> ride = this.rides.stream().filter(r -> r.getId().equals(rideId)).findFirst();
        ride.get().setStatus(RideStatus.CANCELLED);
        System.out.println("Cancelled ride: " + ride.get().getId());
    }

    public double closeRide(String rideId) {
        Optional<Ride> ride = this.rides.stream().filter(r -> r.getId().equals(rideId)).findFirst();
        double amount = ride.get().closeRide();
        Rider r = ride.get().getRider();
        System.out.println("Ride amount: " + amount);
        r.incrementRides();
        return amount;
    }

    public void updateRide(String rideId, int start, int end, int seats) {
        Optional<Ride> ride = this.rides.stream().filter(r -> r.getId().equals(rideId)).findFirst();
        Ride r = ride.get();
        r.setStart(start);
        r.setEnd(end);
        r.setSeats(seats);
    }
}
