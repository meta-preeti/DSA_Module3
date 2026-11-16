import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Represents the network graph.
 * This class manages all the devices present in the network.
 */
public class Graph {


    /**
     * Stores all devices in the network.
     *
     * Key   -> Device Name (Lower Case)
     * Value -> Device Object
     */
    private HashMap<String, Device> devices;


    /**
     * Represents the current active device.
     */
    private Device currentDevice;


    /**
     * Creates a new network.
     * Initially, the network contains only one device:
     * Gateway
     */
    public Graph() {
        // Initialize the HashMap.
        devices = new HashMap<>();

        // Create the Gateway device.
        Device gateway = new Device("Gateway");

        // Add Gateway to the network.
        devices.put("gateway", gateway);

        // Set Gateway as the current device.
        currentDevice = gateway;
    }

    /**
     * Validates the device name.
     * @param name Device name entered by the user.
     * @return true if the name is valid, otherwise false.
     */
    private boolean isValidName(String name) {

        // Check if the name is null.
        if (name == null) {
            System.out.println("Invalid device name.");
            return false;
        }

        // Remove leading and trailing spaces.
        name = name.trim();
        // Check if the name is empty.
        if (name.isEmpty()) {
            System.out.println("Device name cannot be empty.");
            return false;
        }

        return true;
    }


    /**
     * Returns the key used to store devices in the HashMap.
     *
     * @param name Device name.
     * @return Lower case device name.
     */
    private String getKey(String name) {
        return name.trim().toLowerCase();
    }

    /**
     * Returns the device object using its name.
     *
     * @param name Device name.
     * @return Device object if found, otherwise null.
     */
    private Device getDevice(String name) {
        if (!isValidName(name)) {
            return null;
        }
        return devices.get(getKey(name));
    }

     /**
 * Adds a new device to the network.
 *
 * @param name Name of the device.
 */
public void addDevice(String name) {

    // Validate the device name.
    if (!isValidName(name)) {
        return;
    }

    // Remove extra spaces from the device name.
    name = name.trim();

    // Generate the key for HashMap.
    String key = getKey(name);

    // Check if the device already exists.
    if (devices.containsKey(key)) {
        System.out.println("Device already exists.");
        return;
    }

    // Create a new device.
    Device newDevice = new Device(name);

    // Store the device in the network.
    devices.put(key, newDevice);

    System.out.println("Device added successfully.");
}

 /**
 * Creates a bidirectional link between two devices.
 *
 * @param device1 First device name.
 * @param device2 Second device name.
 */
public void linkDevices(String device1, String device2) {

    // Validate both device names.
    if (!isValidName(device1) || !isValidName(device2)) {
        return;
    }
    // Remove extra spaces.
    device1 = device1.trim();
    device2 = device2.trim();

    // A device cannot be linked to itself.
    if (device1.equalsIgnoreCase(device2)) {
        System.out.println("Cannot link a device to itself.");
        return;
    }

    // Get both device objects.
    Device firstDevice = getDevice(device1);
    Device secondDevice = getDevice(device2);

    // Check whether both devices exist.
    if (firstDevice == null || secondDevice == null) {
        System.out.println("Device not found.");
        return;
    }

    // Check whether the devices are already linked.
    if (firstDevice.getNeighbours().contains(secondDevice)) {
        System.out.println("Devices are already linked.");
        return;
    }

    // Create a bidirectional connection.
    firstDevice.getNeighbours().add(secondDevice);
    secondDevice.getNeighbours().add(firstDevice);

    System.out.println("Devices linked successfully.");
}


/**
 * Moves to a directly connected device.
 * @param deviceName Name of the device.
 */
public void hop(String deviceName) {
    Device destination = getDevice(deviceName);

    if (destination == null) {
        System.out.println("Device not found.");
        return;
    }

    if (currentDevice == destination) {
        System.out.println("Already at current device.");
        return;
    }

    if (!currentDevice.getNeighbours().contains(destination)) {
        System.out.println("Devices are not directly connected.");
        return;
    }
    currentDevice = destination;
    System.out.println("Current device : " + currentDevice.getName());
}


/**
 * Displays all devices directly connected to the current device.
 *
 * For every connected device, display:
 * 1. Device Name
 * 2. Creation Time
 * 3. Total Number of Links
 *
 * Also displays the total number of directly connected devices.
 */
public void listDevices() {

    // Get all neighbouring devices.
    ArrayList<Device> neighbours = currentDevice.getNeighbours();

    // Check whether the current device has any neighbours.
    if (neighbours.isEmpty()) {
        System.out.println("No devices are directly connected to "
                + currentDevice.getName() + ".");
        return;
    }

    System.out.println("\nCurrent Device : " + currentDevice.getName());
    System.out.println("---------------------------------------------");


    // Display details of every neighbour.
    for (Device device : neighbours) {
        System.out.println("Device Name   : " + device.getName());
        System.out.println("Created Time  : " + device.getCreatedTime());
        System.out.println("Total Links   : "
                + device.getNeighbours().size());
        System.out.println("---------------------------------------------");
    }

    System.out.println("Total Connected Devices : "
            + neighbours.size());
}

/**
 * Finds the shortest path from the current device
 * to the destination device.
 * @param destinationName Name of the destination device.
 */
public void path(String destinationName) {

    // Get destination device.
    Device destination = getDevice(destinationName);

    // Check whether the destination exists.
    if (destination == null) {
        System.out.println("Device not found.");
        return;
    }
    // If source and destination are same.
    if (currentDevice == destination) {
        System.out.println("Path : " + currentDevice.getName());
        System.out.println("Hop Count : 0");
        return;
    }


    Queue<Device> queue = new LinkedList<>();
    HashMap<Device, Boolean> visited = new HashMap<>();
    HashMap<Device, Device> parent = new HashMap<>();
    queue.offer(currentDevice);
    visited.put(currentDevice, true);
    boolean found = false;

 while (!queue.isEmpty()) {
        Device current = queue.poll();
        // Copy neighbours.
        ArrayList<Device> neighbours =
                new ArrayList<>(current.getNeighbours());

        // Sort alphabetically.
        Collections.sort(neighbours,
                (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        for (Device neighbour : neighbours) {
            if (!visited.containsKey(neighbour)) {
                visited.put(neighbour, true);
                parent.put(neighbour, current);
                queue.offer(neighbour);
                if (neighbour == destination) {
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            break;
        }
    }


    // No path exists.
    if (!visited.containsKey(destination)) {
        System.out.println("No route available.");
        return;
    }


    // Reconstruct path.
    ArrayList<String> route = new ArrayList<>();
    Device temp = destination;

    while (temp != null) {
        route.add(temp.getName());
        temp = parent.get(temp);
    }

    Collections.reverse(route);

    System.out.print("Path : ");

    for (int i = 0; i < route.size(); i++) {
        System.out.print(route.get(i));
        if (i != route.size() - 1) {
            System.out.print(" -> ");
        }
    }


    System.out.println();
    System.out.println("Hop Count : " + (route.size() - 1));
}

/**
 * Displays every reachable device from the current device
 * as a tree using Breadth First Search (BFS).
 */
public void spread() {
    Queue<Device> queue = new LinkedList<>();
    HashMap<Device, Boolean> visited = new HashMap<>();
    HashMap<Device, Device> parent = new HashMap<>();
    queue.offer(currentDevice);
    visited.put(currentDevice, true);
    parent.put(currentDevice, null);


    while (!queue.isEmpty()) {
        Device current = queue.poll();

        ArrayList<Device> neighbours =  new ArrayList<>(current.getNeighbours());
        // Visit neighbours in alphabetical order.
        Collections.sort(neighbours, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));


        for (Device neighbour : neighbours) {
            if (!visited.containsKey(neighbour)) {
                visited.put(neighbour, true);
                parent.put(neighbour, current);
                queue.offer(neighbour);
            }
        }
    }


    System.out.println(currentDevice.getName());

    ArrayList<Device> rootChildren = getChildren(currentDevice, parent);


    for (int i = 0; i < rootChildren.size(); i++) {
        boolean isLast = (i == rootChildren.size() - 1);
        printTree(rootChildren.get(i), parent, "", isLast);
    }
}




/**
 * Recursively prints the tree.
 *
 * @param node Current device.
 * @param parent Parent map generated by BFS.
 * @param prefix Spaces and vertical lines.
 * @param isLast Indicates whether the node is the last child.
 */
private void printTree(Device node, HashMap<Device, Device> parent, String prefix,  boolean isLast) {


    if (isLast) {
        System.out.println(prefix + "└── " + node.getName());
    } else {
        System.out.println(prefix + "├── " + node.getName());
    }


    ArrayList<Device> children = getChildren(node, parent);


    String newPrefix;


    if (isLast) {
        newPrefix = prefix + "    ";
    } else {
        newPrefix = prefix + "│   ";
    }


    for (int i = 0; i < children.size(); i++) {
        boolean lastChild = (i == children.size() - 1);
        printTree(children.get(i), parent, newPrefix, lastChild);
    }
}




/**
 * Returns all children of a node in alphabetical order.
 *
 * @param parentNode Parent device.
 * @param parent Parent map.
 * @return List of children.
 */
private ArrayList<Device> getChildren(Device parentNode,   HashMap<Device, Device> parent) {


    ArrayList<Device> children = new ArrayList<>();


    for (Device device : parent.keySet()) {
        if (parent.get(device) == parentNode) {
            children.add(device);
        }
    }

    Collections.sort(children, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

    return children;
}

}