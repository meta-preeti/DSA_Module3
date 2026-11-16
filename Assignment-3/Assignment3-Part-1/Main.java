/**
 * Driver class for testing the Virtual Network Console.
 */
public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();
        System.out.println("========== INITIAL NETWORK ==========");
        graph.listDevices();
        System.out.println("\n========== ADD DEVICES ==========");

        graph.addDevice("Core-1");
        graph.addDevice("Core-2");
        graph.addDevice("Edge-1");
        graph.addDevice("Edge-2");
        graph.addDevice("Edge-3");
        graph.addDevice("Switch-1");

        System.out.println("\n========== EDGE CASES : ADD ==========");
        graph.addDevice("Core-1");       // Already exists
        graph.addDevice("core-1");       // Case insensitive duplicate
        graph.addDevice("");
        graph.addDevice("   ");
        graph.addDevice(null);

        System.out.println("\n========== CREATE LINKS ==========");
        graph.linkDevices("Gateway", "Core-1");
        graph.linkDevices("Gateway", "Core-2");
        graph.linkDevices("Core-1", "Edge-1");
        graph.linkDevices("Core-1", "Edge-2");
        graph.linkDevices("Core-2", "Edge-3");
        graph.linkDevices("Edge-2", "Switch-1");


        System.out.println("\n========== EDGE CASES : LINK ==========");
        graph.linkDevices("Gateway", "Gateway"); // Self link
        graph.linkDevices("Core-1", "Edge-1");   // Already linked
        graph.linkDevices("Laptop", "Core-1");   // Device not found
        graph.linkDevices("", "Core-1");
        graph.linkDevices(null, "Core-1");


        System.out.println("\n========== LIST ==========");
        graph.listDevices();
        System.out.println("\n========== HOP ==========");
        graph.hop("Core-1");
        graph.listDevices();
        System.out.println("\n========== EDGE CASES : HOP ==========");
        graph.hop("Core-1");     // Already current
        graph.hop("Gateway");    // Success
        graph.hop("Edge-1");     // Not directly connected
        graph.hop("Laptop");     // Not found
        graph.hop("");
        graph.hop(null);

        System.out.println("\n========== PATH ==========");
        graph.path("Edge-2");
        graph.path("Switch-1");
        graph.path("Core-2");

        System.out.println("\n========== EDGE CASES : PATH ==========");
        graph.path("Gateway");
        graph.path("Laptop");
        graph.path("");
        graph.path(null);


        System.out.println("\n========== SPREAD ==========");
        graph.spread();
        System.out.println("\n========== END ==========");
    }
}