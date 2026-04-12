package gui;

public class RequestData {

    public static String[] names = new String[100];
    public static String[] studentIds = new String[100];
    public static String[] categories = new String[100];
    public static String[] details = new String[100];
    public static String[] time = new String[100];
    public static String[] status = new String[100];

    public static int count = 0;

    public static void addRequest(String name, String studentId, String category, String detail, String timeNow) {

        names[count] = name;
        studentIds[count] = studentId;  
        categories[count] = category;
        details[count] = detail;
        time[count] = timeNow;

        status[count] = "Pending";  // default

        count++;
    }
}