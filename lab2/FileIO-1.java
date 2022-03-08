/*
 * Author: Jack Roach
 * Date: Feb 6, 2021
 * Class: CSE 271 - E
 * File: FileIO.java
 * Description:
 */

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Author: Dr. Vaskar Raychoudhury
 * Date: 09/03/2020
 *
 * Modified: Dr. Garrett Goodman
 * Date: 2/3/2021
 */
public class FileIO {
	private final static int SEED = 100;

	/**
	 * Create a file with N number of random ints.
	 * @return the number of random ints
	 */
	public static int createFile() {
		Random rnd = new Random(SEED);

		// Prompt the user to enter the number of integers to generate.
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer to generate N random numbers: ");
		int num = scanner.nextInt();
		scanner.close();

		// Print writer for file output.
		PrintWriter printWriter = null;

		try {
			// Assign to output file.
			printWriter = new PrintWriter("numbers.txt");

			// Generate N amount of random numbers.
			for (int i = 0; i < num; i++) {
				printWriter.println(rnd.nextInt(SEED));
			} // End for loop.

			// Catch, print an error message, return status code -1.
		} catch (FileNotFoundException e) {
			System.err.println("Error " + e.getMessage());
			return -1;

		} finally {
			try {
				// Confirm the print writer has a value and close it.
				assert printWriter != null;
				printWriter.close();

				// Catch and print an error message.
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			} // End try/catch.
		} // End try/catch.

		return num;
	} // End method createFile.

	/**
	 * Read a file of random ints.
	 * @param arrayOfIntegers is an array of ints
	 */
	public static void readFromFile(int[] arrayOfIntegers) {
		// Scanner for file input.
		Scanner scanner = null;

		try {
			// Assign to input file.
			scanner = new Scanner(new File("numbers.txt"));

			// Read each line of the file an replace the index with that line.
			int i = 0;
			while (scanner.hasNext()) {
				arrayOfIntegers[i] = scanner.nextInt();
				i++;
			} // End while loop.

			// Catch and print an error message.
		} catch (FileNotFoundException e) {
			System.err.println("Error " + e.getMessage());

		} finally {
			try {
				// Confirm the print writer has a value and close it.
				assert scanner != null;
				scanner.close();

				// Catch and print an error message.
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			} // End try/catch.
		} // End try/catch.
	} // End method readFromFile.

	/**
	 * Append a file of N number of random ints.
	 * @param arrayOfIntegers is an array of ints
	 */
	public static void writeToFile(int[] arrayOfIntegers) {
		// Print writer for file output.
		PrintWriter printWriter = null;

		try {
			// Assign to output file.
			printWriter = new PrintWriter(new FileWriter("numbers.txt", true));

			// Print the array.
			printWriter.println("\nNumbers: ");
			printWriter.print(Arrays.toString(arrayOfIntegers));

			// Print the sorted array.
			printWriter.println("\nSorted Numbers: ");
			Arrays.sort(arrayOfIntegers);
			printWriter.print(Arrays.toString(arrayOfIntegers));

			// Print the statistics.
			printWriter.println("\n");
			writeStats(printWriter, arrayOfIntegers);

			// Catch and print an error message.
		} catch (IOException e) {
			System.err.println("Error " + e.getMessage());

		} finally {
			try {
				// Confirm the print writer has a value and close it.
				assert printWriter != null;
				printWriter.close();

				// Catch and print an error message.
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			} // End try/catch.
		} // End try/catch.
	} // End method writeToFile.

	/**
	 * Write statistics of an array of ints to a file.
	 * @param printWriter is a print writer object
	 * @param array is an array of ints
	 */
	public static void writeStats(PrintWriter printWriter, int[] array ) {
		int odd = 0;
		int even = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		double sum = 0;

		for (int num : array) {
			// Calc iterations for odd and even.
			odd += num % 2 != 0 ? 1 : 0;
			even += num % 2 == 0 ? 1 : 0;

			// Calc min and max.
			min = Math.min(num, min);
			max = Math.max(num, max);

			// Sum the array for mean.
			sum += num;
		} // End for loop.

		// Print the stats to the output file.
		printWriter.println("Number of odd numbers: " + odd);
		printWriter.println("Number of even numbers: " + even);
		printWriter.println("Smallest number: " + min);
		printWriter.println("Largest number: " + max);
		printWriter.println("Mean: " + sum/array.length);
	} // End method writeStats.

	/**
	 * Main method used to execute the FileIO class.
	 * @param args are the command-line arguments as an array of strings
	 */
	public static void main(String[] args) {
		// Declare the integer array to use for the rest of the program.
		int[] arrayOfIntegers = new int[createFile()];
		readFromFile(arrayOfIntegers);
		writeToFile(arrayOfIntegers);
	} // End method main.

} // End class FileIO.