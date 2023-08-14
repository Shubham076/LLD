package SplitWise;

public class Main {
    public static void main(String[] args) {
        InputProcessor processor = new InputProcessor();
//        processor.processInputFromConsole();
        processor.processInputFromFile("src/SplitWise/Input.txt");
    }
}
