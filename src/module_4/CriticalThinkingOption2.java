package module_4;

import java.util.Scanner;

public class CriticalThinkingOption2 {

	public static void main(String[] args) {
		final int TOTAL_GRADES = 10;
		double sum = 0.0;
		double maxGrade = Double.NEGATIVE_INFINITY;
		double minGrade = Double.POSITIVE_INFINITY;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter " + TOTAL_GRADES + " grades.");

		for (int i = 1; i <= TOTAL_GRADES; i++) {
			double grade = 0.0;
			boolean valid = false;

			// Keep asking until a valid grade is entered
			while (!valid) {
				System.out.print("Enter grade #" + i + ": ");
				String input = scanner.nextLine();

				try {
					grade = Double.parseDouble(input);

					// Optionally check for valid grade range
					if (grade < 0 || grade > 100) {
						System.out.println("Grade must be between 0 and 100. Try again.");
					} else {
						valid = true;
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a numeric value.");
				}
			}

			sum += grade;
			maxGrade = Math.max(maxGrade, grade);
			minGrade = Math.min(minGrade, grade);
		}

		double average = sum / TOTAL_GRADES;

		System.out.println("\n--- Grade Statistics ---");
		System.out.printf("Average grade: %.2f\n", average);
		System.out.printf("Maximum grade: %.2f\n", maxGrade);
		System.out.printf("Minimum grade: %.2f\n", minGrade);

		scanner.close();
	}
}
