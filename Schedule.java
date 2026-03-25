import java.util.HashMap;

public class Schedule {

    static HashMap<Integer, TimeSlot> slots = new HashMap<>();

    public static TimeSlot getTimeSlot(int id) {
        return slots.get(id);
    }

    public static void addTimeSlot(TimeSlot slot) {
        slots.put(slot.getTimeSlotID(), slot);
    }
    public static Schedule getByDoctorID(int id) {
        return new Schedule();
}
}