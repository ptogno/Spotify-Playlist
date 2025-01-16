// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- ptogno
package dailymixes;

import student.TestCase;

/**
 *  Test class of the Playlist class
 * 
 *  @author togno
 *  @version Nov 5, 2024
 */
public class PlaylistTest extends TestCase {
    private Playlist playlist1;
    private Playlist diffCapacity;
    private Playlist samePlaylist;
    private Playlist diffOrder;
    private Playlist diffSpacesLeft;
    private Playlist minGenreDiff;
    private Playlist maxGenreDiff;
    private Playlist minRangePlaylist;
    private Playlist maxRangePlaylist;
    private Playlist diffName;
    private Playlist fullPlaylist;
    private Song song1;
    private Song song2;
    private Song song3;
    private String notPlaylist;
    
    /**
     * Set up all test methods for class
     */
    public void setUp() {
        playlist1 = new Playlist("p1", 10, 30, 20, 30, 50, 40, 10);
        samePlaylist = new Playlist("p1", 10, 30, 20, 30, 50, 40, 10);
        diffOrder = new Playlist("p1", 10, 30, 20, 30, 50, 40, 10);
        diffCapacity = new Playlist("p1", 10, 30, 20, 30, 50, 40, 5);
        minRangePlaylist = new Playlist("p1", 25, 45, 35, 30, 50, 40, 5);
        maxRangePlaylist = new Playlist("p1", 10, 30, 20, 15, 35, 25, 10);
        diffSpacesLeft = new Playlist("p1", 10, 30, 20, 30, 50, 40, 10);
        minGenreDiff = new Playlist("p2", 5, 15, 10, 30, 50, 40, 10);
        diffName = new Playlist("q1", 10, 30, 20, 30, 50, 40, 10);
        fullPlaylist = new Playlist("p1", 10, 30, 20, 30, 50, 40, 2);
        song1 = new Song("song1", 20, 40, 30, "");
        song2 = new Song("song2", 20, 40, 30, "");
        song3 = new Song("song3", 5, 50, 15, "");
        maxGenreDiff = new Playlist("p1", 10, 30, 20, 40, 60, 50, 10);
        notPlaylist = "not";
    }
    /**
     * Test method to test getMinGenreSet
     */
    public void testGetMinGenreSet() {
        GenreSet expectedGenreSet = new GenreSet(10, 30, 20);
        assertEquals(playlist1.getMinGenreSet(), expectedGenreSet);
    }

    /**
     * Test method for getMaxGenreSet
     */
    public void testGetMaxGenreSet() {
        GenreSet expectedGenreSet = new GenreSet(30, 50, 40);
        assertEquals(playlist1.getMaxGenreSet(), expectedGenreSet);
    }
    /**
     * Test method for getSongs
     */
    public void testGetSongs() {
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        
        Song[] actual = playlist1.getSongs();
        Song[] expected = { song1, song2 };
                
        for (int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }
    /**
     * Test method for compareTo method
     */
    public void testCompareTo() {
        assertEquals(playlist1.compareTo(diffCapacity), 1);
        assertEquals(diffCapacity.compareTo(playlist1), -1);
        assertEquals(playlist1.compareTo(samePlaylist), 0);
        
        diffSpacesLeft.addSong(song1);
        assertEquals(playlist1.compareTo(diffSpacesLeft), 1);
        assertEquals(diffSpacesLeft.compareTo(playlist1), -1);
        assertEquals(diffSpacesLeft.compareTo(diffSpacesLeft), 0);
        
        assertEquals(playlist1.compareTo(minGenreDiff), 1);
        assertEquals(minGenreDiff.compareTo(playlist1), -1);
        assertEquals(minGenreDiff.compareTo(minGenreDiff), 0);
        
        assertEquals(playlist1.compareTo(maxGenreDiff), -1);
        assertEquals(maxGenreDiff.compareTo(playlist1), 1);
        assertEquals(maxGenreDiff.compareTo(maxGenreDiff), 0);
        
        assertEquals(playlist1.compareTo(diffName), -1);
        assertEquals(diffName.compareTo(playlist1), 1);
        assertEquals(diffName.compareTo(diffName), 0);
    }
    /**
     * Test method to getCapacity
     */
    public void testGetCapacity() {
        assertEquals(playlist1.getCapacity(), 10);
    }
    /**
     * Test method to setName
     */
    public void testSetName() {
        playlist1.setName("o2");
        assertEquals(playlist1.getName(), "o2");
    }
    /**
     * Test method for getSpaces
     */
    public void testGetSpaces() {
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        
        assertEquals(playlist1.getSpacesLeft(), 8);
    }
    /**
     * Test method for getName
     */
    public void testGetName() {
        assertEquals(playlist1.getName(), "p1");
    }
    /**
     * Test method getNumberOfSongs
     */
    public void testGetNumberOfSongs() {
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        
        assertEquals(playlist1.getNumberOfSongs(), 2);
    }
    /**
     * Test method isFull
     */
    public void testIsFull() {
        fullPlaylist.addSong(song1);
        fullPlaylist.addSong(song2);
            
        assertTrue(fullPlaylist.isFull());
    }
    /**
     * Test method for addSong
     */
    public void testAddSong() {
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        
        assertEquals(playlist1.getNumberOfSongs(), 2);
        assertFalse(playlist1.addSong(song3));
    }
    /**
     * Test method for testing toString
     */
    public void testToString() {
        assertEquals(playlist1.toString(), 
            "Playlist: p1, # of songs: 0 (cap: 10), Requires: "
            + "Pop:10%-30%, Rock:30%-50%, Country:20%-40%");
    }
    /**
     * Test method for isQualified
     */
    public void testIsQualified() {
        fullPlaylist.addSong(song1);
        fullPlaylist.addSong(song2);
        assertFalse(fullPlaylist.isQualified(song1));
        
        assertFalse(minRangePlaylist.isQualified(song1));
        assertFalse(maxRangePlaylist.isQualified(song1));
        
        assertTrue(playlist1.isQualified(song1));
    }
    /**
     * Test method for equals
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertTrue(playlist1.equals(playlist1));
        
        assertFalse(playlist1.equals(null));
        assertFalse(playlist1.equals(notPlaylist));
        
        assertFalse(playlist1.equals(diffCapacity));
        
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        samePlaylist.addSong(song1);
        samePlaylist.addSong(song2);

        assertTrue(playlist1.equals(samePlaylist));
        
        diffOrder.addSong(song2);
        diffOrder.addSong(song1);
        
        assertFalse(playlist1.equals(diffOrder));
        
        samePlaylist.addSong(song1);
        assertFalse(playlist1.equals(samePlaylist));
    }
}