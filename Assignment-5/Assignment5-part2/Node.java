/**
 * Represents a player in the leaderboard.
 * Each node stores the player's registration ID,
 * name, score, and links to the previous and next nodes.
 */
public class Node {


    int registrationId;
    String playerName;
    int score;


    Node prev;
    Node next;


    /**
     * Creates a new player node.
     *
     * @param registrationId Unique registration ID of the player.
     * @param playerName Name of the player.
     * @param score Current score of the player.
     * @throws IllegalArgumentException If registration ID is invalid,
     *                                  player name is null/blank,
     *                                  or score is negative.
     */
    public Node(int registrationId, String playerName, int score) {


        if (registrationId <= 0) {
            throw new IllegalArgumentException("Registration ID must be greater than 0.");
        }


        if (playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }


        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be negative.");
        }


        this.registrationId = registrationId;
        this.playerName = playerName.trim();
        this.score = score;


        this.prev = null;
        this.next = null;
    }
}

