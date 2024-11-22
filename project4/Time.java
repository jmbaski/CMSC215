/** Custom Time class for Project4 GUI.
 * @author Joe Baskin
 * @version 2.0
 */

class Time implements Comparable<Time> {
    private int hours; // Class storage for Hours of time HH:MM xM
    private int minutes; // Class storage for Minutes of time HH:MM xM
    private String meridian; // Class storage for Meridian of time HH:MM xM

    /** Secondary Time constructor
     * @param hours Integer value to 12-hour time value
     * @param minutes Integer value to 60-minute time value
     * @param meridian String value for AM or PM
     * @throws InvalidTime Custom Exception class when exception raised
     */
    public Time(int hours, int minutes, String meridian) throws InvalidTime {
        // Hours only accepted if between 0 and 12.
        // Minutes only accepted if between 0 and 59.
        if (hours < 0 || hours > 12 || minutes < 0 || minutes > 59) {
            throw new InvalidTime ("Invalid time format");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.meridian = meridian;

    }

    /** Primary Time constructor
     * @param time String value representing whole time
     * @throws InvalidTime Custom Exception class when exception raised
     */
    public Time(String time) throws InvalidTime {
        // Split HH:MM AM on whitespace.  If Length is not 2, raise exception
        String[] parts = time.split(" ");
        if (parts.length != 2) { throw new InvalidTime ("Invalid time format"); }

        // Split HH:MM on colon.  If Length is not 2, raise exception
        String[] timeParts = parts[0].split(":");
        if (timeParts.length != 2) { throw new InvalidTime ("Invalid time format"); }

        // Store Hour, Minute, and Meridian of input String
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        String meridian = parts[1];

        // Check if Hour value not between 0 and 12, and minute value not between 0 and 59.
        if (hours < 0 || hours > 12 || minutes < 0 || minutes > 59) {
            throw new InvalidTime ("Invalid time format");
        }

        // Convert hours to 24-hour time based on Meridian.  Store 24-hour time, minutes,
        // and meridian in class variables.
        if (meridian.equals("AM")) {
            if (hours == 12) {
                this.hours = 0;
            } else {
                this.hours = hours;
            }
            this.minutes = minutes;
            this.meridian = meridian;
        } else if (meridian.equals("PM")) {
            if (hours < 12) {
                this.hours = hours + 12;
            } else {
                this.hours = hours;
            }

            this.minutes = minutes;
            this.meridian = meridian;
        } else {
            throw new InvalidTime ("Invalid Meridian");
        }
    }

    /** Method to get stored Hours value
     * @return Integer value for hours, based on 12-hour time
     */
    // Convert 24-hour time back to 12-hour time.
    public int getHours() {
        if (this.hours == 0) {
            return this.hours + 12;
        } else if (this.hours == 12) {
            return this.hours;
        } else {
            return this.hours % 12;
        }
    }

    /** Method to get stored Minutes value
     * @return Integer value for minutes
     */
    public int getMinutes() { return this.minutes; }

    /** Method to get stored Meridian value
     * @return String value for Meridian
     */
    public String getMeridian() { return this.meridian; }

    /** Method to compare Time object to stored values
     * @param o the object to be compared.
     * @return Result of comparisons
     */
    public int compareTo(Time o) {
        if ( meridian.compareTo(o.meridian) >= 0 && hours != o.hours) { return Integer.compare(hours, o.hours); }
        else if ( meridian.compareTo(o.meridian) < 0 && hours != o.hours) { return Integer.compare(o.hours, hours); }

        if (meridian.compareTo(o.meridian) >= 0 && minutes != o.minutes) { return Integer.compare(minutes, o.minutes); }
        else if (meridian.compareTo(o.meridian) < 0 && minutes != o.minutes){ return Integer.compare(o.minutes, minutes); }

        return meridian.compareTo(o.meridian);
    }

    /** Overriding Method to retrieve full stored Time value
     * @return Formatted string value of Time object
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d %s", getHours(), getMinutes(), getMeridian().toUpperCase());
    }
}
