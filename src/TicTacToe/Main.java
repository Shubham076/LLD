package TicTacToe;

public class Main {
    public static void main(String[] args) {
        InputProcessor processor = new InputProcessor();
        processor.processInputFromFile("src/TicTacToe/Input.txt");
    }
}
