/**
 * Manages the Printer Scheduling using Circular Queue.
 */
public class PrinterScheduler {

    // Queue to store print jobs
    private CircularQueue queue;

    // Maximum pages printed in one turn
    private int k;


    /**
     * Creates a Printer Scheduler.
     * @param capacity maximum queue capacity
     * @param k maximum pages printed in one turn
     */
    public PrinterScheduler(int capacity, int k) {

        if (k <= 0) {
            throw new IllegalArgumentException("Pages per turn must be greater than 0.");
        }

        queue = new CircularQueue(capacity);
        this.k = k;
    }


    /**
     * Adds a new job to the printer queue.
     * @param job print job
     */
    public void addJob(Job job) {

    if (queue.enqueue(job)) {
        System.out.println("Job " + job.getJobId() + " Added Successfully.");
    } else {
        System.out.println("Queue is Full. Job Rejected.");
    }
}


    /**
     * Executes one printer turn.
     * Prints at most k pages.
     */
    public void runPrinterTurn() {

        // Edge Case : Queue Empty
        if (queue.isEmpty()) {
            System.out.println("Nothing to Print.");
            return;
        }

        Job currentJob = queue.dequeue();
        System.out.println("\nPrinting Job ID : " + currentJob.getJobId());

        // Job completed
        if (currentJob.getPages() <= k) {

            System.out.println("Printed " + currentJob.getPages() + " pages.");
            System.out.println("Job Completed.");

        }

        // Job not completed
        else {


            System.out.println("Printed " + k + " pages.");

            currentJob.setPages(currentJob.getPages() - k);

            System.out.println("Remaining Pages : " + currentJob.getPages());

            queue.enqueue(currentJob);
        }
    }


    /**
     * Checks whether all jobs are completed.
     *
     * @return true if queue is empty, otherwise false
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}