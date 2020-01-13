
/**
 *
 * Course.java class to store Courses
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Courses {

    private ArrayList<Course> courses;

    // construct courses
    public Courses() {
        courses = new ArrayList<Course>();
        readCourses();
    }

    // add course
    public void addCourse(Course c) {
        courses.add(c);
        saveCourses();
    }

    // find course by code
    public Course findCourse(String code) {
        // write all courses to file
        for (Course c : courses) {
            if (c.getCourseCode().equals(code)) {
                return c;
            }
        }

        return null;
    }

    // get course
    public Course getCourse(int index) {
        return courses.get(index);
    }

    // return number o courses
    public int getNumCourses() {
        return courses.size();
    }

    // read courses from file
    public void readCourses() {
        try {
            // open file
            Scanner fsc = new Scanner(new File("courses.txt"));

            // scan to end of file
            while (fsc.hasNextLine()) {
                // get line in file
                String line = fsc.nextLine();

                // get fields
                String[] tokens = line.split(",");

                // add course
                courses.add(new Course(tokens[0], 
                        Integer.parseInt(tokens[1]), tokens[2]));
            }

            fsc.close(); // close file
        } // report error
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    // save courses to file
    public void saveCourses() {
        try {
            // open file
            PrintWriter pw = new PrintWriter(new File("courses.txt"));

            // write all courses to file
            for (Course c : courses) {
                pw.println(c.getCourseCode() + "," 
                        + c.getGrade() + "," + c.getCourseDescription());
            }

            pw.close(); // close file
        } // report error
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
