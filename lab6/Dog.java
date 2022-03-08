/**
 * @author Jack Roach
 * Date: Mar 6, 2022
 * Class: CSE 271 - E
 */
public class Dog extends Animal {

    private String breed;

    /**
     * The default constructor.
     */
    public Dog() {
        this.breed = "";
    }

    /**
     * The workhorse constructor.
     *
     * @param age is an int
     * @param size is a String
     * @param breed is a String
     */
    public Dog(int age, String size, String breed) {
        super(age, size);
        this.breed = breed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog)) {
            return false;
        }

        Dog d = (Dog) o;
        return d.breed.equals(breed) && super.equals(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("I am a/an %s %s breed dog that is %d years old.",
            super.getSize(), breed, super.getAge());
    }

    /**
     * Sound that the Dog makes.
     *
     * @return Bark
     */
    public String speak() {
        return "Bark";
    }

    /**
     * Gets the Dog breed.
     *
     * @return the Dog breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the Dog breed.
     *
     * @param breed is a String
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

}