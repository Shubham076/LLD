package Trello;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Input {
    private Service service;

    public Input() {
        this.service = new Service();
    }

    public void processInputFromConsole() {
        System.out.println("Started Trello Service");
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
            case "addBoard":
                service.addBoard(parts[1], parts[2], parts[3]);
                break;
            case "deleteBoard":
                service.deleteBoard(parts[1]);
                break;
            case "viewBoard":
                service.viewBoard(parts[1]);
                break;
            case "addUser":
                service.addUser(parts[1], parts[2], parts[3]);
                break;
            case "addList":
                service.addList(parts[1], parts[2]);
                break;
            case "deleteList":
                service.deleteList(parts[1], parts[2]);
                break;
            case "showList":
                service.showList(parts[1], parts[2]);
                break;
            case "addCard":
                service.addCard(parts[1], parts[2], parts[3],  Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                break;
            case "deleteCard":
                service.deleteCard(parts[1], parts[2], parts[3]);
                break;
            case "moveCard":
                service.moveCard(parts[1], parts[2], parts[3], parts[4]);
                break;
            case "assignCard":
                service.assignCard(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                break;
            case "showCard":
                service.showCard(parts[1], parts[2], parts[3]);
                break;
            case "overview":
                service.overview();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}