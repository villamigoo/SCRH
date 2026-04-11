package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class frame extends JFrame implements ActionListener {

    JButton loginButton;
    JButton registerButton;

    public frame() {

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 100, 100, 40);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton = new JButton("Register");
        registerButton.setBounds(260, 100, 100, 40);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        this.setTitle("Smart Campus Resource Hub");
        this.setLayout(null);
        this.setSize(500, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(loginButton);
        this.add(registerButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	if (e.getSource() == loginButton) {
    	    new Login(this);
    	    this.setVisible(false); // hide main menu
    	}

        if (e.getSource() == registerButton) {
            new Register(); 
        }
    }
}