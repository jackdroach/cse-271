public class Cube extends Square implements Volume {

    public Cube(double length, String name) {
        super(length, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVolume() {
        return Math.pow(Math.sqrt(getArea()), 3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Cube";
    }

}