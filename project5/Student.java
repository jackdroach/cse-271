import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jack Roach
 * Date: May 1, 2022
 * Class: CSE 271 - E
 */
public class Student implements Comparable<Student> {

    private int id;
    private String firstName;
    private String lastName;
    private int grade;

    /**
     * Default constructor. Instantiates a new StudentRecord.
     */
    public Student(int id, String firstName, String lastName, int grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Student s) {
        return Integer.compare(grade, s.grade);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }

        Student s = (Student) o;
        return id == s.id;
    }

    /**
     * Read Students from a file.
     *
     * @param filePath File name
     * @return array of Students
     */
    public static Student[] readFromFile(String filePath) {
        Scanner scan = null;
        List<Student> list = new ArrayList<>();

        try {
            scan = new Scanner(new File(filePath));

            while (scan.hasNext()) {
                String[] array = scan.nextLine().split(",");
                list.add(new Student(Integer.parseInt(array[0]), array[1],
                    array[2], Integer.parseInt(array[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (scan != null) {
                    scan.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list.toArray(new Student[0]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %d", id, firstName, lastName, grade);
    }

    /**
     * Sorts an array of Students.
     *
     * @param students array of Students
     */
    public static void sort(Student[] students) {
        if (students == null || students.length < 2) {
            return;
        }

        for (int i = 1; i < students.length; i++) {
            Student temp = students[i];
            int j = i;

            while (j > 0 && students[j - 1].compareTo(temp) > 0) {
                students[j] = students[--j];
            }

            students[j] = temp;
        }
    }

    /**
     * Searches an array of Students.
     *
     * @param students array of Students
     * @param s Student to search for
     * @return Student index, -1 if not found
     */
    public static int search(Student[] students, Student s) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(s)) {
                return i;
            }
        }

        return -1;
    }

}