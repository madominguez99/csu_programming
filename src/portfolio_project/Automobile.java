package portfolio_project;


public class Automobile {
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;

	// Default constructor
	public Automobile() {
		this.make = "";
		this.model = "";
		this.color = "";
		this.year = 0;
		this.mileage = 0;
	}

	// Parameterized constructor
	public Automobile(String make, String model, String color, int year, int mileage) {
		try {
			this.make = make;
			this.model = model;
			this.color = color;
			this.year = year;
			this.mileage = mileage;
		} catch (Exception e) {
			this.make = "";
			this.model = "";
			this.color = "";
			this.year = 0;
			this.mileage = 0;
			System.out.println("Error in constructor: " + e.getMessage());
		}
	}

	// Add a new vehicle
	public String addVehicle(String make, String model, String color, int year, int mileage) {
		try {
			this.make = make;
			this.model = model;
			this.color = color;
			this.year = year;
			this.mileage = mileage;
			return "Vehicle added successfully.";
		} catch (Exception e) {
			return "Error: Unable to add vehicle.";
		}
	}

	// Return vehicle info as a string array with fallbacks
	public String[] listVehicle() {
		try {
			return new String[] { "Make: " + (this.make.isEmpty() ? "UNKNOWN" : this.make),
					"Model: " + (this.model.isEmpty() ? "UNKNOWN" : this.model),
					"Color: " + (this.color.isEmpty() ? "UNKNOWN" : this.color),
					"Year: " + (this.year == 0 ? "UNKNOWN" : this.year),
					"Mileage: " + (this.mileage == 0 ? "UNKNOWN" : this.mileage) };
		} catch (Exception e) {
			return new String[] { "Error retrieving vehicle info." };
		}
	}

	// Update all attributes
	public String updateVehicle(String make, String model, String color, int year, int mileage) {
		try {
			this.make = make;
			this.model = model;
			this.color = color;
			this.year = year;
			this.mileage = mileage;
			return "Vehicle updated successfully.";
		} catch (Exception e) {
			return "Error: Unable to update vehicle.";
		}
	}
}
