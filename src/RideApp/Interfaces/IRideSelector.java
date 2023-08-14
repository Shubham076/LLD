package RideApp.Interfaces;

import RideApp.Models.Ride;

import java.util.List;

public interface IRideSelector {
    Ride selectRide(List<Ride> rides);
}
