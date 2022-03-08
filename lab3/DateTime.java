/*
 * Author: Jack Roach
 * Date: Feb 13, 2021
 * Class: CSE 271 - E
 * File: DateTime.java
 * Description: DateTime object blueprint for the DateTimeDriver class.
 */

/**
 * DateTime object blueprint for the DateTimeDriver class.
 *
 * @author Jack Roach
 * @version Feb 13, 2021
 */
public class DateTime {
    // Instance properties.
    private int second;
    private int minute;
    private int hour;
    private int day;
    private String month;
    private int year;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        // Verify that the object is a car.
        if (!(object instanceof DateTime)) {
            return false;
        } // End if/else.

        DateTime dateTime = (DateTime) object;
        return dateTime.second == second &&
                   dateTime.minute == minute &&
                   dateTime.hour == hour &&
                   dateTime.day == day &&
                   dateTime.month.equals(month) &&
                   dateTime.year == year;
    } // End method equals.

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%d:%d:%d %d %s %d", hour, minute, second, day,
            month, year);
    } // End method toString.

    /**
     * Gets the second of the date time as an int.
     * @return the car year model.
     */
    public int getSecond() {
        return second;
    } // End method getSecond.

    /**
     * Sets the second instance property.
     * @param second is an int
     */
    public void setSecond(int second) {
        this.second = second;
    } // End method setSecond.

    /**
     * Gets the minute of the date time as an int.
     * @return the car year model.
     */
    public int getMinute() {
        return minute;
    } // End method getMinute.

    /**
     * Sets the minute instance property.
     * @param minute is an int
     */
    public void setMinute(int minute) {
        this.minute = minute;
    } // End method setMinute.

    /**
     * Gets the hour of the date time as an int.
     * @return the car year model.
     */
    public int getHour() {
        return hour;
    } // End method getHour.

    /**
     * Sets the hour instance property.
     * @param hour is an int
     */
    public void setHour(int hour) {
        this.hour = hour;
    } // End method setHour.

    /**
     * Gets the day of the date time as an int.
     * @return the car year model.
     */
    public int getDay() {
        return day;
    } // End method getDay.

    /**
     * Sets the day instance property.
     * @param day is an int
     */
    public void setDay(int day) {
        this.day = day;
    } // End method setDay.

    /**
     * Gets the month of the date time as a string.
     * @return the car year model.
     */
    public String getMonth() {
        return month;
    } // End method getMonth.

    /**
     * Sets the month instance property.
     * @param month is a string
     */
    public void setMonth(String month) {
        this.month = month;
    } // End method setMonth.

    /**
     * Gets the year of the date time as an int.
     * @return the car year model.
     */
    public int getYear() {
        return year;
    } // End method getYear.

    /**
     * Sets the year instance property.
     * @param year is an int
     */
    public void setYear(int year) {
        this.year = year;
    } // End method setYear.

} // End class DateTime.