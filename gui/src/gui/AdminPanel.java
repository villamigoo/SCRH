package gui;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {

    JButton approve, reject, complete;
    DefaultListModel<String> listModel;
    JList<String> requestList;
    JLabel stats;

    public AdminPanel() {

        setLayout(null);

        // TITLE
        JLabel title = new JLabel("Admin Dashboard");
        title.setBounds(20, 10, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // LIST MODEL
        listModel = new DefaultListModel<>();
        requestList = new JList<>(listModel);

        JScrollPane scroll = new JScrollPane(requestList);
        scroll.setBounds(20, 50, 500, 250);
        add(scroll);

        // STATS
        stats = new JLabel();
        stats.setBounds(550, 50, 200, 200);
        add(stats);

        // BUTTONS
        approve = new JButton("Approve");
        reject = new JButton("Reject");
        complete = new JButton("Complete");

        approve.setBounds(550, 270, 150, 30);
        reject.setBounds(550, 310, 150, 30);
        complete.setBounds(550, 350, 150, 30);

        add(approve);
        add(reject);
        add(complete);

        // =========================
        // BUTTON LOGIC
        // =========================

        approve.addActionListener(e -> updateStatus("Approved"));
        reject.addActionListener(e -> updateStatus("Rejected"));
        complete.addActionListener(e -> updateStatus("Completed"));
    }

    // =========================
    // LOAD REQUESTS
    // =========================
    public void loadRequests() {

        listModel.clear();

        int approved = 0;
        int rejected = 0;
        int completed = 0;

        for (int i = 0; i < RequestData.count; i++) {

            listModel.addElement(
                i + " | " +
                RequestData.names[i] + " | " +
                RequestData.categories[i] + " | " +
                RequestData.status[i]
            );

            if (RequestData.status[i].equals("Approved")) approved++;
            if (RequestData.status[i].equals("Rejected")) rejected++;
            if (RequestData.status[i].equals("Completed")) completed++;
        }

        // UPDATE STATS
        stats.setText(
            "<html>" +
            "Total: " + RequestData.count + "<br>" +
            "Approved: " + approved + "<br>" +
            "Rejected: " + rejected + "<br>" +
            "Completed: " + completed +
            "</html>"
        );
    }

    // UPDATE STATUS METHOD
    private void updateStatus(String newStatus) {

        int index = requestList.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Select a request first!");
            return;
        }

        RequestData.status[index] = newStatus;

        loadRequests(); // refresh UI
    }
}