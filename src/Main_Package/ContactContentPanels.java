package Main_Package;

import Entries.ContactPanels;
import Entries.Contacts;

import javax.swing.*;
import java.awt.*;

public class ContactContentPanels extends JPanel {
    Contacts contacts = new Contacts();
    ContactPanels[] contactPanels;
    JPanel[] border;
    int height = 600;
    int count = 600;
    int panelCounter = -1;
    ContactContentPanels() {
        this.setPreferredSize(new Dimension(450, height));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(new Color(0x171717));
//        this.setOpaque(false);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x171717));
        loadContacts();
    }

    public void loadContacts() {
        this.removeAll();
        contacts.loadContacts();
        contactPanels = new ContactPanels[contacts.count];
        border = new JPanel[contacts.count];
        contacts.Sort();
        for (int i = 0; i < contactPanels.length; i++) {
            if (count > height) {
                height += 600;
                this.setPreferredSize(new Dimension(450, height));
            }
            border[i] = new JPanel();
            border[i].setBackground(new Color(0x4B4B4B));
            border[i].setPreferredSize(new Dimension(400, 1));
            contactPanels[i] = new ContactPanels();
            String temp = String.valueOf(contacts.contactsList.getName(i).charAt(0));
            System.out.println(temp);
            contactPanels[i].icon.setText(temp.toUpperCase());
            contactPanels[i].name.setText(contacts.contactsList.getName(i));
            contactPanels[i].number.setText(contacts.contactsList.getNumber(i));
            this.add(contactPanels[i]);
            this.add(border[i]);
            count += 60;
            panelCounter++;
        }
        System.out.println("Printing List: ");
        contacts.printList();
        this.repaint();
    }

    public void addContact(String name) {
        contacts.contactsList.add(name);
        contacts.contactsTree.add(name);
    }
}
