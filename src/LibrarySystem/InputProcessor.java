package LibrarySystem;
import LibrarySystem.Service.LibraryService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class InputProcessor {
    private LibraryService service;

    public InputProcessor() {
        this.service = new LibraryService();
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
            case "REGISTER":
                service.addUser(parts[1], parts[2], parts[3], parts[4]);
                break;
            case "BORROW":
                service.borrowBook(parts[1], parts[2], parts[3]);
                break;
            case "RETURN":
                service.returnBook(parts[1], parts[2], parts[3]);
                break;
            case "VIEW":
                service.view(parts[1]);
                break;
            case "SHOW_INVENTORY":
                service.showInventory();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}