// import required classes
import java.util.Scanner;

/**
 * @author Joe Baskin
 * @version 1.0
 */
public class Exercise18_17 {
    /** Helper method for counting letters in a string
     * @param chars Character array
     * @param ch Character to search for
     * @return Returns character occurrence to main()
     */
    public static int count(char[] chars, char ch) {
	// Call method count, pass chars[], character, and length
        return count(chars, ch, chars.length - 1);
    }

    /** Recursive method for counting characters in a string
     * @param chars Character array to search
     * @param ch Character to search for in string
     * @param high Length of character array
     * @return Return 0 if length is less than 0, else return character count
     */
    private static int count(char[] chars, char ch, int high) {
	// Return 0 if character array length is less than 0.
        if (high < 0) {
            return 0;
        } else {
	// Recursively call count, with character less - 1, and add to current count if
    // character found in recursive search.
            return count(chars, ch, high - 1) + (chars[high] == ch ? 1 : 0);
        }
    }
    
    /** Main program, collects String and Character
     * @param args String Array, not used or required.
     */
    public static void main(String[] args) {
        // Declare Scanner input
        Scanner input = new Scanner(System.in);
 
        // Prompt user for String to be searched
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        char[] chars = s.toCharArray();

        // Prompt user for Character to search for
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);
        input.close();

	// Output number of times ch appears in the string.
        System.out.println(ch + " appears "  + count(chars, ch) + " times");
    }
}