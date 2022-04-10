import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class CircleTest {

    /**
     * Test the workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Circle c = new Circle(2.0, "JR Circle");
        double delta = 0.00001;

        assertEquals(2.0, c.getRadius(), delta);
        assertEquals("JR Circle", c.getName());
    }

    /**
     * Test the getName method.
     */
    @Test
    public void test_getName() {
        Circle c = new Circle(2.0, "JR Circle");

        assertEquals("JR Circle", c.getName());
    }

    /**
     * Test the getArea method.
     */
    @Test
    public void test_getArea() {
        Circle c = new Circle(2.0, "JR Circle");
        double delta = 0.00001;

        assertEquals(12.566370614359172, c.getArea(), delta);
    }

    /**
     * Test the equals method.
     */
    @Test
    public void test_equals() {
        Circle c = new Circle(2.0, "JR Circle");
        Circle c2 = new Circle(1.0, "JR Circle");

        assertTrue(c.equals(c));
        assertFalse(c.equals(c2));
        assertFalse(c.equals(""));
    }

    /**
     * Test the toString method.
     */
    @Test
    public void test_toString() {
        Circle c = new Circle(2.0, "JR Circle");

        assertEquals("Circle [Name: JR Circle, Radius: 2.0]", c.toString());
    }

}