import java.util.ArrayList;

// Faculty class (Can exist independently)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class (Exists only within a University → Composition)
class Departmentt {
    private String name;

    public Departmentt(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// University class (Composition: Contains Departments, Aggregation: Contains Faculty)
class University {
    private String name;
    private ArrayList<Departmentt> departments; // Composition
    private ArrayList<Faculty> faculties; // Aggregation

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Adding Departments (Composition)
    public void addDepartment(String deptName) {
        departments.add(new Departmentt(deptName));
    }

    // Adding Faculty (Aggregation)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display University details
    public void displayDetails() {
        System.out.println("University: " + name);

        // Display Departments
        System.out.println("Departments:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println("  - " + departments.get(i).getName());
        }

        // Display Faculty
        System.out.println("Faculty Members:");
        for (int i = 0; i < faculties.size(); i++) {
            System.out.println("  - " + faculties.get(i).getName());
        }
    }
}

// Main class to demonstrate Composition & Aggregation
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating University
        University uni = new University("Chitkara University");

        // Adding Departments (Composition)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Electronics");

        // Creating Faculty members (Independent of University)
        Faculty f1 = new Faculty("Dr. A Sharma");
        Faculty f2 = new Faculty("Prof. R Mehta");

        // Adding Faculty to University (Aggregation)
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Displaying University Details
        uni.displayDetails();

        // Deleting University (Departments should be deleted, Faculty still exists)
        uni = null;
        System.out.println("\nUniversity deleted! Departments are gone, but Faculty still exists.");
        System.out.println("Faculty members still exist: " + f1.getName() + ", " + f2.getName());
    }
}
