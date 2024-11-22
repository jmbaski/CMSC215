/**
 * Stores TripCost class variables and methods.
 * @author Joe Baskin
 * @version 1.0
 */
public class TripCost {
    /** Instance Variable for Distance as Double */
    private double distance;
    /** Instance Variable for Distance Units as String */
    private String distanceUnit;
    /** Instance Variable for Gasoline Price as Double */
    private double gasPrice;
    /** Instance Variable for Gasoline Price Units as String */
    private String gasPriceUnit;
    /** Instance Variable for Gas Mileage as Double */
    private double gasMileage;
    /** Instance Variable for Gas Mileage Units as String */
    private String gasMileageUnit;
    /** Instance Variable for Number of Days as Integer */
    private int numberOfDays;
    /** Instance Variable for Hotel Costs as Double */
    private double hotelCost;
    /** Instance Variable for Food Costs as Double */
    private double foodCost;
    /** Instance Variable for Attractions Costs as Double */
    private double attractions;

    /** No-arg constructor for TripCost object */
    public TripCost() {
        this(1, "miles", 1.00, "dollars/gal", 12.5,
                "miles/gallon", 1, 1.00, 0.00, 0.00);
    }

    /**
     * Constructor for TripCost objects
     * @param distance Distance travelled
     * @param distanceUnit Distance Units
     * @param gasPrice Gasoline Price
     * @param gasPriceUnit Gasoline Price Units
     * @param gasMileage Gas Mileage
     * @param gasMileageUnit Gas Mileage Units
     * @param numberOfDays Number of Days
     * @param hotelCost Hotel Costs per day
     * @param foodCost Food Costs per day
     * @param attractions Attractions costs
     */
    public TripCost(double distance, String distanceUnit, double gasPrice, String gasPriceUnit, double gasMileage,
                    String gasMileageUnit, int numberOfDays, double hotelCost, double foodCost, double attractions) {
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.gasPrice = gasPrice;
        this.gasPriceUnit = gasPriceUnit;
        this.gasMileage = gasMileage;
        this.gasMileageUnit = gasMileageUnit;
        this.numberOfDays = numberOfDays;
        this.hotelCost = hotelCost;
        this.foodCost = foodCost;
        this.attractions = attractions;
    }

    // Getter methods
    /** @return Returns stored DistanceUnit */
    public String getDistanceUnit() { return this.distanceUnit; }
    /** @return Returns stored GasPriceUnit*/
    public String getGasPriceUnit() { return this.gasPriceUnit; }
    /** @return Returns stored Gas MileageUnit*/
    public String getGasMileageUnit() { return this.gasMileageUnit; }
    /** @return Returns stored distance value */
    public double getDistance() { return this.distance; }
    /** @return Returns stored Gas Price value */
    public double getGasPrice() { return this.gasPrice; }
    /** @return Returns stored Gas Mileage value */
    public double getGasMileage() { return this.gasMileage; }
    /** @return Returns stored Number of Days value */
    public int getNumberOfDays() { return this.numberOfDays; }
    /** @return Returns stored Hotel Cost value */
    public double getHotelCost() { return this.hotelCost; }
    /** @return Returns stored Food Cost value */
    public double getFoodCost() { return this.foodCost; }
    /** @return Returns stored Attractions cost value */
    public double getAttractions() { return this.attractions; }

    /**
     * Method to calculate the total Gasoline Cost
     * @return Returns Gasoline Cost as Double
     */
    public double getGasolineCost() {
        double KILOMETERS_PER_HOUR = 1.609347;
        double LITERS_PER_GALLON = 3.78541178;

        double distance = getDistance();
        double gasPrice = getGasPrice();
        double gasMileage = getGasMileage();

        // Based on the ComboBox selection, perform calculations to convert from one unit to the other, getting the
        //     correct value and adding to the total.
        switch (getDistanceUnit()) {
            case "miles":
                if (getGasMileageUnit().equals("kms/liter")) {
                    gasMileage = gasMileage / (KILOMETERS_PER_HOUR * LITERS_PER_GALLON);
                }

                if ( getGasPriceUnit().equals("dollars/liter")) {
                    gasPrice = gasPrice * (1 / LITERS_PER_GALLON);
                }
                break;
            case "kilometers":
                if (getGasMileageUnit().equals("miles/gallon")) {
                    gasMileage = gasMileage * KILOMETERS_PER_HOUR;
                }

                if ( getGasPriceUnit().equals("dollars/gal")) {
                    gasPrice = gasPrice / LITERS_PER_GALLON;
                }
                break;
        }

        return (distance / gasMileage) * gasPrice;
    }

    /**
     * Method to calculate total trip cost
     * @return Returns Total Trip Cost as Double
     */
    public double getTotalTripCost() {
        return (getGasolineCost() + ((getHotelCost() + getFoodCost()) * getNumberOfDays()) + getAttractions());
    }
}
