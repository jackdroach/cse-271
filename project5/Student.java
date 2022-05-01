import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements Comparable<Student> {
    private int id;
    private String firstName;
    private String lastName;
    private int grade;

    public Student(int id, String firstName, String lastName, int grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(grade, s.grade);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }

        Student s = (Student) o;
        return grade == s.grade;
    }

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

    public static int search(Student[] students, Student s) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].compareTo(s) == 0) {
                return i;
            }
        }

        return -1;
    }

}