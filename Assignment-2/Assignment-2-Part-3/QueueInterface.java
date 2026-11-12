/**
 * Interface representing the basic operations of a Queue.
 * This interface will be implemented using a Circular Queue.
 */
public interface QueueInterface {

    /**
     * Inserts a job into the queue.
     * @param job the job to be inserted
     */
    boolean enqueue(Job job);

    /**
     * Removes and returns the front job from the queue.
     * @return removed job, or null if queue is empty
     */
    Job dequeue();

    /**
     * Checks whether the queue is empty.
     * @return true if queue is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * Checks whether the queue is full.
     * @return true if queue is full, otherwise false
     */
    boolean isFull();
}