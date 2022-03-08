import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Mar 4, 2022
 * Class: CSE 271 - E
 * File: Customer.java
 */
public class CustomerTest {

    /**
     * Test default constructor.
     */
    @Test
    public void test_DefaultConstructor() {
        Customer c = new Customer();

        assertEquals("", c.getName());
        assertEquals(new Address(), c.getAddress());
        assertEquals("", c.getSsn());
    }

    /**
     * Test workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Address a = new Address();
        Customer c = new Customer("", a, "");

        assertEquals("", c.getName());
        assertEquals(a, c.getAddress());
        assertEquals("", c.getSsn());
    }

    /**
     * Test copy constructor.
     */
    @Test
    public void test_CopyConstructor() {
        Customer c = new Customer();
        Customer c2 = new Customer(c);

        assertEquals("", c2.getName());
        assertEquals(new Address(), c2.getAddress());
        assertEquals("", c2.getSsn());
    }

    /**
     * Test equals.
     */
    @Test
    public void test_Equals() {
        Customer c = new Customer();
        Customer c2 = new Customer(" ", new Address(), "");

        assertTrue(c.equals(c));
        assertFalse(c.equals(c2));
        assertFalse(c.equals(""));
    }

    /**
     * Test toString.
     */
    @Test
    public void test_ToString() {
        Customer c = new Customer();

        assertEquals("1012, , 0 , , OH, 00000, ", c.toString());
    }

    /**
     * Test setSsn.
     */
    @Test
    public void test_SetSsn() {
        Customer c = new Customer();

        try {
            c.setSsn("000-00-00000");
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            c.setSsn("000+00-000");
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        c.setSsn("000-00-0000");
        assertEquals("000-00-0000", c.getSsn());
    }

}