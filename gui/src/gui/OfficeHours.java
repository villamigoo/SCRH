package gui;

import javax.swing.*;
import java.awt.*;

public class OfficeHours extends JPanel {

    public OfficeHours() {

        this.setLayout(null);

        // TITLE
        JLabel title = new JLabel("Contact Info & Office Hours");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(30, 20, 400, 30);
        this.add(title);

        // CONTACT INFO SECTION
        JLabel contactTitle = new JLabel("Contact Information");
        contactTitle.setFont(new Font("Arial", Font.BOLD, 16));
        contactTitle.setBounds(30, 60, 300, 25);
        this.add(contactTitle);

        JLabel address = new JLabel("Address: PHINMA University of Pangasinan");
        address.setBounds(30, 90, 300, 20);
        this.add(address);

        JLabel counselor = new JLabel("Email: student.support@phinmaupang.edu.ph");
        counselor.setBounds(30, 110, 300, 20);
        this.add(counselor);

        JLabel numbers = new JLabel("Contact: (075) 522-5635");
        numbers.setBounds(30, 130, 300, 20);
        this.add(numbers);

        // OFFICE HOURS TITLE
        JLabel hoursTitle = new JLabel("Office Hours");
        hoursTitle.setFont(new Font("Arial", Font.BOLD, 16));
        hoursTitle.setBounds(30, 170, 300, 25);
        this.add(hoursTitle);

        // TABLE DATA
        String[][] data = {
                {"Monday", "9:00 AM - 5:00 PM"},
                {"Tuesday", "9:00 AM - 5:00 PM"},
                {"Wednesday", "9:00 AM - 5:00 PM"},
                {"Thursday", "9:00 AM - 5:00 PM"},
                {"Friday", "9:00 AM - 5:00 PM"},
                {"Saturday", "9:00 AM - 5:00 PM"},
                {"Sunday", "10:00 AM - 1:00 PM "}
        };

        String[] columns = {"Days", "Office Hours"};

        // NON-EDITABLE TABLE
        JTable table = new JTable(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setFillsViewportHeight(true);

        // auto height
        int rowHeight = table.getRowHeight();
        int tableHeight = data.length * rowHeight + 25;

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 200, 500, tableHeight);

        this.add(scrollPane);
    }
}