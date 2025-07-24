package Entries;

import javax.swing.*;
import java.awt.*;

public class ContactPanels extends JPanel {
    public JLabel name = new JLabel();
    public JLabel number = new JLabel();
    public JLabel icon = new JLabel();

    public ContactPanels() {
        this.setPreferredSize(new Dimension(400, 40));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(new Color(0x171717));


        icon.setText("Null");
        icon.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
        icon.setForeground(Color.WHITE);
        icon.setBounds(1, 7, 30, 30);

        name.setText("Null");
        name.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 18));
        name.setForeground(Color.WHITE);
        name.setBounds(40, -4, 150, 50);

        number.setText("Null");
        number.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 18));
        number.setForeground(Color.WHITE);
        number.setBounds(280, -4, 150, 50);

        this.add(icon);
        this.add(name);
        this.add(number);
    }
}
