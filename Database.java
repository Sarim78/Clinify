public class Database {

    public static User findUserByEmail(String email) {
        for (User u : User.users.values()) {
            if (u.email.equals(email)) {
                return u;
            }
        }
        return null;
    }
}