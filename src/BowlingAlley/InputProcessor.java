package BowlingAlley;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class InputProcessor {
    private BowlingGame game;

    public InputProcessor() {
        this.game = new BowlingGame();
    }

    public void processInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands. Type 'exit' to stop:");
        while(true) {
            String line = scanner.nextLine();
            if ("exit".equalsIgnoreCase(line)) {
                break;
            }
            processLine(line);
        }
    }

    public void processInputFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private void processLine(String line) {
        String[] parts = line.split(" ");
        String command = parts[0];

        switch(command) {
            case "addLane":
                game.addLane(Integer.parseInt(parts[1]));
                break;
            case "addPlayer":
                game.addPlayer(Integer.parseInt(parts[1]), parts[2]);
                break;
            case "startGame":
                game.startGame(Integer.parseInt(parts[1]));
                break;
            case "show":
                game.show(Integer.parseInt(parts[1]));
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}