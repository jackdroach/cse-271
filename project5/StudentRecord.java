import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.border.TitledBorder;

public class StudentRecord extends JFrame {

    private Student[] studentArray;
    private JButton loadData;
    private JButton sortRecords;
    private JButton findStudents;
    private JTextField searchField;
    private JTextField


    /**
     * Default constructor. Instantiates a new StudentRecord.
     */
    public StudentRecord() {
        constructDisplay();
    }

    /**
     * Constructs new JPanels to add to the AddressBook.
     */
    private void constructDisplay() {
        constructFields();
        constructTopPanel();

        constructButtons();
        constructMiddlePanel();

        constructTextArea();
        constructBottomPanel();

        readContactsFromFile();
    }

    /**
     * Constructs a new JPanel to add to the AddressBook.
     */
    private void constructTopPanel() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.PAGE_START);
        panel.setLayout(new GridLayout(0, 2));
        panel.setBorder(new TitledBorder("Enter New Contact Information"));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(emailLabel);
        panel.add(emailField);
    }

    /**
     * Constructs a new JPanel to add to the AddressBook.
     */
    private void constructMiddlePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
        panel.setBorder(new TitledBorder("Add New Contact or Save to File"));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.add(addContact);
        panel.add(saveToFile);
    }

    /**
     * Constructs a new JPanel to add to the AddressBook.
     */
    private void constructBottomPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Saved Contacts"));
        getContentPane().add(panel, BorderLayout.PAGE_END);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
    }

    /**
     * Constructs JLabels and JTextFields to add to the JPanel.
     */
    private void constructFields() {
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        addressLabel = new JLabel("Address:");
        addressField = new JTextField();

        phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();

        emailLabel = new JLabel("Email:");
        emailField = new JTextField();
    }

    /**
     * Constructs JButtons to add to the JPanel.
     */
    private void constructButtons() {
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
    private void constructTextArea() {
        textArea = new JTextArea();
        textArea.setRows(17);
        textArea.setColumns(40);
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
        StudentRecord studentRecord = new StudentRecord();

        studentRecord.setSize(630, 550);
        studentRecord.setTitle("Address Book Application");
        studentRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentRecord.setVisible(true);
    }


}