package AdapterPattern;

public class Main {
    public static void main(String[] args) {
        Client c = new WeightAdapter(new WeightImp());
        System.out.println(c.getWeightInGrams());
    }
}
