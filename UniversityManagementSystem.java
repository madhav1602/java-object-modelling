import java.util.ArrayList;

// Student Class
class Studentt {
    private String name;
    private ArrayList<Coursee> Coursees;

    public Studentt(String name) {
        this.name = name;
        this.Coursees = new ArrayList<>();
    }
    public String getName(){
        return name;
    }

    public void enrollCoursee(Coursee Coursee) {
        Coursees.add(Coursee);
        Coursee.addStudent(this); // Establishing bidirectional association
    }

    public void displayCoursees() {
        System.out.println("Student: " + name);
        System.out.println("Enrolled Coursees:");
        for (int i = 0; i < Coursees.size(); i++) {
            System.out.println("  - " + Coursees.get(i).getCourseeName());
        }
    }
}

// Professor Class
class Professor {
    private String name;
    private ArrayList<Coursee> Coursees;

    public Professor(String name) {
        this.name = name;
        this.Coursees = new ArrayList<>();
    }
    public String getName(){
        return name;
    }

    public void assignCoursee(Coursee Coursee) {
        Coursees.add(Coursee);
        Coursee.setProfessor(this);
    }

    public void displayCoursees() {
        System.out.println("Professor: " + name);
        System.out.println("Teaching Coursees:");
        for (int i = 0; i < Coursees.size(); i++) {
            System.out.println("  - " + Coursees.get(i).getCourseeName());
        }
    }
}

// Coursee Class (Aggregates Students and has an Association with a Professor)
class Coursee {
    private String CourseeName;
    private Professor professor;
    private ArrayList<Studentt> students;

    public Coursee(String CourseeName) {
        this.CourseeName = CourseeName;
        this.students = new ArrayList<>();
    }

    public String getCourseeName() {
        return CourseeName;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Studentt student) {
        students.add(student);
    }

    public void displayDetails() {
        System.out.println("Coursee: " + CourseeName);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Enrolled Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("  - " + students.get(i).getName());
        }
    }
}

// Main Class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating Coursees
        Coursee c1 = new Coursee("Data Structures");
        Coursee c2 = new Coursee("Operating Systems");

        // Creating Professor
        Professor p1 = new Professor("Dr. Sharma");
        Professor p2 = new Professor("Dr. Verma");

        // Assigning Coursees to Professors
        p1.assignCoursee(c1);
        p2.assignCoursee(c2);

        // Creating Students
        Studentt s1 = new Studentt("Madhav");
        Studentt s2 = new Studentt("Amit");

        // Enrolling Students in Coursees
        s1.enrollCoursee(c1);
        s2.enrollCoursee(c1);
        s1.enrollCoursee(c2);

        // Displaying Details
        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
        System.out.println();
        s1.displayCoursees();
        System.out.println();
        s2.displayCoursees();
        System.out.println();
        p1.displayCoursees();
        System.out.println();
        p2.displayCoursees();
    }
}
