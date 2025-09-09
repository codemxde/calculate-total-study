package org.codemxde;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        greetUser();
        String effortTaken = readUserInput();
        printTotalEffort(effortTaken);
    }

    public static void greetUser() {
        System.out.println("Welcome to the effort calculator :)");
        System.out.println(
                "NOTE: 1h 36 minutes should be input as 1.36 for simpler user interaction" +
                "\nEnter 'x' to calculate total effort and exit application"
        );
    }

    public static String readUserInput() {

        Scanner scanner = new Scanner(System.in);

        // Time object to handle all time-based calculations
        var time = new Time();

        System.out.println();
        while (true) {
            System.out.print("Input: ");
            String userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals("x")) break;

            try {
                time.setUserInput(Double.parseDouble(userInput));
                time.setHours(); time.setMinutes();
                time.setTotalHours(); time.setTotalMinutes();
            } catch (NumberFormatException nfe) {
                System.out.print("\nHmm.. That's weird we didn't understand your input!" +
                        "\nKindly stick to the time format as instructed." +
                        "\nEnter 'x' to exit\n\n");
            }
        }

        time.convertMinutesToHours();

        return time.getTotalHours() + "h " + time.getTotalMinutes() + "m";
    }

    public static void printTotalEffort(String effortTaken) {
        System.out.println("Your total for the day 💪🏼: " + effortTaken);
    }

}
