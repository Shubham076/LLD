package SplitWise;

import SplitWise.Factories.Splitfactory;
import SplitWise.Models.Split;
import SplitWise.Service.SplitwiseService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InputProcessor {
    private SplitwiseService service;

    public InputProcessor() {
        this.service = new SplitwiseService();
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
                service.addUser(parts[1]);
                break;
            case "addExpense":
                String expenseType = parts[1];
                String paidBy = parts[2];
                double amount = Double.parseDouble(parts[3]);
                int splitCount = Integer.parseInt(parts[4]);
                List<String> friends = new ArrayList<>();
                List<Double> vals = new ArrayList<>();

                for(int i = 0; i < splitCount; i++) {
                    friends.add(parts[5 + i]);
                }

                if (expenseType.equals("EXACT") || expenseType.equals("PERCENTAGE")) {
                    for(int i = 0; i < splitCount; i++) {
                        String temp = parts[5 + splitCount + i];
                        vals.add(Double.parseDouble(temp));
                    }
                }
                service.addExpense(expenseType, paidBy, amount, friends, vals);
                break;
            case "showBalance":
                service.showBalances(parts[1]);
                break;
            case "show":
                service.show();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}