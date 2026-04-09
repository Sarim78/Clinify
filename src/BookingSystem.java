public class BookingSystem {

    public Appointment bookAppointment(int patientID, int doctorID, int timeSlotID) {

        TimeSlot requestedSlot = Schedule.getTimeSlot(timeSlotID);

        if (requestedSlot.getAvailabilityStatus().equals("Unavailable"))
        {
            System.out.println("Time slot is already booked.");
            return null;
        }
        else
        {
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
    }
}