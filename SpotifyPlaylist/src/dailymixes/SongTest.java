// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

import student.TestCase;

/**
 *  Test class for the Song class
 * 
 *  @author togno
 *  @version Nov 3, 2024
 */
public class SongTest extends TestCase {
    private Song song1;
    private Song song2;
    private Song diffGenreSet;
    private Song diffName;
    private Song diffSuggestedPlaylist;
    private Song nullPlaylist;
    private Song emptyPlaylist;
    private String notSong;
    private Song sameSong;
    
    /**
     * Set up all test methods for the class
     */
    public void setUp() {
        song1 = new Song("Pinball Wizard", 20, 60, 10, "p1");
        diffName = new Song("HotToGo", 20, 60, 10, "p1");
        diffGenreSet = new Song("Pinball Wizard", 20, 70, 10, "p1");
        diffSuggestedPlaylist = new Song("Pinball Wizard", 20, 70, 10, "p2");
        song2 = new Song("Song 2", 15, 50, 5, "p2");
        sameSong = new Song("Pinball Wizard", 20, 60, 10, "p1");
        nullPlaylist = new Song("Last Suprise", 5, 70, 20, null);
        emptyPlaylist = new Song("Last Suprise", 5, 70, 20, "");
        notSong = "Song";
        
    }
    /**
     * Test method for getPlaylistName
     */
    public void testGetPlaylistName() {
        assertEquals(song1.getPlaylistName(), "p1");
    }
    /**
     * Test method for getName method
     */
    public void testGetName() {
        assertEquals(song1.getName(), "Pinball Wizard");
    }
    /**
     * Test method for getGenreSet method
     */
    public void testGetGenreSet() {
        GenreSet expectedGenreSet = new GenreSet(20, 60, 10);
        assertEquals(expectedGenreSet, song1.getGenreSet());
    }
    /**
     * Test method for toString method
     */
    public void testToString() {
        assertEquals(nullPlaylist.toString(), 
            "No-Playlist Last Suprise Pop:5 Rock:70 Country:20");
        assertEquals(song1.toString(), 
            "Pinball Wizard Pop:20 Rock:60 Country:10 Suggested p1");
        assertEquals(emptyPlaylist.toString(), 
            "No-Playlist Last Suprise Pop:5 Rock:70 Country:20");
    }
    /**
     * Test method for the equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        assertTrue(song1.equals(song1));
        assertFalse(song1.equals(notSong));
        assertFalse(song1.equals(null));
        assertFalse(song1.equals(song2));
        assertTrue(song1.equals(sameSong));
        assertFalse(song1.equals(diffGenreSet));
        assertFalse(song1.equals(diffSuggestedPlaylist));
        assertFalse(song1.equals(diffName));

    }
}