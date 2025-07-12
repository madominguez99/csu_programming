package module_3;

import java.util.Scanner;

public class critical_thinking_option_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Prompt user for coupon amount
		System.out.print("Enter coupon amount as a decimal (e.g., 0.10 for 10%): ");
		double coupon = scanner.nextDouble();
		boolean isCouponValid = true;

		// Validate if coupon amount is valid and apply 10% coupon if it is not
		if (coupon <= 0 || coupon > 1) {
			System.out.println("Invalid coupon entered. A 10% coupon will be applied.");
			coupon = 0.10; // Set to default 10%
			isCouponValid = false; // You can still keep this if you want
		}

		// Prompt user for grocery bills for 4 weeks
		System.out.print("Enter grocery bill for week 1: ");
		double week1 = scanner.nextDouble();

		System.out.print("Enter grocery bill for week 2: ");
		double week2 = scanner.nextDouble();

		System.out.print("Enter grocery bill for week 3: ");
		double week3 = scanner.nextDouble();

		System.out.print("Enter grocery bill for week 4: ");
		double week4 = scanner.nextDouble();

		// Calculate monthly total and weekly average
		double monthlyTotal = week1 + week2 + week3 + week4;
		double weeklyAverage = monthlyTotal / 4;

		// Calculate monthly total and weekly average with coupon applied
		double discountedMonthlyTotal = monthlyTotal * (1 - coupon);
		double discountedWeeklyAverage = discountedMonthlyTotal / 4;

		// Display results
		System.out.printf("\nMonthly Total (without coupon): $%.2f\n", monthlyTotal);
		System.out.printf("Weekly Average (without coupon): $%.2f\n", weeklyAverage);

		System.out.printf("\nMonthly Total (with coupon): $%.2f\n", discountedMonthlyTotal);
		System.out.printf("Weekly Average (with coupon): $%.2f\n", discountedWeeklyAverage);

		scanner.close();
	}
}
