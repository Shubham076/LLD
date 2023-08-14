package TicTacToe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class InputProcessor {
    private Game game;

    public InputProcessor() {
        this.game = new Game();
    }

    public void processInputFromConsole() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line, br);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public void processInputFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line, br);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private void processLine(String line, BufferedReader br) throws IOException{
        String[] parts = line.split(" ");
        String command = parts[0];

        switch(command) {
            case "initialize":
                game.initialize(Integer.parseInt(parts[1]));
                break;
            case "addPlayer":
                game.addPlayer(parts[1], parts[2]);
                break;
            case "startGame":
                game.startGame(br);
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}