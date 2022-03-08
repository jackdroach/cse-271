import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jack Roach
 * Date: Mar 4, 2022
 * Class: CSE 271 - E
 * File: AccountTest.java
 */
public class AccountTest {

    private final double DELTA = 0.00001;

    /**
     * Test partial constructor.
     */
    @Test
    public void test_PartialConstructor() {
        Customer c = new Customer();
        Account a = new Account(c);

        assertEquals(c, a.getCustomer());
        assertEquals(0.0, a.getBalance(), DELTA);
    }

    /**
     * Test workhorse constructor.
     */
    @Test
    public void test_WorkhorseConstructor() {
        Customer c = new Customer();
        Account a = new Account(c, 100.0);

        assertEquals(c, a.getCustomer());
        assertEquals(100.0, a.getBalance(), DELTA);
    }

    /**
     * Test copy constructor.
     */
    @Test
    public void test_CopyConstructor() {
        Customer c = new Customer();
        Account a = new Account(c);
        Account a2 = new Account(a);

        assertEquals(c, a2.getCustomer());
        assertEquals(0.0, a2.getBalance(), DELTA);
    }

    /**
     * Test deposit.
     */
    @Test
    public void test_Deposit() {
        Account a = new Account(new Customer());

        try {
            a.deposit(-1.0);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        a.deposit(0.0);
        assertEquals(0.0, a.getBalance(), DELTA);

        a.deposit(100.0);
        assertEquals(100.0, a.getBalance(), DELTA);
    }

    /**
     * Test withdraw.
     */
    @Test
    public void test_Withdraw() {
        Account a = new Account(new Customer());
        a.setBalance(500.0);

        try {
            a.withdraw(-1.0);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        a.withdraw(0.0);
        assertEquals(500.0, a.getBalance(), DELTA);

        a.withdraw(100.0);
        assertEquals(400.0, a.getBalance(), DELTA);
    }

    /**
     * Test equals.
     */
    @Test
    public void test_Equals() {
        Customer c = new Customer();
        Account a = new Account(c);
        Account a2 = new Account(c, 100.0);

        assertTrue(a.equals(a));
        assertFalse(a.equals(a2));
        assertFalse(a.equals(""));
    }

    /**
     * Test toString.
     */
    @Test
    public void test_ToString() {
        Account a = new Account(new Customer());

        assertEquals("1140, 1013, , 0 , , OH, 00000, , 0.00", a.toString());
    }

    /**
     * Test setBalance
     */
    @Test
    public void test_SetBalance() {
        Account a = new Account(new Customer());

        try {
            a.setBalance(-1.0);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        a.setBalance(0.0);
        assertEquals(0.0, a.getBalance(), DELTA);


        a.setBalance(100.0);
        assertEquals(100.0, a.getBalance(), DELTA);
    }

}