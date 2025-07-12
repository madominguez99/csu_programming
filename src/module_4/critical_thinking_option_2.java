package module_4;

import java.util.Scanner;

public class critical_thinking_option_2 {

	    public static void main(String[] args) {
	    	
	        // Initialize variables
	        final int TOTAL_GRADES = 10;    // Entering only 10 grades
	        int count = 0;                  // To keep track of how many valid grades have been entered
	        double sum = 0.0;               // To store the sum of all grades
	        double maxGrade = -9999.0;      // Start with a very low number
	        double minGrade = 9999.0;       // Start with a very high number

	        Scanner scanner = new Scanner(System.in); 

	        // Get user input for 10 grades
	        while (count < TOTAL_GRADES) {
	            System.out.print("Enter grade #" + (count + 1) + ": ");
	            String input = scanner.nextLine();  

	            try {
	                double grade = Double.parseDouble(input);  // Convert input to a number

	                // Add grade to total sum
	                sum = sum + grade;

	                // Check if it's the highest grade so far
	                if (grade > maxGrade) {
	                    maxGrade = grade;
	                }

	                // Check if it's the lowest grade so far
	                if (grade < minGrade) {
	                    minGrade = grade;
	                }

	                count++; 
	            } 
                	// Validate input is valid
	            	catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a valid number.");
	            }
	        }

	        // Calculate the average
	        double average = sum / TOTAL_GRADES;

	        // Display results
	        System.out.println("\n--- Grade Statistics ---");
	        System.out.printf("Average grade: %.2f\n", average);   
	        System.out.printf("Maximum grade: %.2f\n", maxGrade);
	        System.out.printf("Minimum grade: %.2f\n", minGrade);

	        scanner.close();  
	    }
	}
