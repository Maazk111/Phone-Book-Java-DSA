package Entries;

import javax.swing.*;
import java.awt.*;

public class RecentPanels extends JPanel {

    public JLabel name = new JLabel();
    public JLabel time = new JLabel();


    public RecentPanels() {
        name.setText("Null");
        time.setText("Null");
        name.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 18));
        time.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 13));
        name.setForeground(Color.WHITE);
        time.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 40));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
//        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0x171717));
        this.add(name, BorderLayout.WEST);
        this.add(time, BorderLayout.EAST);
    }

}
