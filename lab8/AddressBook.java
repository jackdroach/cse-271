import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

    public AddressBook() {
        constructDisplay();
    }

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

    public void constructFields() {
        nameLabel = new JLabel("Name:    ");

        nameField = new JTextField();
        nameField.setColumns(44);

        addressLabel = new JLabel("Address:");

        addressField = new JTextField();
        addressField.setColumns(44);

        phoneLabel = new JLabel("Phone:   ");

        phoneField = new JTextField();
        phoneField.setColumns(44);

        emailLabel = new JLabel("Email:    ");

        emailField = new JTextField();
        emailField.setColumns(44);
    }

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

    public void readContactsFromFile() {
        Scanner scan = null;
        StringBuilder strBuilder = new StringBuilder();

        try {
            scan = new Scanner(new File("contacts.txt"));

            while (scan.hasNext()) {
                strBuilder.append(scan.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
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

    public void constructTextArea() {
        textArea = new JTextArea();
        textArea.setRows(20);
        textArea.setColumns(50);
        textArea.setEditable(false);
    }

    public void writeContactsToFile() {
        PrintWriter write = null;

        try {
            write = new PrintWriter(new FileWriter("contacts.txt"));

            write.append(textArea.getText());
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

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        addressBook.setSize(630, 550);
        addressBook.setTitle("Address Book Application");
        addressBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addressBook.setVisible(true);
    }

}