// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

import list.AList;

/**
 *  Class which calcualtes adding or rejecting a song to a playlist
 * 
 *  @author togno
 *  @version Nov 7, 2024
 */
public class PlaylistCalculator {
    private Playlist[] playlists;
    /**
     * 
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * 
     */
    public static final int MIN_PERCENT = 0;
    /**
     * 
     */
    public static final int MAX_PERCENT = 100;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    
    /**
     * Create a new PlaylistCalculator object.
     * 
     * @param songQueue songQueue for the PlaylistCalculator object
     * @param playlists array of playlists for the playlist calculator object
     */
    public PlaylistCalculator(
        ArrayQueue<Song> songQueue, Playlist[] playlists) {
        if (songQueue == null) {
            throw new IllegalArgumentException();
        }
        this.songQueue = songQueue;
        this.playlists = playlists;
        rejectedTracks = new AList<Song>();
    }
    
    /**
     * Method to determine if the next song can be added to 
     * a playlist.
     * 
     * @param nextSong the next song to be added to a playlist
     * 
     * @return playlist if the next song can be added to a playlist, 
     * null if this fails
     */
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }
        String suggestedPlaylistName = nextSong.getPlaylistName();
        int suggestedPlaylistIndex = getPlaylistIndex(suggestedPlaylistName);
        
        if (suggestedPlaylistIndex != -1) {
            Playlist suggestedPlaylist = playlists[suggestedPlaylistIndex];
            if (suggestedPlaylist.isQualified(nextSong)) {
                return suggestedPlaylist;
            }
        }
        
        return getPlaylistWithMaximumCapacity(nextSong);
    }
    /**
     * Gets the integer representation of given playlist
     * 
     * @param playlist given playlist to return index of
     *
     * @return the given index if the playlist is found, -1 if
     * otehrwise
     */
    public int getPlaylistIndex(String playlist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i].getName().equals(playlist)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Method to find the playlist with the maximum capacity
     * 
     * @param aSong to be tested if qualified for the playlist
     * 
     * @return the playlist with the maximum capacity remaining
     */
    private Playlist getPlaylistWithMaximumCapacity(Song aSong) {
        Playlist maxCapacityPlaylist = null;
        int maxCapacity = -1;
        
        for (int i = 0; i < playlists.length; i++) {
            Playlist currentPlaylist = playlists[i];
            int currentCapacity = currentPlaylist.getSpacesLeft();
            
            if (currentPlaylist.isQualified(aSong) && 
                currentCapacity > maxCapacity) {
                maxCapacity = currentCapacity;
                maxCapacityPlaylist = currentPlaylist;
            }
        }
        return maxCapacityPlaylist;
    }
    /**
     * Method that attempts to add the next song
     * 
     * @return false if song is not added, true if the song is added
     */
    public boolean addSongToPlaylist() {
        if (songQueue.isEmpty()) {
            return false;
        }
        Song nextSong = songQueue.getFront();
        Playlist playlist = getPlaylistForSong(nextSong);
        
        if (playlist != null) {
            playlist.addSong(nextSong);
            songQueue.dequeue();
            return true;
        }
        return false;
    }
    /**
     * Method to reject adds the next song in line to a list of 
     * rejected songs.
     */
    public void reject() { 
        if (!songQueue.isEmpty()) {
            Song rejectedSong = songQueue.dequeue();
            rejectedTracks.add(rejectedSong);
        }
    }
    /**
     * Method to return the list of rejected tracks
     * @return the list of rejected tracks
     */
    public AList<Song> getRejectedTracks() {
        return rejectedTracks;
    }
    /**
     * Method to return the array of playlists
     * @return the array of playlists in the calculator
     */
    public Playlist[] getPlaylists() {
        return playlists;
    }
    /**
     * Method to return the ArrayQueue of songs
     * @return the ArrayQueue of songs of the calculator
     */
    public ArrayQueue<Song> getQueue() {
        return songQueue;
    }
}