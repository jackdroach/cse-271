public class Cylinder extends Circle implements Volume {

    private double height;

    public Cylinder(double height, double radius, String name) {
        super(radius, name);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}