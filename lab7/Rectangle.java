import java.util.Objects;

public class Rectangle implements Shape {

    private int x;
    private int y;
    private double length;
    private double width;

    /**
     * Workhorse constructor. Instantiates a new Rectangle.
     *
     * @param x Rectangle x position
     * @param y Rectangle y position
     * @param length Rectangle length
     * @param width Rectangle width
     */
    public Rectangle(int x, int y, double length, double width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void scale(double factor) {
        length *= factor;
        width *= factor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) {
            return false;
        }

        Rectangle r = (Rectangle) o;
        return r.x == x && r.y == y && r.length == length && r.width == width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("Rectangle [x = %d, y = %d, length = %.1f, width ="
            + " %.1f]", x, y, length, width);
    }

    /**
     * Gets the Rectangle x.
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the Rectangle x.
     *
     * @param x Rectangle x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the Rectangle y.
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Set the Rectangle y.
     *
     * @param y Rectangle y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the Rectangle length.
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the Rectangle length.
     *
     * @param length Rectangle length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gets the Rectangle width.
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the Rectangle width.
     *
     * @param width Rectangle width
     */
    public void setWidth(double width) {
        this.width = width;
    }

}