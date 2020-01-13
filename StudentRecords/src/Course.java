
/**
 *
 * Course class stores information about a course
 */
public class Course {

    private String CourseCode;
    private int Grade;
    private String CourseDescription;

    /**
     *
     * construct Course
     */
    public Course(String CourseCode, int Grade, String CourseDescription) {
        this.CourseCode = CourseCode;
        this.Grade = Grade;
        this.CourseDescription = CourseDescription;
    }

    /**
     *
     * return code
     */
    public String getCourseCode() {
        return CourseCode;
    }

    /**
     *
     * assign CourseCode
     */
    public void setCourseCode(String CourseCode) {
        this.CourseCode = CourseCode;
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
     * return description
     */
    public String getCourseDescription() {
        return CourseDescription;
    }

    /**
     *
     * assign CourseDescription
     */
    public void setCourseDescription(String CourseDescription) {
        this.CourseDescription = CourseDescription;
    }

}
