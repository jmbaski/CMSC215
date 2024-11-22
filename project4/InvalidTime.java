/** Custom Exception class to show Invalid Times
 */
public class InvalidTime extends Exception {
    /** Class storage for message as String */
    private String message;

    /**
     * Constructor requires Message
     * @param message String message for error to throw
     */
    public InvalidTime(String message) {
        this.message = message;
    }

    /** Overriden String to get Error/Exception message
     * @return Exception message
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
