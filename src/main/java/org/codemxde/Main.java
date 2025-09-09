package org.codemxde;

import java.util.Scanner;

public class Main {

//    TODO: Add Validations for User Input can not be longer than 4 characters

    public static void main(String[] args) {
        greetUser();
        String effortTaken = readUserInput();
        System.out.println("Your total for the day 💪🏼: " + effortTaken);
    }

    public static void greetUser() {
        System.out.println("Welcome to the effort calculator :)");
        System.out.println("NOTE: 1h 36 minutes should be input as 1.36 for simpler user interaction" +
                "\nEnter 'x' to calculate total effort and exit application"
        );
    }

    public static String readUserInput() {
        int count = 1;
        int totalHours = 0;
        double totalMinutes = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        while (true) {
            System.out.print("Input " + count + ": ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("x")) break;
            try {
                double time = Double.parseDouble(userInput);
                int hours = (int) time;
                double minutes = (time - hours) * 100;

                totalHours += hours; totalMinutes += minutes;

                count++;
            } catch (NumberFormatException nfe) {
                System.out.print("\nHmm.. That's weird we didn't understand your input!" +
                        "\nKindly stick to the time format as instructed.\nEnter 'x' to exit\n\n");
            }
        }

        int remaningMinutes = 0;
        if (totalMinutes > 0) {
            int hours = (int) totalMinutes / 60;
            totalHours += hours;
            remaningMinutes = (int) totalMinutes % 60;
        }

        return totalHours + "h " + remaningMinutes + "m";
    }

}
