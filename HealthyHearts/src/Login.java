import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JFrame frame = new JFrame();
    ImageIcon main_login;
    JLabel label;
    ImageIcon user_interface;
    JLabel user_name;
    JTextField tusername;
    ImageIcon padlock;
    JLabel pass_word;
    JPasswordField tpassword;
    JButton login;
    JLabel text1;
    JButton register;
    JLabel text2;
    JButton forget;
    Login(){

        main_login = new ImageIcon("login_main.png");
        Image i = main_login.getImage();
        Image new_image = i.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        main_login = new ImageIcon(new_image);

        label = new JLabel();
        label.setIcon(main_login);
        label.setBounds(200,50,200,200);
        label.setBackground(new Color(0x8EACCD));
        label.setOpaque(true);

        user_interface = new ImageIcon("user-interface.png");
        Image i1 = user_interface.getImage();
        Image new_image1 = i1.getScaledInstance(20,20,Image.SCALE_SMOOTH);
        user_interface = new ImageIcon(new_image1);

        user_name = new JLabel();
        user_name.setIcon(user_interface);
        user_name.setText("Username");
        user_name.setFont(new Font("Cambria",Font.PLAIN,20));
        user_name.setForeground(Color.black);
        user_name.setBounds(150,283,200,50);

        tusername = new JTextField();
        tusername.setFont(new Font("Monospace",Font.PLAIN,20));
        tusername.setBounds(150,320,300,25);
        tusername.setBorder(BorderFactory.createEmptyBorder());

        padlock = new ImageIcon("padlock.png");
        Image i2 = padlock.getImage();
        Image new_image2 = i2.getScaledInstance(20,20,Image.SCALE_SMOOTH);
        padlock = new ImageIcon(new_image2);

        pass_word = new JLabel();
        pass_word.setIcon(padlock);
        pass_word.setText("Password");
        pass_word.setFont(new Font("Cambria",Font.PLAIN,20));
        pass_word.setForeground(Color.black);
        pass_word.setBounds(150,353,200,50);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Monospace",Font.PLAIN,20));
        tpassword.setBounds(150,390,300,25);
        tpassword.setBorder(BorderFactory.createEmptyBorder());

        login = new JButton("Login");
        login.setBounds(255,450,80,30);
        login.setBackground(new Color(0x1B9C85));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        login.addActionListener(this);
        login.setFocusable(false);

        text1 = new JLabel("New User? Register here...");
        text1.setFont(new Font("Cambria",Font.PLAIN,16));
        text1.setForeground(new Color(0xBB2525));
        text1.setBounds(150,550,200,20);

        register = new JButton("Register");
        register.setBounds(340,548,80,25);
        register.setBackground(new Color(0x1B9C85));
        register.setForeground(Color.white);
        register.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        register.addActionListener(this);
        register.setFocusable(false);

        text2 = new JLabel("Forgot Password? Click here...");
        text2.setFont(new Font("Cambria",Font.PLAIN,16));
        text2.setForeground(new Color(0xBB2525));
        text2.setBounds(150,600,300,20);

        forget = new JButton("Reset Password");
        forget.setBounds(368,598,120,25);
        forget.setBackground(new Color(0x1B9C85));
        forget.setForeground(Color.white);
        forget.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        forget.addActionListener(this);
        forget.setFocusable(false);

        frame.add(label);
        frame.add(tusername);
        frame.add(user_name);
        frame.add(tpassword);
        frame.add(pass_word);
        frame.add(login);
        frame.add(text1);
        frame.add(register);
        frame.add(text2);
        frame.add(forget);

        frame.setTitle("Login");
        frame.setIconImage(main_login.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600,700);
        frame.getContentPane().setBackground(new Color(0x8EACCD));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            try{
                String username = tusername.getText();
                String password = tpassword.getText();

                Conn c = new Conn();
                String query = "select * from data_storage where username = '"+username+"' AND password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    new Dashboard();
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect username and password");
                }
            }
            catch(Exception a){
                a.printStackTrace();
            }

        }
        if(e.getSource()==register){
            frame.dispose();
            new Register();
        }
        if(e.getSource()==forget){
            frame.dispose();
            new ForgotPassword();
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

}


//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener{
//
//    JButton login;
//    JButton register;
//    JFrame frame = new JFrame();
//
//    ImageIcon main_login;
//    ImageIcon user_interface;
//    ImageIcon padlock;
//
//    JLabel label;
//    JLabel user_name;
//    JLabel pass_word;
//    JLabel text;
//    JTextField tusername,tpassword;
//    //JPasswordField password;
//    Login(){
//
//        login = new JButton("Login");
//        login.setBounds(255,450,80,30);
//        login.setBackground(new Color(0x1B9C85));
//        login.setForeground(Color.white);
//        login.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        login.setFocusable(false);
//        login.addActionListener(this);
//
//        text = new JLabel("New User? Register here...");
//        text.setFont(new Font("Cambria",Font.PLAIN,16));
//        text.setForeground(new Color(0xBB2525));
//        text.setBounds(150,550,200,20);
//
//        register = new JButton("Register");
//        register.setBounds(340,548,80,25);
//        register.setBackground(new Color(0x1B9C85));
//        register.setForeground(Color.white);
//        register.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        register.addActionListener(this);
//        register.setFocusable(false);
//
//        main_login = new ImageIcon("login_main.png");
//        Image i = main_login.getImage();
//        Image new_image = i.getScaledInstance(200,200,Image.SCALE_SMOOTH);
//        main_login = new ImageIcon(new_image);
//
//        user_interface = new ImageIcon("user-interface.png");
//        Image i1 = user_interface.getImage();
//        Image new_image1 = i1.getScaledInstance(20,20,Image.SCALE_SMOOTH);
//        user_interface = new ImageIcon(new_image1);
//
//        padlock = new ImageIcon("padlock.png");
//        Image i2 = padlock.getImage();
//        Image new_image2 = i2.getScaledInstance(20,20,Image.SCALE_SMOOTH);
//        padlock = new ImageIcon(new_image2);
//
//        label = new JLabel();
//        label.setIcon(main_login);
//        label.setBounds(200,50,200,200);
//        label.setBackground(new Color(0xA2C579));
//        label.setOpaque(true);
//
//        user_name = new JLabel();
//        user_name.setIcon(user_interface);
//        user_name.setText("Username");
//        user_name.setFont(new Font("Cambria",Font.PLAIN,20));
//        user_name.setForeground(Color.white);
//        user_name.setBounds(150,283,200,50);
//
//        pass_word = new JLabel();
//        pass_word.setIcon(padlock);
//        pass_word.setText("Password");
//        pass_word.setFont(new Font("Cambria",Font.PLAIN,20));
//        pass_word.setForeground(Color.white);
//        pass_word.setBounds(150,353,200,50);
//
//        tusername = new JTextField();
//        tusername.setFont(new Font("Monospace",Font.PLAIN,20));
//        tusername.setBounds(150,320,300,25);
//        tusername.setBorder(BorderFactory.createEmptyBorder());
//
//        tpassword = new JTextField();
//        tpassword.setFont(new Font("Monospace",Font.PLAIN,20));
//        tpassword.setBounds(150,390,300,25);
//        tpassword.setBorder(BorderFactory.createEmptyBorder());
//
//        frame.add(tusername);
//        frame.add(tpassword);
//        frame.add(user_name);
//        frame.add(pass_word);
//        frame.add(label);
//        frame.add(login);
//        frame.add(register);
//        frame.add(text);
//
//        frame.setTitle("Login");
//        frame.setIconImage(main_login.getImage());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(null);
//        frame.setSize(600,700);
//        frame.getContentPane().setBackground(new Color(0xA2C579));
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//
//    }
//
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource()== login){
//            try{
//                String username = tusername.getText();
//                String password = tpassword.getText();
//
//                Conn c = new Conn();
//                String query = "select * from login_data_storage where username = '"+username+"' AND password = '"+password+"'";
//                ResultSet rs = c.s.executeQuery(query);
//                if(rs.next()){
//                    setVisible(false);
//                    new Dashboard();
//                }
//                else{
//                    JOptionPane.showMessageDialog(null,"Incorrect username and password");
//                }
//            }
//            catch(Exception a){
//                a.printStackTrace();
//            }
//        }
//        else if(e.getSource()== register){
//            setVisible(false);
//            new Register();
//        }
//        else{
//            setVisible(false);
//            new ForgotPassword();
//        }
////        if(e.getSource()==login) {
////            String username = tusername.getText();
////            String password = tpassword.getText();
////            String query= "insert into login_data_storage values('"+username+"', '"+password+"')";
////            try{
////                Conn c = new Conn();
////                c.s.executeUpdate(query);
////                JOptionPane.showMessageDialog(null,"Login Successfully");
////                setVisible(false);
////            }catch(Exception f) {
////                f.printStackTrace();
////            }
////        }
//
//
//
//    }
//
//
//    public static void main(String[] args) {
//        Login login = new Login();
//    }
//
//}