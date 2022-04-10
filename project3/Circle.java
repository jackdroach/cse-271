/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class Circle extends Shape implements Area {

    private double radius;

    /**
     * Workhorse constructor. Instantiates a new Circle.
     *
     * @param radius Circle radius
     * @param name Circle name
     */
    public Circle(double radius, String name) {
        super(name);
        this.radius = radius;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return super.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getArea() {
        return Math.pow(radius, 2.0) * Math.PI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }

        Circle c = (Circle) o;
        return c.radius == radius && c.name.equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Circle [Name: %s, Radius: %.1f]", name, radius);
    }

    /**
     * Gets the Circle radius.
     *
     * @return Circle radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the Circle radius.
     *
     * @param radius Circle radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

}