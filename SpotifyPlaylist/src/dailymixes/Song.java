// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

/**
 *  Objects to represent songs in a playlist, contains a GenreSet object, 
 *  and a string representation of the song's suggested playlist.
 * 
 *  @author togno
 *  @version Nov 3, 2024
 */
public class Song {
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;
    /**
     * Create a new Song object.
     * @param name name of song
     * @param pop percent composition for pop
     * @param rock percent composition for rock
     * @param country percent composition for country
     * @param suggested suggested playlist to be added to
     */
    public Song(String name, int pop, int rock, 
        int country, String suggested) {
        this.name = name;
        suggestedPlaylist = suggested;
        genreSet = new GenreSet(pop, rock, country);
    }
    /**
     * Method which returns the name of the suggested playlist
     * @return suggestedPlaylist's name
     */
    public String getPlaylistName() {
        return suggestedPlaylist;
    }
    /**
     * Method which returns the name of the song
     * @return song name
     */
    public String getName() {
        return name;
    }
    /**
     * Method which returns the genre set of the song
     * @return genreSet of the song
     */
    public GenreSet getGenreSet() {
        return genreSet;
    }
    /**
     * Method which returns a string representation of the song
     * 
     * @return String representation of song
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        if (suggestedPlaylist == null || 
            suggestedPlaylist.length() == 0) {
            builder.append("No-Playlist ");
        }
        builder.append(name).append(" ").append(genreSet.toString());
        
        if (suggestedPlaylist != null && 
            suggestedPlaylist.length() > 0) {
            builder.append(" Suggested ").append(suggestedPlaylist);
        }
        return builder.toString();
    }
    /**
     * Equals method to check if two song objects are equal
     * 
     * @param obj to compare
     * 
     * @return false if objects are not identical, true if they are 
     * equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Song song = (Song) obj;
        return this.name.equals(song.name) && 
            this.genreSet.equals(song.genreSet) &&
            this.suggestedPlaylist.equals(song.suggestedPlaylist); 
    }
}