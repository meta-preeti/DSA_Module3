/**
 * Driver class to test the Leaderboard application.
 */
public class Main {


    public static void main(String[] args) {


        Leaderboard leaderboard = new Leaderboard();


        // Nearly sorted leaderboard
        leaderboard.insertPlayer(101, "Nikita", 95);
        leaderboard.insertPlayer(102, "Rahul", 82);
        leaderboard.insertPlayer(103, "Aman", 85);
        leaderboard.insertPlayer(104, "Priya", 92);
        leaderboard.insertPlayer(105, "Riya", 75);
        leaderboard.insertPlayer(106, "Karan", 92);


        System.out.println("Leaderboard Before Sorting:");
        leaderboard.displayLeaderboard();


        leaderboard.bubbleSort();


        System.out.println("\nLeaderboard After Sorting:");
        leaderboard.displayLeaderboard();
    }
}