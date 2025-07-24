package Main_Package;

import Keypad.KeypadPanel;
import javax.swing.*;
import java.awt.*;
public class MainPanel extends JPanel {
    ContentPanel contentPanel = new ContentPanel();
    JScrollPane scrollContent = new JScrollPane(
            contentPanel,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    OptionPanel optionPanel = new OptionPanel(this);
    KeypadPanel keypadPanel = new KeypadPanel();
    ContactContentPanels contactContentPanels = new ContactContentPanels();
    HomePanel homePanel = new HomePanel(contactContentPanels);
    JScrollPane scrollContacts = new JScrollPane(
            contactContentPanels,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    //sets the main panel with all content
    public MainPanel() {
        this.setPreferredSize(new Dimension(450, 800));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setLayout(new BorderLayout());
        scrollContacts.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollContent.getVerticalScrollBar().setBackground(Color.BLACK);
        this.add(scrollContent, BorderLayout.CENTER);
        this.add(homePanel, BorderLayout.NORTH);
        this.add(optionPanel, BorderLayout.SOUTH);
    }

    //repaints when option clicked
    public void rePaintMainPanel() {
        if (optionPanel.option.equals("contactsButton")) {
            this.remove(keypadPanel);
            this.remove(scrollContent);
            homePanel.remove(homePanel.editButton2);
            homePanel.add(homePanel.addButton);
            homePanel.add(homePanel.searchButton);
            homePanel.add(homePanel.deleteButton);
            homePanel.add(homePanel.editButton);
            homePanel.add(homePanel.jLabel);
            homePanel.searchButton.setBounds(400,260,70,40);
            this.add(scrollContacts, BorderLayout.CENTER);
        }
        if (optionPanel.option.equals("keypadButton")) {
            this.remove(scrollContent);
            this.remove(scrollContacts);
            homePanel.remove(homePanel.addButton);
            homePanel.remove(homePanel.deleteButton);
            homePanel.remove(homePanel.editButton);
            homePanel.remove(homePanel.jLabel);
            homePanel.add(homePanel.editButton2);
            homePanel.add(homePanel.searchButton);
            homePanel.searchButton.setBounds(400,3,70,40);
            homePanel.editButton2.setBounds(350,5,70,40);
            this.add(keypadPanel, BorderLayout.CENTER);
        }
        if (optionPanel.option.equals("recentsButton")) {
            this.remove(keypadPanel);
            this.remove(scrollContacts);
            homePanel.remove(homePanel.editButton);
            homePanel.remove(homePanel.addButton);
            homePanel.remove(homePanel.deleteButton);
            homePanel.add(homePanel.searchButton);
            homePanel.add(homePanel.editButton2);
            homePanel.add(homePanel.jLabel);
            homePanel.searchButton.setBounds(400,260,70,40);
            homePanel.editButton2.setBounds(350,260,70,40);
            this.add(scrollContent, BorderLayout.CENTER);
        }
        this.validate();
        this.repaint();
    }
}
