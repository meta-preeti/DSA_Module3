


/**
 * Represents the robot's position on a 2D grid.
 *
 * @author Nikita
 * @version 1.0
 */
public class Position {


    int x;
    int y;

    /**
     * Creates a position with the given coordinates.
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Returns the position in (x, y) format.
     *
     * @return Position as a string
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}