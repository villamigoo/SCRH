package gui;

import javax.swing.*;
import java.awt.*;

public class AnalyticsPanel extends JPanel {

    JLabel totalLbl, approvedLbl, rejectedLbl, completedLbl;

    public AnalyticsPanel() {

        setLayout(null);

        JLabel title = new JLabel("Analytics Dashboard");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(20, 20, 300, 30);
        add(title);

        totalLbl = new JLabel();
        approvedLbl = new JLabel();
        rejectedLbl = new JLabel();
        completedLbl = new JLabel();

        totalLbl.setBounds(50, 100, 300, 30);
        approvedLbl.setBounds(50, 140, 300, 30);
        rejectedLbl.setBounds(50, 180, 300, 30);
        completedLbl.setBounds(50, 220, 300, 30);

        add(totalLbl);
        add(approvedLbl);
        add(rejectedLbl);
        add(completedLbl);
    }

    public void loadStats() {

        int approved = 0;
        int rejected = 0;
        int completed = 0;

        for (int i = 0; i < RequestData.count; i++) {

            if (RequestData.status[i].equals("Approved")) approved++;
            if (RequestData.status[i].equals("Rejected")) rejected++;
            if (RequestData.status[i].equals("Completed")) completed++;
        }

        totalLbl.setText("Total Requests: " + RequestData.count);
        approvedLbl.setText("Approved: " + approved);
        rejectedLbl.setText("Rejected: " + rejected);
        completedLbl.setText("Completed: " + completed);
    }
}