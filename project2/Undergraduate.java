/**
 * Undergraduate class that extends Student class and stores additional Undergraduate specific information
 * @author Joe Baskin
 * @version 1.0
 */
public class Undergraduate extends Student {
    /** String value for year of school (Senior, Junior, Sophomore, or Freshman) */
    private final String schoolYear;

    /**
     * Creates an Undergraduate object with Student object superclass.
     * @param name String value for Student's Name
     * @param creditHours Integer value for earned Credit Hours
     * @param qualityPoints Integer value for earned Quality Points
     * @param schoolYear String value for year of school.
     */
    public Undergraduate(String name, int creditHours, int qualityPoints, String schoolYear) {
        // Superclass call to create inherited variables from Student class.
        super(name, creditHours, qualityPoints);
        this.schoolYear = schoolYear;
    }

    /**
     * Overrides Student method, adds condition that student must be in final 2 years of school for eligibility.
     * @return Returns 1 if eligible for Honor Society, 0 otherwise.
     */
    @Override
    public int eligibleForHonorSociety() {
        // Method call super.eligibleForHonorSociety() uses Student class method to check GPA against the GPA Threshold
        //     and adds a requirement that the student must be in their Junior or Senior year of school to be eligible.
        //     Returns an integer value of 1 back to the main caller if the student meets both requirements.
        //     Returns an integer value of 0 otherwise.
        if ((this.schoolYear.equalsIgnoreCase("junior") ||
                this.schoolYear.equalsIgnoreCase("senior")) &&
                super.eligibleForHonorSociety() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Overrides Student method, adds year of school student is currently in.
     * @return Returns String value with Name, GPA, and Year of School.
     */
    @Override
    public String toString() {
        // Calls Student class method toString and appends year of school to the end.
        return super.toString() + " " + this.schoolYear.toUpperCase();
    }
}
