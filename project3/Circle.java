/**
 * The class Circle.
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
     * Gets area.
     *
     * @return the area
     */
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return "Circle";
    }

    /**`
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString();
    }


    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}