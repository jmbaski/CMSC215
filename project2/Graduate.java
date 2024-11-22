/**
 * Graduate class that extends Student class and stores additional Graduate-specific information
 * @author Joe Baskin
 * @version 1.0
 */
public class Graduate extends Student {
    /** String value for Type of Degree (Masters or Doctorate). */
    private final String degreeType;

    /**
     * Constructor that creates a Graduate object with Name, Credit Hours, Quality Points, and Degree Type with Student superclass.
     * @param name String value of Student's Name
     * @param creditHours Integer value of Student's earned Credit Hours
     * @param qualityPoints Integer value of Student's earned Quality Points
     * @param degreeType String value of Student's degree type
     */
    public Graduate(String name, int creditHours, int qualityPoints, String degreeType) {
        // Superclass call to create inherited variables from Student class.
        super(name, creditHours, qualityPoints);
        this.degreeType = degreeType;
    }

    /**
     * Overrides Student class method, adds requirement of a Master's degree for Honor Society eligibility.
     * @return Returns 1 if Degree Type is a Masters, 0 otherwise
     */
    @Override
    public int eligibleForHonorSociety() {
        // Method call super.eligibleForHonorSociety() uses Student class method to check GPA against the GPA Threshold
        //     and adds a requirement that the student must be seeking a Master's Degree to be eligible.
        //     Returns an integer value of 1 back to the main caller if the student meets both requirements.
        //     Returns an integer value of 0 otherwise.
        if (this.degreeType.equalsIgnoreCase("masters") &&
                super.eligibleForHonorSociety() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Overrides Student class method, adds the Degree type being pursued.
     * @return Returns String value of Student's Name, GPA, and Degree Type (Masters or Doctorate)
     */
    @Override
    public String toString() {
        // Calls Student class method toString() and appends degree type to the end.
        return super.toString() + " " + this.degreeType.toUpperCase();
    }
}
