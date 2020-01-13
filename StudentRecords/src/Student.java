
/**
 *
 * Student class stores information about a student
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student {

    public final static int NUM_COURSES = 8;
    private String FirstName;
    private String LastName;
    private String StreetAddress;
    private String City;
    private String Province;
    private String PostalCode;
    private String StudentNumber;
    private String HomePhoneNumber;
    private String DateofBirth;
    private String Gender;
    private int Grade;
    // calculate age from date of birth
    private int Age;
    // Eight possible courses with eight marks
    private String[] Courses = new String[NUM_COURSES];
    private double[] Marks = new double[NUM_COURSES];
    private int NumCourses;
    // the student's average for the courses that have marks
    private double Average;

    // default student
    public Student() {
        this.FirstName = "";
        this.LastName = "";
        this.StreetAddress = "";
        this.City = "";
        this.Province = "";
        this.PostalCode = "";
        this.StudentNumber = "";
        this.HomePhoneNumber = "";
        this.DateofBirth = "";
        this.Gender = "";
        this.Grade = 0;

        // clear courses
        for (int i = 0; i < Courses.length; i++) {
            Courses[i] = "";
            Marks[i] = 0.0;
        }
    }

    // construct student
    public Student(String FirstName, String LastName, String StreetAddress,
            String City, String Province, String PostalCode,
            String StudentNumber, String HomePhoneNumber, String DateofBirth,
            String Gender, int Grade) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.StreetAddress = StreetAddress;
        this.City = City;
        this.Province = Province;
        this.PostalCode = PostalCode;
        this.StudentNumber = StudentNumber;
        this.HomePhoneNumber = HomePhoneNumber;
        this.DateofBirth = DateofBirth;
        this.Gender = Gender;
        this.Grade = Grade;

        // clear courses
        for (int i = 0; i < Courses.length; i++) {
            Courses[i] = "";
            Marks[i] = 0.0;
        }
    }

    /**
     *
     * return first name
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     *
     * assign FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     *
     * return address
     */
    public String getStreetAddress() {
        return StreetAddress;
    }

    /**
     *
     * assign StreetAddress
     */
    public void setStreetAddress(String StreetAddress) {
        this.StreetAddress = StreetAddress;
    }

    /**
     *
     * return city
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * assign City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * return province
     */
    public String getProvince() {
        return Province;
    }

    /**
     *
     * assign Province
     */
    public void setProvince(String Province) {
        this.Province = Province;
    }

    /**
     * return postal code
     */
    public String getPostalCode() {
        return PostalCode;
    }

    /**
     *
     * assign PostalCode
     */
    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    /**
     *
     * return number
     */
    public String getStudentNumber() {
        return StudentNumber;
    }

    /**
     *
     * assign StudentNumber
     */
    public void setStudentNumber(String StudentNumber) {
        this.StudentNumber = StudentNumber;
    }

    /**
     *
     * return phone number
     */
    public String getHomePhoneNumber() {
        return HomePhoneNumber;
    }

    /**
     *
     * assign HomePhoneNumber
     */
    public void setHomePhoneNumber(String HomePhoneNumber) {
        this.HomePhoneNumber = HomePhoneNumber;
    }

    /**
     *
     * return date of birth
     */
    public String getDateofBirth() {
        return DateofBirth;
    }

    /**
     *
     * assign DateofBirth
     */
    public void setDateofBirth(String DateofBirth) {
        this.DateofBirth = DateofBirth;
    }

    /**
     *
     * return gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     *
     * assign Gender
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     *
     * return grade
     */
    public int getGrade() {
        return Grade;
    }

    /**
     *
     * assign Grade
     */
    public void setGrade(int Grade) {
        this.Grade = Grade;
    }

    /**
     *
     * return age
     */
    public int getAge() {
        return Age;
    }

    /**
     *
     * return average
     */
    public double getAverage() {
        return Average;
    }

    /**
     *
     * return number courses
     */
    public int getNumCourses() {
        return NumCourses;
    }

    /**
     *
     * return last name
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * assign LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     *
     * return course at index
     */
    public String getCourse(int index) {
        return Courses[index];
    }

    /**
     *
     * at index assign course
     */
    public void setCourse(int index, String course) {
        this.Courses[index] = course;
    }

    /**
     *
     * return mark at index
     */
    public double getMark(int index) {
        return Marks[index];
    }

    /**
     *
     * assign index assign mark
     */
    public void setMark(int index, double mark) {
        this.Marks[index] = mark;
    }

    /**
     * calculate age from date of birth
     */
    public int calculateAge() throws ParseException {

        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        Date dateOfBirth = df.parse(DateofBirth);
        Date today = new Date();
        long diffAsLong = today.getTime() - dateOfBirth.getTime();
        Calendar diffAsCalendar = Calendar.getInstance();
        diffAsCalendar.setTimeInMillis(diffAsLong);
        Age = diffAsCalendar.get(Calendar.YEAR) - 1970; // 
        return Age;
    }

    // return true i has coursw
    public boolean hasCourse(String code) {
        for (int i = 0; i < Courses.length; i++) {
            if (Courses[i].equals(code)) {
                return true;
            }
        }
        return false;
    }

    /*
     * calculate average frim marks
     */
    public double calculateAverage() {
        NumCourses = 0;
        double sum = 0;
        Average = 0;

        // sum marks
        for (int i = 0; i < Courses.length; i++) {
            if (!Courses[i].equals("")) {
                sum += Marks[i];
                NumCourses++;
            }

        }

        // calculate average
        if (NumCourses > 0) {
            Average = sum / NumCourses;
        }

        return Average;
    }

}
