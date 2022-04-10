/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class Cube extends Square implements Volume {

    /**
     * Workhorse constructor. Instantiates a new Cube.
     *
     * @param length Cube length
     * @param name Cube name
     */
    public Cube(double length, String name) {
        super(length, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVolume() {
        return Math.pow(getLength(), 3.0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Cube [Name: %s, Side: %.1f]", name, getLength());
    }

}