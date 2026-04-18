package gui;

public class userData {

	
    public static String[] names = new String[100];
    public static String[] emails = new String[100];
    public static String[] passwords = new String[100];
    public static String[] studentIds = new String[100];
    public static String currentName;
    public static String currentStudentId;
    public static int count = 0;
    

    public static String register(String name, String email, String password) {

        // prevent overflow
        if (count >= 100) return null;

        // check duplicate email
        for (int i = 0; i < count; i++) {
            if (email.equals(emails[i])) {
                return null;
            }
        }

        names[count] = name;
        emails[count] = email;
        passwords[count] = password;

        // GENERATE STUDENT ID
        String id = "03-01-2526-" + (int)(Math.random() * 900000 + 100000);
        studentIds[count] = id;

        count++;

        return id;
    }

    public static int login(String email, String password) {

        for (int i = 0; i < count; i++) {

            if (email.equals(emails[i]) && password.equals(passwords[i])) {
                return i; // return index if match
            }
        }

        return -1;
    }
}