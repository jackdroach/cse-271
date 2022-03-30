/**
 * The class Square.
 */
public class Square extends Shape implements Area {

    private double length;

    /**
     * The [] constructor. Instantiates a new Square.
     *
     * @param length Square length
     * @param name Square name
     */
    public Square(double length, String name) {
        super(name);
        this.length = length;
    }

    /**
     * Gets area.
     *
     * @return the area
     */
    @Override
    public double getArea() {
        return length * length;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return Square.class.getName();
    }


    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return super.toString();
    }


    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }
        
        Square s = (Square) o;
        return s.length == length && super.equals(o);
    }

    /**
     * Test.
     */
    void test() {
        Object o = new Object();
    }
    
}