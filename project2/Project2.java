import java.util.*;
import java.io.*;

// All javadocs for this project were built with the following command-line:
//     javadoc -d api -private -author -version *.java
/**
 * Project2 for CMSC215 - Intermediate Programming at UMGC, Spring 2024 session.
 * @author Joe Baskin
 * @version 2.0
 */
public class Project2 {
    /**
     * Method used to build an Undergraduate object for use in Main
     * @param inputs Accepts String Array to create Undergraduate object
     * @return Returns Undergraduate object
     */
    // Method that returns a new Undergraduate object with a Name, Credit Hours, Quality Points earned, and
    //     the year of school the student is in (Senior, Junior, Sophomore, or Freshman).
    public static Undergraduate buildUndergrad(String[] inputs) {
        return new Undergraduate(inputs[0], Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), inputs[3]);
    }

    /**
     * Method used to build a Graduate object for use in Main
     * @param inputs Accepts String Array to create Graduate object
     * @return Returns Graduate object
     */
    // Method that returns a new Graduate object with a Name, Credit Hours, Quality points earned, and
    //    the type of Graduate degree being pursued (Master's or Doctorate's).
    public static Graduate buildGrad(String[] inputs) {
        return new Graduate(inputs[0], Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), inputs[3]);
    }

    /**
     * Main method handles all file opening and reading, processes data and outputs selected data.
     * @param args Command-line arguments (not used).
     * @throws FileNotFoundException if File is not Found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Create file object with file students.txt
        File studentFile = new File("students.txt");
        // Create ArrayList to hold Students of all classes.
        ArrayList<Student> students = new ArrayList<>();

        //Check if file students.txt exists.  If it doesn't, throw new FileNotFoundException, alerting user
        //  that the file wasn't found.
        if (studentFile.exists()) {
            //Try reading data from students.txt in through Scanner utility.
            try (Scanner reader = new Scanner(studentFile)) {
                while (reader.hasNext()) {
                    // Parse file for each line, splitting line on whitespace, creating 4 items in String Array.
                    // For example: if the nextLine is Baskin,Joe 29 106 Sophomore
                    // then String[] tmp = {"Baskin,Joe", 29, 106, "Sophomore"}
                    // and tmp[0] = "Baskin,Joe"
                    //     tmp[1] = 29
                    //     tmp[2] = 106
                    //     tmp[3] = "Sophomore"
                    String[] tmp = reader.nextLine().split(" ");

                    // Call method to build Graduate student if tmp[3] is Master's or Doctorate.
                    if (tmp[3].equalsIgnoreCase("masters") || tmp[3].equalsIgnoreCase("doctorate")) {
                        students.add(buildGrad(tmp));
                    } else {
                        students.add(buildUndergrad(tmp));
                    }
                }

                // Sum all GPAs for both graduate and undergraduate students.  For each one, increase the number of
                //     GPAs added.
                double sumOfAllGPAs = 0.0;
                int numberOfGPAs = 0;
                for (Student student : students) {
                    sumOfAllGPAs += student.getGPA();
                    numberOfGPAs++;
                }

                double midpointGPA = Student.setGpaThreshold(sumOfAllGPAs, numberOfGPAs);
                System.out.println("GPA threshold for membership is " + midpointGPA);
                System.out.println();
                System.out.println("Student(s) eligible for Honor Society:");

                // Iterating i through ArrayList students and ArrayList method get(i) allows for each subclass'
                //     method eligibleForHonorSociety() to be called as the for loop gets to that subclass of Student.
                //     For example:  students.get(0) is an Undergraduate object that needs to be a Junior or Senior
                //               and students.get(1) is a Graduate object that needs to be pursuing a Masters
                for (int i = 0; i <= students.size() - 1; i++) {
                    if (students.get(i).eligibleForHonorSociety() == 1) {
                        System.out.println(students.get(i).toString());
                    }
                }
            } catch (FileNotFoundException fnf) {
                fnf.getLocalizedMessage();
            }
        } else {
            System.out.println("File Not Found");
            throw new FileNotFoundException("student.txt (The system cannot find the file specified)");
        }
    }
}
