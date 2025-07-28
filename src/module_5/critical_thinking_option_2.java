package module_5;

import java.util.Scanner;


public class critical_thinking_option_2 {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Array for month names
	        String[] months = {
	            "January", "February", "March", "April",
	            "May", "June", "July", "August",
	            "September", "October", "November", "December"
	        };

	        // Corresponding average temperatures
	        double[] temperatures = {
	            30.5, 32.0, 45.2, 55.6,
	            65.3, 79, 91, 90,
	            70.2, 65.6, 45.9, 35.2
	        };

	        // Main loop
	        while (true) {
	            System.out.print("\nTo see the average temperatrure of a specific month, enter the month name. Enter 'year' to view all, or 'exit' to quit: ");
	            String input = scanner.nextLine().trim();

	            // Exit condition
	            if (input.equalsIgnoreCase("exit")) {
	                System.out.println("Program terminated.");
	                break;
	            }

	            // Yearly report
	            else if (input.equalsIgnoreCase("year")) {
	                double total = 0.0;
	                double highest = temperatures[0];
	                double lowest = temperatures[0];
	                String highestMonth = months[0];
	                String lowestMonth = months[0];

	                System.out.println("\nMonthly Average Temperatures:");
	                for (int i = 0; i < months.length; i++) {
	                    System.out.printf("%-10s : %.1f°F\n", months[i], temperatures[i]);
	                    total += temperatures[i];

	                    if (temperatures[i] > highest) {
	                        highest = temperatures[i];
	                        highestMonth = months[i];
	                    }

	                    if (temperatures[i] < lowest) {
	                        lowest = temperatures[i];
	                        lowestMonth = months[i];
	                    }
	                }

	                double yearlyAverage = total / months.length;
	                System.out.printf("\nYearly Average Temperature: %.1f°F", yearlyAverage);
	                System.out.printf("\nHighest Average Temperature: %.1f°F (%s)", highest, highestMonth);
	                System.out.printf("\nLowest Average Temperature: %.1f°F (%s)\n", lowest, lowestMonth);
	            }

	            // Specific month
	            else {
	                boolean found = false;
	                for (int i = 0; i < months.length; i++) {
	                    if (months[i].equalsIgnoreCase(input)) {
	                        System.out.printf("Average temperature for %s is %.1f°F\n", months[i], temperatures[i]);
	                        found = true;
	                        break;
	                    }
	                }

	                if (!found) {
	                    System.out.println("Invalid input. Please enter a valid month name, 'year', or 'exit'.");
	                }
	            }
	        }

	        scanner.close();
	    }
	}

