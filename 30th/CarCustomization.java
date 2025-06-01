import java.util.*;

public class CarCustomization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your car Manufacturer (Mahindra/Hyundai/Maruti):");
        String manufacturer = sc.nextLine();

        String model = "Not Applicable";
        if(manufacturer.equalsIgnoreCase("Manhindra")){
            System.out.println("Choose your model(Scorpio/Thar/Scorpio N/XUV 700):");
            model = sc.nextLine();
        }

        System.out.println("Choose your Transmission (Manual/Automatic)");
        String transmission = sc.nextLine();

        System.out.println("Choose your Fuel Type (Petrol/Diesel/CNG)");
        String fuelType = sc.nextLine();

        System.out.println("Choose your Color (Silver/Blue/Yellow)");
        String colorType = sc.nextLine();

        System.out.println("Choose your Location (Delhi/Bangalore/Hyderabad/Chennai)");
        String location = sc.nextLine();

        System.out.println("Your Car Customization:");
        System.out.println("Manufacturer : " + manufacturer);
        System.out.println("Model : " + model);
        System.out.println("Transmission : " + transmission);
        System.out.println("Fuel Type : " + fuelType);
        System.out.println("Color : " + colorType);
        System.out.println("Location : " + location);

        sc.close();
    }
}
