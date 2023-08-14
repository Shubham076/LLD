package RideSharingApplication.Strategies;

import RideSharingApplication.Interfaces.IRidePrice;
import RideSharingApplication.Constants;

public class RegularpriceStrategy implements IRidePrice {
    @Override
    public double calculatePrice(int kms, int seats) {
        if (seats >= 2) {
            return kms * seats * 0.75 * Constants.PRICE_PER_KM;
        } else {
            return kms * seats * Constants.PRICE_PER_KM;
        }
    }
}
