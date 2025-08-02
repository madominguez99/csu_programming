package portfolio_project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CarDealershipInventory {

	// Write vehicle info to a file
	public static void printToFile(List<Automobile> inventory, String filePath) {
		try (FileWriter writer = new FileWriter(filePath)) {
			for (Automobile car : inventory) {
				String[] info = car.listVehicle();
				for (String line : info) {
					writer.write(line + System.lineSeparator());
				}
				writer.write(System.lineSeparator());
			}
			System.out.println("Vehicle info written to file: " + filePath);
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	//Entry point of the program - initialize the scanner and inventory list
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Automobile> inventory = new ArrayList<>();
		boolean exit = false;

		while (!exit) {
			// Menu options
			System.out.println("\n--- Car Dealership Inventory ---");
			System.out.println("1. List all vehicles");
			System.out.println("2. Add a new vehicle");
			System.out.println("3. Update a vehicle");
			System.out.println("4. Remove a vehicle");
			System.out.println("5. Print inventory to file");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				// List vehicles
				if (inventory.isEmpty()) {
					System.out.println("Inventory is empty.");
				} else {
					int i = 1;
					for (Automobile car : inventory) {
						System.out.println("\nVehicle #" + i++);
						for (String line : car.listVehicle()) {
							System.out.println(line);
						}
					}
				}
				break;

			case "2":
				// Add new vehicle with default handling
				System.out.print("Enter make: ");
				String make = scanner.nextLine().trim();
				if (make.isEmpty())
					make = "UNKNOWN";

				System.out.print("Enter model: ");
				String model = scanner.nextLine().trim();
				if (model.isEmpty())
					model = "UNKNOWN";

				System.out.print("Enter color: ");
				String color = scanner.nextLine().trim();
				if (color.isEmpty())
					color = "UNKNOWN";

				System.out.print("Enter year (or press Enter to skip): ");
				String yearInput = scanner.nextLine().trim();
				int year = 0;
				if (!yearInput.isEmpty()) {
					try {
						year = Integer.parseInt(yearInput);
					} catch (NumberFormatException e) {
						System.out.println("Invalid year input. Defaulting to 0.");
					}
				}

				System.out.print("Enter mileage (or press Enter to skip): ");
				String mileageInput = scanner.nextLine().trim();
				int mileage = 0;
				if (!mileageInput.isEmpty()) {
					try {
						mileage = Integer.parseInt(mileageInput);
					} catch (NumberFormatException e) {
						System.out.println("Invalid mileage input. Defaulting to 0.");
					}
				}

				Automobile newVehicle = new Automobile();
				String result = newVehicle.addVehicle(make, model, color, year, mileage);
				inventory.add(newVehicle);
				System.out.println(result);
				break;

			case "3":
				// Update a vehicle
				System.out.print("Enter the vehicle number to update: ");
				int updateIndex = Integer.parseInt(scanner.nextLine()) - 1;
				if (updateIndex >= 0 && updateIndex < inventory.size()) {
					Automobile vehicleToUpdate = inventory.get(updateIndex);

					System.out.print("Enter new make: ");
					make = scanner.nextLine().trim();
					if (make.isEmpty())
						make = "UNKNOWN";

					System.out.print("Enter new model: ");
					model = scanner.nextLine().trim();
					if (model.isEmpty())
						model = "UNKNOWN";

					System.out.print("Enter new color: ");
					color = scanner.nextLine().trim();
					if (color.isEmpty())
						color = "UNKNOWN";

					System.out.print("Enter new year: ");
					year = Integer.parseInt(scanner.nextLine());

					System.out.print("Enter new mileage: ");
					mileage = Integer.parseInt(scanner.nextLine());

					System.out.println(vehicleToUpdate.updateVehicle(make, model, color, year, mileage));
				} else {
					System.out.println("Invalid vehicle number.");
				}
				break;

			case "4":
				// Remove a vehicle
				System.out.print("Enter the vehicle number to remove: ");
				int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;
				if (removeIndex >= 0 && removeIndex < inventory.size()) {
					inventory.remove(removeIndex);
					System.out.println("Vehicle removed successfully.");
				} else {
					System.out.println("Invalid vehicle number.");
				}
				break;

			case "5":
				// Print inventory to a file
				System.out.print("Enter file path (e.g., C:\\\\Temp\\\\Autos.txt): ");
				String path = scanner.nextLine().trim();
				printToFile(inventory, path);
				break;

			case "6":
				// Exit the program
				exit = true;
				System.out.println("Exiting program...");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}

		scanner.close();
	}
}
