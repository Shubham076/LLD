package RideApp.RideSelectors;

import RideApp.Interfaces.IRideSelector;
import RideApp.Models.Ride;

import java.util.Comparator;
import java.util.List;

public class MostVacantSelector implements IRideSelector {
    @Override
    public Ride selectRide(List<Ride> rides) {
        return rides.stream()
                .max(Comparator.comparing(Ride::getSeats))
                .orElse(null);
    }
}
