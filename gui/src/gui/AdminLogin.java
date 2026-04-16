package gui;

import javax.swing.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;

    MainApp mainApp;

    public AdminLogin(MainApp mainApp) {
        this.mainApp = mainApp;

        this.setTitle("Admin Login");
        this.setSize(300, 200);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JLabel userLabel = new JLabel("Admin Username:");
        userLabel.setBounds(20, 20, 120, 25);

        usernameField = new JTextField();
        usernameField.setBounds(140, 20, 120, 25);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 120, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 60, 120, 25);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 110, 100, 30);
        loginBtn.addActionListener(this);

        this.add(userLabel);
        this.add(usernameField);
        this.add(passLabel);
        this.add(passwordField);
        this.add(loginBtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (username.equals("scrh_admin") && password.equals("scrh1")) {

            JOptionPane.showMessageDialog(this, "Admin login successful!");

            this.dispose();

            mainApp.openAdminPanel(); // switch to admin UI

        } else {
            JOptionPane.showMessageDialog(this, "Invalid admin credentials!");
        }
    }
}