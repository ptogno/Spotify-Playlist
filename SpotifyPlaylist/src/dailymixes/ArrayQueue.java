// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;
/**
 *  Circular Array data structure used to store songs 
 * 
 *  @author togno
 *  @version Nov 4, 2024
 * @param <T> T
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    /**
     * Initial default capacity of Array Queue, set to 20
     */
    static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;
    /**
     * Create a new ArrayQueue object.
     * @param capacity integer representing the capacity of the ArrayQueue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
        size = 0;
    }
    /**
     * Create a new ArrayQueue object.
     */
    public ArrayQueue() {
       this(DEFAULT_CAPACITY);
    }
    /**
     * Get the front entry (dequeueIndex) for the ArrayQueue
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }
    /**
     * Method to clear the ArrayQueue
     */
    @Override
    public void clear()
    {
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
        size = 0;
    }
    /**
     * Method to remove first index (dequeueIndex) from ArrayQueue
     * @return front new first index after dequeue execution
     */
    @Override
    public T dequeue()
    {
        T front = getFront(); //Will throw exception if empty
        queue[dequeueIndex] = null;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        size--;
        return front;
    }
    /**
     * Method to add entry to last index (enqueueIndex)
     */
    @Override
    public void enqueue(T anEntry)
    {
        ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        size++;
        queue[enqueueIndex] = anEntry;
    }
    /**
     * Method to check if ArrayQueue is empty
     */
    @Override
    public boolean isEmpty() {
        return (dequeueIndex == (enqueueIndex + 1) % queue.length); 
    }
    /**
     * Method to check if ArrayQueue is full
     */
    private boolean isFull() {
        return size == queue.length;
    }
    /**
     * Method to get the size of the array
     * @return size of the array
     */
    public int getSize() {
        return size;
    }
    /**
     * Method to get the length of the underlying array
     * @return The length of the underlying array is simply the capacity + 1
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }
    /**
     * Helper method used to upgrade length of the array if full
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            T[] oldQueue = queue;
            int oldSize = queue.length;
            int newSize = (2 * oldSize) - 1;
            queue = (T[]) new Object[newSize];
            
            int j = dequeueIndex;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldQueue[i];
                j = (j + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }
    }
//    /**
//     * Helper method to help with circular array logic
//     */
//    private int incrementIndex(int index) {
//        return ((index + 1) % queue.length);
//    }
    /**
     * Array representation of arrayQueue
     * @return array representation of queue
     * 
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = queue[(dequeueIndex + i) % queue.length];
        }
        return array;
    }
    /**
     * String representation of the ArrayQueue
     * 
     * @return StringBuilder representation of ArrayQueue
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(queue[(dequeueIndex + i) 
                                 % queue.length].toString());
            if (i < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
    /**
     * Method to compare whether two ArrayQueues are equal
     * 
     * @param obj to compare to
     * 
     * @return true if two objects are equal, false if otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ArrayQueue<?> other = (ArrayQueue<?>) obj;
        if (this.size != other.size) {
            return false;
        }
        // Checks if every element of "this" ArrayQueue matches with
        // every element of "other" array queue, and if even one element
        // does not match, returns false, otherwise, returns true.
        for (int i = 0; i < size; i++) {
            if (!queue[(dequeueIndex + i) % queue.length]
                .equals(other.queue[(other.dequeueIndex + i) 
                                    % other.queue.length])) {
                return false;
            }
        }
        return true;
    }
}
