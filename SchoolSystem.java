import java.util.ArrayList;

// Course class (Can exist independently)
class Course {
    private String name;
    private ArrayList<Student> students;  // Many-to-Many relationship

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + name + " has students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("  - " + students.get(i).getName());
        }
    }
}

// Student class (Can exist independently)
class Student {
    private String name;
    private ArrayList<Course> courses;  // Many-to-Many relationship

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);  // Bidirectional association
    }

    public void displayEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("  - " + courses.get(i).getName());
        }
    }
}

// School class (Aggregation: contains multiple Students)
class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name + " has students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("  - " + students.get(i).getName());
        }
    }
}

// Main class to demonstrate Association & Aggregation
public class SchoolSystem {
    public static void main(String[] args) {
        // Create School
        School school = new School("Chitkara University");

        // Create Students
        Student s1 = new Student("Madhav Aggarwal");
        Student s2 = new Student("Rahul Sharma");

        // Create Courses
        Course java = new Course("Java Programming");
        Course dbms = new Course("Database Management");

        // Students enroll in courses
        s1.enrollInCourse(java);
        s1.enrollInCourse(dbms);
        s2.enrollInCourse(dbms);

        // Add Students to School (Aggregation)
        school.addStudent(s1);
        school.addStudent(s2);

        // Display Results
        school.displayStudents();
        s1.displayEnrolledCourses();
        s2.displayEnrolledCourses();
        java.displayEnrolledStudents();
        dbms.displayEnrolledStudents();
    }
}
