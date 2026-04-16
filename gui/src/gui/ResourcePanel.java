package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResourcePanel extends JPanel implements ActionListener {

    java.util.Map<String, String> data = new java.util.HashMap<>();

    JButton scholarshipBtn, tutorialBtn, medicalBtn, otherBtn;
    JList<String> resourceList;
    DefaultListModel<String> listModel;
    JTextArea detailsArea;

    public ResourcePanel() {

        this.setLayout(null);

        // TITLE
        JLabel title = new JLabel("Campus Resources");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(30, 20, 400, 30);
        this.add(title);

        // BUTTONS
        scholarshipBtn = createButton("Scholarships", 30);
        tutorialBtn = createButton("Tutorials", 200);
        medicalBtn = createButton("Medical", 370);
        otherBtn = createButton("Other Services", 540);

        this.add(scholarshipBtn);
        this.add(tutorialBtn);
        this.add(medicalBtn);
        this.add(otherBtn);

        // LIST
        listModel = new DefaultListModel<>();
        resourceList = new JList<>(listModel);

        JScrollPane listScroll = new JScrollPane(resourceList);
        listScroll.setBounds(30, 120, 250, 280);
        this.add(listScroll);

        // DETAILS
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane detailScroll = new JScrollPane(detailsArea);
        detailScroll.setBounds(300, 120, 430, 280);
        this.add(detailScroll);

        // DATA
        data.put("Dean's List Scholarship", "Requirements:\n"
        		+ "Grades (to be applied in the Registrar)\nBenefits: "
        		+ "\n100% coverage of tuition fees for the top 10 "
        		+ "\n50% off the tuition fee for the top 11-25 ");
        
        data.put("Hawak Kamay Scholarship", "Requirements: \n"
        		+ "Must pass exam given at the Marketing Dept.\n"
        		+ "No maintaining grade\n"
        		+ "Benefits:\n"
        		+ "HK5.5 (₱5,500 per semester)\n"
        		+ "HK7.5 ( as low as ₱7,500 per semester)\n"
        		+ "HK10 ( as low as ₱10,000 per semester)\n"
        		+ "HK12.5 (as low as ₱12,000 per semester)\n"
        		+ "** Books and uniforms not included");
        
        data.put("With Highest Honor", "Requirements:\n"
        		+ "Certificate from Principal\n"
        		+ "Birth Certificate\n"
        		+ "Enrollment Registration\n"
        		+ "Benefits:\n"
        		+ "100% off the tuition for semester upon entry only");

        data.put("Peer Tutoring Program", "Benefits:\n"
        		+ "Free tutoring\n"
        		+ "Able to choose subject");
        
        data.put("Math & Science Help Desk", "Requirements:\n"
        		+ "Walk-in academic help");

        data.put("Campus Clinic Checkups", "Benefits:\n"
        		+ "Free checkup\nRequirements:\n"
        		+ "Bring student ID");

        data.put("Library Services", "Benefits:\n"
        		+ "Borrow books\n"
        		+ "Study area access");

        // 🔥 CLICK LISTENER (SUPER SHORT)
        resourceList.addListSelectionListener(e -> {
            String s = resourceList.getSelectedValue();
            if (s != null) detailsArea.setText(data.get(s));
        });
    }

    private JButton createButton(String text, int x) {
        JButton btn = new JButton(text);
        btn.setBounds(x, 70, 150, 35);
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        listModel.clear();
        detailsArea.setText("Select an item to view details.");

        if (e.getSource() == scholarshipBtn) {
            listModel.addElement("Dean's List Scholarship");
            listModel.addElement("Hawak Kamay Scholarship");
            listModel.addElement("With Highest Honor");
        }
        else if (e.getSource() == tutorialBtn) {
            listModel.addElement("Peer Tutoring Program");
            listModel.addElement("Math & Science Help Desk");
        }
        else if (e.getSource() == medicalBtn) {
            listModel.addElement("Campus Clinic Checkups");
        }
        else if (e.getSource() == otherBtn) {
            listModel.addElement("Library Services");
        }
    }
}