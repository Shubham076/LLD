package RideApp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class InputProcessor {
    private RideAppService service;

    public InputProcessor() {
        this.service = new RideAppService();
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
            case "addUser":
                service.addUser(parts[1], parts[2], Integer.parseInt(parts[3]));
                break;
            case "addVehicle":
                service.addVehicle(parts[1], parts[2], parts[3]);
                break;
            case "offerRide":
                service.offerRide(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], parts[5]);
                break;
            case "selectRide":
                service.selectRide(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5]);
                break;
            case "endRide":
                service.endRide(Integer.parseInt(parts[1]));
                break;
            case "rideStats":
                service.printRideStats();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}