import java.util.ArrayList;

// Patient class
class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Doctor class (Consults multiple patients)
class Doctor {
    private String name;
    private ArrayList<Patient> patients; // List of patients consulted by the doctor

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Consult a patient (Association)
    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " is consulting " + patient.getName());
    }

    // Display patients consulted by this doctor
    public void showPatients() {
        System.out.println("Dr. " + name + "'s Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println("  - " + patients.get(i).getName());
        }
    }
}

// Hospital class (Contains Doctors and Patients)
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add Doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Add Patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Display Hospital Details
    public void displayDetails() {
        System.out.println("Hospital: " + name);

        // Display Doctors
        System.out.println("Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println("  - " + doctors.get(i).getName());
        }

        // Display Patients
        System.out.println("Patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println("  - " + patients.get(i).getName());
        }
    }
}

// Main class to demonstrate Association & Communication
public class HospitalSystem {
    public static void main(String[] args) {
        // Creating Hospital
        Hospital hospital = new Hospital("Apollo Hospital");

        // Creating Doctors
        Doctor d1 = new Doctor("Sharma");
        Doctor d2 = new Doctor("Mehta");

        // Creating Patients
        Patient p1 = new Patient("Rahul");
        Patient p2 = new Patient("Ananya");
        Patient p3 = new Patient("Karan");

        // Adding Doctors & Patients to Hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);

        // Consultations (Many-to-Many Association)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p2);
        d2.consult(p3);

        // Display Hospital Details
        System.out.println();
        hospital.displayDetails();

        // Display Consultations
        System.out.println();
        d1.showPatients();
        d2.showPatients();
    }
}
