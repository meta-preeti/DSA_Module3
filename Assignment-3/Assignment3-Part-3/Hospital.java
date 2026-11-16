import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * Simulates the hospital patient scheduling system.
 * Patients are treated according to:
 * 1. Higher Severity
 * 2. Earlier Arrival Time
 * 3. Smaller Patient ID
 */
public class Hospital {

    /**
     * Stores all patients.
     */
    private ArrayList<Patient> patients;

    /**
     * Stores waiting patients according to their priority.
     */
    private PriorityQueue<Patient> waitingQueue;

    /**
     * Creates a new hospital.
     */
    public Hospital() {
        // Initialize the patient list.
        patients = new ArrayList<>();

        // Create the priority queue.
        waitingQueue = new PriorityQueue<>(new PatientComparator());
    }



/**
 * Adds a patient to the hospital.
 *
 * @param patient Patient object.
 */
public void addPatient(Patient patient) {


    if (patient == null) {
        System.out.println("Invalid patient.");
        return;
    }

    // Add these validations HERE
    if (patient.getId() <= 0) {
        System.out.println("Invalid Patient ID.");
        return;
    }

    if (patient.getArrivalTime() < 0) {
        System.out.println("Arrival time cannot be negative.");
        return;
    }

    if (patient.getTreatmentDuration() <= 0) {
        System.out.println("Treatment duration must be greater than 0.");
        return;
    }

    if (patient.getSeverity() < 0) {
        System.out.println("Severity cannot be negative.");
        return;
    }

    // Duplicate ID check
    for (Patient existingPatient : patients) {

        if (existingPatient.getId() == patient.getId()) {
            System.out.println("Patient ID already exists.");
            return;
        }
    }

    patients.add(patient);
}



/**
 * Sorts all patients according to their arrival time.
 * If two patients have the same arrival time,
 * the patient with the smaller ID is placed first.
 */
private void sortPatients() {

    for (int i = 0; i < patients.size() - 1; i++) {
        for (int j = 0; j < patients.size() - i - 1; j++) {
            Patient first = patients.get(j);
            Patient second = patients.get(j + 1);
            // Compare arrival time.
            if (first.getArrivalTime() > second.getArrivalTime()) {

                patients.set(j, second);
                patients.set(j + 1, first);
            }
            // If arrival time is same, compare patient ID.
            else if (first.getArrivalTime() == second.getArrivalTime()
                    && first.getId() > second.getId()) {

                patients.set(j, second);
                patients.set(j + 1, first);
            }
        }
    }
}

/**
 * Simulates the treatment of all patients.
 */
public void treatPatients() {

    if (patients.isEmpty()) {
        System.out.println("No patients available.");
        return;
    }
    // Sort patients according to arrival time.
    sortPatients();

    int currentTime = 0;
    int index = 0;
    int totalWaitingTime = 0;

    System.out.println("Treatment Order");
    System.out.println("-----------------------");

    // Continue until all patients are treated.
    while (index < patients.size() || !waitingQueue.isEmpty()) {

        // Add all patients who have arrived.
        while (index < patients.size() && patients.get(index).getArrivalTime() <= currentTime) {

            waitingQueue.offer(patients.get(index));
            index++;
        }

        // If no patient is waiting, doctor waits.
        if (waitingQueue.isEmpty()) {
            currentTime = patients.get(index).getArrivalTime();
            continue;
        }

        // Get the highest priority patient.
        Patient currentPatient = waitingQueue.poll();

        // Calculate waiting time.
        int waitingTime = currentTime - currentPatient.getArrivalTime();

        totalWaitingTime += waitingTime;

        // Display treatment details.
        System.out.println("Patient ID      : " + currentPatient.getId());

        System.out.println("Arrival Time    : " + currentPatient.getArrivalTime());

        System.out.println("Severity        : " + currentPatient.getSeverity());

        System.out.println("Treatment Start : " + currentTime);

        System.out.println("Treatment End   : " + (currentTime + currentPatient.getTreatmentDuration()));

        System.out.println("Waiting Time    : " + waitingTime);

        System.out.println("-------------------------------");

        // Doctor becomes free after treatment.
        currentTime += currentPatient.getTreatmentDuration();
    }

    System.out.println("Total Waiting Time : "
            + totalWaitingTime);
}
}