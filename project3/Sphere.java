/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class Sphere extends Circle implements Volume {

    /**
     * Workhorse constructor. Instantiates a new Sphere.
     *
     * @param radius Sphere radius
     * @param name Sphere name
     */
    public Sphere(double radius, String name) {
        super(radius, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVolume() {
        return getArea() * getRadius() * 4 / 3;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Sphere[Name: %s, Radius: %.1f]", name,
            getRadius());
    }

}