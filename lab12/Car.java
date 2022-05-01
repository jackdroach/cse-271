import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jack Roach
 * Date: Apr 25, 2022
 * Class: CSE 271 - E
 */
public class Car implements Comparable<Car> {

    private int id;
    private String carMake;
    private String carModel;
    private int year;

    /**
     * Workhorse constructor. Instantiates a new Emoticon.
     *
     * @param id Car id
     * @param carMake Car make
     * @param carModel Car model
     * @param year Car year
     */
    public Car(int id, String carMake, String carModel, int year) {
        this.id = id;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
    }

    /**
     * Creates an array of Cars from a file.
     *
     * @param filePath file name
     * @return array of Cars
     */
    public static Car[] readFromFile(String filePath) {
        Scanner scan = null;
        List<Car> list = new ArrayList<>();

        try {
            scan = new Scanner(new File(filePath));

            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                list.add(new Car(Integer.parseInt(array[0]), array[1], array[2],
                    Integer.parseInt(array[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert scan != null;
                scan.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list.toArray(new Car[]{});
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }

        Car c = (Car) o;
        return c.id == id && c.carMake.equals(carMake) &&
            c.carModel.equals(carModel) && c.year == year;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Car c) {
        if (carMake.compareTo(c.carMake) == 0) {
            if (carModel.compareTo(c.carModel) == 0) {
                return 0;
            } else if (carModel.compareTo(c.carModel) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (carMake.compareTo(c.carMake) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Sorts an array of cars using insertion sort.
     *
     * @param cars array of Cars
     */
    public static void sort(Car[] cars) {
        if (cars == null || cars.length < 2) {
            return;
        }

        for (int i = 1; i < cars.length; i++) {
            Car temp = cars[i];
            int j = i;

            while (j > 0 && cars[j - 1].compareTo(temp) > 0) {
                cars[j] = cars[--j];
            }

            cars[j] = temp;
        }
    }

    /**
     * Searches an array of cars using linear search.
     *
     * @param cars array of Cars
     * @param car Car to search
     * @return car index
     */
    public static int linearSearch(Car[] cars, Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].compareTo(car) == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Searches an array of cars using binary search.
     *
     * @param cars array of Cars
     * @param car Car to search
     * @return car index
     */
    public static int binaryRecursiveSearch(Car[] cars, Car car) {
        return binaryRecursiveSearch(cars, car, 0, cars.length - 1);
    }

    /**
     * Binary search helper method.
     *
     * @param cars array of Cars
     * @param car Car to search
     * @param low lowest index
     * @param high highest index
     * @return car index
     */
    private static int binaryRecursiveSearch(Car[] cars, Car car, int low,
        int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (cars[mid].compareTo(car) == 0) {
            return mid;
        }

        if (cars[mid].compareTo(car) > 0) {
            return binaryRecursiveSearch(cars, car, low, mid - 1);
        } else {
            return binaryRecursiveSearch(cars, car, mid + 1, high);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %d", id, carMake, carModel, year);
    }

}