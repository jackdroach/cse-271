/**
 * @author Jack Roach
 * Date: Mar 15, 2022
 * Class: CSE 271 - E
 */
public class Triangle implements Shape {

    private double base;
    private double height;

    /**
     * Workhorse constructor. Instantiates a new Triangle.
     *
     * @param base Triangle base
     * @param height Triangle height
     */
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * Gets the Triangle area.
     *
     * @return {@inheritDoc}
     */
    @Override
    public double getArea() {
        return base * height * 0.5;
    }

    /**
     * Scales the Triangle measurements.
     *
     * @param factor {@inheritDoc}
     */
    @Override
    public void scale(double factor) {
        base *= factor;
        height *= factor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Triangle)) {
            return false;
        }

        Triangle t = (Triangle) o;
        return t.base == base && t.height == height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Triangle [base = %.1f, height = %.1f]", base,
            height);
    }

}