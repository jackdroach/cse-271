import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 01, 2022
 * Class: CSE 271 - E
 */
public class SquareTest {

    /**
     * Test the workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Square s = new Square(2.0, "JR Square");
        double delta = 0.00001;

        assertEquals(2.0, s.getLength(), delta);
        assertEquals("JR Square", s.getName());
    }

    /**
     * Test the getName method.
     */
    @Test
    public void test_getName() {
        Square s = new Square(2.0, "JR Square");

        assertEquals("JR Square", s.getName());
    }

    /**
     * Test the getArea method.
     */
    @Test
    public void test_getArea() {
        Square s = new Square(2.0, "JR Square");
        double delta = 0.00001;

        assertEquals(4.0, s.getArea(), delta);
    }

    /**
     * Test the equals method.
     */
    @Test
    public void test_equals() {
        Square s = new Square(2.0, "JR Square");
        Square s2 = new Square(1.0, "JR Square");

        assertTrue(s.equals(s));
        assertFalse(s.equals(s2));
        assertFalse(s.equals(""));
    }

    /**
     * Test the toString method.
     */
    @Test
    public void test_toString() {
        Square s = new Square(2.0, "JR Square");

        assertEquals("Square [Name: JR Square, Side: 2.0]", s.toString());
    }

}