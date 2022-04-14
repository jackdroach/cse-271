import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 10, 2022
 * Class: CSE 271 - E
 */
public class RecursionTester {

    /**
     * Test the power method.
     */
    @Test
    public void test_power() {
        assertEquals(0, Recursion.power(0, 1));
        assertEquals(1, Recursion.power(1, 0));
        assertEquals(8, Recursion.power(2, 3));
    }

    /**
     * Test the sumDigits method.
     */
    @Test
    public void test_sumDigits() {
        assertEquals(0, Recursion.sumDigits(0));
        assertEquals(1, Recursion.sumDigits(10));
        assertEquals(6, Recursion.sumDigits(123));
    }

    /**
     * Test the printBackwards method.
     */
    @Test
    public void test_printBackwards() {
        System.out.print("\"\" : \"");
        Recursion.printBackwards("");
        System.out.print("\"");

        System.out.print("\n\"cse271\" : \"");
        Recursion.printBackwards("cse271");
        System.out.print("\"");

        System.out.print("\n\"miami\" : \"");
        Recursion.printBackwards("miami");
        System.out.print("\"");
    }

    /**
     * Test the isPalindrome method.
     */
    @Test
    public void test_isPalindrome() {
        assertTrue(Recursion.isPalindrome("racecar"));
        assertFalse(Recursion.isPalindrome("Racecar"));
        assertFalse(Recursion.isPalindrome("racecars"));
    }

    /**
     * Test the sumPositive method.
     */
    @Test
    public void test_sumPositive() {
        assertEquals(0, Recursion.sumPositive(new int[] {0}));
        assertEquals(1, Recursion.sumPositive(new int[] {-1, 1}));
        assertEquals(6, Recursion.sumPositive(new int[] {1, 2, 3}));
    }

    /**
     * Test the max method.
     */
    @Test
    public void test_max() {
        assertEquals(0, Recursion.max(new int[] {0}));
        assertEquals(-1, Recursion.max(new int[] {-2, -1}));
        assertEquals(3, Recursion.max(new int[] {1, 2, 3}));
    }

}