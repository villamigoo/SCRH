package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResourcePanel extends JPanel implements ActionListener {

    JButton scholarshipBtn, tutorialBtn, medicalBtn, otherBtn;
    JTextArea contentArea;

    public ResourcePanel() {

        this.setLayout(null);

        // TITLE
        JLabel title = new JLabel("Campus Resources");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(30, 20, 400, 30);
        this.add(title);

        // BUTTONS (HORIZONTAL)
        scholarshipBtn = createButton("Scholarships", 30);
        tutorialBtn = createButton("Tutorials", 200);
        medicalBtn = createButton("Medical", 370);
        otherBtn = createButton("Other Services", 540);

        this.add(scholarshipBtn);
        this.add(tutorialBtn);
        this.add(medicalBtn);
        this.add(otherBtn);

        // CONTENT AREA (BULLET STYLE)
        contentArea = new JTextArea();
        contentArea.setBounds(30, 120, 700, 280);
        contentArea.setEditable(false);
        contentArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(contentArea);
        scroll.setBounds(30, 120, 700, 280);

        this.add(scroll);
    }

    // BUTTON CREATOR
    private JButton createButton(String text, int x) {
        JButton btn = new JButton(text);
        btn.setBounds(x, 70, 150, 35);
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == scholarshipBtn) {
            contentArea.setText(
                "• Academic Scholarship\n" +
                "• Athletic Scholarship\n" +
                "• Financial Assistance Program\n" +
                "• CHED Scholarship Support\n"
            );
        }

        if (e.getSource() == tutorialBtn) {
            contentArea.setText(
                "• Peer Tutoring Program\n" +
                "• Math & Science Help Desk\n" +
                "• IT & Programming Tutorials\n" +
                "• Study Skills Workshops\n"
            );
        }

        if (e.getSource() == medicalBtn) {
            contentArea.setText(
                "• Campus Clinic Checkups\n" +
                "• Free Consultation\n" +
                "• Mental Health Counseling\n" +
                "• First Aid Services\n"
            );
        }

        if (e.getSource() == otherBtn) {
            contentArea.setText(
                "• Library Services\n" +
                "• Career Guidance\n" +
                "• Student Organizations\n" +
                "• Campus Events & Webinars\n"
            );
        }
    }
}