package com.linkedin.javacodechallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class App {

    private static HashMap<String, Integer> hmap = new HashMap<>();

    public static void loadTicketDB() throws java.io.FileNotFoundException {
        String fileName = "ticketHolders.csv";
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");
        App.hmap = new HashMap<>();
        // String titleRow = sc.nextLine();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() != 0) {
                String[] fields = Arrays.stream(line.split(","))
                        .map(String::trim)
                        .toArray(String[]::new);
                App.hmap.put(fields[0], Integer.parseInt(fields[1]));
            }
        }
        sc.close();
    }

    public static int checkTicketDB(String name) {

        Optional<Integer> ticketsPurchased = Optional.ofNullable(App.hmap.get(name));
        return ticketsPurchased.orElse(0);
    }

    public static void main(String[] args) {
        try {
            // Load CSV file into Java.
            App.loadTicketDB();
            Scanner sc = new Scanner(System.in);
            // Loop thru entrants and check them against the CSV list.
            while (true) {
                System.out.print("Name as it appears in reservation: ");
                String name = sc.nextLine().trim();
                System.out.println("name entered was " + name);
                if (name.equals("done"))
                    break;
                int result = App.checkTicketDB(name);
                if (result == 0)
                    System.out.println("Customer " + name + " has not purchased any tickets.");
                else
                    System.out.println("Customer " + name + " has purchased " + result + " tickets");
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
