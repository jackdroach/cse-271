import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class CylinderTest {

    /**
     * Test the workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Cylinder c = new Cylinder(5.0, 2.0, "JR Cylinder");
        double delta = 0.00001;

        assertEquals(2.0, c.getRadius(), delta);
        assertEquals("JR Cylinder", c.getName());
    }

    /**
     * Test the getName method.
     */
    @Test
    public void test_getName() {
        Cylinder c = new Cylinder(5.0, 2.0, "JR Cylinder");

        assertEquals("JR Cylinder", c.getName());
    }

    /**
     * Test the getArea method.
     */
    @Test
    public void test_getVolume() {
        Cylinder c = new Cylinder(5.0, 2.0, "JR Cylinder");
        double delta = 0.00001;

        assertEquals(62.83185307179586, c.getVolume(), delta);
    }

    /**
     * Test the equals method.
     */
    @Test
    public void test_equals() {
        Cylinder c = new Cylinder(5.0, 2.0, "JR Cylinder");
        Cylinder c2 = new Cylinder(5.0, 1.0, "JR Cylinder");

        assertTrue(c.equals(c));
        assertFalse(c.equals(c2));
        assertFalse(c.equals(""));
    }

    /**
     * Test the toString method.
     */
    @Test
    public void test_toString() {
        Cylinder c = new Cylinder(5.0, 2.0, "JR Cylinder");

        assertEquals("Cylinder [Name: JR Cylinder, Height: 5.0, Radius: 2.0]", c.toString());
    }

}