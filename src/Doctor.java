import java.util.List;

public class Doctor {

    int userID;
    String specialization;
    String licenseNumber;

    public Schedule getSchedule()
    {
        Schedule docSchedule = Schedule.getByDoctorID(userID); 

        if (docSchedule == null)
        {
            System.out.println("Schedule not found.");
            return null;
        }

        return docSchedule;
    }

    public String setAvailability(int timeSlotID, String newStatus)
    {
        TimeSlot slot = Schedule.getTimeSlot(timeSlotID);

        if (slot == null)
        {
            return "Time slot not found.";
        }

        slot.updateStatus(newStatus);
        TimeSlot.updateStatus(timeSlotID, newStatus); 

        return "Availability updated successfully.";
    }

    public List<Appointment> getAppointments()
    {
        List<Appointment> doctorAppointments = Appointment.getByDoctorID(userID);

        if (doctorAppointments == null || doctorAppointments.isEmpty())
        {
            System.out.println("No appointments found.");
            return null;
        }

        return doctorAppointments;
    }

    public String acceptAppointment(int appointmentID)
    {
        Appointment appt = Appointment.getByID(appointmentID);

        if (appt == null)
        {
            return "Appointment not found.";
        }

        if (appt.doctor != userID)
        {
            return "Doctor is not assigned to this appointment.";
        }

        appt.Status = "Confirmed";
        Appointment.updateStatus(appointmentID, "Confirmed");

        Notification notif = new Notification();
        notif.Message = "Your appointment has been accepted by the doctor.";
        notif.notificationType = "Confirmation";
        notif.sendTo(appt.patient);

        return "Appointment accepted successfully.";
    }

    public String cancelAppointment(int appointmentID)
    {
        Appointment appt = Appointment.getByID(appointmentID);

        if (appt == null)
        {
            return "Appointment not found.";
        }

        if (appt.doctor != userID)
        {
            return "Doctor is not assigned to this appointment.";
        }

        appt.Status = "Cancelled";
        Appointment.updateStatus(appointmentID, "Cancelled");

        TimeSlot slot = Schedule.getTimeSlot(appointmentID);
        if (slot != null)
        {
            slot.updateStatus("Available");
            TimeSlot.updateStatus(slot.getTimeSlotID(), "Available");
        }

        Notification notif = new Notification();
        notif.Message = "Your appointment has been cancelled by the doctor.";
        notif.notificationType = "Cancellation";
        notif.sendTo(appt.patient);

        return "Appointment cancelled successfully.";
    }

    public String updateProfile(String newSpecialization, String newLicenseNumber)
    {
        if (newSpecialization != null && !newSpecialization.equals(""))
        {
            specialization = newSpecialization;
        }

        if (newLicenseNumber != null && !newLicenseNumber.equals(""))
        {
            licenseNumber = newLicenseNumber;
        }

        Doctor.update(userID, specialization, licenseNumber);

        return "Profile updated successfully.";
    }

    public static void update(int userID, String specialization, String licenseNumber) {
        System.out.println("Doctor updated.");
    }
}