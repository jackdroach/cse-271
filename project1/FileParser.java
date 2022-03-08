import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Parses a file for palindromes and $100 words and prints the parsed words.
 *
 * @author Jack Roach
 * Date: Feb 18, 2022
 * Class: CSE 271 - E
 */
public class FileParser {

    /**
     * The main method where the program starts running.
     *
     * @param args is an array of strings
     */
    public static void main(String[] args) {
        // Scanner for console input.
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an input file name.
        System.out.print("Enter input file name: ");
        File in = new File(scanner.next());

        // Display the menu.
        int choice = menu(scanner);

        // Prompt the user for an output file name.
        System.out.print("Enter output filename: ");
        File out = new File(scanner.next());

        switch (choice) {
            // Parse the file for raw words.
            case 1:
                parse(in, out);
                System.out.println("Finished printing raw word list.");
                break;

           // Parse the file for palindromes.
            case 2:
                parsePalindrome(in, out);
                System.out.println("Finished printing palindromes.");
                break;

            // Parse the file for $100 words.
            case 3:
                parseHundredDollarWord(in, out);
                System.out.println("Finished printing $100 words.");
                break;

            // If the user enters an invalid selection.
            default:
                System.out.println("invalid choice.");
                break;
        } // End switch.
    } // End method main.

    /**
     * Displays a selection menu to the console.
     *
     * @param scanner is a scanner
     * @return user's selection choice
     */
    public static int menu(Scanner scanner) {
        // Prompt the user to make a selection.
        System.out.println("1. Raw word list");
        System.out.println("2. Palindromes");
        System.out.println("3. $100 words");
        System.out.print("Choose: ");

        return scanner.nextInt();
    } // End method menu.

    /**
     * Remove non-letter characters from a string.
     *
     * @param word is a string
     * @return the cleaned string
     */
    public static String clean(String word) {
        String string = "";

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Check if the character is valid.
            if (Character.isLetter(ch)) {
                string += ch;
            } // End if/else.
        } // End for loop.

        return string.toUpperCase();
    } // End method clean.

    /**
     * Parses a file for words and prints those words to another file.
     *
     * @param in is a file
     * @param out is a file
     */
    public static void parse(File in, File out) {
        // Scanner for file input and print writer for file output.
        Scanner input = null;
        PrintWriter output = null;

        try {
            // Try to add the files to the input and output objects.
            input = new Scanner(in);
            output = new PrintWriter(out);

        // Catch file not found and print an error message.
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());

        } finally {
            while (input.hasNext()) {
                // Print the word to the output file.
                output.println(input.next());
            } // End while loop.

            try {
                // Try to close the input and output objects.
                input.close();
                output.close();

            // Catch exceptions and print an error message.
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } // End try/catch.
        } // End try/catch.
    } // End method parse.

    /**
     * Returns true if a word is the same in reverse.
     *
     * @param word is a string
     * @return true if palindrome, else false
     */
    public static boolean isPalindrome(String word) {
        word = clean(word);

        for (int i = 0; i < word.length(); i++) {
            // Return false if any 2 reverse side chars don't match.
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            } // End if/else.
        } // End for loop.

        return true;
    } // End method isPalindrome.

    /**
     * Parses a file for palindromes and prints those words to another file.
     *
     * @param in is a file
     * @param out is a file
     */
    public static void parsePalindrome(File in, File out) {
        // Scanner for file input and print writer for file output.
        Scanner input = null;
        PrintWriter output = null;

        try {
            // Try to add the files to the input and output objects.
            input = new Scanner(in);
            output = new PrintWriter(out);

        // Catch file not found and print an error message.
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());

        } finally {
            ArrayList<String> arrayList = new ArrayList<>();

            while (input.hasNext()) {
                String word = clean(input.next());

                // Add the word if it is a palindrome and it is unique.
                if (isPalindrome(word) && !arrayList.contains(word)) {
                    arrayList.add(word);
                } // End if/else.
            } // End while loop.

            // Sort the array.
            Collections.sort(arrayList);

            // Print the sorted array to the file.
            for (String element : arrayList) {
                output.println(element);
            } // End for loop.

            try {
                // Try to close the input and output objects.
                input.close();
                output.close();

            // Catch exceptions and print an error message.
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } // End try/catch.
        } // End try/catch.
    } // End method parsePalindrome.

    /**
     * Find the integer value of a word. A = 1 and Z = 26.
     *
     * @param word is a string
     * @return integer value of the word
     */
    public static int value(String word) {
        int sum = 0;
        word = clean(word);

        for (int i = 0; i < word.length(); i++) {
            // Add the current letter to the sum.
            sum += word.charAt(i);
        } // End for/else.

        return sum - 64 * word.length();
    } // End method value.

    /**
     * Parses a file for $100 words and prints those words to another file.
     *
     * @param in is a file
     * @param out is a file
     */
    public static void parseHundredDollarWord(File in, File out) {
        // Scanner for file input and print writer for file output.
        Scanner input = null;
        PrintWriter output = null;

        try {
            // Try to add the files to the input and output objects.
            input = new Scanner(in);
            output = new PrintWriter(out);

        // Catch file not found and print an error message.
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());

        } finally {
            ArrayList<String> arrayList = new ArrayList<>();

            while (input.hasNext()) {
                String word = clean(input.next());

                // Add the word if its value = 100 and it is unique.
                if (value(word) == 100 && !arrayList.contains(word)) {
                    arrayList.add(word);
                } // End if/else.
            } // End while loop.

            // Sort the array.
            Collections.sort(arrayList);

            // Print the sorted array to the file.
            for (String element : arrayList) {
                output.println(element);
            } // End for-each loop.

            try {
                // Try to close the input and output objects.
                input.close();
                output.close();

            // Catch exceptions and print an error message.
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } // End try/catch.
        } // End try/catch.
    } // End method parseHundredDollarWord.

} // End class FileParser.