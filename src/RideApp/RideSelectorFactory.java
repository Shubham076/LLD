package RideApp;

import RideApp.Interfaces.IRideSelector;
import RideApp.RideSelectors.MostVacantSelector;
import RideApp.RideSelectors.PreferredVehicleSelector;

public class RideSelectorFactory {
    public static IRideSelector getSelector(String s) {
        String condition = s;
        String[] parts = s.split("=");
        if (s.contains("=")) {
            condition = parts[0];
        }

        switch (condition) {
            case "MostVacant":
                return new MostVacantSelector();
            case "PreferredVehicle":
                return new PreferredVehicleSelector(parts[1]);
            default: return null;
        }
    }
}
