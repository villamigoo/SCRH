package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gui.RequestForm;

public class MainApp extends JFrame implements ActionListener {

    JButton homeBtn, tutorialsBtn, webinarsBtn, supportBtn, requestBtn, adminBtn;
    JPanel mainPanel, homePanel, resourcesPanel, appointmentsPanel, officePanel, requestPanel, adminPanel;
    CardLayout cardLayout;

    public MainApp() {

        this.setTitle("Smart Campus Resource Hub");
        this.setSize(800, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // NAVBAR PANEL
        JPanel navBar = new JPanel();
        navBar.setLayout(new GridLayout(1, 6));
        navBar.setBounds(0, 0, 800, 50);
        navBar.setBackground(new Color(30, 30, 30));

        // Buttons
        homeBtn = createNavButton("HOME");
        tutorialsBtn = createNavButton("RESOURCES");
        webinarsBtn = createNavButton("APPOINTMENTS");
        supportBtn = createNavButton("OFFICE HOURS");
        requestBtn = createNavButton("REQUEST");
        adminBtn = createNavButton("ADMIN");
        

        adminBtn.setBackground(new Color(0, 150, 200));
        adminBtn.setForeground(Color.WHITE);

        navBar.add(homeBtn);
        navBar.add(tutorialsBtn);
        navBar.add(webinarsBtn);
        navBar.add(supportBtn);
        navBar.add(requestBtn);
        navBar.add(adminBtn);

        this.add(navBar);

        // MAIN PANEL with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(0, 50, 800, 450);

        // Create content panels
        homePanel = new HomePanel(this);
        resourcesPanel = new ResourcePanel();
        appointmentsPanel = createPanel("Appointment Scheduling Dashboard");
        officePanel = new OfficeHours();
        requestPanel = new RequestForm();
        adminPanel = createPanel("Admin Panel");
        
        // Add panels to Layout
        mainPanel.add(homePanel, "HOME");
        mainPanel.add(resourcesPanel, "RESOURCES");
        mainPanel.add(appointmentsPanel, "APPOINTMENTS");
        mainPanel.add(officePanel, "OFFICE HOURS");
        mainPanel.add(requestPanel, "REQUEST");
        mainPanel.add(adminPanel, "ADMIN");

        this.add(mainPanel);

        this.setVisible(true);
    }

    // Button design
    public JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(50, 50, 50));
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.addActionListener(this);
        return btn;
    }

    // Simple panel with label
    public JPanel createPanel(String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == homeBtn) {
            cardLayout.show(mainPanel, "HOME");
        }

        if (e.getSource() == tutorialsBtn) {
            cardLayout.show(mainPanel, "RESOURCES");
        }

        if (e.getSource() == webinarsBtn) {
            cardLayout.show(mainPanel, "APPOINTMENTS");
        }

        if (e.getSource() == supportBtn) {
            cardLayout.show(mainPanel, "OFFICE HOURS");
        }

        if (e.getSource() == requestBtn) {
            cardLayout.show(mainPanel, "REQUEST");
        }
        if (e.getSource() == adminBtn) {
            cardLayout.show(mainPanel, "ADMIN");
        }

    }

    public static void main(String[] args) {
        new MainApp();
    }
}