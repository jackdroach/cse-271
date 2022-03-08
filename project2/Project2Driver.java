import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jack Roach
 * Date: Mar 4, 2022
 * Class: CSE 271 - E
 * File: Project2Driver.java
 */
public class Project2Driver {

    /**
     * The main method for testing
     *
     * @param args is an array of Strings
     */
    public static void main(String[] args) {
        writeAccountsToFile(readAccountsFromFile("accounts.txt"), "accounts");
    }

    /**
     * Reads Accounts from a file.
     *
     * @param fileName is a String
     * @return read array of Accounts
     */
    public static Account[] readAccountsFromFile(String fileName) {
        ArrayList<Account> accounts = new ArrayList<>();

        Scanner scan = null;
        try {
            scan = new Scanner(new File(fileName));

            while (scan.hasNext()) {
                String[] parts = scan.nextLine().split(", ");

                accounts.add(new Account(new Customer(parts[2], new Address(
                    Integer.parseInt(parts[3].split(" ", 2)[0]),
                    parts[3].split(" ", 2)[1], parts[4], parts[5], parts[6]),
                    parts[7]), Double.parseDouble(parts[8])));
            }
        } catch (FileNotFoundException e) {
            return new Account[]{};
        } finally {
            try {
                assert scan != null;
                scan.close();
            } catch (Exception e) {
                return new Account[]{};
            }
        }

        return accounts.toArray(new Account[0]);
    }

    /**
     * Writes Accounts to a file.
     *
     * @param accounts is an array of Accounts
     * @param fileName is a String
     * @return true if successful, false otherwise
     */
    public static boolean writeAccountsToFile(Account[] accounts,
        String fileName) {
        PrintWriter write = null;

        try {
            write = new PrintWriter(new FileWriter(fileName));

            for (Account account : accounts) {
                write.println(account.toString());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            try {
                assert write != null;
                write.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        return true;
    }

}