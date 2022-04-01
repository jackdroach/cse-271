public class Sphere extends Circle implements Volume {

    public Sphere(double radius, String name) {
        super(radius, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVolume() {
        return super.getArea() * 4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString();
    }

}