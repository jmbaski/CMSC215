import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** Project4 checks overlapping time intervals via a GUI
 * @author Joe Baskin
 * @version 1.0
 */

public class Project4 extends Application {
    // Declare buttons and textfields used throughout GUI.
    Button btnCompareInts, btnCheckTime;
    TextField tfStart1, tfStart2, tfEnd1, tfEnd2, tfCheck, tfOutput;

    /** Method to compare two intervals of type Time
     * @param i1 First Interval of type Time
     * @param i2 Second Interval of type Time
     * @return String message based on output of comparisons
     */
    public String getCompareIntervals(Interval<Time> i1, Interval<Time> i2) {
        String message;

        if (i1.subinterval(i2)) { message = "Interval 1 is a sub-interval of interval 2."; }
        else if (i2.subinterval(i1)) { message = "Interval 2 is a sub-interval of interval 1."; }
        else if (i1.overlaps(i2)) { message = "The intervals overlap"; }
        else { message = "The intervals are disjoint"; }

        return message;
    }

    /** Method to check if Time object is in Intervals of type Time
     * @param i1 First interval of type Time
     * @param i2 Second interval of type Time
     * @param t Time object to be checked
     * @return String message based on comparisons
     */
    public String getTimeCheck(Interval<Time> i1, Interval<Time> i2, Time t) {
        String message;

        if (i1.within(t) && i2.within(t)) { message = "Both intervals contain the time " + t.toString(); }
        else if (i1.within(t) && !i2.within(t)) { message = "Interval 1 contains the time " + t.toString(); }
        else if (!i1.within(t) && i2.within(t)) { message = "Interval 2 contains the time " + t.toString(); }
        else { message = "Neither intervals contain the time " + t.toString(); }

        return message;
    }

    /** Main method for GUI
     * @param primaryStage Required Stage for GUI
     */
    public void start(Stage primaryStage) {
        // Call method to build GridPane for main GUI functions
        GridPane gpMain = buildGridPane();

        // Set action events for button to compare intervals.  If exception is raised, output message to output
        // textfield
        btnCompareInts.setOnAction( e -> {
            try {
                // Create Time objects of all times input in GUI textfields.
                Time startTime1 = new Time(tfStart1.getText());
                Time startTime2 = new Time(tfStart2.getText());
                Time endTime1 = new Time(tfEnd1.getText());
                Time endTime2 = new Time(tfEnd2.getText());

                // Create Interval objects of type Time with Time objects
                Interval<Time> i1 = new Interval<>(startTime1, endTime1);
                Interval<Time> i2 = new Interval<>(startTime2, endTime2);

                // Call method to compare intervals
                String intervalMessage = getCompareIntervals(i1, i2);
                tfOutput.setText(intervalMessage);
            } catch (InvalidTime it) {
                tfOutput.setText(it.getMessage());
            }
        });

        // Set action event for button to check time.  If exception is raised, output message to output textfield
        btnCheckTime.setOnAction( e -> {
            try {
                // Create Time objects of all times input in GUI textfields
                Time startTime1 = new Time(tfStart1.getText());
                Time startTime2 = new Time(tfStart2.getText());
                Time endTime1 = new Time(tfEnd1.getText());
                Time endTime2 = new Time(tfEnd2.getText());

                // Create Interval objects of type Time with Time objects
                Interval<Time> i1 = new Interval<>(startTime1, endTime1);
                Interval<Time> i2 = new Interval<>(startTime2, endTime2);

                // Create Time object for time to be checked
                Time checkTime = new Time(tfCheck.getText());

                // Call method to check time against intervals.
                String checkMessage = getTimeCheck(i1, i2, checkTime);
                tfOutput.setText(checkMessage);
            } catch (InvalidTime it) {
                tfOutput.setText(it.getMessage());
            }
        });

        // Set Scene, add everything to Stage and show Stage.
        Scene scene = new Scene(gpMain, 550, 250);
        primaryStage.setTitle("Time Interval Checker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Build GridPane
     * @return GridPane gpMain with all nodes and labels
     */
    public GridPane buildGridPane() {
        GridPane gpMain = new GridPane();

        // Build all labels needed for UI
        Label lblStartTime, lblEndTime, lblTimeInt1, lblTimeInt2, lblTimeCheck;
        lblStartTime = new Label("Start Time");
        lblEndTime = new Label("End Time");
        lblTimeInt1 = new Label("Time Interval 1");
        lblTimeInt2 = new Label("Time Interval 2");
        lblTimeCheck = new Label("Time to Check");

        // Build buttons needed for UI, and set width to match columns.
        btnCompareInts = new Button("Compare Intervals");
        btnCompareInts.setMinWidth(510);
        btnCheckTime = new Button("Check Time");
        btnCheckTime.setMinWidth(510);

        // Build all textfields.  Set center alignment on the time textfields and
        //     set initial text to "HH:MM AM/PM" to show user required input style.
        //     This will help the user better understand what the program requires to
        //     run properly.
        tfStart1 = new TextField();
        tfStart1.setAlignment(Pos.CENTER);
        tfStart1.setStyle("-fx-text-fill: gray");
        tfStart1.setText("HH:MM AM/PM");
        tfStart1.setOnMouseClicked(e -> {
            if (tfStart1.getText().equals("HH:MM AM/PM")) {
                tfStart1.setText("");
            }
            tfStart1.setStyle("-fx-text-fill: black");
        });

        tfStart2 = new TextField();
        tfStart2.setAlignment(Pos.CENTER);
        tfStart2.setStyle("-fx-text-fill: gray");
        tfStart2.setText("HH:MM AM/PM");
        tfStart2.setOnMouseClicked(e -> {
            if (tfStart2.getText().equals("HH:MM AM/PM")) {
                tfStart2.setText("");
            }
            tfStart2.setStyle("-fx-text-fill: black");
        });

        tfEnd1 = new TextField();
        tfEnd1.setAlignment(Pos.CENTER);
        tfEnd1.setStyle("-fx-text-fill: gray");
        tfEnd1.setText("HH:MM AM/PM");
        tfEnd1.setOnMouseClicked(e -> {
            if (tfEnd1.getText().equals("HH:MM AM/PM")) {
                tfEnd1.setText("");
            }
            tfEnd1.setStyle("-fx-text-fill: black");
        });

        tfEnd2 = new TextField();
        tfEnd2.setAlignment(Pos.CENTER);
        tfEnd2.setStyle("-fx-text-fill: gray");
        tfEnd2.setText("HH:MM AM/PM");
        tfEnd2.setOnMouseClicked(e -> {
            if (tfEnd2.getText().equals("HH:MM AM/PM")) {
                tfEnd2.setText("");
            }
            tfEnd2.setStyle("-fx-text-fill: black");
        });

        tfCheck = new TextField();
        tfCheck.setAlignment(Pos.CENTER);
        tfOutput = new TextField();

        // Establish Column Constraints
        ColumnConstraints col1 = new ColumnConstraints(100);
        ColumnConstraints col2 = new ColumnConstraints(200);
        ColumnConstraints col3 = new ColumnConstraints(200);

        // Add constraints to GridPane and set Columns 2 and 3 center alignment.
        gpMain.getColumnConstraints().addAll(col1, col2, col3);
        col2.setHalignment(HPos.CENTER);
        col3.setHalignment(HPos.CENTER);

        // Set Padding around in between cells in GridPane.
        gpMain.setPadding(new Insets(20, 20, 20, 20));
        gpMain.setHgap(5);
        gpMain.setVgap(5);

        // Add everything to GridPane
        gpMain.add(lblStartTime, 1, 0);
        gpMain.add(lblEndTime, 2, 0);
        gpMain.add(lblTimeInt1, 0, 1);
        gpMain.add(tfStart1, 1, 1);
        gpMain.add(tfEnd1, 2, 1);
        gpMain.add(lblTimeInt2, 0, 2);
        gpMain.add(tfStart2, 1, 2);
        gpMain.add(tfEnd2, 2, 2);
        gpMain.add(btnCompareInts, 0, 3);
        gpMain.add(lblTimeCheck, 0, 4);
        gpMain.add(tfCheck, 1, 4, 2, 1);
        gpMain.add(btnCheckTime, 0, 5);
        gpMain.add(tfOutput, 0, 6, 3, 1);

        return gpMain;
    }
}
