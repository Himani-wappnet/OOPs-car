import java.util.Scanner;

// Interface for vehicles that can accelerate
interface Acceleratable {
    void accelerate();
}

// Abstract class for vehicles
abstract class Vehicle {
    private String model;
    protected String color;
    public int year;

    // Constructors
    public Vehicle(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    // Public method to access the model field
    public String getModel() {
        return model;
    }

    // Abstract method for displaying information
    public abstract void displayCarInfo();

    // Methods with different modifiers
    protected void brake() {
        System.out.println("The vehicle has stopped.");
    }
}

// Subclass for cars (inherits from Vehicle)
class Car extends Vehicle implements Acceleratable {
    // Constructors
    public Car(String model, String color, int year) {
        super(model, color, year);
    }

    // Display information about the car
    @Override
    public void displayCarInfo() {
        System.out.println("Model: " + getModel());
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
    }

    // Implement the interface method
    @Override
    public void accelerate() {
        System.out.println("The car is now accelerating.");
    }
}

// Subclass for Basic cars (inherits from Car)
class BasicCar extends Car {
    // Additional variables for BasicCar with protected modifier
    protected int numberOfDoors;
    private double fuelEfficiency; // in miles per gallon
    private boolean hasAirbags;
    private boolean hasGPS;

    // Constructor
    public BasicCar(String model, String color, int year, int numberOfDoors, double fuelEfficiency, boolean hasAirbags, boolean hasGPS) {
        super(model, color, year);
        this.numberOfDoors = numberOfDoors;
        this.fuelEfficiency = fuelEfficiency;
        this.hasAirbags = hasAirbags;
        this.hasGPS = hasGPS;
    }

    // Override displayCarInfo method
    @Override
    public void displayCarInfo() {
        super.displayCarInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        displayAdditionalFeatures();
    }

    // Display additional features
    private void displayAdditionalFeatures() {
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " mpg");
        System.out.println("Airbags: " + (hasAirbags ? "Yes" : "No"));
        System.out.println("GPS: " + (hasGPS ? "Yes" : "No"));
    }

    // Getter for fuel efficiency
    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    // Getter for airbags
    public boolean hasAirbags() {
        return hasAirbags;
    }

    // Getter for GPS
    public boolean hasGPS() {
        return hasGPS;
    }

    // Additional method for getting a recommendation based on features
    public String getRecommendation() {
        // Customize this logic based on your preferences
        if (fuelEfficiency >= 30 && hasAirbags && hasGPS) {
            return "This car is a great choice!";
        } else {
            return "Consider checking other options.";
        }
    }
}

// Subclass for Sports cars (inherits from Car)
class SportsCar extends Car {
    // Additional variables for SportCar with private modifier
    private int numberOfSeats;
    private double fuelEfficiency; // in miles per gallon
    private boolean hasAirbags;
    private boolean hasGPS;

    // Constructor
    public SportsCar(String model, String color, int year, int numberOfSeats, double fuelEfficiency, boolean hasAirbags, boolean hasGPS) {
        super(model, color, year);
        this.numberOfSeats = numberOfSeats;
        this.fuelEfficiency = fuelEfficiency;
        this.hasAirbags = hasAirbags;
        this.hasGPS = hasGPS;
    }

    // Override displayCarInfo method
    @Override
    public void displayCarInfo() {
        super.displayCarInfo();
        System.out.println("Number of Seats: " + numberOfSeats);
        displayAdditionalFeatures();
    }

    // Display additional features
    private void displayAdditionalFeatures() {
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " mpg");
        System.out.println("Airbags: " + (hasAirbags ? "Yes" : "No"));
        System.out.println("GPS: " + (hasGPS ? "Yes" : "No"));
    }

    // Getter for fuel efficiency
    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    // Getter for airbags
    public boolean hasAirbags() {
        return hasAirbags;
    }

    // Getter for GPS
    public boolean hasGPS() {
        return hasGPS;
    }

    // Additional method for getting a recommendation based on features
    public String getRecommendation() {
        // Customize this logic based on your preferences
        if (fuelEfficiency >= 25 && numberOfSeats >= 2 && hasAirbags && hasGPS) {
            return "This sports car is a great choice!";
        } else {
            return "Consider checking other sports car options.";
        }
    }
}

// New subclass for Luxury cars (inherits from SportsCar)
class LuxuryCar extends SportsCar {
    private boolean hasMassageSeats;

    // Constructor
    public LuxuryCar(String model, String color, int year, int numberOfSeats, double fuelEfficiency, boolean hasAirbags, boolean hasGPS, boolean hasMassageSeats) {
        super(model, color, year, numberOfSeats, fuelEfficiency, hasAirbags, hasGPS);
        this.hasMassageSeats = hasMassageSeats;
    }

    // Override displayCarInfo method
    @Override
    public void displayCarInfo() {
        super.displayCarInfo();
        System.out.println("Massage Seats: " + (hasMassageSeats ? "Yes" : "No"));
    }

    // Additional method for getting a recommendation based on features
    public String getRecommendation() {
        // Customize this logic based on your preferences for luxury cars
        if (hasMassageSeats) {
            return "This luxury car is a great choice!";
        } else {
            return "Consider checking other luxury car options.";
        }
    }
}

// Main class for demonstration

public class CarManufacturingDemo {
    public static void main(String[] args) {
        // Create instances of BasicCar and SportsCar with user input
        BasicCar basicCar = createBasicCar();
        SportsCar sportsCar = createSportsCar();
        LuxuryCar luxuryCar = createLuxuryCar();

        // Display information about the cars
        System.out.println("Details of Basic Car:");
        basicCar.displayCarInfo();

        System.out.println("\nDetails of Sports Car:");
        sportsCar.displayCarInfo();

        System.out.println("\nDetails of Luxury Car:");
        luxuryCar.displayCarInfo();


        // // Accelerate and brake the cars
        // System.out.println("\nBasic Car Actions:");
        // basicCar.accelerate();
        // basicCar.brake();

        // System.out.println("\nSports Car Actions:");
        // sportsCar.accelerate();
        // sportsCar.brake();

        // Get recommendations based on additional features
        System.out.println("\nRecommendation for Basic Car: " + basicCar.getRecommendation());
        System.out.println("Recommendation for Sports Car: " + sportsCar.getRecommendation());
        System.out.println("Recommendation for Luxury Car: " + luxuryCar.getRecommendation());
    }

    // Create a BasicCar with user input for additional features
    private static BasicCar createBasicCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Basic Car details:");
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Number of Doors: ");
        int numberOfDoors = scanner.nextInt();
        System.out.print("Fuel Efficiency (mpg): ");
        double fuelEfficiency = scanner.nextDouble();
        System.out.print("Has Airbags (true/false): ");
        boolean hasAirbags = scanner.nextBoolean();
        System.out.print("Has GPS (true/false): ");
        boolean hasGPS = scanner.nextBoolean();

        return new BasicCar(model, color, year, numberOfDoors, fuelEfficiency, hasAirbags, hasGPS);
    }

    // Create a SportsCar with user input for additional features
    private static SportsCar createSportsCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Sports Car details:");
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Number of Seats: ");
        int numberOfSeats = scanner.nextInt();
        System.out.print("Fuel Efficiency (mpg): ");
        double fuelEfficiency = scanner.nextDouble();
        System.out.print("Has Airbags (true/false): ");
        boolean hasAirbags = scanner.nextBoolean();
        System.out.print("Has GPS (true/false): ");
        boolean hasGPS = scanner.nextBoolean();

        return new SportsCar(model, color, year, numberOfSeats, fuelEfficiency, hasAirbags, hasGPS);
    }

    // Create a LuxuryCar with user input for additional features
    private static LuxuryCar createLuxuryCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Luxury Car details:");
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Number of Seats: ");
        int numberOfSeats = scanner.nextInt();
        System.out.print("Fuel Efficiency (mpg): ");
        double fuelEfficiency = scanner.nextDouble();
        System.out.print("Has Airbags (true/false): ");
        boolean hasAirbags = scanner.nextBoolean();
        System.out.print("Has GPS (true/false): ");
        boolean hasGPS = scanner.nextBoolean();
        System.out.print("Has Massage Seats (true/false): ");
        boolean hasMassageSeats = scanner.nextBoolean();

        return new LuxuryCar(model, color, year, numberOfSeats, fuelEfficiency, hasAirbags, hasGPS, hasMassageSeats);
    }
}
