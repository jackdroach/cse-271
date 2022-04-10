import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class GlomeTest {

    /**
     * Test the workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Glome g = new Glome(2.0, "JR Glome");
        double delta = 0.00001;

        assertEquals(2.0, g.getRadius(), delta);
        assertEquals("JR Glome", g.getName());
    }

    /**
     * Test the getName method.
     */
    @Test
    public void test_getName() {
        Glome g = new Glome(2.0, "JR Glome");

        assertEquals("JR Glome", g.getName());
    }

    /**
     * Test the getArea method.
     */
    @Test
    public void test_getVolume() {
        Glome g = new Glome(2.0, "JR Glome");
        double delta = 0.00001;

        assertEquals(78.95683520871486, g.getVolume(), delta);
    }

    /**
     * Test the equals method.
     */
    @Test
    public void test_equals() {
        Glome g = new Glome(2.0, "JR Glome");
        Glome g2 = new Glome(1.0, "JR Glome");

        assertTrue(g.equals(g));
        assertFalse(g.equals(g2));
        assertFalse(g.equals(""));
    }

    /**
     * Test the toString method.
     */
    @Test
    public void test_toString() {
        Glome g = new Glome(2.0, "JR Glome");

        assertEquals("Glome [Name: JR Glome, Radius: 2.0]", g.toString());
    }

}