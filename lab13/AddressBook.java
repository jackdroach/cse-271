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

    public AddressBook() {
        contactList = new ArrayList<>();

        load();
        loop();
        save();
    }

    private void loop() {
        int selection;

        do {
            selection = menu();

            switch (selection) {
                case 1 -> add();
                case 2 -> remove();
                case 3 -> save();
                case 4 -> load();
                case 5 -> displayAll();
                case 6 -> search();
            }

            if (selection != 7) {
                System.out.println();
            }
        } while (selection != 7);
    }

    private int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Address Book Operations: \n"
            + "1) Add \n"
            + "2) Remove \n"
            + "3) Save \n"
            + "4) Load \n"
            + "5) Display All \n"
            + "6) Search \n"
            + "7) Exit \n"
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

        scan.close();
        return selection;
    }

    private void add() {
        Scanner scan = new Scanner(System.in);
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
                scan.close();
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

        scan.close();
    }

    private void remove() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Phone number: ");
        String phoneNumber = scan.next();

        for (Contact contact : contactList) {
            System.out.println(contact.getPhoneNumber());
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contactList.remove(contact);
                System.out.println("Contact removed.");
                scan.close();
                return;
            }
        }
    }

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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
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

    private void displayAll() {
        System.out.println();
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    private void search() {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter search parameters: ");
        String search = scan.next();

        System.out.println("Search Results:");

        for (Contact contact : contactList) {
            if (contact.toString().contains(search)) {
                System.out.println(contact);
                scan.close();
                return;
            }
        }

        scan.close();
    }

    public static void main(String[] args) {
        new AddressBook();
    }

}