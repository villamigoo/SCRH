package gui;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	
	frame mainFrame;

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;

    public Login(frame mainFrame) {
    	this.mainFrame = mainFrame;
        this.setTitle("Login");
        this.setSize(350, 250);
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

        loginBtn = new JButton("Login");
        loginBtn.setBounds(120, 140, 100, 35);
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

        boolean success = userData.login(username, password);

        if (success) {
            JOptionPane.showMessageDialog(this, "Login successful!");

            this.dispose();

            new MainApp();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!");
        }
    }
}