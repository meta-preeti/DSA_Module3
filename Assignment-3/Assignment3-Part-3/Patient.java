/**
 * Represents a patient in the hospital.
 *
 * Each patient stores:
 * 1. Patient ID
 * 2. Arrival Time
 * 3. Treatment Duration
 * 4. Severity
 */
public class Patient {

    /**
     * Unique ID of the patient.
     */
    private int id;

    /**
     * Time at which the patient arrives.
     */
    private int arrivalTime;


    /**
     * Time required to treat the patient.
     */
    private int treatmentDuration;


    /**
     * Severity of the patient's condition.
     * Higher value means higher priority.
     */
    private int severity;


    /**
     * Creates a new patient.
     * @param id Unique patient ID.
     * @param arrivalTime Arrival time of the patient.
     * @param treatmentDuration Treatment duration.
     * @param severity Severity of the patient.
     */
    public Patient(int id, int arrivalTime, int treatmentDuration, int severity) {

        this.id = id;
        this.arrivalTime = arrivalTime;
        this.treatmentDuration = treatmentDuration;
        this.severity = severity;
    }


    /**
     * Returns the patient ID.
     * @return Patient ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the arrival time.
     * @return Arrival time.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }
    /**
     * Returns the treatment duration.
     * @return Treatment duration.
     */
    public int getTreatmentDuration() {
        return treatmentDuration;
    }

    /**
     * Returns the severity.
     * @return Severity.
     */
    public int getSeverity() {
        return severity;
    }
}