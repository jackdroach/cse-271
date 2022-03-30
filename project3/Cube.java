public class Cube extends Square implements Volume {

    private int length;
    private String name;

    public Cube(double length, String name) {
        super(length, name);
    }

    @Override
    public double getVolume() {
        return super.getArea() * length;
    }

    @Override
    public String getName() {
        return "Cube";
    }

}