/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class Square extends Shape implements Area {

    private double length;

    /**
     * Workhorse constructor. Instantiates a new Square.
     *
     * @param length Square length
     * @param name Square name
     */
    public Square(double length, String name) {
        super(name);
        this.length = length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getArea() {
        return Math.pow(length, 2.0);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }

        Square s = (Square) o;
        return s.length == length && s.name.equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Square [Name: %s, Side: %.1f]", name, length);
    }

    /**
     * Gets the Square length.
     *
     * @return Square length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the Square length.
     *
     * @param length Square length
     */
    public void setLength(double length) {
        this.length = length;
    }

}