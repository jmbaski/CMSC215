/**
 * Student class representing a student, stores Name, Credit Hours, Quality Points, GPA, and GPA Threshold.
 * @author Joe Baskin
 * @version 2.0
 */
public class Student {
    /** String for Student's Name. */
    private String studentName;
    /** Integer for Student's earned Credit Hours */
    private int creditHours;
    /** Integer for Student's earned Quality Points. */
    private int qualityPoints;
    /** Double for Student's GPA. */
    private double gpa;
    /** Static Double for GPA Threshold */
    private static double gpaThreshold;

    /**
     * No-arg constructor for a Student object.
     */
    // No-arg constructor that was required to be present to extend Undergraduate and Graduate clases.
    public Student() {}

    /**
     * Creates a Student object and stores the student's Name, Credit Hours, Quality Points, and calculates GPA.
     * @param name String Student Name
     * @param creditHours Integer Credit Hours taken
     * @param qualityPoints Integer Quality Points earned.
     */
    public Student(String name, int creditHours, int qualityPoints) {
        // Creates a student object and stores Name, Credit Hours, and Quality Points.
        //     Then calls calculateGPA to store student GPA.
        this.studentName = name;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints;
        this.gpa = calculateGPA();
    }

    /**
     * Calculates GPA: Quality Points / Credit Hours
     * @return Double representation of GPA rounded to 2 decimal places.
     */
    public double calculateGPA() {
        // Student GPA is calculated by taking the Quality Points earned and dividing by the amount of Credit Hours
        //     earned by the student.
        //     - Quality Points are the product of the student's grade in the class and the number of credit hours
        //       the class gives.  For example, if a student was taking a class that awarded 3 Semester hours, and
        //       the student received an A in the class, then quality points = 3 credit hours * 4 grade score = 12
        //       quality points.
        //     The below equation multiplies Quality Points by 1.0 to create a double value, and divides that
        //     by the Credit Hours, using method Math.round() * 100 / 100.0 to create a double value rounded to 2
        //     decimal numbers.
        return Math.round((this.qualityPoints * 1.0 / this.creditHours) * 100) / 100.0;
    }

    // Getter methods

    /**
     * Used to get the class instance variable for GPA.
     * @return Returns the stored value for GPA.
     */
    protected double getGPA() {
        return this.gpa;
    }
    /**
     * Checks if Student's GPA is greater than the Honor Society GPA Threshold
     * @return Returns 1 if greater than, 0 otherwise.
     */
    public int eligibleForHonorSociety() {
        if (this.gpa >= gpaThreshold) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Converts values stored in Student to one String object.
     * @return Returns String values of stored Name and GPA.
     */
    public String toString() {
        return "Name: " + this.studentName + " GPA: " + this.gpa;
    }

    /**
     * Sets the GPA Threshold for Honor Society membership.
     * @param sumOfAllGPAs Double value for GPA, rounded to 2 decimal places.
     * @param numberOfGPAs Integer value for total number of Students GPA is averaged by.
     * @return Returns the GPA Threshold rounded to 2 decimal places.
     */
    public static double setGpaThreshold(double sumOfAllGPAs, int numberOfGPAs) {
        double averageGPA = Math.round((sumOfAllGPAs / numberOfGPAs) * 100) / 100.0;
        gpaThreshold = Math.round(((averageGPA + 4.0) / 2) * 100) / 100.0;
        return gpaThreshold;
    }
}