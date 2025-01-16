// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;
/**
 *  Exception thrown if data is incorrect in the input files
 * 
 *  @author togno
 *  @version Nov 7, 2024
 */
public class DailyMixDataException extends Exception {
    /**
     * Create a new DailyMixDataException object.
     * @param string string message
     */
    DailyMixDataException(String string) {
        super(string);
    }
}