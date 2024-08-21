import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Launch extends JFrame implements MouseListener {

    JFrame frame = new JFrame();
    int counter = 1;
    ImageIcon icon;
    ImageIcon logo;
    JLabel label;

    JProgressBar bar;

    Launch(){

        icon = new ImageIcon("Logo.png");
        logo = new ImageIcon("Logo_white_bgless.png");

        Image i1 = logo.getImage();
        Image new_image = i1.getScaledInstance(450,450,Image.SCALE_SMOOTH);
        logo = new ImageIcon(new_image);

        label = new JLabel();
        label.setIcon(logo);
        label.setBounds(275,20,400,400);
        label.setBackground(new Color(0x1F4172));
        label.setOpaque(true);

        bar = new JProgressBar(0,99);
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setBounds(330,450,350,50);
        bar.setFont(new Font("Digital-7",Font.BOLD,25));
        bar.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,new Color(0x00A36C),new Color(0x00A36C)));
//        bar.setForeground(new Color(0x50C878));
//        bar.setForeground(new Color(0x2AAA8A));
        bar.setForeground(new Color(0x4CBB17));
        bar.setBackground(Color.white);

        frame.add(label);
        frame.add(bar);
        frame.setTitle("Calorie Count");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.getContentPane().setBackground(new Color(0x1F4172));
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        fill();
    }

    public void fill() {

        while (counter <= 99) {
            bar.setValue(counter);
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 1;
            bar.setString(counter + " of 100");
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        bar.setString("Click anywhere to continue...");

        frame.addMouseListener(this);

    }

    public void mouseClicked(MouseEvent e) {
        frame.dispose();
        new Login();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        Launch launch = new Launch();
    }

}