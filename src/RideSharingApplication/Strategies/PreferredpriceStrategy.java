package RideSharingApplication.Strategies;

import RideSharingApplication.Constants;
import RideSharingApplication.Interfaces.IRidePrice;

public class PreferredpriceStrategy implements IRidePrice {
    @Override
    public double calculatePrice(int kms, int seats) {
        if (seats >= 2) {
            return kms * seats * 0.5 * Constants.PRICE_PER_KM;
        } else {
            return kms * seats * Constants.PRICE_PER_KM;
        }
    }
}
