/**
 * @author Jack Roach
 * Date: Mar 6, 2022
 * Class: CSE 271 - E
 */
public class Executive extends Manager {

    private String officeLocation;

    /**
     * The default constructor.
     */
    public Executive() {
        officeLocation = "";
    }

    /**
     * The workhorse constructor.
     *
     * @param name is a String
     * @param yearOfBirth is an int
     * @param salary is a double
     * @param department is a String
     * @param officeLocation is a String
     */
    public Executive(String name, int yearOfBirth, double salary,
        String department, String officeLocation) {
        super(name, yearOfBirth, salary, department);
        this.officeLocation = officeLocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Executive)) {
            return false;
        }

        Executive e = (Executive) o;
        return e.officeLocation.equals(officeLocation) && super.equals(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return
            String.format("I am an executive and my office location is %s. %s",
                officeLocation, super.toString());
    }

    /**
     * Gets the Executive officeLocation.
     *
     * @return the Executive officeLocation
     */
    public String getOfficeLocation() {
        return officeLocation;
    }

    /**
     * Sets the Executive officeLocation.
     *
     * @param officeLocation is a String
     */
    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

}
