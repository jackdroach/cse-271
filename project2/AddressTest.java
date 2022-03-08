import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Mar 4, 2022
 * Class: CSE 271 - E
 * File: AddressTest.java
 */
public class AddressTest {

    /**
     * Test default constructor.
     */
    @Test
    public void test_DefaultConstructor() {
        Address a = new Address();

        assertEquals(0, a.getStreetNumber());
        assertEquals("", a.getStreetName());
        assertEquals("", a.getCity());
        assertEquals("OH", a.getState());
        assertEquals("00000", a.getZipCode());
    }

    /**
     * Test workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Address a = new Address(0, "", "", "OH", "00000");

        assertEquals(0, a.getStreetNumber());
        assertEquals("", a.getStreetName());
        assertEquals("", a.getCity());
        assertEquals("OH", a.getState());
        assertEquals("00000", a.getZipCode());
    }

    /**
     * Test copy constructor.
     */
    @Test
    public void test_CopyConstructor() {
        Address a = new Address();
        Address a2 = new Address(a);

        assertEquals(0, a2.getStreetNumber());
        assertEquals("", a2.getStreetName());
        assertEquals("", a2.getCity());
        assertEquals("OH", a2.getState());
        assertEquals("00000", a2.getZipCode());
    }

    /**
     * Test equals.
     */
    @Test
    public void test_Equals() {
        Address a = new Address();
        Address a2 = new Address(0, "", "", "MI", "00000");

        assertTrue(a.equals(a));
        assertFalse(a.equals(a2));
        assertFalse(a.equals(""));
    }

    /**
     * Test toString.
     */
    @Test
    public void test_ToString() {
        Address a = new Address();

        assertEquals("0 , , OH, 00000", a.toString());
    }

    /**
     * Test setStreetNumber.
     */
    @Test
    public void test_SetStreetNumber() {
        Address a = new Address();

        try {
            a.setStreetNumber(-1);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        a.setStreetNumber(0);
        assertEquals(0, a.getStreetNumber());

        a.setStreetNumber(123);
        assertEquals(123, a.getStreetNumber());
    }

    /**
     * Test setState.
     */
    @Test
    public void test_SetState() {
        Address a = new Address();

        try {
            a.setState("A1");
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            a.setState("OH1");
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        a.setState("OH");
        assertEquals("OH", a.getState());
    }

    /**
     * Test setZipCode.
     */
    @Test
    public void test_SetZipCode() {
        Address a = new Address();

        try {
            a.setZipCode("A0000");
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            a.setZipCode("000000");
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        a.setZipCode("12345");
        assertEquals("12345", a.getZipCode());
    }

}