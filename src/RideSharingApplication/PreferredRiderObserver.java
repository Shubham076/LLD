package RideSharingApplication;

import RideSharingApplication.Enums.RiderType;
import RideSharingApplication.Interfaces.Observer;
import RideSharingApplication.Models.Ride;
import RideSharingApplication.Models.Rider;

public class PreferredRiderObserver implements Observer {

    @Override
    public void updateRider(Rider r) {
        if (r.getRides() >= 2 &&  r.getRiderType() != RiderType.PREFERRED) {
            System.out.println("Rider: " + r.getName() + " updated to preferred rider");
            r.setRiderType(RiderType.PREFERRED);
        }
    }
}
