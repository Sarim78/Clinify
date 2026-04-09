import java.sql.Time;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // Create test user
        User u1 = new User();
        u1.userID = 1;
        u1.email = "test@email.com";
        u1.phoneNumber = "1234567890";
        u1.password = "123";
        u1.role = "Patient";
        User.addUser(u1);
        User u2 = new User();
        u2.userID = 2;
        u2.email = "test2@email.com";
        u2.phoneNumber = "1234567890";
        u2.password = "123";
        u2.role = "Patient";
        User.addUser(u2);

        // Create time slot
        TimeSlot slot = new TimeSlot(
            5001,
            new Date(),
            new Time(10, 0, 0),
            new Time(10, 30, 0),
            "Available"
        );

        Schedule.addTimeSlot(slot);

        // Test booking
        BookingSystem system = new BookingSystem();

        Appointment appt1 = system.bookAppointment(1, 101, 5001);
        if (appt1 != null) {
            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Booking failed.");
        }
        Appointment appt2 = system.bookAppointment(2, 101, 5001);
        if (appt2 != null) {
            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Booking failed.");
        }
    }
}
