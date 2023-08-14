package RideSharingApplication;
import RideSharingApplication.Interfaces.IRidePrice;
import RideSharingApplication.Models.Rider;
import RideSharingApplication.Strategies.PreferredpriceStrategy;
import RideSharingApplication.Strategies.RegularpriceStrategy;

public class IPriceFactory {
    public static IRidePrice getPriceStrategy(Rider ride) {
        if (ride.getRides() >= 2) {
            return new PreferredpriceStrategy();
        } else {
            return new RegularpriceStrategy();
        }
    }
}
