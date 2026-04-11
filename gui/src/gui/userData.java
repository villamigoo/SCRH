package gui;

public class userData {

    public static String[] usernames = new String[100];
    public static String[] passwords = new String[100];
    public static int count = 0;

    // REGISTER METHOD
    public static boolean register(String username, String password) {

        for (int i = 0; i < count; i++) {
            if (usernames[i].equals(username)) {
                return false;
            }
        }

        usernames[count] = username;
        passwords[count] = password;
        count++;

        return true;
    }
    
    // LOGIN METHOD
    public static boolean login(String username, String password) {

        for (int i = 0; i < count; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                return true;
            }
        }

        return false;
    }
    
    
}