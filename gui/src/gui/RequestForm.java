package gui;

import javax.swing.*;
import java.awt.*;

public class RequestForm extends JPanel {

    JTextField nameField, emailField;
    JComboBox<String> dropdown;
    JTextArea detailsArea;
    JButton submitBtn;

    public RequestForm() {

        this.setLayout(null); 

        // NAME FIELD
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 20, 200, 20);
        this.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(50, 45, 500, 30);
        this.add(nameField);

        // EMAIL FIELD
        JLabel studentIdLabel = new JLabel("Student Id:");
        studentIdLabel.setBounds(50, 85, 200, 20);
        this.add(studentIdLabel);

        emailField = new JTextField();
        emailField.setBounds(50, 110, 500, 30);
        this.add(emailField);

        // DROPDOWN
        JLabel dropLabel = new JLabel("Category:");
        dropLabel.setBounds(50, 150, 200, 20);
        this.add(dropLabel);

        dropdown = new JComboBox<>(new String[]{"Scholarship", "Tutorial", "Medical Service", "Appointment", "Other"});
        dropdown.setBounds(50, 175, 500, 30);
        this.add(dropdown);

        // TEXT AREA
        JLabel detailsLabel = new JLabel("Request Details:");
        detailsLabel.setBounds(50, 215, 200, 20);
        this.add(detailsLabel);

        detailsArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        scrollPane.setBounds(50, 240, 500, 100);
        this.add(scrollPane);

        // SUBMIT BUTTON
        submitBtn = new JButton("Submit Request");
        submitBtn.setBounds(50, 350, 500, 40); 
        submitBtn.setBackground(new Color(200, 200, 200));
        submitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(submitBtn);
    }
}