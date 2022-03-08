/**
 * @author Jack Roach
 * Date: Mar 6, 2022
 * Class: CSE 271 - E
 */
public class Person {

    private String name;
    private int yearOfBirth;

    /**
     * The default constructor.
     */
    public Person() {
        this("", 0);
    }

    /**
     * The workhorse constructor.
     *
     * @param name is a String
     * @param yearOfBirth is an int
     */
    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }

        Person p = (Person) o;
        return p.name.equals(name) && p.yearOfBirth == yearOfBirth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(
            "I am a person whose name is %s and was born in %d.", name,
            yearOfBirth);
    }

    /**
     * Gets the Person name.
     *
     * @return the Person name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Person name.
     *
     * @param name is a String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Person yearOfBirth.
     *
     * @return the Person yearOfBirth
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Gets the Person yearOfBirth.
     *
     * @param yearOfBirth is an int
     */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

}