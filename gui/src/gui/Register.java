package gui;

import javax.swing.*;
import java.awt.event.*;

public class Register extends JFrame implements ActionListener {

    JTextField nameField, emailField;
    JPasswordField passwordField, confirmField;
    JButton registerBtn;

    public Register() {
        this.setTitle("Register");
        this.setSize(350, 350);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // NAME
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(30, 20, 100, 30);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 180, 30);

        // EMAIL
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 30);

        emailField = new JTextField();
        emailField.setBounds(120, 70, 180, 30);

        // PASSWORD
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 120, 100, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 120, 180, 30);

        // CONFIRM
        JLabel confirmLabel = new JLabel("Confirm:");
        confirmLabel.setBounds(30, 170, 100, 30);

        confirmField = new JPasswordField();
        confirmField.setBounds(120, 170, 180, 30);

        // BUTTON
        registerBtn = new JButton("Register");
        registerBtn.setBounds(120, 220, 100, 35);
        registerBtn.addActionListener(this);

        // ADD
        this.add(nameLabel);
        this.add(nameField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(passLabel);
        this.add(passwordField);
        this.add(confirmLabel);
        this.add(confirmField);
        this.add(registerBtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String email = emailField.getText();
        String pass = String.valueOf(passwordField.getPassword());
        String confirm = String.valueOf(confirmField.getPassword());

     // EMPTY CHECK
        if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        // NAME LENGTH
        if (name.length() < 3) {
            JOptionPane.showMessageDialog(this, "Name must be at least 3 characters!");
            return;
        }

        // EMAIL LENGTH 
        String prefix = email.replace("@phinmaed.com", "");

        if (prefix.length() < 6) {
            JOptionPane.showMessageDialog(this, "Email must have at least 6 characters before @phinmaed.com");
            return;
        }

        // EMAIL
        if (!email.endsWith("@phinmaed.com")) {
            JOptionPane.showMessageDialog(this, "Email must be @phinmaed.com");
            return;
        }

        // PASSWORD LENGTH
        if (pass.length() < 6) {
            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters!");
            return;
        }

        // PASSWORD MATCH
        if (!pass.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }

        // REGISTER
        String studentId = userData.register(name, email, pass);

        if (studentId != null) {
            JOptionPane.showMessageDialog(this,
                    "Registered successfully!\n\nName: " + name +
                    "\nEmail: " + email +
                    "\nStudent ID: " + studentId);

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Account already exists!");
        }
    }
}