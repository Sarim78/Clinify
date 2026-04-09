import java.util.Date;
public class Notification {

    int notificationID;
    String Message;
    Date dateSent;
    String deliveryStatus;
    String notificationType;

    public String sendTo(int userID)
    {
        User recipient = User.getUserByID(userID);

        if (recipient == null)
        {
            deliveryStatus = "Failed";
            return "User not found.";
        }

        if (Message == null || Message.equals(""))
        {
            deliveryStatus = "Failed";
            return "Notification message missing.";
        }

        dateSent = new Date();

        if (recipient.email != null && !recipient.email.equals(""))
        {
            EmailService.send(recipient.email, Message);
            deliveryStatus = "Sent";
        }
        else if (recipient.phoneNumber != null && !recipient.phoneNumber.equals(""))
        {
            PhoneService.send(recipient.phoneNumber, Message);
            deliveryStatus = "Sent";
        }
        else
        {
            deliveryStatus = "Failed";
            return "No contact info on file.";
        }

        Notification.save(this);
        return deliveryStatus;
    }

    public void updateDeliveryStatus(String newStatus)
    {
        deliveryStatus = newStatus;
        Notification.updateStatus(notificationID, newStatus);
    }
    public static void updateStatus(int id, String status) {
    System.out.println("Notification status updated.");
    
    }
    public static void save(Notification n) {
        System.out.println("Notification saved.");
    }
    
}