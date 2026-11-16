import java.util.Comparator;

/**
 * Compares two patients based on their priority.
 * Priority Rules:
 * 1. Higher Severity -> Higher Priority
 * 2. If Severity is same, Earlier Arrival Time -> Higher Priority
 * 3. If Arrival Time is also same, Smaller Patient ID -> Higher Priority
 */
public class PatientComparator implements Comparator<Patient> {

    /**
     * Compares two patients.
     *
     * @param first  First patient
     * @param second Second patient
     * @return
     * Negative value -> first comes first
     * Positive value -> second comes first
     * Zero -> both are equal
     */
    @Override
    public int compare(Patient first, Patient second) {

        // Higher severity gets higher priority.
        if (first.getSeverity() != second.getSeverity()) {
            return second.getSeverity() - first.getSeverity();
        }

        // If severity is same, patient who arrived earlier gets priority.
        if (first.getArrivalTime() != second.getArrivalTime()) {
            return first.getArrivalTime() - second.getArrivalTime();
        }

        // If arrival time is also same, smaller patient ID gets priority.
        return first.getId() - second.getId();
    }
}