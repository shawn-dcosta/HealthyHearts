import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JPanel implements ActionListener {

    JFrame frame = new JFrame();;
    JLabel label;
    JLabel text;
    JLabel n;
    JLabel sn;
    JLabel u;
    JLabel p1;
    JLabel p2;
    JLabel p;
    JLabel nn;
    JLabel s;
    JPanel panel;
    JPanel contentPanel;
    JScrollPane scrollPane;
    ImageIcon add_user;
    JTextField namef;
    JTextField surnamef;
    JTextField usernamef;
    JPasswordField password1f;
    JPasswordField password2f;
    JTextField petf;
    JTextField nicknamef;
    JTextField sportf;
    JButton submit;

    Register(){

        add_user = new ImageIcon("add_user.png");
        Image i = add_user.getImage();
        Image new_image = i.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        add_user = new ImageIcon(new_image);

        label = new JLabel();
        label.setIcon(add_user);
        label.setBounds(208,15,200,200);
        label.setBackground(new Color(0x22668D));
        label.setOpaque(true);

        panel = new JPanel();
        panel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0,0,608,786);
        scrollPane.setBackground(new Color(0x22668D));

        n = new JLabel("Enter your Name:");
        n.setForeground(Color.white);
        n.setFont(new Font("Monospace",Font.PLAIN,20));
        n.setBounds(150,285,300,20);

        namef = new JTextField();
        namef.setFont(new Font("Monospace",Font.PLAIN,20));
        namef.setBounds(150,310,300,25);
        namef.setBorder(BorderFactory.createEmptyBorder());

        sn = new JLabel("Enter your Surname:");
        sn.setForeground(Color.white);
        sn.setFont(new Font("Monospace",Font.PLAIN,20));
        sn.setBounds(150,385,300,20);

        surnamef = new JTextField();
        surnamef.setFont(new Font("Monospace",Font.PLAIN,20));
        surnamef.setBounds(150,410,300,25);
        surnamef.setBorder(BorderFactory.createEmptyBorder());

        u = new JLabel("Enter your Username:");
        u.setForeground(Color.white);
        u.setFont(new Font("Monospace",Font.PLAIN,20));
        u.setBounds(150,485,300,20);

        usernamef = new JTextField();
        usernamef.setFont(new Font("Monospace",Font.PLAIN,20));
        usernamef.setBounds(150,510,300,25);
        usernamef.setBorder(BorderFactory.createEmptyBorder());

        p1 = new JLabel("Enter your Password:");
        p1.setForeground(Color.white);
        p1.setFont(new Font("Monospace",Font.PLAIN,20));
        p1.setBounds(150,585,300,20);

        password1f = new JPasswordField();
        password1f.setFont(new Font("Monospace",Font.PLAIN,20));
        password1f.setBounds(150,610,300,25);
        password1f.setBorder(BorderFactory.createEmptyBorder());

        p2 = new JLabel("Confirm your Password:");
        p2.setForeground(Color.white);
        p2.setFont(new Font("Monospace",Font.PLAIN,20));
        p2.setBounds(150,685,300,20);

        password2f = new JPasswordField();
        password2f.setFont(new Font("Monospace",Font.PLAIN,20));
        password2f.setBounds(150,710,300,25);
        password2f.setBorder(BorderFactory.createEmptyBorder());

        text = new JLabel();
        text.setText("Security Questions:");
        text.setFont(new Font("Stencil",Font.PLAIN,20));
        text.setForeground(Color.black);
        text.setBounds(150,795,300,20);

        p = new JLabel("What is the name of your Pet?");
        p.setForeground(Color.white);
        p.setFont(new Font("Monospace",Font.PLAIN,20));
        p.setBounds(150,855,300,20);

        petf = new JTextField();
        petf.setFont(new Font("Monospace",Font.PLAIN,20));
        petf.setBounds(150,880,300,25);
        petf.setBorder(BorderFactory.createEmptyBorder());

        nn = new JLabel("What is your Nickname?");
        nn.setForeground(Color.white);
        nn.setFont(new Font("Monospace",Font.PLAIN,20));
        nn.setBounds(150,955,300,20);

        nicknamef = new JTextField();
        nicknamef.setFont(new Font("Monospace",Font.PLAIN,20));
        nicknamef.setBounds(150,980,300,25);
        nicknamef.setBorder(BorderFactory.createEmptyBorder());

        s = new JLabel("What is your favourite Sport?");
        s.setForeground(Color.white);
        s.setFont(new Font("Monospace",Font.PLAIN,20));
        s.setBounds(150,1055,300,20);

        sportf = new JTextField();
        sportf.setFont(new Font("Monospace",Font.PLAIN,20));
        sportf.setBounds(150,1080,300,25);
        sportf.setBorder(BorderFactory.createEmptyBorder());

        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setBackground(new Color(0x1B9C85));
        submit.setForeground(Color.white);
        submit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        submit.setBounds(258,1185,80,30);
        submit.addActionListener(this);

        contentPanel = new JPanel();

        contentPanel.add(label);
        contentPanel.add(n);
        contentPanel.add(namef);
        contentPanel.add(sn);
        contentPanel.add(surnamef);
        contentPanel.add(u);
        contentPanel.add(usernamef);
        contentPanel.add(p1);
        contentPanel.add(password1f);
        contentPanel.add(p2);
        contentPanel.add(password2f);
        contentPanel.add(text);
        contentPanel.add(p);
        contentPanel.add(petf);
        contentPanel.add(nn);
        contentPanel.add(nicknamef);
        contentPanel.add(s);
        contentPanel.add(sportf);
        contentPanel.add(submit);

//        for (int a = 1; a <= 50; a++) {
//            JLabel label = new JLabel("Label " + a + ":");
//            label.setBounds(10, 10 + (a - 1) * 30, 80, 20); // Position and size for the label
//
//            JTextField textField = new JTextField();
//            textField.setBounds(100, 10 + (a - 1) * 30, 200, 20); // Position and size for the text field
//
//            contentPanel.add(label);
//            contentPanel.add(textField);
//        }

        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(590,1250));
        contentPanel.setBackground(new Color(0x22668D));

        scrollPane.setViewportView(contentPanel);

        panel.add(scrollPane);

        frame.add(panel);

        frame.setTitle("Registration");
        frame.setIconImage(add_user.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(null);
        frame.setSize(620,820);
//        frame.getContentPane().setBackground(new Color(0xA2C579));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            namef.setEnabled(false);
            surnamef.setEnabled(false);
            usernamef.setEnabled(false);
            password1f.setEnabled(false);
            password2f.setEnabled(false);
            petf.setEnabled(false);
            nicknamef.setEnabled(false);
            sportf.setEnabled(false);

            String name = namef.getText();
            String username=usernamef.getText();
            String password= password1f.getText();
            String Confirm_password=password2f.getText();
            String surname= surnamef.getText();
            String pet=petf.getText();
            String nickname = nicknamef.getText();
            String sport=sportf.getText();
            String query = "INSERT INTO data_storage VALUES('"+name+"','"+username+"','"+surname+"','"+password+"','"+Confirm_password+"','"+pet+"','"+nickname+"','"+sport+"')";

            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                String[] responses = {};
                ImageIcon imageIcon = new ImageIcon("approve.png");
                Image i = imageIcon.getImage();
                Image new_image = i.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(new_image);
                JOptionPane optionPane = new JOptionPane("User Registered Successfully.\nRedirecting to Login page in 5 seconds...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, imageIcon, responses, 0);

                final JDialog dialog = optionPane.createDialog(null, "Success!");
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                // Create a timer to close the dialog after 5 seconds
                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false); // Run the timer only once
                timer.start();

                dialog.setVisible(true); // Display the dialog
//                JOptionPane.showMessageDialog(null,"Registered Successfully");
            }catch(Exception f) {
                f.printStackTrace();
            }


//            String[] responses = {};
//            ImageIcon imageIcon = new ImageIcon("approve.png");
//            Image i = imageIcon.getImage();
//            Image new_image = i.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
//            imageIcon = new ImageIcon(new_image);
//            JOptionPane optionPane = new JOptionPane("User Registered Successfully.\nRedirecting to Login page in 5 seconds...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, imageIcon, responses, 0);
//
//            final JDialog dialog = optionPane.createDialog(null, "Success!");
//            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//
//            // Create a timer to close the dialog after 5 seconds
//            Timer timer = new Timer(5000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    dialog.dispose();
//                }
//            });
//            timer.setRepeats(false); // Run the timer only once
//            timer.start();
//
//            dialog.setVisible(true); // Display the dialog

            frame.dispose();
            new Login();
        }
    }

//    public void actionPerformed(ActionEvent e){
//        if(e.getSource()==submit){
//
//            name.setEnabled(false);
//            surname.setEnabled(false);
//            username.setEnabled(false);
//            password1.setEnabled(false);
//            password2.setEnabled(false);
//            pet.setEnabled(false);
//            nickname.setEnabled(false);
//            sport.setEnabled(false);
//
//            String[] responses = {};
//            ImageIcon imageIcon = new ImageIcon("approve.png");
//            Image i = imageIcon.getImage();
//            Image new_image = i.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
//            imageIcon = new ImageIcon(new_image);
//            JOptionPane.showOptionDialog(null,"User Registered Successfully.\n Redirecting to Login page...","Success!",JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,imageIcon,responses,0);
//
//        }

    public static void main(String[] args) {
        new Register();
    }
}