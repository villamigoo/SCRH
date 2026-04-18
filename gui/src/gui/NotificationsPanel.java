package gui;

import javax.swing.*;
import java.awt.*;

public class NotificationsPanel extends JPanel {

    JTextArea displayArea;

    public NotificationsPanel() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Notifications / Requests", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(displayArea);

        add(title, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public void loadRequests() {

        displayArea.setText("");

        for (int i = 0; i < RequestData.count; i++) {

        	displayArea.append(
        		    "Name: " + RequestData.names[i] + "\n" +
        		    "Student ID: " + RequestData.studentIds[i] + "\n" + 
        		    "Type: " + RequestData.categories[i] + "\n" +
        		    "Details: " + RequestData.details[i] + "\n" +
        		    "Time: " + RequestData.time[i] + "\n" +
        		    "Status: " + RequestData.status[i] + "\n" +
        		    "------------------------------\n"
        		);
        }
    }
}