/**
 * @author Jack Roach
 * Date: Mar 6, 2022
 * Class: CSE 271 - E
 */
public class Employee extends Person {

    private double salary;

    /**
     * The default constructor.
     */
    public Employee() {
        salary = 0.0;
    }

    /**
     * The workhorse constructor.
     *
     * @param name is a String
     * @param yearOfBirth is an int
     * @param salary is a double
     */
    public Employee(String name, int yearOfBirth, double salary) {
        super(name, yearOfBirth);
        this.salary = salary;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }

        Employee e = (Employee) o;
        return e.salary == salary && super.equals(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("I am an employee and have a salary of $%.2f. %s",
            salary, super.toString());
    }

    /**
     * Gets the Employee salary.
     *
     * @return the Employee salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the Employee salary.
     *
     * @param salary is a double
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

}