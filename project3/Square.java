public class Square extends Shape implements Area {

    private double length;

    public Square(double length, String name) {
        super(name);
        this.length = length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getArea() {
        return Math.pow(length, 2.0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return super.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }
        
        Square s = (Square) o;
        return s.length == length && super.equals(o);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}