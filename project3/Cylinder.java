public class Cylinder extends Circle implements Volume {

    private double height;

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
    public String toString() {
        return "Cylinder";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}