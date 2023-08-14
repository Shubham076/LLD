package DigitalWallet;

import DigitalWallet.Interface.Observer;
import DigitalWallet.Offers.Offer1;
import DigitalWallet.Service.WalletService;

import java.io.*;
import java.util.Scanner;

class InputProcessor {
    private WalletService service;

    public InputProcessor() {
        this.service = new WalletService();
        Observer offer1 = new Offer1();
        service.addObserver(offer1);
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
            case "CreateWallet":
                service.createWallet(parts[1], Double.parseDouble(parts[2]));
                break;
            case "TransferMoney":
                service.transfer(parts[1], parts[2], Double.parseDouble(parts[3]));
                break;
            case "Statement":
                service.showStatement(parts[1]);
                break;
            case "Overview":
                service.overview();
                break;
            case "Offer2":
                service.offer2();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}