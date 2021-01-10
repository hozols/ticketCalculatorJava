import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello and welcome to the price checking app!");
        System.out.println("Please choose the city you want to travel to");
        try {
            // Read JSON file with data
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/Data.json"));
            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
            JsonArray destinations = (JsonArray) parser.get("destinations");

            // Get our VAT rate
            int vat = Integer.parseInt((String) parser.get("vat"));

            // Create a hash map with city and the corresponding price
            HashMap<String, String> cities = new HashMap<String, String>();
            destinations.forEach(entry -> {
                JsonObject destination = (JsonObject) entry;
                System.out.println(destination.get("city"));
                String city = (String) destination.get("city");
                cities.put(city.toLowerCase(), (String) destination.get("price"));
            });

            // UI
            System.out.println("Choose the city:");
            Scanner sc = new Scanner(System.in);
            String chosenCity = sc.nextLine();
            chosenCity.toLowerCase();
            System.out.println("Enter the amount of adult passengers");
            int adults = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the amount of bags");
            int adultBags = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the amount of child passengers");
            int children = Integer.parseInt(sc.nextLine());
            int childBags = 0;
            if (children > 0) {
                System.out.println("Enter the amount of bags");
                childBags = Integer.parseInt(sc.nextLine());
            }

            int price = Integer.parseInt(cities.get(chosenCity));

            // Create a new trip object
            Trip trip = new Trip(chosenCity, price, adults, children, adultBags, childBags, vat);

            // Print the results
            trip.printTotal();

            // Close IO streams
            sc.close();
            reader.close();

            //TODO add possibility to choose destination again
        } catch (Exception ex) {
            System.out.println("Something went wrong, restart the app");
            ex.printStackTrace();
        }
    }
}
