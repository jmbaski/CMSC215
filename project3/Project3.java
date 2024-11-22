import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * GUI interface that calculates the cost of a road trip.
 * @author Joe Baskin
 * @version 1.0
 */
public class Project3 extends Application {
    // Create Textfield objects
    /** TextField for Distance in Miles or Kilometers */
    private TextField tfDistance = new TextField();
    /** TextField for Gasoline price in Dollars per Gallon or Dollars per Liter */
    private TextField tfGasolineCost = new TextField();
    /** TextField for Gas Mileage in Miles per Gallon or Kilometers per Liter */
    private TextField tfGasMileage = new TextField();
    /** TextField for Number of Days for the trip */
    private TextField tfNumberOfDays = new TextField();
    /** TextField for Hotel Costs per day */
    private TextField tfHotelCost = new TextField();
    /** TextField for Food Costs per day */
    private TextField tfFoodCost = new TextField();
    /** TextField for price of Attractions */
    private TextField tfAttractions = new TextField();
    /** TextField for Total Trip Cost (Output Only) */
    private TextField tfTotalTripCost = new TextField();

    // Create Button objects
    /** Button for calling calculateTripCost method */
    private Button btnCalculate = new Button("Calculate");

    // Create ComboBox objects
    /** ComboBox for Distance Units (Miles or Kilometers) */
    private ComboBox<String> cbMiles = new ComboBox<>();
    /** ComboBox for Gasoline Costs Units */
    private ComboBox<String> cbGasCost = new ComboBox<>();
    /** ComboBox for Gas Mileage Units */
    private ComboBox<String> cbMileage = new ComboBox<>();

    /**
     * Builds the GUI Interface for the Trip Cost Estimator
     * @param primaryStage Primary Stage for GUI Interface
     */
    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Fill ComboBox items with required values and set the default to Imperial measurements.
        cbMiles.getItems().addAll("miles", "kilometers");
        cbMiles.setValue("miles");
        cbGasCost.getItems().addAll("dollars/gal", "dollars/liter");
        cbGasCost.setValue("dollars/gal");
        cbMileage.getItems().addAll("miles/gallon", "kms/liter");
        cbMileage.setValue("miles/gallon");

        // Stretch Button to match TextField width.
        btnCalculate.setPrefWidth(150);

        // Create UI using GridPane, add elements needed
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Distance:"), 0, 0);
        gridPane.add(tfDistance, 1, 0);
        gridPane.add(cbMiles, 2, 0);
        gridPane.add(new Label("Gasoline Cost:"), 0, 1);
        gridPane.add(tfGasolineCost, 1, 1);
        gridPane.add(cbGasCost, 2, 1);
        gridPane.add(new Label("Gas Mileage"), 0, 2);
        gridPane.add(tfGasMileage, 1, 2);
        gridPane.add(cbMileage, 2, 2);
        gridPane.add(new Label("Number Of Days:"), 0, 3);
        gridPane.add(tfNumberOfDays, 1, 3);
        gridPane.add(new Label("Hotel Cost"), 0, 4);
        gridPane.add(tfHotelCost, 1, 4);
        gridPane.add(new Label("Food Cost"), 0, 5);
        gridPane.add(tfFoodCost, 1, 5);
        gridPane.add(new Label("Attractions"), 0, 6);
        gridPane.add(tfAttractions, 1, 6);
        gridPane.add(btnCalculate, 1, 7);
        gridPane.add(new Label("Total Trip Cost"), 0, 8);
        gridPane.add(tfTotalTripCost, 1, 8);

        //Set Properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfDistance.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasolineCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasMileage.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfDays.setAlignment(Pos.BOTTOM_RIGHT);
        tfHotelCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfFoodCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfAttractions.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalTripCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalTripCost.setEditable(false);
        GridPane.setHalignment(btnCalculate, HPos.RIGHT);

        // Create and Register ActionEvent Listener for Button
        btnCalculate.setOnAction(e -> calculateTripCost());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 425, 300);
        primaryStage.setTitle("Trip Cost Estimator"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Performs TripCost object creation and handles calculations for program.
     */
    private void calculateTripCost() {
        // Parse each TextField input and assign to variables
        double distance = Double.parseDouble(tfDistance.getText());
        String distanceUnit = cbMiles.getValue();
        double gasCost = Double.parseDouble(tfGasolineCost.getText());
        String gasCostUnit = cbGasCost.getValue();
        double gasMileage = Double.parseDouble(tfGasMileage.getText());
        String gasMileageUnit = cbMileage.getValue();
        int numberOfDays = Integer.parseInt(tfNumberOfDays.getText());
        double hotelCost = Double.parseDouble(tfHotelCost.getText());
        double foodCost = Double.parseDouble(tfFoodCost.getText());
        double attractions = Double.parseDouble(tfAttractions.getText());

        // Create TripCost object with input values.
        TripCost trip = new TripCost(distance, distanceUnit, gasCost, gasCostUnit, gasMileage, gasMileageUnit,
                numberOfDays, hotelCost, foodCost, attractions);

        // Fill output TextField with the output from getTotalTripCost() method.
        tfTotalTripCost.setText(String.format("$%.2f", trip.getTotalTripCost()));
    }
}
