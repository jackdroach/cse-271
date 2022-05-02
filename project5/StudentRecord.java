import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author Jack Roach
 * Date: May 1, 2022
 * Class: CSE 271 - E
 */
public class StudentRecord extends JFrame {

    private Student[] studentArray;
    private JTextField searchField;
    private JTextField displayField;
    private JButton loadData;
    private JButton sortRecords;
    private JButton findStudent;
    private JTextArea textArea;

    /**
     * Default constructor. Instantiates a new StudentRecord.
     */
    public StudentRecord() {
        constructDisplay();
    }

    /**
     * Constructs the StudentRecord display.
     */
    private void constructDisplay() {
        constructButtons();
        constructFields();
        constructTextArea();
        constructTopPanel();
        constructMiddlePanel();
        constructBottomPanel();
    }

    /**
     * Constructs a JPanel for the StudentRecord.
     */
    private void constructTopPanel() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.PAGE_START);
        panel.setBorder(new TitledBorder("Control Panel"));
        panel.add(loadData);
        panel.add(sortRecords);
        panel.add(findStudent);
        panel.add(searchField);
    }

    /**
     * Constructs a JPanel for the StudentRecord.
     */
    private void constructMiddlePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Individual Student Record"));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.add(displayField);
    }

    /**
     * Constructs a JPanel for the StudentRecord.
     */
    private void constructBottomPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("All Student Records"));
        getContentPane().add(panel, BorderLayout.PAGE_END);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
    }

    /**
     * Constructs JButtons
     */
    private void constructButtons() {
        loadData = new JButton("Load Data");
        loadData.addActionListener(e -> {
            studentArray = Student.readFromFile("MOCK_DATA.csv");
            displayAllRecords();
        });

        sortRecords = new JButton("Sort Records");
        sortRecords.addActionListener(e -> {
            Student.sort(studentArray);
            displayAllRecords();
        });

        findStudent = new JButton("Find Student");
        findStudent.addActionListener(e -> {
            int index = Student.search(studentArray, new Student(
                Integer.parseInt(searchField.getText()), "", "", 0));

            displayField.setText(String.format("%s, Index = %d",
                studentArray[index].toString(), index + 1));
        });
    }

    /**
     * Constructs a JTextFields for the StudentRecord.
     */
    private void constructFields() {
        searchField = new JTextField();
        searchField.setColumns(15);

        displayField = new JTextField();
        displayField.setColumns(50);
        displayField.setEditable(false);
    }

    /**
     * Constructs a JTextArea for the StudentRecord.
     */
    private void constructTextArea() {
        textArea = new JTextArea();
        textArea.setRows(31);
        textArea.setColumns(50);
        textArea.setEditable(false);
    }

    /**
     * Display an array of Students in the JTextArea.
     */
    private void displayAllRecords() {
        StringBuilder strBuilder = new StringBuilder();
        for (Student s : studentArray) {
            strBuilder.append(s.toString()).append("\n");
        }

        textArea.setText(strBuilder.toString());
    }

    /**
     * The main method of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord();

        studentRecord.setSize(600, 700);
        studentRecord.setTitle("Student Searcher and Sorter");
        studentRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentRecord.setVisible(true);
    }

}