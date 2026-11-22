/**
 * Represents a flight record.
 * Each flight has a unique flight number and a departure time.
 */
public class Flight {


    /** Unique flight number. */
    private int flightNumber;


    /** Departure time of the flight. */
    private String departureTime;


    /**
     * Creates a Flight object.
     *
     * @param flightNumber Unique flight number.
     * @param departureTime Departure time of the flight.
     */
    public Flight(int flightNumber, String departureTime) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
    }


    /**
     * Returns the flight number.
     *
     * @return Flight number.
     */
    public int getFlightNumber() {
        return flightNumber;
    }


    /**
     * Returns the departure time.
     *
     * @return Departure time.
     */
    public String getDepartureTime() {
        return departureTime;
    }


    /**
     * Updates the departure time.
     *
     * @param departureTime New departure time.
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }


    /**
     * Returns flight details as a string.
     *
     * @return Flight information.
     */
    @Override
    public String toString() {
        return "Flight Number: " + flightNumber +
               ", Departure Time: " + departureTime;
    }
}