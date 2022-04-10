import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class SphereTest {

    /**
     * Test the workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Sphere s = new Sphere(2.0, "JR Sphere");
        double delta = 0.00001;

        assertEquals(2.0, s.getRadius(), delta);
        assertEquals("JR Sphere", s.getName());
    }

    /**
     * Test the getName method.
     */
    @Test
    public void test_getName() {
        Sphere s = new Sphere(2.0, "JR Sphere");

        assertEquals("JR Sphere", s.getName());
    }

    /**
     * Test the getArea method.
     */
    @Test
    public void test_getVolume() {
        Sphere s = new Sphere(2.0, "JR Sphere");
        double delta = 0.00001;

        assertEquals(33.510321638291124, s.getVolume(), delta);
    }

    /**
     * Test the equals method.
     */
    @Test
    public void test_equals() {
        Sphere s = new Sphere(2.0, "JR Sphere");
        Sphere s2 = new Sphere(1.0, "JR Sphere");

        assertTrue(s.equals(s));
        assertFalse(s.equals(s2));
        assertFalse(s.equals(""));
    }

    /**
     * Test the toString method.
     */
    @Test
    public void test_toString() {
        Sphere s = new Sphere(2.0, "JR Sphere");

        assertEquals("Sphere[Name: JR Sphere, Radius: 2.0]", s.toString());
    }

}