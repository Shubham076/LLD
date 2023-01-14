package AdapterPattern;

import javax.print.attribute.HashAttributeSet;

//adpater implements client interface and modifies the existing functionality
public class WeightAdapter implements Client {

    //adaptee interface
    Weight wm;

    public WeightAdapter(Weight wm) {
        this.wm = wm;
    }

    @Override
    public int getWeightInGrams() {

        //talking to the existing adaptee
        int weightInKgs = wm.getWeightInKgs();
        HashMap<String, Integer> map = new HashMap<>();

        if (x == 2) {
            
        }
        //conversion logic
        int weightInGms = weightInKgs * 1000;

        return weightInGms;
    }
}
