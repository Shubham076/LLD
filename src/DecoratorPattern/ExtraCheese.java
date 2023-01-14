package DecoratorPattern;

public class ExtraCheese extends ToppingsDecorator {
    BasePizza pizza;

    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public int cost() {
        return pizza.cost() + 10;
    }
}
