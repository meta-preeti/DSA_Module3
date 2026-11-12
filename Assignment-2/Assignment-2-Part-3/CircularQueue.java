/**
 * Implements a Circular Queue using an array.
 */
public class CircularQueue implements QueueInterface {

    // Array to store jobs
    private Job[] queue;

    // Front index
    private int front;

    // Rear index
    private int rear;


    // Current number of elements
    private int size;

    /**
     * Creates a Circular Queue with the given capacity.
     * @param capacity maximum number of jobs
     */
    public CircularQueue(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }

        queue = new Job[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }


    /**
     * Inserts a job into the queue.
     * @param job job to be inserted
     */
     @Override
      public boolean enqueue(Job job) {

        if (isFull()) {
        return false;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = job;
        size++;

       return true;
     }


    /**
     * Removes and returns the front job.
     * @return removed job or null if queue is empty
     */
    @Override
    public Job dequeue() {

        if (isEmpty()) {
            return null;
        }
        Job removedJob = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        return removedJob;
    }


    /**
     * Checks whether the queue is empty.
     * @return true if queue is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Checks whether the queue is full.
     * @return true if queue is full, otherwise false
     */
    @Override
    public boolean isFull() {
        return size == queue.length;
    }


    /**
     * Returns the current number of jobs.
     * @return current size of queue
     */
    public int getSize() {
        return size;
    }
}