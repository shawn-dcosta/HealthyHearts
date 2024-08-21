import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ForgotPassword extends JFrame implements ActionListener {

    JFrame quest = new JFrame();
    JPanel panel0;
    JPanel panel1;
    JPanel panel2;
    JLabel l0;
    JLabel l01;
    JTextField t0;
    JButton b0;
    JLabel head1;
    ImageIcon security;
    ImageIcon resetp;
    ImageIcon one;
    JLabel q1;
    JTextField a1;
    ImageIcon two;
    JLabel q2;
    JTextField a2;
    ImageIcon three;
    JLabel q3;
    JTextField a3;
    JButton next;
    JLabel head2;
    JLabel new_p;
    JPasswordField p1;
    JLabel conf_newp;
    JPasswordField p2;
    JButton confirm;


    ForgotPassword(){

        l0 = new JLabel("Enter Username:");


        panel0 = new JPanel();

        head1 = new JLabel("<html>Answer the following Security Questions,<br><center>to reset your account Password.</center></html>",SwingConstants.CENTER);
        head1.setHorizontalAlignment(JLabel.CENTER);
        head1.setBounds(0,30,800,100);
        head1.setFont(new Font("Stencil",Font.PLAIN,33));
        head1.setForeground(Color.black);
        head1.setLayout(null);
        head1.setOpaque(false);

        one = new ImageIcon("1.png");
        Image i1 = one.getImage();
        Image new_image1 = i1.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        one = new ImageIcon(new_image1);

        q1 = new JLabel("   What is your Pet's name?");
        q1.setFont(new Font("Monospace",Font.PLAIN,25));
        q1.setForeground(new Color(0xFFFFFF));
        q1.setBounds(200,250,500,30);
        q1.setIcon(one);
        q1.setLayout(null);
        q1.setOpaque(false);

        a1 = new JTextField();
        a1.setBorder(BorderFactory.createEmptyBorder());
        a1.setFont(new Font("Monospace",Font.PLAIN,20));
        a1.setBounds(258,290,278,25);

        two = new ImageIcon("2.png");
        Image i2 = two.getImage();
        Image new_image2 = i2.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        two = new ImageIcon(new_image2);

        q2 = new JLabel("   What was your childhood Nickname?");
        q2.setFont(new Font("Monospace",Font.PLAIN,25));
        q2.setForeground(new Color(0xFFFFFF));
        q2.setBounds(200,370,500,30);
        q2.setIcon(two);
        q2.setLayout(null);
        q2.setOpaque(false);

        a2 = new JTextField();
        a2.setBorder(BorderFactory.createEmptyBorder());
        a2.setFont(new Font("Monospace",Font.PLAIN,20));
        a2.setBounds(258,410,278,25);

        three = new ImageIcon("3.png");
        Image i3 = three.getImage();
        Image new_image3 = i3.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        three = new ImageIcon(new_image3);

        q3 = new JLabel("   What is your favourite Sport?");
        q3.setFont(new Font("Monospace",Font.PLAIN,25));
        q3.setForeground(new Color(0xFFFFFF));
        q3.setBounds(200,490,500,30);
        q3.setIcon(three);
        q3.setLayout(null);
        q3.setOpaque(false);

        a3 = new JTextField();
        a3.setBorder(BorderFactory.createEmptyBorder());
        a3.setFont(new Font("Monospace",Font.PLAIN,20));
        a3.setBounds(258,530,278,25);

        next = new JButton("Next");
        next.setFocusable(false);
        next.setBackground(new Color(0x1B9C85));
        next.setForeground(Color.white);
        next.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        next.setBounds(353,630,80,30);
        next.addActionListener(this);

        panel1 = new JPanel();
        panel1.setSize(800,800);
        panel1.setBackground(new Color(0x478778));

        panel1.add(head1);
        panel1.add(q1);
        panel1.add(a1);
        panel1.add(q2);
        panel1.add(a2);
        panel1.add(q3);
        panel1.add(a3);
        panel1.add(next);

        panel1.setLayout(null);
        panel1.setVisible(true);

        head2 = new JLabel("Set New Password!");
        head2.setHorizontalAlignment(JLabel.CENTER);
        head2.setBounds(10,70,800,100);
        head2.setFont(new Font("Britannic Bold",Font.PLAIN,50));
        head2.setForeground(Color.black);
        head2.setLayout(null);
        head2.setOpaque(false);

        new_p = new JLabel("Enter a new Password:");
        new_p.setFont(new Font("Monospace",Font.PLAIN,23));
        new_p.setForeground(new Color(0xFFFFFF));
        new_p.setBounds(258,250,500,30);

        p1 = new JPasswordField();
        p1.setBorder(BorderFactory.createEmptyBorder());
        p1.setFont(new Font("Monospace",Font.PLAIN,20));
        p1.setBounds(258,290,278,25);

        conf_newp = new JLabel("Re-enter your Password:");
        conf_newp.setFont(new Font("Monospace",Font.PLAIN,23));
        conf_newp.setForeground(new Color(0xFFFFFF));
        conf_newp.setBounds(258,370,500,30);

        p2 = new JPasswordField();
        p2.setBorder(BorderFactory.createEmptyBorder());
        p2.setFont(new Font("Monospace",Font.PLAIN,20));
        p2.setBounds(258,410,278,25);

        panel2 = new JPanel();
        panel2.setSize(800,800);
        panel2.setBackground(new Color(0x478778));

        confirm = new JButton("Reset Password");
        confirm.setFocusable(false);
        confirm.setBackground(new Color(0x1B9C85));
        confirm.setForeground(Color.white);
        confirm.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        confirm.setBounds(330,510,120,30);
        confirm.addActionListener(this);

        panel2.add(head2);
        panel2.add(new_p);
        panel2.add(p1);
        panel2.add(conf_newp);
        panel2.add(p2);
        panel2.add(confirm);

        panel2.setLayout(null);
        panel2.setVisible(false);

        security = new ImageIcon("security.png");

        quest.add(panel1);
        quest.add(panel2);

        quest.setSize(800,800);
        quest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quest.setIconImage(security.getImage());
        quest.setTitle("Security Questions");
        quest.setLayout(null);
        quest.setLocationRelativeTo(null);
//        quest.getContentPane().setBackground(new Color(0xA2C579));
        quest.setVisible(true);

        resetp = new ImageIcon("reset-password.png");

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==next){
            panel1.setVisible(false);
            panel2.setVisible(true);
            quest.setIconImage(resetp.getImage());
            quest.setTitle("Reset Password");
        }
        if(e.getSource()==confirm){
            String pass1 = p1.getText();
            String pass2 = p2.getText();
            String pet= a1.getText();
            String nickname= a2.getText();
            String sport= a3.getText();
            try {
                String query = "UPDATE data_storage set confirm_password= '" +p2.getText()+"'  WHERE nickname= '" + a2.getText() + "'";
                String query2 = "UPDATE data_storage set password= '" +p2.getText()+"'  WHERE nickname= '" + a2.getText() + "'";
                Conn c = new Conn();

                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
            }catch(Exception f) {
                f.printStackTrace();
            }

            p1.setEnabled(false);
            p2.setEnabled(false);

            String[] responses = {};
            ImageIcon imageIcon = new ImageIcon("reset_success.png");
            Image i = imageIcon.getImage();
            Image new_image = i.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(new_image);
            JOptionPane optionPane = new JOptionPane("Password Reset Successfully.\nRedirecting to Login page...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, imageIcon, responses, 0);

            final JDialog dialog = optionPane.createDialog(null, "Reset Successful!");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
            timer.setRepeats(false);
            timer.start();

            dialog.setVisible(true);
            quest.dispose();
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgotPassword();
    }

}