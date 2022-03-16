/**
 * @author Jack Roach
 * Date: Mar 15, 2022
 * Class: CSE 271 - E
 */
public class ShapeTester {

    public static void main(String[] args) {
        Shape s = new Rectangle(2, 3, 4, 5);
        s.scale(2);
        System.out.printf(
            "%.1f %b %b %s",
            s.getArea(),
            s.equals(new Rectangle(2, 3, 4, 5)),
            s.equals(new Rectangle(2, 3, 8, 10)),
            s.toString()
        );

        System.out.println();

        s = new Triangle(2, 3);
        s.scale(2);
        System.out.printf(
            "%.1f %b %b %s",
            s.getArea(),
            s.equals(new Triangle(2, 3)),
            s.equals(new Triangle(4, 6)),
            s.toString()
        );
    }

}