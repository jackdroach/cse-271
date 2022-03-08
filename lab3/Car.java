/*
 * Author: Jack Roach
 * Date: Feb 13, 2021
 * Class: CSE 271 - E
 * File: Car.java
 * Description: Car object blueprint for the CarDriver class.
 */

/**
 * Car object blueprint for the CarDriver class.
 *
 * @author Jack Roach
 * @version Feb 13, 2021
 */
public class Car {
    // Instance properties.
    private int yearModel;
    private String make;
    private int numberOfWheels;
    private int speed;
    private double fuelLevel;

    /**
     * Increases the cars speed by 4 and decreases the cars fuel by 0.5.
     */
    public void accelerate() {
        // Verify that the car has enough fuel.
        if (fuelLevel >= 0.5) {
            // Increase speed by 4.
            speed += 4;

            // Decrease fuel by 5.0.
            fuelLevel-=0.5;

            // Keep speed at or below 200.
            if (speed > 200) {
                speed = 200;
            } // End if/else.
        } // End if/else.
    } // End method accelerate.

    /**
     * Decreases the cars speed by 3.
     */
    public void brake() {
        // Decrease speed by 3.
        speed -= 3;

        // Keep speed at or above 0.
        if (speed < 0) {
            speed = 0;
        } // End if/else.
    } // End method brake.

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        // Verify that the object is a car.
        if (!(object instanceof Car)) {
            return false;
        } // End if/else.

        Car car = (Car) object;
        return car.yearModel == yearModel &&
                car.make.equals(make) &&
                car.numberOfWheels == numberOfWheels &&
                car.speed == speed &&
                car.fuelLevel == fuelLevel;
    } // End method equals.

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Make: %s, Year: %d, Wheels: %d, Speed: %d, " +
            "Fuel Level: %.1f", make, yearModel, numberOfWheels, speed,
            fuelLevel);
    } // End method toString.

    /**
     * Gets the year model of the car as an int.
     * @return the car year model.
     */
    public int getYearModel() {
        return yearModel;
    } // End method getYearModel.

    /**
     * Sets the year model instance property.
     * @param yearModel is an int
     */
    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    } // End method setYearModel.

    /**
     * Gets the make of the car as a string.
     * @return the car make
     */
    public String getMake() {
        return make;
    } // End method getMake.

    /**
     * Sets the make instance property.
     * @param make is a string
     */
    public void setMake(String make) {
        this.make = make;
    } // End method setMake.

    /**
     * Gets the number of wheels of the car as an int.
     * @return the car make
     */
    public int getNumberOfWheels() {
        return numberOfWheels;
    } // End method getNumberOfWheels.

    /**
     * Sets the make instance property.
     * @param numberOfWheels is an int
     */
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    } // End method setNumberOfWheels.

    /**
     * Gets the speed of the car as an int.
     * @return the car speed
     */
    public int getSpeed() {
        return speed;
    } // End method getSpeed.

    /**
     * Sets the speed instance property.
     * @param speed is an int
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    } // End method setSpeed.

    /**
     * Gets the fuel level of the car as a double.
     * @return the car speed
     */
    public double getFuelLevel() {
        return fuelLevel;
    } // End method getFuelLevel.

    /**
     * Sets the fuel level instance property.
     * @param fuelLevel is a double
     */
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    } // End method setFuelLevel.

} // End class Car.