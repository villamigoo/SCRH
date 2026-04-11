package gui;

import javax.swing.*;
import java.awt.event.*;

public class newWindow extends JFrame {

    public newWindow() {
        this.setTitle("Dashboard");
        this.setSize(400, 200);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome! You are logged in.");
        label.setBounds(100, 60, 250, 30);

        this.add(label);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                new frame();

                dispose();
            }
        });

        this.setVisible(true);
    }
}