public class Cube extends Square implements Volume {

    public Cube(double length, String name) {
        super(length, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVolume() {
        return Math.pow(super.getLength(), 3.0);
    }

}