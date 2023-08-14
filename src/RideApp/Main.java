package RideApp;

public class Main {
    public static void main(String[] args) {
        InputProcessor processor = new InputProcessor();
        processor.processInputFromFile("src/RideApp/Input.txt");
//        processor.processInputFromConsole();
    }
}
