/**
 * Tester class for Car.java.
 *
 * @author Jack Roach
 * Date: Feb 20, 2022
 * Class: CSE 271 - E
 * File: CarDriver.java
 */
public class CarDriver {
    private static Car car;

    /**
     * The main method from where the process begins to run.
     *
     * @param args is a String array
     */
    public static void main(String[] args) {
        testConstructors();

        testAccelerate();
        testBrake();
        testIsGasTankEmpty();
        testSameOwner();

        testEqualsToString();

        testGettersSetters();
    } // End method main.

    /**
     * A tester method for Car.java constructors.
     */
    public static void testConstructors() {
        System.out.println("CONSTRUCTOR TESTS");

        // Empty constructor.
        car = new Car();
        System.out.println(car);

        // Partial constructor 1.
        car = new Car("Elon", "Tesla", "Cybertruck", 2022);
        System.out.println(car);

        // Partial constructor 2.
        car = new Car(car.getOwner(), car.getMake(), car.getModel(), 2022, 1.0);
        System.out.println(car);

        // Workhorse constructor.
        car = new Car(car.getOwner(), car.getMake(), car.getModel(), 2022, 1.0,
            250, true);
        System.out.println(car);

        // Copy constructor.
        Car car2 = new Car(car);
        System.out.println(car2);

        System.out.println();
    } // End method testConstructors.

    /**
     * A tester method for Car.java accelerate method.
     */
    public static void testAccelerate() {
        System.out.println("ACCELERATION TEST");

        System.out.println(car.getSpeed() + " " + car.accelerate());

        car.setSpeed(100);
        System.out.println(car.getSpeed() + " " + car.accelerate());
        System.out.println();
    } // End method testAccelerate.

    /**
     * A tester method for Car.java brake method.
     */
    public static void testBrake() {
        System.out.println("BRAKE TEST");

        System.out.println(car.getSpeed() + " " + car.brake());

        car.setSpeed(0);
        System.out.println(car.getSpeed() + " " + car.brake());
        System.out.println();
    } // End method testBrake.

    /**
     * A tester method for Car.java isGasTankEmpty method.
     */
    public static void testIsGasTankEmpty() {
        System.out.println("IS GAS TANK EMPTY TEST");

        System.out.println(car.getFuelLevel() + " " + car.isGasTankEmpty());

        car.setFuelLevel(0.04);
        System.out.println(car.getFuelLevel() + " " + car.isGasTankEmpty());
        System.out.println();
    } // End method testBrake.

    /**
     * A tester method for Car.java sameOwner method.
     */
    public static void testSameOwner() {
        System.out.println("SAME OWNER TEST");

        Car car2 = new Car();
        System.out.println(car2.getOwner() + " " + car.sameOwner(car2));

        car2.setOwner(car.getOwner());
        System.out.println(car2.getOwner() + " " + car.sameOwner(car2));
        System.out.println();

    } // End method testSameOwner.

    /**
     * A tester method for Car.java equals and toString methods.
     */
    public static void testEqualsToString() {
        System.out.println("EQUALS AND TO STRING TEST");

        Car car2 = new Car();
        System.out.println(car.equals(car2));

        car2 = car;
        System.out.println(car.equals(car2));
        System.out.println(car.toString());
        System.out.println();
    } // End method testSameOwner.

    /**
     * A tester method for Car.java getters and setters.
     */
    public static void testGettersSetters() {
        System.out.println("GETTER AND SETTER TEST");

        car = new Car();
        car.setOwner("Elon");
        car.setMake("Tesla");
        car.setModel("Cybertruck");
        car.setYearModel(2022);
        car.setFuelLevel(1.0);
        car.setSpeed(70);
        car.setStart(true);

        System.out.println(car.getOwner() + " " +
            car.getMake() + " " +
            car.getModel() + " " +
            car.getYearModel() + " " +
            car.getFuelLevel() + " " +
            car.getSpeed() + " " +
            car.isStart() + " ");
    } // End method testGettersSetters.

} // End class CarDriver