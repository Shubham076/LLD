package RideSharingApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class InputProcessor {
    private RideService service;

    public InputProcessor() {
        this.service = new RideService();
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
            case "AddRider":
                service.addUser(parts[1]);
                break;
            case "CreateRide":
                service.createRide(parts[1], Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                break;
            case "CancelRide":
                service.cancelRide(parts[1]);
                break;
            case "CloseRide":
                service.closeRide(parts[1]);
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}