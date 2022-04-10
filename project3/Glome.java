/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class Glome extends Sphere implements Volume {

    /**
     * Workhorse constructor. Instantiates a new Glome.
     *
     * @param radius Glome radius
     * @param name Glome name
     */
    public Glome(double radius, String name) {
        super(radius, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVolume() {
        return 0.5 * Math.pow(getRadius(), 4) * Math.pow(Math.PI, 2.0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Glome [Name: %s, Radius: %.1f]", name,
            getRadius());
    }

}