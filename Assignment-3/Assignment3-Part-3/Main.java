/**
 * Driver class for testing the Hospital Scheduling System.
 */
public class Main {


    public static void main(String[] args) {
        // Create the hospital.
        Hospital hospital = new Hospital();

        // Add patients.
        hospital.addPatient(new Patient(1, 0, 5, 2));
        hospital.addPatient(new Patient(2, 1, 3, 4));
        hospital.addPatient(new Patient(3, 2, 2, 9));
        hospital.addPatient(new Patient(4, 3, 4, 7));
        hospital.addPatient(new Patient(5, 5, 2, 7));
        hospital.addPatient(new Patient(6, 5, 3, 7));
        hospital.addPatient(new Patient(7, 10, 1, 10));

        // Edge Case : Null Patient
        hospital.addPatient(null);
        System.out.println("======================================");
        System.out.println(" HOSPITAL PATIENT SCHEDULING SYSTEM ");
        System.out.println("======================================\n");

        // Start simulation.
        hospital.treatPatients();
    }
}