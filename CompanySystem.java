import java.util.ArrayList;

// Employee class (Exists only within Department)
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("   Employee: " + name);
    }
}

// Department class (Exists only within Company)
class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void display() {
        System.out.println(" Department: " + name);
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).display();
        }
    }
}

// Company class (Deleting Company deletes all Departments and Employees)
class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getName().equals(deptName)) {
                departments.get(i).addEmployee(empName);
                return;
            }
        }
    }


    public void display() {
        System.out.println("Company: " + name);
        for (int i = 0; i < departments.size(); i++) {
            departments.get(i).display();
        }
    }
}

// Main class to demonstrate Composition
public class CompanySystem {
    public static void main(String[] args) {
        Company capgemini = new Company("Capgemini");

        capgemini.addDepartment("IT");
        capgemini.addDepartment("HR");

        capgemini.addEmployeeToDepartment("IT", "Madhav Aggarwal");
        capgemini.addEmployeeToDepartment("IT", "Rahul Sharma");
        capgemini.addEmployeeToDepartment("HR", "Aman Verma");

        capgemini.display(); // Show Company, Departments, and Employees
    }
}
