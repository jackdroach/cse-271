/**
 * @author Jack Roach
 * Date: Mar 6, 2022
 * Class: CSE 271 - E
 */
public class Animal {

    private int age;
    private String size;

    /**
     * The default constructor.
     */
    public Animal() {
        this(0, "");
    }

    /**
     * The workhorse constructor.
     *
     * @param age is an int
     * @param size is a String
     */
    public Animal(int age, String size) {
        this.age = age;
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal)) {
            return false;
        }

        Animal a = (Animal) o;
        return a.age == age && a.size.equals(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("I am an unknown %s animal that is %d years old.",
            size, age);
    }

    /**
     * Sound that the Animal makes.
     *
     * @return Unintelligible sound
     */
    public String speak() {
        return "Unintelligible sound";
    }

    /**
     * Gets the Animal age.
     *
     * @return the Animal age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the Animal age.
     *
     * @param age is an int
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the Animal size.
     *
     * @return the Animal size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the Animal size.
     *
     * @param size is a String
     */
    public void setSize(String size) {
        this.size = size;
    }

}