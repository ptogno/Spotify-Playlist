// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

import queue.EmptyQueueException;
import student.TestCase;

/**
 *  Test class for the ArrayQueue class
 * 
 *  @author togno
 *  @version Nov 4, 2024
 */
public class ArrayQueueTest extends TestCase {
    private ArrayQueue<String> queue1;
    private ArrayQueue<String> queue2;
    private ArrayQueue<String> queue3;
    private String notQueue;
    /**
     * Method to set up all test methods
     */
    public void setUp() {
        queue1 = new ArrayQueue<>(20);
        queue2 = new ArrayQueue<>(20);
        queue3 = new ArrayQueue<>(20);
        notQueue = "queue1";
    }
    /**
     * Test method for constructor
     */
    public void testConstructor() {
        assertNotNull(queue1);
        assertTrue(queue1.isEmpty());
        
        assertEquals(ArrayQueue.DEFAULT_CAPACITY + 1, 
            queue1.getLengthOfUnderlyingArray());
    }
    /**
     * Test method for testing enqueue
     */
    public void testEnqueue() {
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        queue1.enqueue("song3");
        
        assertEquals(queue1.getSize(), 3);
        assertEquals(queue1.getFront(), "song1");
    }
    /**
     * Test method for testing dequeue with an empty dequeue
     */
    public void testDequeueWithEmptyArray() {
        Exception exception = null;
        try {
            queue1.dequeue();
        }
        catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyQueueException);
    }
    /**
     * Test method for testing dequeue with arrayQueue
     */
    public void testDequeue() {
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        queue1.enqueue("song3");
        
        queue1.dequeue();
        assertEquals(queue1.getSize(), 2);
        assertEquals(queue1.getFront(), "song2");
    }
    /**
     * Test method for testing clear
     */
    public void testClear() {
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        queue1.enqueue("song3");
        
        queue1.clear();
        assertEquals(queue1.getSize(), 0);
    }
    /**
     * test getFront method with empty queue
     */
    public void testGetFrontWithEmpty() {
        Exception exception = null;
        try {
            queue1.getFront();
        }
        catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyQueueException);
    }
    /**
     * test method for getFront method
     */
    public void testGetFront() {
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        queue1.enqueue("song3");
        
        assertEquals(queue1.getFront(), "song1");
    }
    /**
     * Test method for isEmpty
     */
    public void testIsEmpty() {
        assertTrue(queue1.isEmpty());
        queue1.enqueue("song1");
        assertFalse(queue1.isEmpty());
    }
    /**
     * Test method for ensureCapacity
     */
    public void testEnsureCapcity() {
        for (int i = 1; i <= 20; i++) {
            queue1.enqueue("Song" + i);
        }
        queue1.enqueue("Song21");
        assertEquals(queue1.getSize(), 21);
        queue1.enqueue("Song22");
        assertEquals(queue1.getLengthOfUnderlyingArray(), 41);
    }
    /**
     * Test method for the getSize method
     */
    public void testGetSize() {
        assertEquals(queue1.getSize(), 0);
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        queue1.enqueue("song3");
        assertEquals(queue1.getSize(), 3);
    }
    /**
     * Test method for the getLengthOfUnderlyingArray
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(queue1.getLengthOfUnderlyingArray(), 21);
    }
    /**
     * Test method for the toArray when empty
     */
    public void testToArrayWithEmpty() {
        Exception exception = null;
        try {
            queue1.toArray();
        }
        catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyQueueException);
    }
    /**
     * Test method for the toArray method
     */
    public void testToArray() {
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        
        Object[] expected = {"song1", "song2"};
        Object[] actual = queue1.toArray();
        
        assertEquals(expected.length, actual.length);
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }
    /**
     * Test method for the toString method
     */
    public void testToString() {
        assertEquals(queue1.toString(), "[]");
        
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        
        assertEquals(queue1.toString(), "[song1, song2]");
        
        queue1.dequeue();
        
        assertEquals(queue1.toString(), "[song2]");
    }
    /**
     * Test method for the equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        queue1.enqueue("song1");
        queue1.enqueue("song2");
        assertTrue(queue1.equals(queue1));
       
        queue2.enqueue("song1");
        assertFalse(queue1.equals(queue2));
        queue2.enqueue("song2");
        assertTrue(queue1.equals(queue2));
        
        queue3.enqueue("song1");
        queue3.enqueue("song3");
        assertFalse(queue1.equals(queue3));
        
        assertFalse(queue1.equals(null));
        
        assertFalse(queue1.equals(notQueue));
    }
}