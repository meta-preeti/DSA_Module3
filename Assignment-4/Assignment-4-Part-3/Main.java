

/**
 * Driver class to test the Robot Movement program.
 *
 * @author Nikita
 * @version 1.0
 */
public class Main {


    public static void main(String[] args) {


        try {

            // Test Case 1
            String program1 = "U(RRU)2D3";
            Position position1 = RobotMovement.getFinalPosition(program1);

            System.out.println("Program : " + program1);
            System.out.println("Final Position : " + position1);

            System.out.println();

            // Test Case 2
            String program2 = "R2(U(L)2)3";

            Position position2 = RobotMovement.getFinalPosition(program2);

            System.out.println("Program : " + program2);
            System.out.println("Final Position : " + position2);


            System.out.println();

            // Test Case 3
            String program3 = "";

            Position position3 = RobotMovement.getFinalPosition(program3);

            System.out.println("Program : Empty String");
            System.out.println("Final Position : " + position3);


            System.out.println();


            // Test Case 4
            String program4 = "((R)2)3";

            Position position4 = RobotMovement.getFinalPosition(program4);
            System.out.println("Program : " + program4);
            System.out.println("Final Position : " + position4);


        } catch (IllegalArgumentException e) {

            System.out.println("Error : " + e.getMessage());


        } catch (Exception e) {

            System.out.println("Unexpected Error : " + e.getMessage());


        }
    }
}