import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Represents a device in the network.
 * Each device stores:
 * 1. Device Name
 * 2. Creation Time
 * 3. List of Directly Connected Devices
 */
public class Device {


    /**
     * Name of the device.
     */
    private String name;


    /**
     * Time when the device was created.
     */
    private LocalDateTime createdTime;


    /**
     * Stores all directly connected neighbouring devices.
     */
    private ArrayList<Device> neighbours;


    /**
     * Creates a new device.
     * @param name Name of the device.
     */
    public Device(String name) {
        // Store the device name.
        this.name = name;

        // Store the current date and time.
        this.createdTime = LocalDateTime.now();

        // Initially, no devices are connected.
        this.neighbours = new ArrayList<>();
    }


    /**
     * Returns the device name.
     * @return Device name.
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the creation time of the device.
     * @return Device creation time.
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }


    /**
     * Returns the list of neighbouring devices.
     * @return List of neighbouring devices.
     */
    public ArrayList<Device> getNeighbours() {
        return neighbours;
    }
}