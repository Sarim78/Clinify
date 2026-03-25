import java.sql.Time;

public class Appointment {

    int patient;
    int doctor;
    Time startTime;
    String Status;

    public static void save(Appointment a) {
        System.out.println("Appointment saved.");
    }

    public static Appointment getByID(int id) {
        return null;
    }

    public static void updateStatus(int id, String status) {
        System.out.println("Appointment updated to " + status);
    }

    public static java.util.List<Appointment> getByDoctorID(int id) {
        return new java.util.ArrayList<>();
    }
    public Appointment bookAppointment(int patientID, int doctorID, int timeSlotID) {

    // Retrieve the time slot being asked
    TimeSlot requestedSlot = Schedule.getTimeSlot(timeSlotID);

    // Check if the slot is actually available
    if (requestedSlot.getAvailabilityStatus().equals("Unavailable")) 
    {
        System.out.println("Time slot is already booked.");
        return null;
    } 
    else 
    {
        // Create the new appointment
        Appointment newAppt = new Appointment();
        newAppt.patient = patientID;
        newAppt.doctor = doctorID;
        newAppt.startTime = requestedSlot.getStartTime();
        newAppt.Status = "Confirmed";

        // Update the time slot status
        requestedSlot.updateStatus("Unavailable");

        // send notification to the patient
        Notification notif = new Notification();
        notif.Message = "Your appointment is confirmed for " + newAppt.startTime;
        notif.sendTo(patientID);

        return newAppt;
    }
}
}