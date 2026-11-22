import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {


        // Create initial flight records
        List<Flight> flights = new ArrayList<>();


        flights.add(new Flight(101, "10:30"));
        flights.add(new Flight(205, "14:00"));
        flights.add(new Flight(150, "11:45"));
        flights.add(new Flight(120, "09:15"));
        flights.add(new Flight(250, "18:20"));


        // Create Flight Registry
        FlightRegistry registry = new FlightRegistry(flights);


        // Insert a new flight
        registry.insert(new Flight(180, "16:00"));


        // Search departure time
        System.out.println("Departure Time : "
                + registry.getDepartureTime(205));


        // Delete a flight
        registry.delete(150);


        // Display all flights in descending order
        System.out.println("\nFlights in Descending Order");


        List<Flight> descendingFlights =
                registry.getAllFlightsDescending();


        for (Flight flight : descendingFlights) {
            System.out.println(flight);
        }


        // Display flights within a range
        System.out.println("\nFlights Between 110 and 220");


        List<Flight> rangeFlights =
                registry.getFlightsBetween(110, 220);


        for (Flight flight : rangeFlights) {
            System.out.println(flight);
        }
    }
}