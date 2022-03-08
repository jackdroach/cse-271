/**
 * Constructors for creating Cars and methods for using the Cars.
 *
 * @author Jack Roach
 * Date: Feb 20, 2022
 * Class: CSE 271 - E
 * File: Car.java
 */
public class Car {

    // Instance fields.
    private String owner;
    private String make;
    private String model;
    private int yearModel;
    private double fuelLevel;
    private int speed;
    private boolean start;

    /**
     * Empty constructor. Sets all Strings to "", yearModel to 2022, fuelLevel
     * to 1.0, speed to 0, and start to false.
     *
     */
    public Car() {
        this("", "", "", 2022, 1.0, 0, false);
    } // End constructor Car.

    /**
     * Partial constructor. Sets speed to 0, fuelLevel to 1.0 start to false.
     *
     * @param owner is a String
     * @param make is a String
     * @param model is a String
     * @param yearModel is an int
     */
    public Car(String owner, String make, String model, int yearModel) {
        this.owner = owner;
        this.make = make;
        this.model = model;
        this.yearModel = yearModel;
        fuelLevel = 1.0;
        speed = 0;
        start = false;
    } // End constructor car.

    /**
     * Partial constructor. Sets speed to 0 and start to false.
     *
     * @param owner is a String
     * @param make is a String
     * @param model is a String
     * @param yearModel is an int
     * @param fuelLevel is a double
     */
    public Car(String owner, String make, String model, int yearModel,
        double fuelLevel) {
        this.owner = owner;
        this.make = make;
        this.model = model;
        setYearModel(yearModel);
        setFuelLevel(fuelLevel);
        speed = 0;
        start = false;
    } // End constructor car.

    /**
     * Workhorse constructor that gets new values for all instance properties.
     *
     * @param owner is a String
     * @param make is a String
     * @param model is a String
     * @param yearModel is an int
     * @param fuelLevel is a double
     * @param speed is an int
     * @param start is a boolean
     */
    public Car(String owner, String make, String model, int yearModel,
        double fuelLevel, int speed, boolean start) {
        this.owner = owner;
        this.make = make;
        this.model = model;
        setYearModel(yearModel);
        setFuelLevel(fuelLevel);
        this.speed = speed;
        this.start = start;
    } // End constructor Car.

    /**
     * Copy constructor that copies the instance properties of another Car.
     *
     * @param car is a Car
     */
    public Car(Car car) {
        this(car.owner, car.make, car.model, car.yearModel, car.fuelLevel,
            car.speed, car.start);
    } // End constructor Car.

    /**
     * Increase the Cars speed by 4 and decrease the fuelLevel by 0.05.
     *
     * @return true if the Car has accelerated, false otherwise
     */
    public boolean accelerate() {
        // The Car is not accelerated. Return false.
        if (fuelLevel < 0.05 || !(isStart()) || speed >= 250) {
            return false;
        } // End if/else.

        speed += 4;

        // Keep speed less than or equal to 250.
        speed = Math.min(speed, 250);

        return true;
    } // End method accelerate.

    /**
     * Decrease the Cars speed by 3.
     *
     * @return true if the Car has braked, false otherwise
     */
    public boolean brake() {
        // The Car is not braked. Return false.
        if (speed == 0) {
            return false;
        } // End if/else.

        speed =- 3;

        // Keep speed greater than or equal to 0.
        speed = Math.max(speed, 0);

        return true;
    } // End method brake.

    /**
     * Checks if the Cars gas tank is full.
     *
     * @return true if gas tank is less than or equal to 0.05, otherwise false.
     */
    public boolean isGasTankEmpty() {
        return fuelLevel <= 0.05;
    } // End method isGasTankEmpty.

    /**
     * Check if two Cars have the same owner instance property.
     *
     * @param car is a Car
     * @return true if the owner is equal, otherwise false
     */
    public boolean sameOwner(Car car) {
        return this.owner.equals(car.owner);
    } // End method sameOwner.

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        // Check that the object entered is a Car.
        if (!(object instanceof Car)) {
            return false;
        }

        // Return equality of all instance properties.
        Car car = (Car) object;
        return car.owner.equals(owner) && car.make.equals(make)
            && car.model.equals(model) && car.yearModel == yearModel
            && car.fuelLevel == fuelLevel && car.speed == speed
            && car.start == start;
    } // End method equals.

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Owner: %s, Make: %s, Model: %s, Year: %d, Speed: "
            + "%d, Fuel Level: %.2f", owner, make, model, yearModel, speed,
            fuelLevel);
    } // End method toString.

    /**
     * Returns the yearModel instance property.
     *
     * @return yearModel as an int.
     */
    public int getYearModel() {
        return yearModel;
    }

    /**
     * Sets the yearModel instance property.
     *
     * @param yearModel is an int
     */
    public void setYearModel(int yearModel) {
        // Check for a yearModel 1855-2022.
        if (yearModel <= 2022 && yearModel >= 1855) {
            this.yearModel = yearModel;
        } else {
            throw new IllegalArgumentException("Invalid year model.");
        } // End if/else.
    } // End method setYearModel.

    /**
     * Returns the make instance property.
     *
     * @return make as a String
     */
    public String getMake() {
        return make;
    } // End method getMake.

    /**
     * Sets the make instance property.
     *
     * @param make is a String
     */
    public void setMake(String make) {
        this.make = make;
    } // End method setMake.

    /**
     * Returns the model instance property.
     *
     * @return model as a String
     */
    public String getModel() {
        return model;
    } // End method getModel.

    /**
     * Sets the model instance property.
     *
     * @param model is a String
     */
    public void setModel(String model) {
        this.model = model;
    } // End method setModel.

    /**
     * Returns the owner instance property.
     *
     * @return owner as a String
     */
    public String getOwner() {
        return owner;
    } // End method getOwner.

    /**
     * Sets the owner instance property.
     *
     * @param owner is a String
     */
    public void setOwner(String owner) {
        this.owner = owner;
    } // End method setOwner.

    /**
     * Returns the speed instance property.
     *
     * @return speed as an int
     */
    public int getSpeed() {
        return speed;
    } // End method getSpeed.

    /**
     * Sets the speed instance property.
     *
     * @param speed is an int
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    } // End method setSpeed.

    /**
     * Returns the fuelLevel instance property.
     *
     * @return fuelLevel as a double.
     */
    public double getFuelLevel() {
        return fuelLevel;
    } // End method getFuelLevel.

    /**
     * Sets the fuelLevel instance property.
     *
     * @param fuelLevel is a double
     */
    public void setFuelLevel(double fuelLevel) {
        // Check for a fuelLevel 0 - 1.
        if (fuelLevel <= 1.0 && fuelLevel >= 0) {
            this.fuelLevel = fuelLevel;
        } else {
            // Throw an exception if the fuel level is invalid.
            throw new IllegalArgumentException("Invalid fuel level.");
        } // End if/else.
    } // End method setFuelLevel.

    /**
     * Returns the start instance property.
     *
     * @return start as a boolean
     */
    public boolean isStart() {
        return start;
    } // End method isStart.

    /**
     * Sets the start instance property.
     *
     * @param start is a boolean
     */
    public void setStart(boolean start) {
        this.start = start;
    } // End method setStart.

} // End class Car.