package Main_Package;

import Entries.ContactPanels;
import Test.Node;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;

public class HomePanel extends JPanel implements ActionListener {

    JLabel jLabel = new JLabel("Phone");
    JButton addButton = new JButton("+");
    JButton deleteButton = new JButton("\uD83D\uDDD1");
    JButton delete = new JButton("Delete");
    JButton editButton = new JButton("✎");
    JButton editButton2 = new JButton("⠇");
    JButton searchButton = new JButton("\uD83D\uDD0D︎");
    JButton add = new JButton("Add");
    JButton update = new JButton("Update");
    JButton search = new JButton("Search");
    JButton cancel = new JButton("Cancel");
    JButton ok;
    JFrame addFrame = new JFrame();
    JFrame searchFrame = new JFrame();
    JFrame deleteFrame = new JFrame();
    JFrame editFrame = new JFrame();
    JFrame promt;
    JPanel addPanel;
    JPanel editPanel;
    JPanel contactPanel;
    JPanel searchPanel;
    JTextField name;
    JTextField name2;
    JTextField number;
    JTextField email;
    ContactContentPanels contactContentPanels;
    HomePanel(ContactContentPanels contactContentPanels) {
        this.contactContentPanels = contactContentPanels;
        this.setPreferredSize(new Dimension(450, 300));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setLayout(null);
        jLabel.setBounds(150, 5, 300, 300);
        this.add(jLabel);
        addButton.setBounds(350,260,70,40);
        addButton.setForeground(Color.WHITE);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);
        addButton.setOpaque(false);
        addButton.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        addButton.addActionListener(this);

        searchButton.setBounds(400,260,70,40);
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusPainted(false);
        searchButton.setOpaque(false);
        searchButton.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        searchButton.addActionListener(this);

        deleteButton.setBounds(300,260,70,40);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBorderPainted(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setFocusPainted(false);
        deleteButton.setOpaque(false);
        deleteButton.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        deleteButton.addActionListener(this);

        editButton.setBounds(250,260,70,40);
        editButton.setForeground(Color.WHITE);
        editButton.setBorderPainted(false);
        editButton.setContentAreaFilled(false);
        editButton.setFocusPainted(false);
        editButton.setOpaque(false);
        editButton.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        editButton.addActionListener(this);

        editButton2.setBounds(350,260,70,40);
        editButton2.setForeground(Color.WHITE);
        editButton2.setBorderPainted(false);
        editButton2.setContentAreaFilled(false);
        editButton2.setFocusPainted(false);
        editButton2.setOpaque(false);
        editButton2.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        editButton2.addActionListener(this);

        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 50));

        this.add(editButton2);
        this.add(searchButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton || e.getSource() == editButton2) {
            UpdateContact();
        }
        if (e.getSource() == update) {
            if (name.getText().equals("Old Name") || name.getText().equals("") ||
                    name2.getText().equals("New Name") || name2.getText().equals("")) {
                displayErr("Enter Old and/or New Name");
            }
            else {
                Update(name.getText(), name2.getText());
            }
        }
        if (e.getSource() == deleteButton) {
            DeleteContact();
        }
        if (e.getSource() == delete) {
            if (name.getText().equals("Name") || name.getText().equals("")) {
                displayErr("Enter Name");
                return;
            }
            Node node = contactContentPanels.contacts.contactsList.Delete(name.getText());
            if (node == null) {
                displayNoName();
            }
            else {
                displayDeletionSuccess();
                contactContentPanels.contacts.contactsList.printList();
                deleteInFile();
                deleteFrame.dispose();
                contactContentPanels.loadContacts();
            }
        }
        if (e.getSource() == addButton) {
            AddContacts();
        }
        if (e.getSource() == searchButton) {
            SearchContact();
        }
        if (e.getSource() == search) {
            if (name.getText().equals("") || name.getText().equals("Name")) {
                displayErr("Enter Name");
            }
            else {
                repaintContactPanel(Search(name.getText()));
            }
        }
        if (e.getSource() == cancel) {
            addFrame.dispose();
            searchFrame.dispose();
            deleteFrame.dispose();
            editFrame.dispose();
        }
        if (e.getSource() == ok) {
            promt.dispose();
        }
        if(e.getSource()==add){
            if ((name.getText().equals("Name") || name.getText().equals("")) && (number.getText().equals("Phone") || number.getText().equals(""))) {
               displayErr("Enter Name or Number");
            }
            else {
                try {
                    if (name.getText().equals("Name") || name.getText().equals("")) {
                        name.setText("");
                    }
                    if (number.getText().equals("Phone") || number.getText().equals("")) {
                        number.setText("");
                    }
                    if (email.getText().equals("E-Mail") || email.getText().equals("")) {
                        email.setText("");
                    }
                    Writer bf = new BufferedWriter(new FileWriter("src/Logs/Contacts", true));
                    String temp = "\n" + name.getText() + "%" + number.getText() + "%" + email.getText();
                    bf.append(temp);
                    bf.close();
                    contactContentPanels.contacts.resetList();
                    contactContentPanels.loadContacts();
                    addFrame.dispose();
                }catch (IOException f) {
                    f.printStackTrace();
                }
            }
        }
    }
    private void displayErr(String text) {
        promt = new JFrame();
        promt.setPreferredSize(new Dimension(400, 200));
        promt.pack();
        promt.setVisible(true);
        promt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        promt.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setLayout(new BorderLayout());
        JLabel promtText = new JLabel(text);
        promtText.setForeground(Color.RED);
        promtText.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 20));
        promtText.setHorizontalAlignment(SwingConstants.CENTER);
        ok = new JButton("OK");
        ok.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        ok.setForeground(Color.WHITE);
        ok.setFocusPainted(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setOpaque(false);
        ok.addActionListener(this);
        panel.add(promtText, BorderLayout.CENTER);
        panel.add(ok, BorderLayout.SOUTH);
        promt.add(panel);
    }
    private void displayDeletionSuccess() {
        promt = new JFrame();
        promt.setPreferredSize(new Dimension(400, 200));
        promt.pack();
        promt.setVisible(true);
        promt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        promt.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setLayout(new BorderLayout());
        JLabel promtText = new JLabel("Contact Deleted Successfully");
        promtText.setForeground(Color.RED);
        promtText.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 20));
        promtText.setHorizontalAlignment(SwingConstants.CENTER);
        ok = new JButton("OK");
        ok.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        ok.setForeground(Color.WHITE);
        ok.setFocusPainted(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setOpaque(false);
        ok.addActionListener(this);
        panel.add(promtText, BorderLayout.CENTER);
        panel.add(ok, BorderLayout.SOUTH);
        promt.add(panel);
    }
    private void displayEditSuccess() {
        promt = new JFrame();
        promt.setPreferredSize(new Dimension(400, 200));
        promt.pack();
        promt.setVisible(true);
        promt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        promt.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setLayout(new BorderLayout());
        JLabel promtText = new JLabel("Contact Updated Successfully");
        promtText.setForeground(Color.RED);
        promtText.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 20));
        promtText.setHorizontalAlignment(SwingConstants.CENTER);
        ok = new JButton("OK");
        ok.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        ok.setForeground(Color.WHITE);
        ok.setFocusPainted(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setOpaque(false);
        ok.addActionListener(this);
        panel.add(promtText, BorderLayout.CENTER);
        panel.add(ok, BorderLayout.SOUTH);
        promt.add(panel);
    }
    private void displayNoName() {
        promt = new JFrame();
        promt.setPreferredSize(new Dimension(400, 200));
        promt.pack();
        promt.setVisible(true);
        promt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        promt.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(400, 200));
        panel.setLayout(new BorderLayout());
        JLabel promtText = new JLabel("Name Not Found");
        promtText.setForeground(Color.RED);
        promtText.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 20));
        promtText.setHorizontalAlignment(SwingConstants.CENTER);
        ok = new JButton("OK");
        ok.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        ok.setForeground(Color.WHITE);
        ok.setFocusPainted(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setOpaque(false);
        ok.addActionListener(this);
        panel.add(promtText, BorderLayout.CENTER);
        panel.add(ok, BorderLayout.SOUTH);
        promt.add(panel);
    }
    private void DeleteContact() {
        deleteFrame = new JFrame();
        deleteFrame.setPreferredSize(new Dimension(600, 400));
        deleteFrame.setVisible(true);
        deleteFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        deleteFrame.setResizable(false);
        deleteFrame.setTitle("Delete Contact");
        deleteFrame.setLocationRelativeTo(null);
        deleteFrame.pack();

        JPanel deletePanel = new JPanel();
        deletePanel.setBackground(Color.BLACK);
        deletePanel.setLayout(null);
        deleteFrame.add(deletePanel);

        JTextField temp = new JTextField("Temp");
        temp.setPreferredSize(new Dimension(4, 4));
        temp.setBackground(Color.BLACK);
        temp.setForeground(Color.BLACK);
        temp.setBorder(null);
        temp.setVisible(true);
        temp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (temp.getText().trim().equals("Temp")) {
                    temp.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (temp.getText().trim().equals("")) {
                    temp.setText("Temp");
                }
            }
        });

        int width = 550;
        int y = 40;

        name = new JTextField("Name");
        name.setBounds(15, y + 40, width, 45);
        name.setBackground(new Color(0x171717));
        name.setForeground(Color.WHITE);
        name.setBorder(null);
        name.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name.getText().trim().equals("Name")) {
                    name.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (name.getText().trim().equals("")) {
                    name.setText("Name");
                }
            }
        });

        delete.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        delete.setBounds(-20, y + 125, 150, 100);
        delete.setForeground(Color.WHITE);
        delete.setFocusPainted(false);
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);
        delete.setOpaque(false);
        delete.addActionListener(this);

        cancel.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        cancel.setBounds(445, y + 125, 150, 100);
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setContentAreaFilled(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(false);
        cancel.addActionListener(this);

        deletePanel.add(temp);
        deletePanel.add(name);
        deletePanel.add(delete);
        deletePanel.add(cancel);
    }
    private void deleteInFile() {
        try {
            Writer bf = new BufferedWriter(new FileWriter("src/Logs/Contacts"));
            Node contact = contactContentPanels.contacts.contactsList.get(0);
            String name = contact.getName() + "%" + contact.getNumber() + "%" + contact.getEmail();
            bf.append(name);
            for (int i = 1; i < contactContentPanels.contacts.contactsList.length(); i++) {
                contact = contactContentPanels.contacts.contactsList.get(i);
                name = "\n" + contact.getName() + "%" + contact.getNumber() + "%" + contact.getEmail();
                bf.append(name);
            }
            bf.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void AddContacts() {
        addFrame = new JFrame();
        addFrame.setPreferredSize(new Dimension(600, 400));
        addFrame.setVisible(true);
        addFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addFrame.setResizable(false);
        addFrame.setTitle("Add Contacts");

        addPanel = new JPanel();
        addPanel.setBackground(Color.BLACK);
        addFrame.add(addPanel);
        addFrame.pack();
        addFrame.setLocationRelativeTo(null);
        addPanel.setLayout(null);

        name = new JTextField("Name");
        number = new JTextField("Phone");
        email = new JTextField("E-Mail");

        JTextField temp = new JTextField("Temp");
        temp.setPreferredSize(new Dimension(4, 4));
        temp.setBackground(Color.BLACK);
        temp.setForeground(Color.BLACK);
        temp.setBorder(null);
        temp.setVisible(true);
        temp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (temp.getText().trim().equals("Temp")) {
                    temp.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (temp.getText().trim().equals("")) {
                    temp.setText("Temp");
                }
            }
        });

        int width = 550;
        int y = 40;

        name.setBounds(15, y, width, 45);
        name.setBackground(new Color(0x171717));
        name.setForeground(Color.WHITE);
        name.setBorder(null);
        name.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name.getText().trim().equals("Name")) {
                    name.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (name.getText().trim().equals("")) {
                    name.setText("Name");
                }
            }
        });

        number.setBounds(15, y + 50, width, 45);
        number.setBackground(new Color(0x171717));
        number.setForeground(Color.WHITE);
        number.setBorder(null);
        number.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        number.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (number.getText().trim().equals("Phone")) {
                    number.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (number.getText().trim().equals("")) {
                    number.setText("Phone");
                }
            }
        });

        email.setBounds(15, y + 100, width, 45);
        email.setBackground(new Color(0x171717));
        email.setForeground(Color.WHITE);
        email.setBorder(null);
        email.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (email.getText().trim().equals("E-Mail")) {
                    email.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (email.getText().trim().equals("")) {
                    email.setText("E-Mail");
                }
            }
        });

        add.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        add.setBounds(-7, y + 125, 100, 100);
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add.setContentAreaFilled(false);
        add.setBorderPainted(false);
        add.setOpaque(false);
        add.addActionListener(this);

        cancel.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        cancel.setBounds(445, y + 125, 150, 100);
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setContentAreaFilled(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(false);
        cancel.addActionListener(this);

        addPanel.add(temp);
        addPanel.add(name);
        addPanel.add(number);
        addPanel.add(email);
        addPanel.add(add);
        addPanel.add(cancel);
    }
    private void SearchContact() {
        searchFrame = new JFrame();
        searchFrame.setVisible(true);
        searchFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        searchFrame.setPreferredSize(new Dimension(600, 400));
        searchFrame.setResizable(false);
        searchFrame.pack();
        searchFrame.setTitle("Search Contacts");
        searchFrame.setLocationRelativeTo(null);
        searchFrame.setLayout(new BorderLayout());

        searchPanel = new JPanel();
        searchPanel.setBackground(Color.BLACK);
        searchPanel.setPreferredSize(new Dimension(600, 180));
        searchPanel.setLayout(null);
        searchFrame.add(searchPanel, BorderLayout.NORTH);

        contactPanel = new JPanel();
        contactPanel.setBackground(Color.BLACK);
        contactPanel.setPreferredSize(new Dimension(600, 220));
        contactPanel.setLayout(null);
        searchFrame.add(contactPanel, BorderLayout.SOUTH);

        JTextField temp = new JTextField("Temp");
        temp.setPreferredSize(new Dimension(4, 4));
        temp.setBackground(Color.BLACK);
        temp.setForeground(Color.BLACK);
        temp.setBorder(null);
        temp.setVisible(true);
        temp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (temp.getText().trim().equals("Temp")) {
                    temp.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (temp.getText().trim().equals("")) {
                    temp.setText("Temp");
                }
            }
        });

        int width = 550;
        int y = 40;

        name = new JTextField("Name");
        name.setBounds(15, y, width, 45);
        name.setBackground(new Color(0x171717));
        name.setForeground(Color.WHITE);
        name.setBorder(null);
        name.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name.getText().trim().equals("Name")) {
                    name.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (name.getText().trim().equals("")) {
                    name.setText("Name");
                }
            }
        });

        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setContentAreaFilled(false);
        search.setBorderPainted(false);
        search.setBounds(-215, y + 70, width, 45);
        search.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        search.addActionListener(this);

        cancel.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        cancel.setBounds(245, y + 70, width, 45);
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setContentAreaFilled(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(false);
        cancel.addActionListener(this);

        searchPanel.add(temp);
        searchPanel.add(name);
        searchPanel.add(search);
        searchPanel.add(cancel);
    }
    private void repaintContactPanel(Node node) {
        if (node == null) {
            return;
        }

        contactPanel = new JPanel();
        contactPanel.setBackground(Color.BLACK);
        contactPanel.setPreferredSize(new Dimension(600, 220));
        contactPanel.setLayout(null);
        searchFrame.add(contactPanel, BorderLayout.SOUTH);

        ContactPanels contact = new ContactPanels();
        contact.name.setText(node.getName());
        contact.number.setText(node.getNumber());
        contact.setBounds(90, 90,  400, 40);
        contactPanel.add(contact);
        contactPanel.repaint();
        contactPanel.revalidate();
    }
    private Node Search(String name) {
        Node node = contactContentPanels.contacts.contactsTree.Search(name);
        if (node == null) {
            displayNoName();
            return null;
        }
        return node;
    }
    private void UpdateContact() {
        editFrame = new JFrame();
        editFrame.setVisible(true);
        editFrame.setTitle("Edit Contact");
        editFrame.setPreferredSize(new Dimension(600, 400));
        editFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        editFrame.setResizable(false);
        editFrame.setTitle("Add Contacts");
        editFrame.setLocationRelativeTo(null);
        editFrame.pack();

        editPanel = new JPanel();
        editPanel.setBackground(Color.BLACK);
        editPanel.setPreferredSize(new Dimension(600, 400));
        editFrame.add(editPanel);
        editPanel.setLayout(null);

        name = new JTextField("Name");
        number = new JTextField("Phone");
        email = new JTextField("E-Mail");

        JTextField temp = new JTextField("Temp");
        temp.setPreferredSize(new Dimension(4, 4));
        temp.setBackground(Color.BLACK);
        temp.setForeground(Color.BLACK);
        temp.setBorder(null);
        temp.setVisible(true);
        temp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (temp.getText().trim().equals("Temp")) {
                    temp.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (temp.getText().trim().equals("")) {
                    temp.setText("Temp");
                }
            }
        });

        int width = 550;
        int y = 40;

        name = new JTextField("Old Name");
        name.setBounds(15, y, width, 45);
        name.setBackground(new Color(0x171717));
        name.setForeground(Color.WHITE);
        name.setBorder(null);
        name.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name.getText().trim().equals("Old Name")) {
                    name.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (name.getText().trim().equals("")) {
                    name.setText("Old Name");
                }
            }
        });

        name2 = new JTextField("New Name");
        name2.setBounds(15, y + 70, width, 45);
        name2.setBackground(new Color(0x171717));
        name2.setForeground(Color.WHITE);
        name2.setBorder(null);
        name2.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        name2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name2.getText().trim().equals("New Name")) {
                    name2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (name2.getText().trim().equals("")) {
                    name2.setText("New Name");
                }
            }
        });

        update.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        update.setBounds(-7, y + 125, 150, 100);
        update.setForeground(Color.WHITE);
        update.setFocusPainted(false);
        update.setContentAreaFilled(false);
        update.setBorderPainted(false);
        update.setOpaque(false);
        update.addActionListener(this);

        cancel.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        cancel.setBounds(445, y + 125, 150, 100);
        cancel.setForeground(Color.WHITE);
        cancel.setFocusPainted(false);
        cancel.setContentAreaFilled(false);
        cancel.setBorderPainted(false);
        cancel.setOpaque(false);
        cancel.addActionListener(this);

        editPanel.add(temp);
        editPanel.add(name);
        editPanel.add(name2);
        editPanel.add(update);
        editPanel.add(cancel);
    }
    private void Update(String oldName, String newName) {
        boolean temp = contactContentPanels.contacts.contactsList.UpdateName(oldName, newName);
        if (!temp) {
            displayNoName();
        }
        else {
            displayEditSuccess();
            deleteInFile();
            contactContentPanels.loadContacts();
            editFrame.dispose();
        }
    }
}