package FactoryDesign;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s = factory.getShape("CIRCLE");
        s.draw();
    }
}
