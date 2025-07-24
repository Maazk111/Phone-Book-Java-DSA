package Main_Package;
import Entries.ContactPanels;
import Entries.Contacts;
import Entries.RecentPanels;
import Entries.Recents;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    Recents recents = new Recents();
    Contacts contacts = new Contacts();
    RecentPanels[] recentPanels;
    ContactPanels[] contactPanels;
    JPanel[] border;
    int height = 600;
    int heightCount = 600;
    ContentPanel() {
        this.setPreferredSize(new Dimension(450, height));
        this.setAutoscrolls(true);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
//        this.setOpaque(false);
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0x171717));
        recents.loadRecents();
        recentPanels = new RecentPanels[recents.panelCount];
        contactPanels = new ContactPanels[contacts.count];
        border = new JPanel[recents.count];
        loadRecents();
        recents.printRecents();
    }

    public void loadRecents() {
        int count = 0;
        for (int i = 0; i < recents.count; i++) {
            if (heightCount > height) {
                height += 600;
                this.setPreferredSize(new Dimension(450, height));
            }
            if (i % 2 == 0) {
                border[count] = new JPanel();
                border[count].setBackground(new Color(0x4B4B4B));
                border[count].setPreferredSize(new Dimension(400, 1));
                recentPanels[count] = new RecentPanels();
                recentPanels[count].name.setText(recents.recentsList.get(i).getName());
            }
            else {
                recentPanels[count].time.setText(recents.recentsList.get(i).getName());
                this.add(recentPanels[count]);
                this.add(border[count]);
                count++;
            }
            heightCount += 60;
        }
    }
}
