/**
 * Driver class to test the Printer Scheduler.
 */
public class Main {


    public static void main(String[] args) {

        // Queue Capacity = 3
        // Printer prints maximum 10 pages per turn
        PrinterScheduler printer = new PrinterScheduler(3, 10);

        // Adding Jobs
        printer.addJob(new Job(101, 25));
        printer.addJob(new Job(102, 8));
        printer.addJob(new Job(103, 15));

        // Queue Full (This job will be rejected)
        printer.addJob(new Job(104, 20));

        System.out.println("\n Printer Started :");

        // Continue printing until all jobs are completed
        while (!printer.isEmpty()) {
            printer.runPrinterTurn();
        }

        System.out.println("\n All Jobs Completed : ");

        // Edge Case : Queue Empty
        printer.runPrinterTurn();
    }
}