import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Jack Roach
 * Date: Mar 27, 2022
 * Class: CSE 271 - E
 */
public class AddressBook extends JFrame {

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JButton addContact;
    private JButton saveToFile;
    private JTextArea textArea;

    /**
     * Default constructor. Instantiates a new AddressBook.
     */
    public AddressBook() {
        constructDisplay();
    }

    /**
     * Constructs a new JPanel to add to the AddressBook.
     */
    private void constructDisplay() {
        JPanel panel = new JPanel();

        constructFields();

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(emailLabel);
        panel.add(emailField);

        constructButtons();

        panel.add(addContact);
        panel.add(saveToFile);

        constructTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        this.add(panel);

        readContactsFromFile();
    }

    /**
     * Constructs JLabels and JTextFields to add to the JPanel.
     */
    public void constructFields() {
        nameLabel = new JLabel("Name:     ");

        nameField = new JTextField();
        nameField.setColumns(46);

        addressLabel = new JLabel("Address:");

        addressField = new JTextField();
        addressField.setColumns(46);

        phoneLabel = new JLabel("Phone:    ");

        phoneField = new JTextField();
        phoneField.setColumns(46);

        emailLabel = new JLabel("Email:     ");

        emailField = new JTextField();
        emailField.setColumns(46);
    }

    /**
     * Constructs JButtons to add to the JPanel.
     */
    public void constructButtons() {
        addContact = new JButton("Add Contact");
        addContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(nameField.getText() + ", " +
                    addressField.getText() + ", " + phoneField.getText() + ", "
                    + emailField.getText() + "\n");
            }
        });

        saveToFile = new JButton("Save to File");
        saveToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeContactsToFile();
            }
        });
    }

    /**
     * Constructs a JTextArea to add to the JPanel.
     */
    public void constructTextArea() {
        textArea = new JTextArea();
        textArea.setRows(20);
        textArea.setColumns(52);
        textArea.setEditable(false);
    }

    /**
     * Reads contacts from a file and adds it to the AddressBook.
     */
    public void readContactsFromFile() {
        File file;
        Scanner scan = null;
        StringBuilder strBuilder = new StringBuilder();

        try {
            file = new File("contacts.txt");
            file.createNewFile();
            scan = new Scanner(file);

            while (scan.hasNext()) {
                strBuilder.append(scan.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert scan != null;
                scan.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        textArea.setText(strBuilder.toString());
    }

    /**
     * Writes the AddressBook contacts to a file.
     */
    public void writeContactsToFile() {
        PrintWriter write = null;

        try {
            write = new PrintWriter("contacts.txt");

            write.print(textArea.getText());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert write != null;
                write.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * The main method of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        addressBook.setSize(630, 550);
        addressBook.setTitle("Address Book Application");
        addressBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addressBook.setVisible(true);
    }

}