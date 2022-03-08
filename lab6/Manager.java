/**
 * @author Jack Roach
 * Date: Mar 6, 2022
 * Class: CSE 271 - E
 */
public class Manager extends Employee {

    private String department;

    /**
     * The default constructor.
     */
    public Manager() {
        department = "";
    }

    /**
     * The workhorse constructor
     *
     * @param name is a String
     * @param yearOfBirth is an int
     * @param salary is a double
     * @param department is a String
     */
    public Manager(String name, int yearOfBirth, double salary,
        String department) {
        super(name, yearOfBirth, salary);
        this.department = department;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Manager)) {
            return false;
        }

        Manager m = (Manager) o;
        return m.department.equals(department) && super.equals(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("I am a manager of the %s department. %s",
            department, super.toString());
    }

    /**
     * Gets the Manager department.
     *
     * @return the Manager department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the Manager department.
     *
     * @param department is a String
     */
    public void setDepartment(String department) {
        this.department = department;
    }

}