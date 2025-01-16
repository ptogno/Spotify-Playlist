// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 *  ProjectRunner class which runs the total program
 * 
 *  @author togno
 *  @version Nov 11, 2024
 */
public class ProjectRunner
{
    /**
     * Create a new ProjectRunner object.
     */
    public ProjectRunner() {
        
    }
    /**
     * Place a description of your method here.
     * @param args command line
     * @throws ParseException
     * @throws DailyMixDataException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws ParseException, 
    DailyMixDataException, FileNotFoundException {
        if (args.length == 2) {
            String songFileName = args[0];
            String playlistsFileName = args[1];
            new PlaylistReader(songFileName, playlistsFileName);
        } else {
            new PlaylistReader("Project4InputFiles/"+"input.txt", "Project4InputFiles/"+"playlists.txt");
        }
    }
}
