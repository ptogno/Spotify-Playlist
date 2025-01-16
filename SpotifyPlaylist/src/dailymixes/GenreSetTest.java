// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

import student.TestCase;

/**
 *  Test class of the GenreSet test class
 * 
 *  @author togno
 *  @version Nov 2, 2024
 */
public class GenreSetTest extends TestCase {
    private GenreSet genreSet1;
    private GenreSet genreSet2;
    private GenreSet genreSet3;
    private GenreSet genreSet4;
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private GenreSet identicalGenreSet;
    private String notGenreSet;
    
    /**
     * Sets up all test methods for class
     */
    public void setUp() {
        genreSet1 = new GenreSet(5, 10, 20);
        identicalGenreSet = new GenreSet(5, 10, 20);
        genreSet2 = new GenreSet(10, 15, 25);
        genreSet3 = new GenreSet(12, 17, 27);
        genreSet4 = new GenreSet(5, 10, 15);
        minGenreSet = new GenreSet(6, 11, 21);
        maxGenreSet = new GenreSet(11, 16, 26);
        notGenreSet = "Pandora";
    }
    // ----------------------------------------------------------
    /**
     * Test method for the isWithinRange method
     */
    public void testIsWithinRange() {
        assertFalse(genreSet1.isWithinRange(minGenreSet, maxGenreSet));
        assertFalse(genreSet3.isWithinRange(minGenreSet, maxGenreSet));
        assertTrue(genreSet2.isWithinRange(minGenreSet, maxGenreSet));
    }
    /**
     * Test method for the getRock method
     */
    public void testGetRock() {
        assertEquals(genreSet1.getRock(), 10);
    }
    /**
     * Test method for the getPop method
     */
    public void testGetPop() {
        assertEquals(genreSet1.getPop(), 5);
    }
    /**
     * Test method for the getCountry method
     */
    public void testGetCountry() {
        assertEquals(genreSet1.getCountry(), 20);
    }
    /**
     * Test method for the equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertTrue(genreSet1.equals(genreSet1));
        assertTrue(genreSet1.equals(identicalGenreSet));
        assertFalse(genreSet1.equals(null));
        assertFalse(genreSet1.equals(genreSet2));
        assertFalse(genreSet1.equals(genreSet4));
        assertFalse(genreSet1.equals(notGenreSet));
    }
    /**
     * test method for the compareTo method
     */
    public void testCompareTo() {
        assertTrue(genreSet1.compareTo(genreSet2) < 0);
        assertTrue(genreSet2.compareTo(genreSet1) > 0);
        assertEquals(genreSet1.compareTo(identicalGenreSet), 0);
    }
    /**
     * Test method for toString method
     */
    public void testToString() {
        assertEquals(genreSet1.toString(), "Pop:5 Rock:10 Country:20");
    }
}
