// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- ptogno
package dailymixes;

/**
 *  Class which handles three ints for genre percent composition,
 *  on a scale of 0 to 100
 * 
 *  @author togno
 *  @version Nov 2, 2024
 */
public class GenreSet implements Comparable<GenreSet> {
    private int pop;
    private int rock;
    private int country;
    
    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * @param pop integer to represent pop
     * @param rock integer to represent rock
     * @param country integer to represent country
     */
    public GenreSet(int pop, int rock, int country) {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }
    /**
     * Comparison of two GenreSet objects, checking if a song's genreset
     * is accepted based on playlist's required genreset range.
     * 
     * @return true if song is acceptable based on required genreset range
     *         false if song does not meet genreset requirements
     */
    private boolean isLessThanOrEqualTo(GenreSet other) {
        return this.pop <= other.pop && this.rock <= other.rock &&
            this.country <= other.country ;
    }
    /**
     * GenreSet object within a range of minimum genre set and maximum 
     * genre set
     * @param minGenreSet minimum genre set parameters
     * @param maxGenreSet maximum genre set parameters
     * @return true if genreset is within range, false if not
     */
    public boolean isWithinRange(GenreSet minGenreSet, 
        GenreSet maxGenreSet) {
        
        return this.isLessThanOrEqualTo(maxGenreSet) && 
            minGenreSet.isLessThanOrEqualTo(this);
    }
    /**
     * Method to return rock parameter integer for genre set
     * @return rock integer for genre set
     */
    public int getRock() {
        return rock;
    }
    /**
     * Method to return pop parameter integer for genre set
     * @return pop integer for genre set
     */
    public int getPop() {
        return pop;
    }
    /**
     * Method to return country parameter integer for genre set
     * @return country integer for genre set
     */
    public int getCountry() {
        return country;
    }
    /**
     * Method to check if two GenreSet objects are equals
     * 
     * @param obj to compare to
     * 
     * @return boolean if two GenreSet objects are equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GenreSet genreSet = (GenreSet) obj;
        return this.pop == genreSet.pop && this.rock == genreSet.rock &&
            this.country == genreSet.country;
    }
    /**
     * Method which compares the sum of two genre set's sums of genre
     * percent composition
     * 
     * @return positive number (1) if thisSum is greater, negative 
     * number (-1) if otherSum is greater than thisSum, and zero if
     * the two sums are equal
     */
    @Override
    public int compareTo(GenreSet other) {
        int thisSum = this.pop + this.rock + this.country;
        int otherSum = other.pop + other.rock + other.country;
        if (thisSum > otherSum) {
            return 1;
        }
        if (otherSum > thisSum) {
            return -1;
        }
        return 0;
    }
    /**
     * Creates a string representation for the genreSet
     * 
     * @return String representation denoting the rock, pop and county
     * elements of the GenreSet
     */
    public String toString() {
        return "Pop:" + pop + " " + "Rock:" + rock 
            + " " + "Country:" + country; 
    }
}