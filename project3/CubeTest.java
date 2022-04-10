import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class CubeTest {

    /**
     * Test the workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Cube c = new Cube(2.0, "JR Cube");
        double delta = 0.00001;

        assertEquals(2.0, c.getLength(), delta);
        assertEquals("JR Cube", c.getName());
    }

    /**
     * Test the getName method.
     */
    @Test
    public void test_getName() {
        Cube c = new Cube(2.0, "JR Cube");

        assertEquals("JR Cube", c.getName());
    }

    /**
     * Test the getArea method.
     */
    @Test
    public void test_getVolume() {
        Cube c = new Cube(2.0, "JR Cube");
        double delta = 0.00001;

        assertEquals(8.0, c.getVolume(), delta);
    }

    /**
     * Test the equals method.
     */
    @Test
    public void test_equals() {
        Cube c = new Cube(2.0, "JR Cube");
        Cube c2 = new Cube(1.0, "JR Cube");

        assertTrue(c.equals(c));
        assertFalse(c.equals(c2));
        assertFalse(c.equals(""));
    }

    /**
     * Test the toString method.
     */
    @Test
    public void test_toString() {
        Cube c = new Cube(2.0, "JR Cube");

        assertEquals("Cube [Name: JR Cube, Side: 2.0]", c.toString());
    }

}