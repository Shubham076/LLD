package DecoratorPattern;

import FactoryDesign.Circle;
import FactoryDesign.Shape;
import FactoryDesign.Square;
import java.awt.Checkbox;
import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static  class ToppingsDecoratorFactory {
        public static BasePizza getPizza(String input, BasePizza pizza) {
            switch (input) {
            case "MUSHROOMS" :
                return new Mushrooms(pizza);

            case "EXTRACHEESE":
                return new ExtraCheese(pizza);
            default: return null;
            }
        }
    }
    public static void main(String[] args) {
        List<String> toppings = new ArrayList<>();
        toppings.add("MUSHROOMS");
        toppings.add("EXTRACHEESE");
        BasePizza pizza = new FarmHouse();
        for(String topping: toppings) {
            pizza = ToppingsDecoratorFactory.getPizza(topping, pizza);
        }
//        BasePizza pizza = new Mushrooms(new ExtraCheese(new FarmHouse()));
        System.out.println(pizza.cost());
    }
}
