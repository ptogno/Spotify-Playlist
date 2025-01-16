// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- ptogno
package dailymixes;

//import queue.QueueInterface;
/**
 *  Object containg a string for playlist name, three integers for min,
 *  and max GenreSet, an array of Song objects, an integer for storing
 *  number of songs on the playlist, and a final integer for the 
 *  maximum capacity of playlist.
 * 
 *  @author togno
 *  @version Nov 4, 2024
 */
public class Playlist implements Comparable<Playlist> {
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;
    
    /**
     * Create a new Playlist object.
     * @param playlistName name of playlist
     * @param minPop minimum pop value
     * @param minRock minimum rock value
     * @param minCountry minimum country value
     * @param maxPop maximum pop value
     * @param maxRock maximum rock value
     * @param maxCountry maximum country value
     * @param playlistCap maximum capacity of playlist
     */
    public Playlist(String playlistName, int minPop, int minRock, 
        int minCountry, int maxPop, int maxRock, int maxCountry, 
        int playlistCap)
    {
        name = playlistName;
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        capacity = playlistCap;
        numberOfSongs = 0;
        songs = new Song[playlistCap];
    }
    /**
     * Method to order the playlists based on various comparisons,
     * in the following order; capacity, spaces left, minimum genre set,
     * maximum genre set, and finally name if all other values are equal
     * 
     * @return Which factor orders the playlist
     */
    @Override
    public int compareTo(Playlist comparablePlaylist)
    {
        if (capacity != comparablePlaylist.capacity) {
            return Integer.compare(capacity, comparablePlaylist.capacity);
        }
        if (getSpacesLeft() != comparablePlaylist.getSpacesLeft()) {
            return Integer.compare(getSpacesLeft(), 
                comparablePlaylist.getSpacesLeft());
        }
        
        if ((minGenreSet.compareTo(
            comparablePlaylist.getMinGenreSet()) != 0)) {
            
            return minGenreSet.compareTo(
                comparablePlaylist.getMinGenreSet());
        }
        if (maxGenreSet.compareTo(
            comparablePlaylist.getMaxGenreSet()) != 0) {
            return maxGenreSet.compareTo(
                comparablePlaylist.getMaxGenreSet());
        }
        return name.compareTo(comparablePlaylist.name);
    }
    /**
     * Method to get minGenreSet
     * @return minimum GenreSet
     */
    public GenreSet getMinGenreSet() {
        return minGenreSet;
    }
    /**
     * Method to get the list of Songs in playlist
     * @return list of Songs in playlist
     */
    public Song[] getSongs() {
        return songs;
    }
    /**
     * Method to get capacity of playlist
     * 
     * @return capacity of playlist
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Method to get maxGenreSet
     * @return maximum GenreSet
     */
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }
    /**
     * Method to set the name of the playlist
     * @param newName new name the playlist will be set to
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * Method which returns the number of available places left in the
     * playlist
     * 
     * @return remaining available place in playlist
     */
    public int getSpacesLeft() {
        return capacity - numberOfSongs;
    }
    /**
     * Method which returns the name of the playlist
     * 
     * @return name of playlist
     */
    public String getName() {
        return name;
    }
    /**
     * Method to get the number of songs in the playlist
     * @return number of songs in the playlist
     */
    public int getNumberOfSongs() {
        return numberOfSongs;
    }
    /**
     * Method which returns true if playlist is full
     * @return true if capacity equals number of songs
     */
    public boolean isFull() {
        return numberOfSongs >= capacity;
    }
    /**
     * Method to add song to playlist
     * @param newSong song being added
     * @return true if song is added, false if not
     */
    public boolean addSong(Song newSong) {
        if (isQualified(newSong)) {
            songs[numberOfSongs++] = newSong;
            return true;
        }
        return false;
    }
    /**
     * Using a StringBuilder, builds a string representation
     * of the playlist
     * 
     * @return String representation for Playlist
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Playlist: ").append(name).
        append(", # of songs: ").append(numberOfSongs).
        append(" (cap: ").append(capacity).append("), Requires: Pop:")
        .append(minGenreSet.getPop()).append("%-").
        append(maxGenreSet.getPop()).append("%, Rock:").
        append(minGenreSet.getRock()).append("%-")
        .append(maxGenreSet.getRock()).append("%, Country:")
        .append(minGenreSet.getCountry()).append("%-")
        .append(maxGenreSet.getCountry()).append("%");
        
        return builder.toString();
    }
    /**
     * Helper method to see if Song is qualified to add a song
     * to the playlist
     * 
     * @param possibleSong song to be used in is qualifed
     * 
     * @return returns false if playlist is full, or the GenreSet
     * is not in range, returnign true if GenreSet is between min
     * and max GenreSet
     */
    public boolean isQualified(Song possibleSong) {
        if (isFull()) {
            return false;
        }
        GenreSet songGenreSet = possibleSong.getGenreSet();
        return songGenreSet.isWithinRange(minGenreSet, maxGenreSet);
    }
    /**
     * Method to test whether two Playlist are equal
     * 
     * @param obj to compare to
     * 
     * @return true if equal, false if not
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Playlist playlist = (Playlist) obj;
        if (capacity == playlist.capacity && 
            numberOfSongs == playlist.numberOfSongs &&
            name == playlist.name && 
            getMinGenreSet().equals(playlist.getMinGenreSet()) &&
            getMaxGenreSet().equals(playlist.getMaxGenreSet())) {
            if (songs.length != playlist.songs.length) {
                return false;
            }
            for (int i = 0; i < numberOfSongs; i++) {
                if (!songs[i].equals(playlist.songs[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
