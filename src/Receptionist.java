public class Receptionist extends User {

    private int userID;

    public Receptionist(int userID) {
        this.userID = userID;
    }

    public Appointment createAppointment(int patientID, int doctorID, int timeSlotID) {

        TimeSlot requestedSlot = Schedule.getTimeSlot(timeSlotID);

        if (requestedSlot == null) {
            System.out.println("Time slot not found.");
            return null;
        }

        if (requestedSlot.getAvailabilityStatus().equals("Unavailable")) {
            System.out.println("Time slot is already booked.");
            return null;
        }

        Appointment newAppt = new Appointment();
        newAppt.patient = patientID;
        newAppt.doctor = doctorID;
        newAppt.startTime = requestedSlot.getStartTime();
        newAppt.Status = "Confirmed";

        requestedSlot.updateStatus("Unavailable");

        Notification notif = new Notification();
        notif.Message = "Your appointment is confirmed for " + newAppt.startTime;
        notif.sendTo(patientID);

        return newAppt;
    }

    public String modifyAppointment(int appointmentID, int newTimeSlotID) {

        Appointment appt = Appointment.getByID(appointmentID);
        if (appt == null) {
            return "Appointment not found.";
        }

        TimeSlot newSlot = Schedule.getTimeSlot(newTimeSlotID);
        if (newSlot == null) {
            return "New time slot not found.";
        }

        if (newSlot.getAvailabilityStatus().equals("Unavailable")) {
            return "Time slot is already booked.";
        }

        TimeSlot oldSlot = Schedule.getTimeSlot(appointmentID);
        if (oldSlot != null) {
            oldSlot.updateStatus("Available");
        }

        appt.startTime = newSlot.getStartTime();
        appt.Status = "Confirmed";

        newSlot.updateStatus("Unavailable");

        Notification notif = new Notification();
        notif.Message = "Your appointment has been rescheduled to " + newSlot.getStartTime();
        notif.sendTo(appt.patient);

        return "Appointment modified successfully.";
    }

    public String cancelAppointment(int appointmentID) {

        Appointment appt = Appointment.getByID(appointmentID);
        if (appt == null) {
            return "Appointment not found.";
        }

        appt.Status = "Cancelled";
        Appointment.updateStatus(appointmentID, "Cancelled");

        TimeSlot slot = Schedule.getTimeSlot(appointmentID);
        if (slot != null) {
            slot.updateStatus("Available");
        }

        Notification notif = new Notification();
        notif.Message = "Your appointment has been cancelled by the receptionist.";
        notif.sendTo(appt.patient);

        return "Appointment cancelled successfully.";
    }
}