/**
 * @author Jack Roach
 * Date: Mar 6, 2022
 * Class: CSE 271 - E
 */
public class Cat extends Animal {

    private int numberOfLives;

    /**
     * The default constructor.
     */
    public Cat() {
        this.numberOfLives = 0;
    }

    /**
     * The workhorse constructor.
     *
     * @param age is an int
     * @param size is a String
     * @param numberOfLives is an int
     */
    public Cat(int age, String size, int numberOfLives) {
        super(age, size);
        this.numberOfLives = numberOfLives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat)) {
            return false;
        }

        Cat c = (Cat) o;
        return c.numberOfLives == numberOfLives && super.equals(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(
            "I am a %s cat that is %d years old and have %s lives left.",
            super.getSize(), super.getAge(), numberOfLives);
    }

    /**
     * Sound that the Cat makes.
     *
     * @return Meow
     */
    @Override
    public String speak() {
        return "Meow";
    }

    /**
     * Gets the Cat numberOfLives.
     *
     * @return the Cat numberOfLives
     */
    public int getNumberOfLives() {
        return numberOfLives;
    }

    /**
     * Sets the Cat numberOfLives.
     *
     * @param numberOfLives is an int
     */
    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

}