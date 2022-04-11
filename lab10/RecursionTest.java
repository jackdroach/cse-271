import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Apr 10, 2022
 * Class: CSE 271 - E
 */
public class RecursionTest extends Recursion {

    @Test
    public void test_power() {
        assertEquals(0, power(0, 1));
        assertEquals(1, power(1, 0));
        assertEquals(8, power(2, 3));
    }

    @Test
    public void test_sumDigits() {
        assertEquals(0, sumDigits(0));
        assertEquals(1, sumDigits(10));
        assertEquals(6, sumDigits(123));
    }

    @Test
    public void test_printBackwards() {
        System.out.print("\"\" : \"");
        printBackwards("");
        System.out.print("\"");

        System.out.print("\n\"cse271\" : \"");
        printBackwards("cse271");
        System.out.print("\"");

        System.out.print("\n\"miami\" : \"");
        printBackwards("miami");
        System.out.print("\"");
    }

    @Test
    public void test_isPalindrome() {
        assertTrue(isPalindrome("racecar"));
        assertFalse(isPalindrome("Racecar"));
        assertFalse(isPalindrome("racecars"));
    }

    @Test
    public void test_sumPositive() {
        assertEquals();
    }

    @Test
    public void test_max() {
    }

}