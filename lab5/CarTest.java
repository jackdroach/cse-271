import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit tests for the Car class.
 *
 * @author Jack Roach
 * Date: Feb 27, 2022
 * Class: CSE 271 - E
 * File: CarTest.java
 */
public class CarTest {

    Car c;

    /**
     * Test the default constructor with test cases for each instance property.
     */
    @Test
    public void test_DefaultConstructor() {
        c = new Car();
        double delta = 0.00001;

        assertEquals("", c.getOwner());
        assertEquals("", c.getMake());
        assertEquals("", c.getModel());
        assertEquals(2022, c.getYearModel());
        assertEquals(1.0, c.getFuelLevel(), delta);
        assertEquals(0, c.getSpeed());
        assertFalse(c.isStart());
    }

    /**
     * Test the partial constructor with test cases for each instance property.
     */
    @Test
    public void test_PartialConstructorOne() {
        c = new Car("Jack", "Tesla", "Model X", 2015);
        double delta = 0.00001;

        assertEquals("Jack", c.getOwner());
        assertEquals("Tesla", c.getMake());
        assertEquals("Model X", c.getModel());
        assertEquals(2015, c.getYearModel());
        assertEquals(1.0, c.getFuelLevel(), delta);
        assertEquals(0, c.getSpeed());
        assertFalse(c.isStart());
    }

    /**
     * Test the partial constructor with test cases for each instance property.
     */
    @Test
    public void test_PartialConstructorTwo() {
        c = new Car("Jack", "Tesla", "Model X", 2015, 1.0);
        double delta = 0.00001;

        assertEquals("Jack", c.getOwner());
        assertEquals("Tesla", c.getMake());
        assertEquals("Model X", c.getModel());
        assertEquals(2015, c.getYearModel());
        assertEquals(1.0, c.getFuelLevel(), delta);
        assertEquals(0, c.getSpeed());
        assertFalse(c.isStart());
    }

    /**
     * Test the workhorse constructor with test cases for each instance
     * property.
     */
    @Test
    public void test_WorkhorseConstructor() {
        c = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 100, true);
        double delta = 0.00001;

        assertEquals("Jack", c.getOwner());
        assertEquals("Tesla", c.getMake());
        assertEquals("Model X", c.getModel());
        assertEquals(2015, c.getYearModel());
        assertEquals(1.0, c.getFuelLevel(), delta);
        assertEquals(100, c.getSpeed());
        assertTrue(c.isStart());
    }

    /**
     * Test the copy constructor with test cases for each instance property.
     */
    @Test
    public void test_CopyConstructor() {
        c = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 100, true);
        Car c2 = new Car(c);
        double delta = 0.00001;

        assertEquals("Jack", c2.getOwner());
        assertEquals("Tesla", c2.getMake());
        assertEquals("Model X", c2.getModel());
        assertEquals(2015, c2.getYearModel());
        assertEquals(1.0, c2.getFuelLevel(), delta);
        assertEquals(100, c2.getSpeed());
        assertTrue(c2.isStart());
    }

    /**
     * Test the accelerate method.
     *
     * 1. Test speed 245
     * 2. Test speed 246
     * 3. Test speed 250
     * 4. Test speed 0
     */
    @Test
    public void test_Accelerate() {
        c = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 245, true);
        Car c2 = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 246, true);
        Car c3 = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 250, true);
        Car c4 = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 0, false);

        // Test case 1.
        assertTrue(c.accelerate());
        assertEquals(249, c.getSpeed());

        // Test case 2.
        assertTrue(c2.accelerate());
        assertEquals(250, c2.getSpeed());

        // Test case 3.
        assertFalse(c3.accelerate());
        assertEquals(250, c3.getSpeed());

        // Test case 4.
        assertFalse(c4.accelerate());
        assertEquals(0, c4.getSpeed());
    }

    /**
     * Test the brake method.
     *
     * 1. Test speed 4
     * 2. Test speed 3
     * 3. Test speed 0
     */
    @Test
    public void test_Brake() {
        c = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 4, true);
        Car c2 = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 3, true);
        Car c3 = new Car("Jack", "Tesla", "Model X", 2015, 1.0, 0, false);

        // Test case 1.
        assertTrue(c.brake());
        assertEquals(1, c.getSpeed());

        // Test case 2.
        assertTrue(c2.brake());
        assertEquals(0, c2.getSpeed());

        // test case 3.
        assertFalse(c3.brake());
        assertEquals(0, c3.getSpeed());
    }

    /**
     * Test the isGasTankEmpty method.
     *
     * 1. Test fuelLevel 0.06
     * 2. Test fuelLevel 0.05
     */
    @Test
    public void test_IsGasTankEmpty() {
        c = new Car("Jack", "Tesla", "Model X", 2015, 0.05);
        Car c2 = new Car("Jack", "Tesla", "Model X", 2015, 0.04);

        assertFalse(c.isGasTankEmpty());
        assertTrue(c2.isGasTankEmpty());
    }

    /**
     * Test the sameOwner method.
     *
     * 1. Test if "" is the same owner as ""
     * 2. Test if "" is the same owner as "Jack"
     */
    @Test
    public void test_SameOwner() {
        c = new Car();
        Car c2 = new Car(c);
        Car c3 = new Car("Jack", "Tesla", "Model X", 2015);

        assertTrue(c.sameOwner(c2));
        assertFalse(c.sameOwner(c3));
    }

    /**
     * Test the equals method.
     *
     * 1. Test if two default cars are equal
     * 2. Test if a default car and another car are equal
     */
    @Test
    public void test_Equals() {
        c = new Car();
        Car c2 = new Car(c);
        Car c3 = new Car("Jack", "Tesla", "Model X", 2015);

        assertTrue(c.equals(c2));
        assertFalse(c.equals(c3));
        assertFalse(c.equals(""));
    }

    /**
     * Test the toString method.
     *
     * 1. Test if the expected string equals the returned string
     */
    @Test
    public void test_ToString() {
        c = new Car();

        assertEquals(
            "Owner: , Make: , Model: , Year: 2022, Speed: 0, Fuel Level: 1.00",
            c.toString());
    }

    /**
     * Test the SetYearModel method.
     *
     * 1. Test yearModel 1884
     * 2. Test yearModel 2023
     * 3. Test fuelLevel 1885
     * 4. Test fuelLevel 2022
     */
    @Test
    public void test_SetYearModel() {
        c = new Car();

        // Test case 1.
        try {
            c.setYearModel(1884);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        // Test case 2.
        try {
            c.setYearModel(2023);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        // Test case 3.
        c.setYearModel(1885);
        assertEquals(1885, c.getYearModel());

        // Test case 4.
        c.setYearModel(2022);
        assertEquals(2022, c.getYearModel());
    }

    /**
     * Test the setFuelLevel method.
     *
     * 1. Test fuelLevel -0.1
     * 2. Test fuelLevel 1.1
     * 3. Test fuelLevel 0.0
     * 4. Test fuelLevel 1.0
     */
    @Test
    public void test_SetFuelLevel() {
        c = new Car();
        double delta = 0.00001;

        // Test case 1.
        try {
            c.setFuelLevel(-0.1);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        // Test case 2.
        try {
            c.setFuelLevel(1.1);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        // Test case 3.
        c.setFuelLevel(0.0);
        assertEquals(0.0, c.getFuelLevel(), delta);

        // Test case 4.
        c.setFuelLevel(1.0);
        assertEquals(1.0, c.getFuelLevel(), delta);
    }

    /**
     * Test the setSpeed method.
     *
     * 1. Test speed -1
     * 2. Test speed 251
     * 3. Test speed 0
     * 4. Test speed 250
     */
    @Test
    public void test_SetSpeed() {
        c = new Car();

        // Test case 1.
        try {
            c.setSpeed(-1);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        // Test case 2.
        try {
            c.setSpeed(251);
            fail("IllegalArgumentException was supposed to occur.");
        } catch (IllegalArgumentException ignored) {
        }

        // Test case 3.
        c.setSpeed(0);
        assertEquals(0, c.getSpeed());

        // Test case 4.
        c.setSpeed(250);
        assertEquals(250, c.getSpeed());
    }

}