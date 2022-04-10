/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public abstract class Shape {

    protected String name;

    /**
     * Workhorse constructor. Instantiates a new Shape.
     *
     * @param name Shape name
     */
    public Shape(String name) {
        this.name = name;
    }

    /**
     * Gets the Shape name.
     *
     * @return Shape name
     */
    public abstract String getName();

}