public class Circle extends Shape implements Area {

    private double radius;

    public Circle(double radius, String name) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}