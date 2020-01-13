
/**
 *
 * Students.java 
 * store students
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Students {

    private ArrayList<Student> students;

    // construct students
    public Students() {
        students = new ArrayList<Student>();
        readStudents();
    }

    // add student
    public void addStudent(Student s) {
        students.add(s);

        saveStudents();
    }

    // update student at index
    public void updateStudent(int index, Student s) {
        students.set(index, s);

        saveStudents();
    }

    // get student at index
    public Student getStudent(int index) {
        return students.get(index);
    }

    // return number of students
    public int getNumStudents() {
        return students.size();
    }

    // sort alphabetically
    public ArrayList<Student> sortAlphabetically() {

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (s1.getLastName().equalsIgnoreCase(s2.getLastName())) {
                    return s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
                } else {
                    return s1.getLastName().compareToIgnoreCase(s2.getLastName());
                }
            }
        });

        return students;
    }

    // sort alphabetically
    public ArrayList<Student> sortAlphabeticallyByGrade() {

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (s1.getGrade() == s2.getGrade()) {
                    if (s1.getLastName().equalsIgnoreCase(s2.getLastName())) {
                        return s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
                    } else {
                        return s1.getLastName().compareToIgnoreCase(s2.getLastName());
                    }
                } else {
                    return s1.getGrade() - s2.getGrade();
                }
            }
        });

        return students;
    }

    // sort course by marks
    public ArrayList<Student> sortByCourse(String code) {
        ArrayList sorted = new ArrayList();

        for (Student s : students) {
            if (s.hasCourse(code)) {
                sorted.add(s);
            }
        }

        Collections.sort(sorted, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (s1.getAverage() > s2.getAverage()) {
                    return -1;
                } else if (s1.getAverage() < s2.getAverage()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return sorted;
    }

    // sort grade by marks
    public ArrayList<Student> sortByGrade(int grade) {
        ArrayList sorted = new ArrayList();

        // get grade
        for (Student s : students) {
            if (s.getGrade() == grade) {
                sorted.add(s);
            }
        }

        Collections.sort(sorted, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (s1.getAverage() > s2.getAverage()) {
                    return -1;
                } else if (s1.getAverage() < s2.getAverage()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return sorted;
    }

    // sort grade by marks
    public ArrayList<Student> sortByGrade() {
        ArrayList sorted = new ArrayList();

        // get grade
        for (Student s : students) {

            sorted.add(s);
        }

        Collections.sort(sorted, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (s1.getAverage() > s2.getAverage()) {
                    return -1;
                } else if (s1.getAverage() < s2.getAverage()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return sorted;
    }

    // sort course by marks
    public ArrayList<Student> sortByCourseGrade(String code, int grade) {
        ArrayList sorted = new ArrayList();

        for (Student s : students) {
            if (s.hasCourse(code) && s.getGrade() == grade) {
                sorted.add(s);
            }
        }

        Collections.sort(sorted, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                if (s1.getAverage() > s2.getAverage()) {
                    return -1;
                } else if (s1.getAverage() < s2.getAverage()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return sorted;
    }

    // sort alphabetically
    public ArrayList<Student> sortByAge() {

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                return s1.getAge() - s2.getAge();
            }
        });

        return students;
    }

    // read students from file
    public void readStudents() {
        try {
            // open file
            Scanner fsc = new Scanner(new File("students.txt"));

            // scan to end of file
            while (fsc.hasNextLine()) {
                // get line in file
                String line = fsc.nextLine();

                // get fields
                String[] tokens = line.split(",");

                // add student
                Student s = new Student(tokens[0], tokens[1], tokens[2],
                        tokens[3], tokens[4], tokens[5], tokens[6], tokens[7],
                        tokens[8], tokens[9], Integer.parseInt(tokens[10]));

                students.add(s);
                // get courses
                line = fsc.nextLine();

                // get fields
                tokens = line.split(",");

                // get number of courses
                int numCourses = Integer.parseInt(tokens[0]);

                for (int i = 0, k = 1; i < numCourses; i++) {
                    s.setCourse(i, tokens[k++]);
                    s.setMark(i, Double.parseDouble(tokens[k++]));
                }

                // calculate age and average
                s.calculateAge();
                s.calculateAverage();
            }

            fsc.close(); // close file
        } // report error
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // find student number
    public int findStudentNumber(String number) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNumber().equals(number)) {
                return i;
            }
        }

        return -1;
    }

    // find student surname
    public int findStudentSurname(String surname) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getLastName().equals(surname)) {
                return i;
            }
        }

        return -1;
    }

    // save students to file
    public void saveStudents() {
        try {
            // open file
            PrintWriter pw = new PrintWriter(new File("students.txt"));

            // write all students to file
            for (Student s : students) {
                pw.println(s.getFirstName() + ","
                        + s.getLastName() + ","
                        + s.getStreetAddress() + ","
                        + s.getCity() + ","
                        + s.getProvince() + ","
                        + s.getPostalCode() + ","
                        + s.getStudentNumber() + ","
                        + s.getHomePhoneNumber() + ","
                        + s.getDateofBirth() + ","
                        + s.getGender() + ","
                        + s.getGrade());

                pw.print(s.getNumCourses() + ",");
                int i = 0;
                for (i = 0; i < s.getNumCourses() - 1; i++) {
                    pw.print(s.getCourse(i) + "," + s.getMark(i) + ",");
                }

                pw.print(s.getCourse(i) + "," + s.getMark(i));
                pw.println("");

            }

            pw.close(); // close file
        } // report error
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
