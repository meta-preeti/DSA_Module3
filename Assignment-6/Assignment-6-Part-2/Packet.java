/**
 * Represents a network packet node in the linked list.
 * Each packet stores its payload size and priority.
 */
public class Packet {

    private int payloadSize;
    private int priority;
    Packet next;

    /**
     * Creates a new packet.
     *
     * @param payloadSize Size of the packet payload.
     * @param priority Priority of the packet.
     * @throws IllegalArgumentException if payload size or priority is negative.
     */
    public Packet(int payloadSize, int priority) {

        if (payloadSize < 0) {
            throw new IllegalArgumentException("Payload size cannot be negative.");
        }

        if (priority < 0) {
            throw new IllegalArgumentException("Priority cannot be negative.");
        }

        this.payloadSize = payloadSize;
        this.priority = priority;
        this.next = null;
    }


    /**
     * Returns payload size.
     */
    public int getPayloadSize() {
        return payloadSize;
    }


    /**
     * Returns priority.
     */
    public int getPriority() {
        return priority;
    }


    /**
     * Returns packet details.
     */
    @Override
    public String toString() {
        return "[Payload=" + payloadSize + ", Priority=" + priority + "]";
    }
}