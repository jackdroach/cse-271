import java.util.Arrays;
import java.util.Scanner;

public class GradeStatistics {
    private static boolean isSorted;

    public static void main(String[] args) {
        double[] grades = populateGrades();

        // Print grades array.
        printGrades(grades);

        // Sort grades array.
        sortGrades(grades);

        // Print sorted grades array.
        printGrades(grades);

        // Print statistics.
        printStatistics(getMean(grades), getMinMax(grades));
    } // End method main.

    /**
     * Add grades to an array
     * @return grades as an array of doubles
     */
    public static double[] populateGrades() {
        // Scanner for console input.
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter # of students.
        System.out.print("How many students do you have in the class: ");
        int students = input.nextInt();

        // Create an array of doubles with the number of students as the size.
        double[] grades = new double[students];

        for (int i = 1; i <= students; i++) {
            // Prompt the user to enter a grade for each student.
            System.out.print("Enter grade of Student " + i + ": ");
            grades[i - 1] = input.nextDouble();
        } // End for loop.

        return grades;
    } // End method populateGrades.

    /**
     * Sort grades in order from lowest to highest.
     * @param grades is an array of doubles
     */
    public static void sortGrades(double[] grades) {
        // Sort the array.
        Arrays.sort(grades);

        // Var used in method printGrades to display a message.
        isSorted = true;
    } // End method sortGrades.

    /**
     * Get the mean grade.
     * @param grades is an array of doubles
     * @return mean grade as a double
     */
    public static double getMean(double[] grades) {
        double sum = 0.0;

        // Calculate the sum of all grades in the array.
        for (double grade : grades) {
            sum += grade;
        } // End for each loop.

        // Calculate and return the average grade.
        return sum / grades.length;
    } // End method getMean.

    /**
     * Get the min and max grades.
     * @param grades is an array of doubles
     * @return min and max grades as an array of doubles
     */
    public static double[] getMinMax(double[] grades) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        // Check for a new min and max in each index of the array. Replace the
        // current min and max if found.
        for (double grade : grades) {
            min = Math.min(grade, min);
            max = Math.max(grade, max);
        } // End for each loop.

        return new double[]{min, max};
    }

    /**
     * Print student grades.
     * @param grades is an array of doubles
     */
    public static void printGrades(double[] grades) {
        // Print a message to console based on if the method sortGrades was run.
        System.out.print(!isSorted ? "The grades are: " : "\nThe sorted grade" +
            "s are: ");

        for (int i = 0; i < grades.length; i++) {
            if (i != 0) {
                // Add coma and spacing.
                System.out.print(", ");
            } // End if/else.

            // Print the grade in the current index.
            System.out.print(grades[i]);
        } // End for loop.
    } // End method printGrades.

    /**
     * Print statistics from the methods getMean and getMinMax.
     * @param mean is a double
     * @param minMax is an array of doubles
     */
    public static void printStatistics(double mean, double[] minMax) {
        // Print the mean of the grades.
        System.out.printf("\nMean = %.1f", mean);

        // Print the min and max of the grades.
        System.out.print("\nMin = " + minMax[0] + " Max = " + minMax[1]);
    } // End method printStatistics/

} // End class GradeStatistics.
