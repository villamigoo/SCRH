package gui;

import javax.swing.*;
import java.awt.event.*;

public class Register extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField, confirmField;
    JButton registerBtn;

    public Register() {
        this.setTitle("Register");
        this.setSize(350, 300);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 40, 100, 30);

        usernameField = new JTextField();
        usernameField.setBounds(120, 40, 180, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 90, 100, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 90, 180, 30);

        JLabel confirmLabel = new JLabel("Confirm:");
        confirmLabel.setBounds(30, 140, 100, 30);

        confirmField = new JPasswordField();
        confirmField.setBounds(120, 140, 180, 30);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(120, 190, 100, 35);
        registerBtn.addActionListener(this);

        this.add(userLabel);
        this.add(usernameField);
        this.add(passLabel);
        this.add(passwordField);
        this.add(confirmLabel);
        this.add(confirmField);
        this.add(registerBtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String pass = String.valueOf(passwordField.getPassword());
        String confirm = String.valueOf(confirmField.getPassword());

        if (!pass.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }

        boolean success = userData.register(username, pass);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registered successfully!");
            this.dispose(); // close register window
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists!");
        }
    }
}