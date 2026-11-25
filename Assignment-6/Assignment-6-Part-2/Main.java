public class Main {


    public static void main(String[] args) {


        try {


            PacketLinkedList packetList = new PacketLinkedList();


            // Creating packets
            packetList.insert(new Packet(50, 2));
            packetList.insert(new Packet(20, 5));
            packetList.insert(new Packet(40, 1));
            packetList.insert(new Packet(20, 8));
            packetList.insert(new Packet(60, 4));
            packetList.insert(new Packet(40, 7));


            System.out.println("Original Linked List:");
            packetList.print();


            packetList.sort();


            System.out.println("\nSorted Linked List:");
            packetList.print();


        }
        catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
        catch (IllegalStateException e) {
            System.out.println("Operation Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }


        /*
         * Uncomment one test case at a time to verify edge cases.
         */


        // ---------- Edge Case 1 : Empty Linked List ----------
        /*
        try {
            PacketLinkedList emptyList = new PacketLinkedList();
            emptyList.sort();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */


        // ---------- Edge Case 2 : Single Node ----------
        /*
        try {
            PacketLinkedList singleList = new PacketLinkedList();
            singleList.insert(new Packet(100, 5));


            singleList.sort();
            singleList.print();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */


        // ---------- Edge Case 3 : Negative Payload ----------
        /*
        try {
            PacketLinkedList list = new PacketLinkedList();
            list.insert(new Packet(-10, 5));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */


        // ---------- Edge Case 4 : Negative Priority ----------
        /*
        try {
            PacketLinkedList list = new PacketLinkedList();
            list.insert(new Packet(20, -1));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */


        // ---------- Edge Case 5 : Null Packet ----------
        /*
        try {
            PacketLinkedList list = new PacketLinkedList();
            list.insert(null);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }
}