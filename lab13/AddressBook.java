import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jack Roach
 * Date: May 1, 2022
 * Class: CSE 271 - E
 */
public class AddressBook {

    private List<Contact> contactList;
    private Scanner scan;

    /**
     * Default constructor. Instantiates a new AddressBook.
     */
    public AddressBook() {
        contactList = new ArrayList<>();
        scan = new Scanner(System.in);

        load();
        loop();
        save();
        scan.close();
    }

    /**
     * Loops the program until the user exits.
     */
    private void loop() {
        int selection;

        do {
            selection = menu();

            switch (selection) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    save();
                    break;
                case 4:
                    load();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    search();
                    break;
            }

            if (selection != 7) {
                System.out.println();
            }
        } while (selection != 7);
    }

    /**
     * Selection menu for the user to pick an operation.
     *
     * @return user selection
     */
    private int menu() {
        System.out.print("Address Book Operations: \n"
            + "1) Add\n"
            + "2) Remove\n"
            + "3) Save\n"
            + "4) Load\n"
            + "5) Display All\n"
            + "6) Search\n"
            + "7) Exit\n"
            + "Select an option (number): ");

        int selection;

        while (true) {
            try {
                selection = scan.nextInt();

                if (selection > 7 || selection < 1) {
                    System.out.println("Must be 1 - 7.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Not an integer.");
                scan.next();
            }

            System.out.print("Select an option (number): ");
        }

        return selection;
    }

    /**
     * Adds a contact to an ArrayList of Contacts.
     */
    private void add() {
        Contact c = new Contact();

        System.out.print("First name: ");
        c.setFirstName(scan.next());

        System.out.print("Last name: ");
        c.setLastName(scan.next());

        System.out.print("Phone number: ");
        String phoneNumber = scan.next();

        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact already exists.");
                
                return;
            }
        }

        c.setPhoneNumber(phoneNumber);

        System.out.print("Email: ");
        c.setEmail(scan.next());

        System.out.print("Address: ");
        c.setAddress(scan.next());

        contactList.add(c);
        System.out.println("Contact added.");
    }

    /**
     * Removes a contact from an ArrayList of Contacts.
     */
    private void remove() {
        System.out.print("Phone number: ");
        String phoneNumber = scan.next();

        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contactList.remove(contact);
                System.out.println("Contact removed.");
                return;
            }
        }
    }

    /**
     * Saves an ArrayList of Contacts to a .bin file.
     */
    private void save() {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("AddressBook.bin"));
            oos.writeObject(contactList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("Saved.");
    }

    /**
     * Loads an ArrayList of Contacts from a .bin file.
     */
    private void load() {
        if (!Files.exists(Paths.get("AddressBook.bin"))) {
            try {
                Files.createFile(Paths.get("AddressBook.bin"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("AddressBook.bin"));
            contactList = (ArrayList<Contact>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ignored) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(Exception ignored) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("Loaded.");
    }

    /**
     * Displays an ArrayList of Contacts.
     */
    private void displayAll() {
        System.out.println();
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    /**
     * Searches an ArrayList of Contacts.
     */
    private void search() {
        System.out.println();
        System.out.print("Enter search parameters: ");
        String search = scan.next();

        System.out.println("Search Results:");

        for (Contact contact : contactList) {
            if (contact.toString().contains(search)) {
                System.out.println(contact);
                return;
            }
        }
    }

    /**
     * The main method of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        new AddressBook();
    }

}