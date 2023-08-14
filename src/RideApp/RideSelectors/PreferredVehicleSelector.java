package RideApp.RideSelectors;

import RideApp.Interfaces.IRideSelector;
import RideApp.Models.Ride;

import java.util.List;

public class PreferredVehicleSelector implements IRideSelector {
    private String vehicleName;

    public PreferredVehicleSelector(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public Ride selectRide(List<Ride> rides) {
        return rides.stream()
                .filter(r -> r.getVehicle().getName().equals(vehicleName))
                .findFirst()
                .orElse(null);
    }
}
