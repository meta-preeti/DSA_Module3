public class Node {


    Flight flight;
    Node left;
    Node right;


    public Node(Flight flight) {
        this.flight = flight;
        this.left = null;
        this.right = null;
    }
}