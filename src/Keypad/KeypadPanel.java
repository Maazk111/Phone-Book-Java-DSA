package Keypad;

import Main_Package.Sound;
import Test.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadPanel extends JPanel implements ActionListener {
    JButton[] button = new JButton[10];
    JButton x = new JButton("X");

    JButton callButton = new JButton();

    JTextField numberField = new JTextField();

    StringBuilder num = new StringBuilder();

    Sound sound = new Sound();

    int top = -1;
    int font_size = 50;
    int gap = 30;

    Icon icon = new ImageIcon("C:\\Users\\sicki\\Documents\\Szabist\\Java\\Phone Book\\asset.png");

    public KeypadPanel() {
        this.setPreferredSize(new Dimension(450, 400));
        this.setBackground(Color.BLACK);
        this.setOpaque(false);
        this.setLayout(new FlowLayout());

        this.add(numberField);

        numberField.setBackground(Color.BLACK);
        numberField.setForeground(Color.WHITE);
        numberField.setBorder(null);
        numberField.setPreferredSize(new Dimension(325, 45));
        numberField.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 30));
        numberField.setHorizontalAlignment(JTextField.CENTER);
        numberField.setEditable(false);

        for (int i = 0; i <= 8; i++) {
            button[i] = new JButton();
            this.add(button[i]);
            button[i].setFont(new Font("SamsungSans-Bold", Font.PLAIN, font_size));
            button[i].setForeground(Color.WHITE);
            button[i].setBorder(BorderFactory.createEmptyBorder(gap - 20, gap + 20, gap - 20, gap + 20));
            button[i].setContentAreaFilled(false);
            button[i].addActionListener(this);
        }

        button[0].setText("1");button[1].setText("2");button[2].setText("3");
        button[3].setText("4");button[4].setText("5");button[5].setText("6");
        button[6].setText("7");button[7].setText("8");button[8].setText("9");

        this.add(callButton);
        callButton.setIcon(icon);
        callButton.setForeground(Color.WHITE);
        callButton.setPreferredSize(new Dimension(55, 55));
        callButton.setBorder(new RoundedBorder(55));
        callButton.setBorderPainted(false);
        callButton.setContentAreaFilled(false);
        callButton.addActionListener(this);

        button[9] = new JButton("0");
        this.add(button[9]);
        button[9].setFont(new Font("SamsungSans-Bold", Font.PLAIN, font_size));
        button[9].setForeground(Color.WHITE);
        button[9].setBorder(BorderFactory.createEmptyBorder(gap - 20, gap + 30, gap - 20, gap));
        button[9].setContentAreaFilled(false);
        button[9].addActionListener(this);

        this.add(x);
        x.setFont(new Font("SamsungSans-Bold", Font.PLAIN, font_size));
        x.setForeground(Color.WHITE);
        x.setBorder(BorderFactory.createEmptyBorder(gap - 20, gap + 22, gap - 20, 0));
        x.setContentAreaFilled(false);
        x.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == x) {
            if (top > -1) {
                num.deleteCharAt(top);
                numberField.setText(num.toString());
                top--;
            }
        }
        if (e.getSource() == callButton) {
            JFrame promt = new JFrame();
            promt.setBackground(Color.BLACK);
            promt.setVisible(true);
            promt.setPreferredSize(new Dimension(400, 200));
            promt.pack();
            promt.setResizable(false);
            promt.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBackground(Color.BLACK);
            panel.setPreferredSize(new Dimension(400, 600));
            JLabel err = new JLabel("Error420: No Sim Inserted");
            err.setFont(new Font("SamsungSans-Bold", Font.PLAIN, 25));
            err.setForeground(Color.RED);
            err.setOpaque(false);
            err.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(err, BorderLayout.CENTER);
            promt.add(panel);
            promt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == button[i]) {
                num.append(button[i].getText());
                sound.setFile(Integer.parseInt(button[i].getText()));
                sound.Play();
                numberField.setText(num.toString());
                top++;
                System.out.println(top);
            }
        }
    }
}
