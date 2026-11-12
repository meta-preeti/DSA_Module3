/**
 * Represents a print job.
 * Each job contains a job ID and the number of pages to print.
 */
public class Job {

    // Unique Job ID
    private int jobId;

    // Number of pages remaining to print
    private int pages;


    /**
     * Creates a new print job.
     * @param jobId unique job ID
     * @param pages number of pages
     */
    public Job(int jobId, int pages) {

        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than zero.");
        }


        this.jobId = jobId;
        this.pages = pages;
    }


    /**
     * Returns the job ID.
     * @return job ID
     */
    public int getJobId() {
        return jobId;
    }


    /**
     * Returns the remaining pages.
     * @return remaining pages
     */
    public int getPages() {
        return pages;
    }


    /**
     * Updates the remaining pages.
     * @param pages updated remaining pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }


    /**
     * Returns the job details.
     * @return job information
     */
    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Remaining Pages: " + pages;
    }
}