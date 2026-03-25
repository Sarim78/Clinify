import java.util.HashMap;

public class User {

    static HashMap<Integer, User> users = new HashMap<>();

    int userID;
    String email;
    String phoneNumber;
    String password;
    String role;

    public static User getUserByID(int id) {
        return users.get(id);
    }

    public static void addUser(User u) {
        users.put(u.userID, u);
    }

    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
}
