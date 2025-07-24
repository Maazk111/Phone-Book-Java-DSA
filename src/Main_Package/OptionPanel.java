package Main_Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPanel extends JPanel implements ActionListener {
    JButton keypadButton = new JButton("Keypad");
    JPanel keypadPanel = new JPanel();
    JButton recentsButton = new JButton("Recents");
    JPanel recentsPanel;
    JButton contactsButton = new JButton("Contacts");
    JPanel contactsPanel = new JPanel();
    JPanel line;
    MainPanel mainPanel;

    public String option = "recentsButton";

    int font_size = 17;

    OptionPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        newRecentsPanel();
        newLine();

        this.setPreferredSize(new Dimension(450, 60));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 51, 10));
        this.add(keypadPanel);
        this.add(recentsPanel);
        this.add(contactsPanel);

        keypadButton.setBorderPainted(false);
        keypadButton.setContentAreaFilled(false);
        keypadButton.setFocusPainted(false);
        keypadButton.setOpaque(false);
        keypadButton.setFont(new Font("SamsungSans-Bold", Font.PLAIN, font_size));
        keypadButton.setForeground(new Color(0xC8FFFFFF, true));
        keypadButton.addActionListener(this);

        keypadPanel.setBackground(Color.BLACK);
        keypadPanel.setLayout(new BorderLayout());
        keypadPanel.setPreferredSize(new Dimension(98, 40));
        keypadPanel.setFocusable(true);
        keypadPanel.setDoubleBuffered(true);
        keypadPanel.add(keypadButton, BorderLayout.CENTER);

        recentsButton.setBorderPainted(false);
        recentsButton.setContentAreaFilled(false);
        recentsButton.setFocusPainted(false);
        recentsButton.setOpaque(false);
        recentsButton.setFont(new Font("SamsungSans-Bold", Font.PLAIN, font_size));
        recentsButton.setForeground(Color.WHITE);
        recentsButton.addActionListener(this);

        contactsButton.setBorderPainted(false);
        contactsButton.setContentAreaFilled(false);
        contactsButton.setFocusPainted(false);
        contactsButton.setOpaque(false);
        contactsButton.setFont(new Font("SamsungSans-Bold", Font.PLAIN, font_size));
        contactsButton.setForeground(new Color(0xC8FFFFFF, true));
        contactsButton.addActionListener(this);

        contactsPanel.setBackground(Color.BLACK);
        contactsPanel.setLayout(new BorderLayout());
        contactsPanel.setPreferredSize(new Dimension(98, 40));
        contactsPanel.setFocusable(true);
        contactsPanel.setDoubleBuffered(true);
        contactsPanel.add(contactsButton, BorderLayout.CENTER);
        recentsPanel.add(line, BorderLayout.SOUTH);
    }

    public void newRecentsPanel() {
        recentsPanel = new JPanel();
        recentsPanel.setBackground(Color.BLACK);
        recentsPanel.setLayout(new BorderLayout());
        recentsPanel.setPreferredSize(new Dimension(98, 40));
        recentsPanel.setFocusable(true);
        recentsPanel.setDoubleBuffered(true);
        recentsPanel.add(recentsButton, BorderLayout.CENTER);
    }

    public void newLine() {
        line = new JPanel();
        line.setPreferredSize(new Dimension(2, 2));
        line.setBackground(Color.WHITE);
        line.setDoubleBuffered(true);
        line.setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == contactsButton) {
            if (!option.equals("contactsButton")) {
                option = "contactsButton";

                recentsButton.setForeground(new Color(0xC8FFFFFF, true));
                keypadButton.setForeground(new Color(0xC8FFFFFF, true));
                contactsButton.setForeground(Color.WHITE);

                keypadPanel.remove(line);
                keypadPanel.repaint();
                recentsPanel.remove(line);
                recentsPanel.repaint();

                mainPanel.rePaintMainPanel();

                contactsPanel.add(line);
                contactsPanel.repaint();
            }
        }
        else if (e.getSource() == recentsButton) {
            if (!option.equals("recentsButton")) {
                option = "recentsButton";

                recentsButton.setForeground(Color.WHITE);
                keypadButton.setForeground(new Color(0xC8FFFFFF, true));
                contactsButton.setForeground(new Color(0xC8FFFFFF, true));

                contactsPanel.remove(line);
                contactsPanel.repaint();
                keypadPanel.remove(line);
                keypadPanel.repaint();

                mainPanel.rePaintMainPanel();

                recentsPanel.add(line);
                recentsPanel.repaint();
            }
        }
        else if (e.getSource() == keypadButton) {
            if (!option.equals("keypadButton")) {
                option = "keypadButton";

                recentsButton.setForeground(new Color(0xC8FFFFFF, true));
                keypadButton.setForeground(Color.WHITE);
                contactsButton.setForeground(new Color(0xC8FFFFFF, true));

                recentsPanel.remove(line);
                recentsPanel.repaint();
                contactsPanel.remove(line);
                contactsPanel.repaint();

                mainPanel.rePaintMainPanel();

                keypadPanel.add(line);
                keypadPanel.repaint();
            }
        }
    }
}
