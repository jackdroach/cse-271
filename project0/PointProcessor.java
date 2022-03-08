/*
 * Author: Jack Roach
 * Date: Feb 5, 2021
 * Class: CSE 271 - E
 * File: PointProcessor.java
 * Description: This is an helper class that is used to perform different
 * operations using a list of points.
 */

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a helper class that is used to perform different operations
 * using a list of points.
 */
public class PointProcessor {

    /**
     * Adds points from a file to an array list.
     * @param fileName is a String
     * @return an array list of point objects
     */
    public static ArrayList<Point> readPointsFromFile(String fileName) {
        // Declare scanner for file input.
        Scanner scan = null;

        // Get input file.
        try {
            scan = new Scanner(new File(fileName));

            // Catch and give the user an error message.
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File");
        } // End try/catch.

        ArrayList<Point> points = new ArrayList<>();

        // Add points until there are no lines left.
        while (scan.hasNext()) {
            // Make a point object and add it to the array list.
            points.add(new Point(scan.nextInt(), scan.nextInt()));
        } // End while loop.

        // Close the scan scanner.
        scan.close();

        return points;
    } // End method readPointsFromFile.

    /**
     * Distance to travel to a point.
     * @param pt is a point object
     * @return distance as an int
     */
    public static int cabDistance(Point pt) {
        return Math.abs(pt.x) + Math.abs(pt.y);
    } // End method cabDistance.

    /**
     * Print information about a point.
     * @param pt is a point object
     */
    public static void showPoint(Point pt) {
        // Print index, formatted coordinates, and distance.
        System.out.printf("(%d, %d)\t%d\n", pt.x, pt.y, cabDistance(pt));
    } // End method showPoint.

    /**
     * Print information about an array list of points.
     * @param ptList is an array list of point objects
     */
    public static void showAllPoints(ArrayList<Point> ptList) {
        // If the list is empty then print a message and end the method.
        if (ptList.isEmpty()) {
            System.out.println("Empty List");
            return;
        } // End if/else.

        for (int i = 0; i < ptList.size(); i++) {
            // Print the index and call showPoint.
            System.out.printf("[%d]", i);
            showPoint(ptList.get(i));
        } // End for loop.
    } // End method showAllPoints.

    /**
     * Match a specific distance with points that have the same distance.
     * @param ptList is an array list of point objects
     * @param dist is an int
     * @return an array list of points that match
     */
    public static ArrayList<Point> findAll(ArrayList<Point> ptList, int dist) {
        ArrayList<Point> points = new ArrayList<>();

        for (Point point : ptList) {
            // Check if the point at the index matches the distance.
            if (cabDistance(point) == dist) {
                // Add the point the the array list.
                points.add(point);
            } // End if/else.
        } // End for loop.

        return points;
    } // End method findAll.

} // End class PointProcessor.