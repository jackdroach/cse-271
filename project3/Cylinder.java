/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class Cylinder extends Circle implements Volume {

    private double height;

    /**
     * Workhorse constructor. Instantiates a new Cylinder.
     *
     * @param height Cylinder height
     * @param radius Cylinder radius
     * @param name Cylinder name
     */
    public Cylinder(double height, double radius, String name) {
        super(radius, name);
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVolume() {
        return getArea() * height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }

        Cylinder c = (Cylinder) o;
        return c.height == height && super.equals(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Cylinder [Name: %s, Height: %.1f, Radius: %.1f]",
            name, height, getRadius());
    }

    /**
     * Gets the Cylinder height.
     *
     * @return Cylinder height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the Cylinder height.
     *
     * @param height Cylinder height
     */
    public void setHeight(double height) {
        this.height = height;
    }

}