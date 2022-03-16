public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getArea() {
        return base * height * 0.5;
    }

    /**
     * {@inheritDoc}
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