/** Custom Generic Class to store two objects of E type
 * @author Joe Baskin
 * @version 2.0
 * @param <E> Generic object
 */

class Interval<E extends Comparable<E>> {
    // Generic type E start and end storage
    private E start;
    private E end;

    /** Generic constructor for Interval class.
     * @param start E object
     * @param end E object
     */
    public Interval(E start, E end) {
        this.start = start;
        this.end = end;
    }

    /** Method to get stored object start
     * @return Stored object start
     */
    public E getStart() { return this.start; }

    /** Method to get stored object end
     * @return Stored object end
     */
    public E getEnd() { return this.end; }

    /** Compares E object against stored objects start and end
     * @param o Generic object of type E
     * @return True or False if comparisons are greater than and less than 0 for start and end
     */
    public boolean within(E o) {
        // Call compareTo() method in Time class, where o is the time object to be checked against stored
        // start and end values.  Will return true if o.compareTo(this.start) > 0 and o.compareTo(this.end) < 0
        return o.compareTo(this.start) >= 0 && o.compareTo(this.end) <= 0;
    }

    /** Checks if Interval o is within calling Interval
     * @param o Generic Interval object of type E
     * @return True or False
     */
    public boolean subinterval(Interval<E> o) {
        return this.start.compareTo(o.start) >= 0 && this.end.compareTo(o.end) <= 0;
    }

    /** Checks if Interval o overlaps with calling Interval
     * @param o Generic Interval object of type E
     * @return True or False
     */
    public boolean overlaps(Interval<E> o) {
        return this.start.compareTo(o.end) <= 0 && this.end.compareTo(o.start) >= 0;
    }
}