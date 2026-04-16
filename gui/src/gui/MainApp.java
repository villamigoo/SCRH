package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gui.RequestForm;
import gui.AdminPanel;

public class MainApp extends JFrame implements ActionListener {

    JButton homeBtn, tutorialsBtn, notificationsBtn, supportBtn, requestBtn, adminBtn;
    JPanel mainPanel, homePanel, resourcesPanel, officePanel, requestPanel, adminPanel;
    JPanel navBar;
    AnalyticsPanel analyticsPanel;
    CardLayout cardLayout;
    NotificationsPanel notificationsPanel;

    public MainApp() {

        this.setTitle("Smart Campus Resource Hub");
        this.setSize(800, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // NAVBAR
        navBar = new JPanel();
        navBar.setLayout(new GridLayout(1, 6));
        navBar.setBounds(0, 0, 800, 50);
        navBar.setBackground(new Color(30, 30, 30));
        this.add(navBar);

        // MAIN PANEL
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(0, 50, 800, 450);

        // PANELS
        homePanel = new HomePanel(this);
        resourcesPanel = new ResourcePanel();
        officePanel = new OfficeHours();
        requestPanel = new RequestForm();
        notificationsPanel = new NotificationsPanel();
        adminPanel = new AdminPanel();
        analyticsPanel = new AnalyticsPanel();
        
        mainPanel.add(homePanel, "HOME");
        mainPanel.add(resourcesPanel, "RESOURCES");
        mainPanel.add(analyticsPanel, "ANALYTICS");
        mainPanel.add(officePanel, "OFFICE HOURS");
        mainPanel.add(requestPanel, "REQUEST");
        mainPanel.add(notificationsPanel, "NOTIFICATIONS");
        mainPanel.add(adminPanel, "ADMIN");

        this.add(mainPanel);

        setupStudentNav();

        this.setVisible(true);
    }

    // STUDENT NAVBAR
    public void setupStudentNav() {

        navBar.removeAll();
        navBar.setLayout(new GridLayout(1, 7));
        homeBtn = createNavButton("HOME");
        tutorialsBtn = createNavButton("RESOURCES");
        notificationsBtn = createNavButton("NOTIFICATIONS");
        supportBtn = createNavButton("OFFICE HOURS");
        requestBtn = createNavButton("REQUEST");
        adminBtn = createNavButton("ADMIN");

        adminBtn.setBackground(new Color(0, 150, 200));
        adminBtn.setForeground(Color.WHITE);
     
        navBar.add(homeBtn);
        navBar.add(tutorialsBtn);
        navBar.add(notificationsBtn);
        navBar.add(supportBtn);
        navBar.add(requestBtn);
        navBar.add(adminBtn);

        navBar.revalidate();
        navBar.repaint();
    }


 // ADMIN NAVBAR
    public void setupAdminNav() {

        navBar.removeAll();
        navBar.setLayout(new GridLayout(1, 4));

        JButton dashBtn = createNavButton("DASHBOARD");
        JButton reqBtn = createNavButton("REQUESTS");
        JButton analyticsBtn = createNavButton("ANALYTICS");
        JButton logoutBtn = createNavButton("LOGOUT");

        navBar.add(dashBtn);
        navBar.add(reqBtn);
        navBar.add(analyticsBtn);
        navBar.add(logoutBtn);

        dashBtn.addActionListener(e -> cardLayout.show(mainPanel, "ADMIN"));

        reqBtn.addActionListener(e -> {
            notificationsPanel.loadRequests();
            cardLayout.show(mainPanel, "NOTIFICATIONS");
        });

        analyticsBtn.addActionListener(e -> {
            analyticsPanel.loadStats();
            cardLayout.show(mainPanel, "ANALYTICS");
        });

        logoutBtn.addActionListener(e -> {
            setupStudentNav();
            cardLayout.show(mainPanel, "HOME");
        });

        navBar.revalidate();
        navBar.repaint();
    }

    // BUTTON DESIGN
    public JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(50, 50, 50));
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == homeBtn) {
            cardLayout.show(mainPanel, "HOME");
        }

        if (e.getSource() == tutorialsBtn) {
            cardLayout.show(mainPanel, "RESOURCES");
        }

        if (e.getSource() == notificationsBtn) {
            notificationsPanel.loadRequests();
            cardLayout.show(mainPanel, "NOTIFICATIONS");
        }

        if (e.getSource() == supportBtn) {
            cardLayout.show(mainPanel, "OFFICE HOURS");
        }

        if (e.getSource() == requestBtn) {
            cardLayout.show(mainPanel, "REQUEST");
        }

        if (e.getSource() == adminBtn) {
            new AdminLogin(this);
        }
    }

    public void openAdminPanel() {
        setupAdminNav();
        ((AdminPanel) adminPanel).loadRequests();
        cardLayout.show(mainPanel, "ADMIN");
    }
    
   
    
}