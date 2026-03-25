import java.util.Date;
import java.sql.Time;
public class TimeSlot {

    private int timeSlotID;
    private Date date;
    private Time startTime;
    private Time endTime;
    private String availabilityStatus;

    public TimeSlot(int timeSlotID, Date date, Time startTime, Time endTime, String availabilityStatus) {
        this.timeSlotID = timeSlotID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availabilityStatus = availabilityStatus;
    }

    public String reserve(){
        if (this.availabilityStatus.equals("Free")){
            this.updateStatus("Booked");
            return "Booked";
        } else {
            return "Time Slot already booked.";
        }
    }

    public String release(){
        if (this.availabilityStatus.equals("Booked")){
            this.updateStatus("Free");
            return "Released";
        } else {
            return "Time Slot already Free.";
        }
    }

    public boolean isAvailable(){
        return availabilityStatus.equals("Free");
    }

    public String getSlotDetails(){
        return "ID: " + timeSlotID + ", Date: " + date + ", Start: " + startTime + ", End: " + endTime + ", Status: " + availabilityStatus;
    }

    public void updateStatus(String newStatus){
        this.availabilityStatus = newStatus;
    }

    public int getTimeSlotID() { return timeSlotID; }
    public Date getDate() { return date; }
    public Time getStartTime() { return startTime; }
    public Time getEndTime() { return endTime; }
    public String getAvailabilityStatus() { return availabilityStatus; }
    public static void updateStatus(int id, String status) {
        System.out.println("TimeSlot updated.");
}
}