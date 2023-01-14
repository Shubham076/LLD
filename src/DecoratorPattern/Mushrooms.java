package DecoratorPattern;

public class Mushrooms extends ToppingsDecorator {
    BasePizza pizza;

    public Mushrooms(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return pizza.cost() + 20;
    }
}
