package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePanel extends JPanel implements ActionListener {

    JButton resourcesBtn, requestBtn, webinarsBtn;
    MainApp parent;

    public HomePanel(MainApp parent) {
        this.parent = parent;

        setLayout(null);
        setBackground(Color.WHITE);

        // TITLE
        JLabel title = new JLabel("Smart Campus Resource Hub");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setBounds(40, 20, 600, 40);
        add(title);

        // School Name
        JLabel school = new JLabel("PHINMA UPang Dagupan");
        school.setFont(new Font("Arial", Font.PLAIN, 16));
        school.setForeground(Color.GRAY);
        school.setBounds(40, 60, 300, 25);
        add(school);

        // CARD 1
        resourcesBtn = createCard("Resources", 40);
        add(resourcesBtn);

        // CARD 2
        requestBtn = createCard("Submit Request", 260);
        add(requestBtn);

        // CARD 3
        webinarsBtn = createCard("Notifications", 480);
        add(webinarsBtn);
    }

    private JButton createCard(String text, int x) {
        JButton btn = new JButton(text);
        btn.setBounds(x, 120, 180, 130);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(240, 240, 240));
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resourcesBtn)
            parent.cardLayout.show(parent.mainPanel, "RESOURCES");

        if (e.getSource() == requestBtn)
            parent.cardLayout.show(parent.mainPanel, "REQUEST");

        if (e.getSource() == webinarsBtn)
            parent.cardLayout.show(parent.mainPanel, "APPOINTMENT");
    }
}