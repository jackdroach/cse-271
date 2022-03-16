/**
 * @author Jack Roach
 * Date: Mar 15, 2022
 * Class: CSE 271 - E
 */
public interface Shape {

    /**
     * Gets the Shape area.
     *
     * @return area
     */
    double getArea();

    /**
     * Scales the Shape measurements.
     *
     * @param factor scale factor
     */
    void scale(double factor);

}
