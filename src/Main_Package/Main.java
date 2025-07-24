package Main_Package;
import Entries.Recents;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //the main frame for the application
        JFrame mainFrame = new JFrame();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Phone");

        //icon for our phone app
        ImageIcon icon = new ImageIcon("phone_icon.png");
        mainFrame.setIconImage(icon.getImage());

        //
        MainPanel mainPanel = new MainPanel();
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);

        Recents recents = new Recents();
        recents.printRecents();
    }
}