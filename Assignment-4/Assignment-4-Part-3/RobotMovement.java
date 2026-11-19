
import java.util.ArrayDeque;

/**
 * Calculates the final position of the robot
 * after executing the movement program.
 *
 * Supported commands:
 * U - Up
 * D - Down
 * L - Left
 * R - Right
 */
public class RobotMovement {

    /**
     * Stores the position before entering a group.
     */
    private static class Frame {

        int x;
        int y;
        Frame(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * Reads the repetition count starting from the given index.
     * If no number is present, returns 1.
     *
     * @param program Movement program
     * @param index Starting index
     * @return Array containing:
     *         [0] -> repetition count
     *         [1] -> next index after the number
     */
    private static int[] readNumber(String program, int index) {
        int count = 0;
        while (index < program.length() && Character.isDigit(program.charAt(index))) {
            count = count * 10 + (program.charAt(index) - '0');
            index++;
        }

        if (count == 0) {
            count = 1;
        }
        return new int[] { count, index };
    }


    /**
     * Calculates the final position of the robot.
     *
     * @param program Robot movement program
     * @return Final Position
     * @throws IllegalArgumentException if program is null
     */
    public static Position getFinalPosition(String program) {
        if (program == null) {
            throw new IllegalArgumentException(
                    "Program cannot be null.");
        }
        program = program.trim();

        if (program.isEmpty()) {
            return new Position(0, 0);
        }

        ArrayDeque<Frame> stack = new ArrayDeque<>();
        int x = 0;
        int y = 0;

        int i = 0;
        while (i < program.length()) {
            char ch = program.charAt(i);
            // Opening bracket
            if (ch == '(') {
                stack.push(new Frame(x, y));

                x = 0;
                y = 0;
                i++;
            }


            // Closing bracket
            else if (ch == ')') {
                int[] result = readNumber(program, i + 1);

              int repeat = result[0];
                i = result[1];

                Frame previous = stack.pop();

                x = previous.x + (x * repeat);
                y = previous.y + (y * repeat);
            }


            // Movement command
            else {

                int[] result = readNumber(program, i + 1);
                int repeat = result[0];
                i = result[1];

                switch (ch) {

                    case 'U':
                        y += repeat;
                        break;

                    case 'D':
                        y -= repeat;
                        break;

                    case 'R':
                        x += repeat;
                        break;


                    case 'L':
                        x -= repeat;
                        break;

                    default:
                        throw new IllegalArgumentException(
                                "Invalid command : " + ch);
                }
            }
        }

        return new Position(x, y);
    }
}