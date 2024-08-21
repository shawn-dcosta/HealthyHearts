import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.awt.Transparency.TRANSLUCENT;

public class Dashboard extends JFrame implements ActionListener, ChangeListener, MouseListener {
    JFrame frame;
    ImageIcon icon;
    ImageIcon A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z;
    ImageIcon homeImg;
    JLabel img;
    JLabel head;    //l1
    JLabel l2_height;
    JLabel l2_weight;
    JLabel wait;
    JLabel l1;
    JTextField tf;
    JPanel panel;
    JLabel dispAns;
    JLabel under;
    JLabel homeImage;
    JLabel normal;
    JLabel over;
    JLabel obese1;
    JLabel obese2;
    JLabel obese3;
    JLabel srno;
    JLabel newDate;
    JLabel newDay;
    JLabel newMeal;
    JLabel newCalories;
    JLabel newDish;
    JLabel bmibg1;
    ImageIcon bmi;
    JTextField tf1;
    JTextField tf2;
    JLabel sr;
    JTextField tfsr;
    JTextField date;
    JTextField serial;
    JTextField calories;
    JTextField dish;
    JSlider slider;
    ImageIcon logo;
    JButton home;
    JButton logout;
    JButton b0;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton add;
    JButton update;
    JButton delete;
    JPanel sub1;
    JPanel sub2;
    JPanel sub3;
    JPanel sub4;
    JPanel sub5;
    JPanel top1;
    JPanel left1;
    JPanel left2;
    JPanel ans;
    JPanel right2;
    JPanel empty;
    JPanel contain,contain2;
    JPanel p0;
    JPanel alpha;
    JPanel blank1,blank2,list,pic;
    JLabel e1,e2,e3,e4,e5;
    JLabel singAlpha;
    JButton a,b,c,d,e,f0,g,h,i0,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,back;
    JComboBox day;
    JComboBox meal;
    JTable table;
    Object[][] data = {};//1,"Monday","03/12/2020","Breakfast","Egg","100"
    String[] columnNames = {"Serial No.","Day","Date","Meal","Dish","Calories"};
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    JTable table2;
    Object[][] data2 = {};
    String[] columnNames2 = {"Serial No.","Ingredient","Calories","Fats","Carbs","Proteins"};
    DefaultTableModel model2 = new DefaultTableModel(data2, columnNames2);
    private DefaultTableCellRenderer cellRenderer;
    Dashboard(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        logo = new ImageIcon("Logo_white_bgless.png");
        Image i = logo.getImage();
        Image new_image = i.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        logo = new ImageIcon(new_image);

        img = new JLabel();
        img.setBounds(0,15,200,200);
        img.setIcon(logo);

        left1 = new JPanel();
        left1.setBackground(new Color(0x123456));
        left1.setLayout(null);
        left1.setPreferredSize(new Dimension(200,(int)screenSize.getHeight()));

        home = new JButton("Home");
        home.setFont(new Font("Eras Demi ITC",Font.PLAIN,25));
        home.setFocusable(false);
        home.setBackground(new Color(0x123456));
        home.setForeground(Color.white);
        home.setBorder(BorderFactory.createEmptyBorder());
        home.setBounds(0,280,200,60);
        home.addActionListener(this);

        b1 = new JButton("BMI Calculator");
        b1.setFont(new Font("Eras Demi ITC",Font.PLAIN,25));
        b1.setFocusable(false);
        b1.setBackground(new Color(0x123456));
        b1.setForeground(Color.white);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setBounds(0,350,200,60);
        b1.addActionListener(this);

        b2 = new JButton("Calorie Counter");
        b2.setFont(new Font("Eras Demi ITC",Font.PLAIN,25));
        b2.setFocusable(false);
        b2.setBackground(new Color(0x123456));
        b2.setForeground(Color.white);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setBounds(0,420,200,60);
        b2.addActionListener(this);

        b3 = new JButton("A-Z Exercises");
        b3.setFont(new Font("Eras Demi ITC",Font.PLAIN,25));
        b3.setFocusable(false);
        b3.setBackground(new Color(0x123456));
        b3.setForeground(Color.white);
        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.setBounds(0,490,200,60);
        b3.addActionListener(this);

        b4 = new JButton("Meal Tracker");
        b4.setFont(new Font("Eras Demi ITC",Font.PLAIN,25));
        b4.setFocusable(false);
        b4.setBackground(new Color(0x123456));
        b4.setForeground(Color.white);
        b4.setBorder(BorderFactory.createEmptyBorder());
        b4.setBounds(0,560,200,60);
        b4.addActionListener(this);

        logout = new JButton("Logout");
        logout.setFont(new Font("Eras Demi ITC",Font.PLAIN,25));
        logout.setFocusable(false);
        logout.setBackground(new Color(0x123456));
        logout.setForeground(Color.white);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setBounds(0,630,200,60);
        logout.addActionListener(this);

        left1.add(img);
        left1.add(home);
        left1.add(b1);
        left1.add(b2);
        left1.add(b3);
        left1.add(b4);
        left1.add(logout);

        head = new JLabel("<html><center>Welcome to your path of Wellness & Strength<br> with Healthy Hearts - Where your nutrition counts!!</center></html>!!");
        head.setBounds(140,0,(int)screenSize.getWidth()-200,150);
        head.setForeground(new Color(0xC70039));
        head.setFont(new Font("Lucida Bright",Font.BOLD,40));

        top1 = new JPanel();
        top1.setPreferredSize(new Dimension((int)screenSize.getWidth()-200,150));
        top1.setLayout(null);
        top1.setBackground(Color.white);

        top1.add(head);

        homeImage = new JLabel();
        homeImg = new ImageIcon("homepage.jpg");
        Image home = homeImg.getImage();
        Image newHome = home.getScaledInstance(1250,750,Image.SCALE_SMOOTH);
        homeImg = new ImageIcon(newHome);

        sub1 = new JPanel();
        sub1.setBackground(Color.RED);
        sub1.setBounds(200,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
        sub1.setLayout(new BorderLayout());

        homeImage.setIcon(homeImg);
        sub1.add(homeImage,BorderLayout.SOUTH);
        sub1.add(top1,BorderLayout.NORTH);

        sub1.setVisible(true);

        l2_height = new JLabel("Enter your Height (in centimeters) :");
        l2_height.setFont(new Font("Bahnschrift",Font.PLAIN,25));
        l2_height.setBounds(180,250,400,30);

        tf1 = new JTextField();
        tf1.setFont(new Font("Cascadia Code SemiLight",Font.PLAIN,25));
        tf1.setBounds(180,300,200,25);
        tf1.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

        l2_weight = new JLabel("Adjust your Weight (in kgs):");
        l2_weight.setFont(new Font("Bahnschrift",Font.PLAIN,25));
        l2_weight.setBounds(180,410,400,30);

        tf2 = new JTextField();
        tf2.setFont(new Font("Cascadia Code SemiLight",Font.PLAIN,25));
        tf2.setBounds(500,410,50,25);
        tf2.setBorder(BorderFactory.createDashedBorder(Color.BLACK));

        tf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateSliderFromTextField(slider, tf2);
                }
            }
        });

        slider = new JSlider(0,400,200);
        slider.setBounds(48,460,610,70);
        slider.setBackground(Color.ORANGE);
        slider.setForeground(Color.BLACK);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(50);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Digital-7",Font.BOLD,17));
        slider.setOrientation(SwingConstants.HORIZONTAL);
        slider.addChangeListener(this);

        b5 = new JButton("Calculate");
        b5.setBounds(300,560,80,30);
        b5.setBackground(new Color(0x1B9C85));
        b5.setForeground(Color.white);
        b5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        b5.addActionListener(this);
        b5.setFocusable(false);

        left2 = new JPanel();
        left2.setBackground(Color.ORANGE);
        left2.setPreferredSize(new Dimension((int)screenSize.getWidth()-740,(int)screenSize.getHeight()));
        left2.setLayout(null);

        left2.add(l2_height);
        left2.add(l2_weight);
        left2.add(tf1);
        left2.add(tf2);
        left2.add(slider);
        left2.add(b5);

        bmi = new ImageIcon("BMI2.jpg");
        Image rebmi = bmi.getImage();
        Image new_rebmi = rebmi.getScaledInstance(540,550,Image.SCALE_SMOOTH);
        bmi = new ImageIcon(new_rebmi);

        bmibg1 = new JLabel();
        bmibg1.setBounds(0,0,540,550);
        bmibg1.setIcon(bmi);

        wait = new JLabel("<html>Please wait <br><center>while we calculate your BMI...</center></html>");
        wait.setForeground(Color.RED);
        wait.setFont(new Font("Consolas",Font.BOLD,20));
        wait.setBounds(100,620,400,50);

        ans = new JPanel();
        ans.setOpaque(false);
//        ans.setBackground(Color.YELLOW);
        ans.setBounds(0,0,450,900);
        ans.setLayout(null);
        ans.setVisible(false);

        right2 = new JPanel();
        right2.setBackground(Color.WHITE);
        right2.setPreferredSize(new Dimension(740,(int)screenSize.getHeight()));
        right2.setLayout(null);

        right2.add(ans);
        right2.add(bmibg1);

        sub2 = new JPanel();
        sub2.setBackground(Color.GREEN);
        sub2.setBounds(200,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
        sub2.setLayout(new BorderLayout());

        sub2.add(left2,BorderLayout.WEST);
        sub2.add(right2,BorderLayout.EAST);

        sub2.setVisible(false);

        l1 = new JLabel("Enter the food item:");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Lucida Bright",Font.PLAIN,18));
        l1.setBounds(820,100,250,30);

        tf = new JTextField();
        tf.setFont(new Font("Lucida Bright",Font.PLAIN,18));
        tf.setBounds(820,155,150,30);
        tf.setBorder(BorderFactory.createEmptyBorder());
//        tf.setBounds(200,130,150,30);
//
//        String[] foodItems = {};
//        comboBox = new JComboBox(foodItems);

        sr = new JLabel("Enter the Serial No:");
        sr.setForeground(Color.white);
        sr.setFont(new Font("Lucida Bright",Font.PLAIN,18));
        sr.setBounds(190,100,250,30);
//        sr.setBounds(200,180,150,30);

        tfsr = new JTextField();
        tfsr.setFont(new Font("Lucida Bright",Font.PLAIN,18));
        tfsr.setBounds(190,155,150,30);
        tfsr.setBorder(BorderFactory.createEmptyBorder());
//        tfsr.setBounds(200,200,150,30);
//
        b0 = new JButton("Insert");
        b0.setBackground(new Color(0x1B9C85));
        b0.setBounds(550,300,75,30);
        b0.setForeground(Color.white);
        b0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        b0.setFocusable(false);
        b0.addActionListener(this);
//
//        ta = new JTextArea();
//        ta.setBounds(200,215,500,150);
//        ta.setSize(500,100);D
//
//        l2= new JLabel("Total Calorie Count:");
//        l2.setBounds(200,320,150,30);
//
//        resultArea = new JTextArea();
//        resultArea.setBounds(200,350,250,250);
//        resultArea.setSize(200,100);

        contain2 = new JPanel();
        contain2.setBackground(new Color(0x22668D));
        contain2.add(l1);
        contain2.add(tf);
        contain2.add(sr);
        contain2.add(tfsr);
        contain2.add(b0);
        contain2.setLayout(null);

        table2 = new JTable(model2);
        table2.setForeground(Color.white);
        table2.setBackground(Color.BLACK);
        table2.setGridColor(Color.RED);
        table2.setSelectionBackground(Color.WHITE);
        table2.setSelectionForeground(Color.BLACK);
        table2.setRowHeight(30);
        table2.setAutoCreateRowSorter(true);
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table2.addMouseListener(this);

//        cellRenderer = new DefaultTableCellRenderer();
//        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
//        table2.getColumnModel().getColumn(0).setPreferredWidth(5);
//        table2.getColumnModel().getColumn(2).setPreferredWidth(100);
//        table2.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);

//        table = new JTable(model);
//        table.setForeground(Color.YELLOW);
//        table.setBackground(Color.BLACK);
//        table.setGridColor(Color.RED);
//        table.setSelectionBackground(Color.WHITE);
//        table.setSelectionForeground(Color.BLACK);
//        table.setRowHeight(30);
//        table.setAutoCreateRowSorter(true);
//        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        table.addMouseListener(this);

        panel = new JPanel();
        panel.setBounds(0,0,1240,900);
        panel.setLayout(new GridLayout(2,1));

        panel.add(new JScrollPane(table2));
        panel.add(contain2);

        sub3 = new JPanel();
        sub3.setBackground(Color.BLUE);
        sub3.setBounds(200,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
        sub3.setLayout(null);
        sub3.add(panel);
        sub3.setVisible(false);

        blank1 = new JPanel();
        blank1.setBackground(Color.white);
        blank2 = new JPanel();
        blank2.setBackground(Color.white);

        A = new ImageIcon("A.png");
        Image i1 = A.getImage();
        Image new_image1 = i1.getScaledInstance(110,110,Image.SCALE_SMOOTH);
        A = new ImageIcon(new_image1);

        a = new JButton();
        a.setIcon(A);
        a.setBackground(Color.WHITE);
        a.setBorder(BorderFactory.createEmptyBorder());
        a.setFocusable(false);
        a.addActionListener(this);

        B = new ImageIcon("B.png");
        Image i2 = B.getImage();
        Image new_image2 = i2.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        B = new ImageIcon(new_image2);

        b = new JButton();
        b.setIcon(B);
        b.setBackground(Color.white);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setFocusable(false);
        b.addActionListener(this);

        C = new ImageIcon("C.png");
        Image i3 = C.getImage();
        Image new_image3 = i3.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        C = new ImageIcon(new_image3);

        c = new JButton();
        c.setIcon(C);
        c.setBackground(Color.white);
        c.setBorder(BorderFactory.createEmptyBorder());
        c.setFocusable(false);
        c.addActionListener(this);

        D = new ImageIcon("D.png");
        Image i4 = D.getImage();
        Image new_image4 = i4.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        D = new ImageIcon(new_image4);

        d = new JButton();
        d.setIcon(D);
        d.setBackground(Color.white);
        d.setBorder(BorderFactory.createEmptyBorder());
        d.setFocusable(false);
        d.addActionListener(this);

        E = new ImageIcon("E.png");
        Image i5 = E.getImage();
        Image new_image5 = i5.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        E = new ImageIcon(new_image5);

        e = new JButton();
        e.setIcon(E);
        e.setBackground(Color.white);
        e.setBorder(BorderFactory.createEmptyBorder());
        e.setFocusable(false);
        e.addActionListener(this);

        F = new ImageIcon("F.png");
        Image i6 = F.getImage();
        Image new_image6 = i6.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        F = new ImageIcon(new_image6);

        f0 = new JButton();
        f0.setIcon(F);
        f0.setBackground(Color.white);
        f0.setBorder(BorderFactory.createEmptyBorder());
        f0.setFocusable(false);
        f0.addActionListener(this);

        G = new ImageIcon("G.png");
        Image i7 = G.getImage();
        Image new_image7 = i7.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        G = new ImageIcon(new_image7);

        g = new JButton();
        g.setIcon(G);
        g.setBackground(Color.white);
        g.setBorder(BorderFactory.createEmptyBorder());
        g.setFocusable(false);
        g.addActionListener(this);

        H = new ImageIcon("H.png");
        Image i8 = H.getImage();
        Image new_image8 = i8.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        H = new ImageIcon(new_image8);

        h = new JButton();
        h.setIcon(H);
        h.setBackground(Color.white);
        h.setBorder(BorderFactory.createEmptyBorder());
        h.setFocusable(false);
        h.addActionListener(this);

        I = new ImageIcon("I.png");
        Image i9 = I.getImage();
        Image new_image9 = i9.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        I = new ImageIcon(new_image9);

        i0 = new JButton();
        i0.setIcon(I);
        i0.setBackground(Color.white);
        i0.setBorder(BorderFactory.createEmptyBorder());
        i0.setFocusable(false);
        i0.addActionListener(this);

        J = new ImageIcon("J.png");
        Image i10 = J.getImage();
        Image new_image10 = i10.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        J = new ImageIcon(new_image10);

        j = new JButton();
        j.setIcon(J);
        j.setBackground(Color.white);
        j.setBorder(BorderFactory.createEmptyBorder());
        j.setFocusable(false);
        j.addActionListener(this);

        K = new ImageIcon("K.png");
        Image i11 = K.getImage();
        Image new_image11 = i11.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        K = new ImageIcon(new_image11);

        k = new JButton();
        k.setIcon(K);
        k.setBackground(Color.white);
        k.setBorder(BorderFactory.createEmptyBorder());
        k.setFocusable(false);
        k.addActionListener(this);

        L = new ImageIcon("L.png");
        Image i12 = L.getImage();
        Image new_image12 = i12.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        L = new ImageIcon(new_image12);

        l = new JButton();
        l.setIcon(L);
        l.setBackground(Color.white);
        l.setBorder(BorderFactory.createEmptyBorder());
        l.setFocusable(false);
        l.addActionListener(this);

        M = new ImageIcon("M.png");
        Image i13 = M.getImage();
        Image new_image13 = i13.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        M = new ImageIcon(new_image13);

        m = new JButton();
        m.setIcon(M);
        m.setBackground(Color.white);
        m.setBorder(BorderFactory.createEmptyBorder());
        m.setFocusable(false);
        m.addActionListener(this);

        N = new ImageIcon("N.png");
        Image i14 = N.getImage();
        Image new_image14 = i14.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        N = new ImageIcon(new_image14);

        n = new JButton();
        n.setIcon(N);
        n.setBackground(Color.white);
        n.setBorder(BorderFactory.createEmptyBorder());
        n.setFocusable(false);
        n.addActionListener(this);

        O = new ImageIcon("O.png");
        Image i15 = O.getImage();
        Image new_image15 = i15.getScaledInstance(140,140,Image.SCALE_SMOOTH);
        O = new ImageIcon(new_image15);

        o = new JButton();
        o.setIcon(O);
        o.setBackground(Color.white);
        o.setBorder(BorderFactory.createEmptyBorder());
        o.setFocusable(false);
        o.addActionListener(this);

        P = new ImageIcon("P.png");
        Image i16 = P.getImage();
        Image new_image16 = i16.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        P = new ImageIcon(new_image16);

        p = new JButton();
        p.setIcon(P);
        p.setBackground(Color.white);
        p.setBorder(BorderFactory.createEmptyBorder());
        p.setFocusable(false);
        p.addActionListener(this);

        Q = new ImageIcon("Q.png");
        Image i17 = Q.getImage();
        Image new_image17 = i17.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        Q = new ImageIcon(new_image17);

        q = new JButton();
        q.setIcon(Q);
        q.setBackground(Color.white);
        q.setBorder(BorderFactory.createEmptyBorder());
        q.setFocusable(false);
        q.addActionListener(this);

        R = new ImageIcon("R.png");
        Image i18 = R.getImage();
        Image new_image18 = i18.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        R = new ImageIcon(new_image18);

        r = new JButton();
        r.setIcon(R);
        r.setBackground(Color.white);
        r.setBorder(BorderFactory.createEmptyBorder());
        r.setFocusable(false);
        r.addActionListener(this);

        S = new ImageIcon("S.png");
        Image i19 = S.getImage();
        Image new_image19 = i19.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        S = new ImageIcon(new_image19);

        s = new JButton();
        s.setIcon(S);
        s.setBackground(Color.white);
        s.setBorder(BorderFactory.createEmptyBorder());
        s.setFocusable(false);
        s.addActionListener(this);

        T = new ImageIcon("T.png");
        Image i20 = T.getImage();
        Image new_image20 = i20.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        T = new ImageIcon(new_image20);

        t = new JButton();
        t.setIcon(T);
        t.setBackground(Color.white);
        t.setBorder(BorderFactory.createEmptyBorder());
        t.setFocusable(false);
        t.addActionListener(this);

        U = new ImageIcon("U.png");
        Image i21 = U.getImage();
        Image new_image21 = i21.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        U = new ImageIcon(new_image21);

        u = new JButton();
        u.setIcon(U);
        u.setBackground(Color.white);
        u.setBorder(BorderFactory.createEmptyBorder());
        u.setFocusable(false);
        u.addActionListener(this);

        V = new ImageIcon("V.png");
        Image i22 = V.getImage();
        Image new_image22 = i22.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        V = new ImageIcon(new_image22);

        v = new JButton();
        v.setIcon(V);
        v.setBackground(Color.white);
        v.setBorder(BorderFactory.createEmptyBorder());
        v.setFocusable(false);
        v.addActionListener(this);

        W = new ImageIcon("W.png");
        Image i23 = W.getImage();
        Image new_image23 = i23.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        W = new ImageIcon(new_image23);

        w = new JButton();
        w.setIcon(W);
        w.setBackground(Color.white);
        w.setBorder(BorderFactory.createEmptyBorder());
        w.setFocusable(false);
        w.addActionListener(this);

        X = new ImageIcon("X.png");
        Image i24 = X.getImage();
        Image new_image24 = i24.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        X = new ImageIcon(new_image24);

        x = new JButton();
        x.setIcon(X);
        x.setBackground(Color.white);
        x.setBorder(BorderFactory.createEmptyBorder());
        x.setFocusable(false);
        x.addActionListener(this);

        Y = new ImageIcon("Y.png");
        Image i25 = Y.getImage();
        Image new_image25 = i25.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        Y = new ImageIcon(new_image25);

        y = new JButton();
        y.setIcon(Y);
        y.setBackground(Color.white);
        y.setBorder(BorderFactory.createEmptyBorder());
        y.setFocusable(false);
        y.addActionListener(this);

        Z = new ImageIcon("Z.png");
        Image i26 = Z.getImage();
        Image new_image26 = i26.getScaledInstance(115,115,Image.SCALE_SMOOTH);
        Z = new ImageIcon(new_image26);

        z = new JButton();
        z.setIcon(Z);
        z.setBackground(Color.white);
        z.setBorder(BorderFactory.createEmptyBorder());
        z.setFocusable(false);
        z.addActionListener(this);

        alpha = new JPanel();
        alpha.setBackground(Color.white);
        alpha.setBounds(0,0,1240,828);
//        alpha.setPreferredSize(new Dimension(1240,900));
        alpha.setLayout(new GridLayout(7,4,10,10));

        alpha.add(a);
        alpha.add(b);
        alpha.add(c);
        alpha.add(d);
        alpha.add(e);
        alpha.add(f0);
        alpha.add(g);
        alpha.add(h);
        alpha.add(i0);
        alpha.add(j);
        alpha.add(k);
        alpha.add(l);
        alpha.add(m);
        alpha.add(n);
        alpha.add(o);
        alpha.add(p);
        alpha.add(q);
        alpha.add(r);
        alpha.add(s);
        alpha.add(t);
        alpha.add(u);
        alpha.add(v);
        alpha.add(w);
        alpha.add(x);
        alpha.add(blank1);
        alpha.add(y);
        alpha.add(z);
        alpha.add(blank2);

        alpha.setVisible(true);

        e1 = new JLabel();
        e1.setForeground(Color.DARK_GRAY);
        e1.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,25));
        e1.setBounds(55,150,500,75);
        e1.setVisible(false);

        e2 = new JLabel();
        e2.setForeground(Color.DARK_GRAY);
        e2.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,25));
        e2.setBounds(55,250,500,75);
        e2.setVisible(false);

        e3 = new JLabel();
        e3.setForeground(Color.DARK_GRAY);
        e3.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,25));
        e3.setBounds(55,350,500,75);
        e3.setVisible(false);

        e4 = new JLabel();
        e4.setForeground(Color.DARK_GRAY);
        e4.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,25));
        e4.setBounds(55,450,500,75);
        e4.setVisible(false);

        e5 = new JLabel();
        e5.setForeground(Color.DARK_GRAY);
        e5.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,25));
        e5.setBounds(55,550,500,75);
        e5.setVisible(false);

        back = new JButton("Back");
        back.setBounds(270,680,80,25);
        back.setBackground(new Color(0x1B9C85));
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        back.setFocusable(false);
        back.addActionListener(this);

        list = new JPanel();
        list.setBounds(0,0,620,900);
        list.setBackground(Color.white);
        list.setLayout(null);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(back);
        list.setVisible(false);

        pic = new JPanel();
        pic.setBackground(Color.LIGHT_GRAY);
        pic.setBounds(620,0,620,900);
        pic.setLayout(null);

        pic.setVisible(false);

        sub4 = new JPanel();
        sub4.setBackground(Color.BLACK);
        sub4.setBounds(200,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());

        sub4.add(alpha);
        sub4.add(list);
        sub4.add(pic);

        sub4.setLayout(null);
        sub4.setVisible(false);

        srno = new JLabel("Serial No:");
        srno.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        srno.setBounds(250,40,300,30);

        serial = new JTextField();
        serial.setFont(new Font("Berlin Sans FB",Font.PLAIN,28));
        serial.setBounds(750,40,200,30);

        newDay = new JLabel("Select the day:");
        newDay.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        newDay.setBounds(250,80,300,30);

        String[] days = {"Select","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        day = new JComboBox(days);
        day.setFont(new Font("Berlin Sans FB",Font.PLAIN,28));
        day.setBounds(750,80,200,30);

        newDate = new JLabel("Enter the Date:");
        newDate.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        newDate.setBounds(250,120,300,30);

        date = new JTextField();
        date.setFont(new Font("Berlin Sans FB",Font.PLAIN,28));
        date.setBounds(750,120,200,30);

        newMeal = new JLabel("Select the Meal:");
        newMeal.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        newMeal.setBounds(250,160,300,30);

        String[] meals = {"Select","Breakfast","Lunch","Snack","Dinner"};
        meal = new JComboBox(meals);
        meal.setFont(new Font("Berlin Sans FB",Font.PLAIN,28));
        meal.setBounds(750,160,200,30);

        newDish = new JLabel("Enter the Dish:");
        newDish.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        newDish.setBounds(250,200,300,30);

        dish = new JTextField();
        dish.setFont(new Font("Berlin Sans FB",Font.PLAIN,28));
        dish.setBounds(750,200,200,30);

        newCalories = new JLabel("Enter the Calories:");
        newCalories.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        newCalories.setBounds(250,240,300,30);

        calories = new JTextField();
        calories.setFont(new Font("Berlin Sans FB",Font.PLAIN,28));
        calories.setBounds(750,240,200,30);

        add = new JButton("Add");
        add.setBackground(new Color(0xD83F31));
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        add.setBounds(50,70,300,100);
        add.setFocusable(false);
        add.addActionListener(this);

        update = new JButton("Update");
        update.setBackground(new Color(0xD83F31));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        update.setBounds(450,70,300,100);
        update.setFocusable(false);
        update.addActionListener(this);

        delete = new JButton("Delete");
        delete.setBackground(new Color(0xD83F31));
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Berlin Sans FB",Font.PLAIN,30));
        delete.setBounds(850,70,300,100);
        delete.setFocusable(false);
        delete.addActionListener(this);

        empty = new JPanel();
        empty.setBackground(new Color(0x79AC78));
        empty.add(add);
        empty.add(update);
        empty.add(delete);
        empty.setLayout(null);

        contain = new JPanel();
        contain.setBackground(new Color(0x79AC78));
        contain.add(srno);
        contain.add(serial);
        contain.add(newDay);
        contain.add(day);
        contain.add(newDate);
        contain.add(date);
        contain.add(newMeal);
        contain.add(meal);
        contain.add(newDish);
        contain.add(dish);
        contain.add(newCalories);
        contain.add(calories);
        contain.setLayout(null);
//        contain.setLayout(new GridLayout(6,2));

        table = new JTable(model);
        table.setForeground(Color.YELLOW);
        table.setBackground(Color.BLACK);
        table.setGridColor(Color.RED);
        table.setSelectionBackground(Color.WHITE);
        table.setSelectionForeground(Color.BLACK);
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(this);

        p0 = new JPanel();
        p0.setBounds(0,0,1240,900);
        p0.setLayout(new GridLayout(3,1));

        p0.add(new JScrollPane(table));
        p0.add(contain);
        p0.add(empty);

        sub5 = new JPanel();
        sub5.setBackground(Color.orange);
        sub5.setBounds(200,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
        sub5.setLayout(new BorderLayout());
        sub5.add(p0);
        sub5.setVisible(false);

//        right = new JPanel();
//        bottom = new JPanel();
//        center = new JPanel();

        icon = new ImageIcon("layout.png");

        frame = new JFrame("Dashboard");
        frame.setIconImage(icon.getImage());
        frame.setSize((int)screenSize.getWidth(),(int)screenSize.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        frame.add(left1,BorderLayout.WEST);
        frame.add(sub1);
        frame.add(sub2);
        frame.add(sub3);
        frame.add(sub4);
        frame.add(sub5);
//        frame.add(right,BorderLayout.EAST);
//        frame.add(bottom,BorderLayout.SOUTH);
//        frame.add(center,BorderLayout.CENTER);

        frame.setVisible(true);
    }
    public void updateSliderFromTextField(JSlider slider, JTextField tf){
        try {
            int value = Integer.parseInt(tf.getText());
            if (value >= slider.getMinimum() && value <= slider.getMaximum()) {
                slider.setValue(value);
            } else {
                JOptionPane.showMessageDialog(frame, "Value out of range!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a number.");
        }
    }

    public void actionPerformed(ActionEvent f) {
        if (f.getSource() == home) {
            sub1.setVisible(true);
            sub2.setVisible(false);
            sub3.setVisible(false);
            sub4.setVisible(false);
            sub5.setVisible(false);
        }
        if (f.getSource() == b1) {
            sub1.setVisible(false);
            sub2.setVisible(true);
            sub3.setVisible(false);
            sub4.setVisible(false);
            sub5.setVisible(false);
        }
        if (f.getSource() == b2) {
            sub1.setVisible(false);
            sub2.setVisible(false);
            sub3.setVisible(true);
            sub4.setVisible(false);
            sub5.setVisible(false);
        }
//        String ingredient_name = tf.getText();
//        if(f.getSource()==b0){
////            b.addActionListener(a -> {
//                String text = ta.getText();
//                String[] foodItems = text.split("\n"); // Split text into individual lines
//
//                double totalCalories = 0;
//                double calorieCount =0;
//                double fatCount=0;
//                double proteinCount=0;
//                Connection connection ;
////            for (String foodItem : foodItems) {
//                try  {
//                    connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/diet", "root", "Shawn@2004");
//                    String sql = "SELECT calories_per_100g, fats_per_100g, protein_per_100g  FROM FoodCalories WHERE ingredient_name = ?";
//                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                    preparedStatement.setString(1, ingredient_name);
//
//                    ResultSet result = preparedStatement.executeQuery();
//                    for(String foodItem: foodItems){
//                        if (result.next()) {
////                        System.out.println("bshbjkw");
//                            calorieCount = result.getDouble("calories_per_100g");
//                            fatCount = result.getDouble("fats_per_100g");
//                            proteinCount = result.getDouble("protein_per_100g");
//                            totalCalories += calorieCount;
//                        }
//                        else {
//                            ta.setText("Food item not found.");
//                        }
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                ta.setText(ingredient_name + " has " + calorieCount + " grams of calories, "+fatCount+ " grams of fat, "+proteinCount+" grams of protein.");
//
//                resultArea.setText("Total Calories: " + totalCalories);
////            });
//        }
        if (f.getSource() == b3) {
            sub1.setVisible(false);
            sub2.setVisible(false);
            sub3.setVisible(false);
            alpha.setVisible(true);
            sub4.setVisible(true);
            sub5.setVisible(false);
        }
        if (f.getSource() == b4) {
            sub1.setVisible(false);
            sub2.setVisible(false);
            sub3.setVisible(false);
            sub4.setVisible(false);
            sub5.setVisible(true);
        }

        if(f.getSource()==logout){
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(confirm==0) {
                frame.dispose();
                new Login();
                JOptionPane.showMessageDialog(null,"Logged out Successfully","Successful Logout",JOptionPane.INFORMATION_MESSAGE);
            }
        }

        boolean resultDisplayed = false; // Add this instance variable

        if (f.getSource() == b5 && !resultDisplayed) {
            resultDisplayed = true; // Set the flag to true
            b5.setEnabled(false);
            ans.removeAll();
            ans.add(wait);
            ans.setVisible(true);
            Timer timer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ans.remove(wait);
                    try {
                        int height = Integer.parseInt(tf1.getText());
                        int weight = Integer.parseInt(tf2.getText());
                        double answer = calcBMI(height, weight);
                        dispAns = new JLabel("Your BMI is: " + answer);

                        if(answer<18.5){
                            under = new JLabel("Underweight");
                            under.setForeground(new Color(0x6082B6));
                            under.setBounds(100,620,300,50);
                            under.setFont(new Font("Consolas", Font.BOLD,20));
                            ans.add(under);
                        }
                        if(answer>=18.5&&answer<=24.9){
                            normal = new JLabel("Normal Weight");
                            normal.setForeground(new Color(0x50C878));
                            normal.setBounds(100,620,300,50);
                            normal.setFont(new Font("Consolas", Font.BOLD,20));
                            ans.add(normal);
                        }
                        if(answer>=25&&answer<=29.9){
                            over = new JLabel("Overweight");
                            over.setForeground(new Color(0xFFA500));
                            over.setBounds(100,620,300,50);
                            over.setFont(new Font("Consolas", Font.BOLD,20));
                            ans.add(over);
                        }
                        if(answer>=30&&answer<=34.9){
                            obese1 = new JLabel("Obesity class I");
                            obese1.setForeground(new Color(0xFF4433));
                            obese1.setBounds(100,620,300,50);
                            obese1.setFont(new Font("Consolas", Font.BOLD,20));
                            ans.add(obese1);
                        }
                        if(answer>=35&&answer<39.9){
                            obese2 = new JLabel("Obesity class II");
                            obese2.setForeground(new Color(0xFF0000));
                            obese2.setBounds(100,620,300,50);
                            obese2.setFont(new Font("Consolas", Font.BOLD,20));
                            ans.add(obese2);
                        }
                        if(answer>40){
                            obese3 = new JLabel("Obesity class III");
                            obese3.setForeground(new Color(0x880808));
                            obese3.setBounds(100,620,300,50);
                            obese3.setFont(new Font("Consolas", Font.BOLD,20));
                            ans.add(obese3);
                        }

                        dispAns.setForeground(Color.BLACK);
                        dispAns.setFont(new Font("Consolas",Font.BOLD,20));
                        dispAns.setBounds(100,590,400,50);

                    } catch (NumberFormatException ex) {
                        dispAns = new JLabel("<html>Invalid input!<br>Please enter valid numeric values for height and weight.</html>");
                        dispAns.setForeground(Color.BLACK);
                        dispAns.setFont(new Font("Consolas",Font.BOLD,18));
                        dispAns.setBounds(100,620,400,100);
                    }
                    ans.add(dispAns);
                    ans.revalidate();
                    ans.repaint();
                    b5.setEnabled(true);
                }
            });
            timer.setRepeats(false); // Set the timer to not repeat
            timer.start();
        }

//        if(f.getSource()==b0){
//            int sr = Integer.parseInt(serial.getText().toString());
//            String newDate = date.getText().toString();
//            String dish1 = dish.getText().toString();
//            int cal = Integer.parseInt(calories.getText().toString());
//
////            Object[] newRow2 = {sr,selected1,newDate,selected2,dish1,cal};
//            model2.addRow(newRow2);

            String ingredient_name = tf.getText();
            String serial_no_new = tfsr.getText();
            if(f.getSource()==b0) {
//            b.addActionListener(a -> {
//                String text = ta.getText();
//                String[] foodItems = text.split("\n"); // Split text into individual lines

                double totalCalories = 0;
                double calorieCount = 0;
                double fatCount = 0;
                double carbCount = 0;
                double proteinCount = 0;
                Connection connection;
//            for (String foodItem : foodItems) {
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diet", "root", "Shawn@2004");
                    String sql = "SELECT calories_per_100g, fats_per_100g, carbs_per_100g, protein_per_100g  FROM FoodCalories WHERE ingredient_name = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, ingredient_name);

                    ResultSet result = preparedStatement.executeQuery();
                    //        for(String foodItem: foodItems){
                    if (result.next()) {
//                        System.out.println("bshbjkw");
                        calorieCount = result.getDouble("calories_per_100g");
                        fatCount = result.getDouble("fats_per_100g");
                        carbCount = result.getDouble("carbs_per_100g");
                        proteinCount = result.getDouble("protein_per_100g");
                        totalCalories += calorieCount;
                    } else {
                        JOptionPane.showMessageDialog(null,"Food Item not found","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
        //    }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                //ta.setText(ingredient_name + " has " + calorieCount + " grams of calories, "+fatCount+ " grams of fat, "+proteinCount+" grams of protein.");

                Object[] newRow2 = {serial_no_new,ingredient_name,calorieCount,fatCount,carbCount,proteinCount};
                model2.addRow(newRow2);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

                for (int i = 0; i < table2.getColumnCount(); i++) {
                    table2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                //resultArea.setText("Total Calories: " + totalCalories);
//            });
            }

            tf.setText(null);
            tfsr.setText(null);

//            serial.setText(null);
//            day.setSelectedIndex(0);
//            date.setText(null);
//            meal.setSelectedIndex(0);
//            dish.setText(null);
//            calories.setText(null);

        if(f.getSource()==add){
            if (serial.getText().toString().isEmpty() || date.getText().toString().isEmpty() || dish.getText().toString().isEmpty() || calories.getText().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int sr = Integer.parseInt(serial.getText().toString());
                String newDate = date.getText().toString();
                String dish1 = dish.getText().toString();
                int cal = Integer.parseInt(calories.getText().toString());

                String selected1 = (String)day.getSelectedItem();
                String selected2 = (String)meal.getSelectedItem();

                String serial_no = serial.getText();
                String datef = date.getText();
                String dayf = (String)day.getSelectedItem();
                String mealf = (String)meal.getSelectedItem();
                String dishf = dish.getText();
                String calorie = calories.getText();

                String query = "INSERT INTO meal_tracker VALUES('" + serial_no + "','" + datef + "','" + dayf + "','" + mealf + "','" + dishf + "','" + calorie + "')";

                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                } catch (Exception a) {
                    a.printStackTrace();
                }

                Object[] newRow = {sr,selected1,newDate,selected2,dish1,cal};
                model.addRow(newRow);

                serial.setText(null);
                day.setSelectedIndex(0);
                date.setText(null);
                meal.setSelectedIndex(0);
                dish.setText(null);
                calories.setText(null);
            }

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }

        if(f.getSource()==update) {
            if (serial.getText().toString().isEmpty() || date.getText().toString().isEmpty() || dish.getText().toString().isEmpty() || calories.getText().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int sr = Integer.parseInt(serial.getText().toString());
                String d = (String)day.getSelectedItem();
                String newDate = date.getText().toString();
                String m = (String)meal.getSelectedItem();
                String dish1 = dish.getText().toString();
                int cal = Integer.parseInt(calories.getText().toString());

                int row = table.getSelectedRow();

                model.setValueAt(sr,row,0);
                model.setValueAt(d,row,1);
                model.setValueAt(newDate,row,2);
                model.setValueAt(m,row,3);
                model.setValueAt(dish1,row,4);
                model.setValueAt(cal,row,5);

                serial.setText(null);
                day.setSelectedIndex(0);
                date.setText(null);
                meal.setSelectedIndex(0);
                dish.setText(null);
                calories.setText(null);
            }
        }

        if(f.getSource()==delete){
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int selection = JOptionPane.showConfirmDialog(null, "Do you really want to delete the selected row?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (selection == JOptionPane.YES_OPTION) {
                    model.removeRow(table.getSelectedRow());
                }
                serial.setText(null);
                day.setSelectedIndex(0);
                date.setText(null);
                meal.setSelectedIndex(0);
                dish.setText(null);
                calories.setText(null);
            }
        }

        if(f.getSource()==a){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Abdominal Crunches");
            e2.setText("II) Alternating Lunges");
            e3.setText("III) Arm Raises");
            e4.setText("IV) Archer Push-ups");
            e5.setText("V) Air Squats");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = A.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            A = new ImageIcon(newBig);
            singAlpha.setIcon(A);
            pic.add(singAlpha);
            pic.setVisible(true);

        }

        if(f.getSource()==b){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Burpees");
            e2.setText("II) Bodyweight Squats");
            e3.setText("III) Bicycle crunches");
            e4.setText("IV) Back Extensions");
            e5.setText("V) Bridging Hamstring Curls");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = B.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            B = new ImageIcon(newBig);
            singAlpha.setIcon(B);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==c){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Crunches");
            e2.setText("II) Chin-ups");
            e3.setText("III) Cycling");
            e4.setText("IV) Cross-body Mountain Climbers");
            e5.setText("V) Cossack Squats");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = C.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            C = new ImageIcon(newBig);
            singAlpha.setIcon(C);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==d){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Diamond Push-ups");
            e2.setText("II) Deadlift");
            e3.setText("III) Dips");
            e4.setText("IV) Double Crunches");
            e5.setText("V) Decline Push-ups");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = D.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            D = new ImageIcon(newBig);
            singAlpha.setIcon(D);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==e){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Explosive Lunges");
            e2.setText("II) Eccentric Squats");
            e3.setText("III) Elbow Plank");
            e4.setText("IV) Elbow-to-knee Bicycle Crunches");
            e5.setText("V) Elevated Mountain Climbers");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = E.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            E = new ImageIcon(newBig);
            singAlpha.setIcon(E);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==f0){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Face Pulls");
            e2.setText("II) Front Squats");
            e3.setText("III) Flutter Kicks");
            e4.setText("IV) Forearm Plank");
            e5.setText("V) Full-Body Roll-ups");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = F.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            F = new ImageIcon(newBig);
            singAlpha.setIcon(F);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==g){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Gymnastics");
            e2.setText("II) Group Stretches");
            e3.setText("III) Glute-Ham Raises");
            e4.setText("IV) Goblet Squats");
            e5.setText("V) Glute Bridge");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = G.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            G = new ImageIcon(newBig);
            singAlpha.setIcon(G);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==h){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Horizontal Pull-ups");
            e2.setText("II) Headstand");
            e3.setText("III) Hip Abduction");
            e4.setText("IV) High Knees");
            e5.setText("V) Hip Flexor Stretch");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = H.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            H = new ImageIcon(newBig);
            singAlpha.setIcon(H);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==i0){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Inverted V-Ups");
            e2.setText("II) Incline Bench Press");
            e3.setText("III) Isometric Pull-Ups");
            e4.setText("IV) Inner Leg Raise");
            e5.setText("V) Inner Thigh Lifts");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = I.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            I = new ImageIcon(newBig);
            singAlpha.setIcon(I);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==j){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Jumping Jacks");
            e2.setText("II) Jogging");
            e3.setText("III) Jump Lunges");
            e4.setText("IV) Jump Squats");
            e5.setText("V) Janda Sit-ups");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = J.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            J = new ImageIcon(newBig);
            singAlpha.setIcon(J);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==k){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Knee Extensions");
            e2.setText("II) Knee Push-ups");
            e3.setText("III) Knee Raises");
            e4.setText("IV) Kipping Pull-Ups");
            e5.setText("V) Knee Tucks");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = K.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            K = new ImageIcon(newBig);
            singAlpha.setIcon(K);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==l){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Long Jump");
            e2.setText("II) Lateral Step-ups");
            e3.setText("III) Lateral Lunges");
            e4.setText("IV) L-Sits");
            e5.setText("V) Low Plank");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = L.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            L = new ImageIcon(newBig);
            singAlpha.setIcon(L);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==m){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Mountain Climbers");
            e2.setText("II) Muscle-ups");
            e3.setText("III) Military Press");
            e4.setText("IV) Mule Kicks");
            e5.setText("V) Modified Plank");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = M.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            M = new ImageIcon(newBig);
            singAlpha.setIcon(M);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==n){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Neck Circles");
            e2.setText("II) Neck Tilt Stretch");
            e3.setText("III) Neck Bridges");
            e4.setText("IV) Narrow-Grip Bench Press");
//            e5.setText("V) ");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = N.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            N = new ImageIcon(newBig);
            singAlpha.setIcon(N);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==o){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Overhead Press");
            e2.setText("II) Oblique Crunches");
            e3.setText("III) One-Legged Deadlifts");
            e4.setText("IV) Oblong Stretch");
            e5.setText("V) Octopus Push-ups");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = O.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            O = new ImageIcon(newBig);
            singAlpha.setIcon(O);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==p){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Push-ups");
            e2.setText("II) Planks");
            e3.setText("III) Prisoner Squats");
            e4.setText("IV) Pranayama");
            e5.setText("V) Parallel Bar Dips");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = P.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            P = new ImageIcon(newBig);
            singAlpha.setIcon(P);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==q){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Quad Stretch");
            e2.setText("II) Quick Feet Drills");
//            e3.setText("III) ");
//            e4.setText("IV) ");
//            e5.setText("V) ");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = Q.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            Q = new ImageIcon(newBig);
            singAlpha.setIcon(Q);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==r){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Running");
            e2.setText("II) Russian Twists");
            e3.setText("III) Rope Skipping");
            e4.setText("IV) Reverse Lunges");
            e5.setText("V) Ring Dips");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = R.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            R = new ImageIcon(newBig);
            singAlpha.setIcon(R);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==s){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Squats");
            e2.setText("II) Sit-Ups");
            e3.setText("III) Side Planks");
            e4.setText("IV) Sprints");
            e5.setText("V) Supermans");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = S.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            S = new ImageIcon(newBig);
            singAlpha.setIcon(S);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==t){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Tricep Dips");
            e2.setText("II) Toe Touches");
            e3.setText("III) T-Push-ups");
            e4.setText("IV) Triple Jump");
            e5.setText("V) Thoracic Extension Stretch");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = T.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            T = new ImageIcon(newBig);
            singAlpha.setIcon(T);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==u){
            String[] responses = {};
            ImageIcon imageIcon = new ImageIcon("partyface.png");
            Image i = imageIcon.getImage();
            Image new_image = i.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(new_image);
            JOptionPane optionPane = new JOptionPane("Hoorayyy!!.\nNo exercises for 'You' in 'U'!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION, imageIcon, responses, 0);

            final JDialog dialog = optionPane.createDialog(null, "No Exercise");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            dialog.setVisible(true);
        }

        if(f.getSource()==v){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) V-Ups");
            e2.setText("II) V-Sits");
            e3.setText("III) V-Stretch");
            e4.setText("IV) Vertical Leg Press");
//            e5.setText("V) ");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = V.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            V = new ImageIcon(newBig);
            singAlpha.setIcon(V);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==w){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Weightlifting");
            e2.setText("II) Walking");
//            e3.setText("III) ");
//            e4.setText("IV) ");
//            e5.setText("V) ");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = W.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            W = new ImageIcon(newBig);
            singAlpha.setIcon(W);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==x){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) X Jumps");
//            e2.setText("II) ");
//            e3.setText("III) ");
//            e4.setText("IV) ");
//            e5.setText("V) ");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = X.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            X = new ImageIcon(newBig);
            singAlpha.setIcon(X);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==y){
            e1.setText(null);
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
            e5.setText(null);
            e1.setText("I) Yoga");
            e2.setText("II) Y Raise");
//            e3.setText("III) ");
//            e4.setText("IV) ");
//            e5.setText("V) ");
            e1.setVisible(true);
            e2.setVisible(true);
            e3.setVisible(true);
            e4.setVisible(true);
            e5.setVisible(true);
            list.setVisible(true);
            alpha.setVisible(false);

            pic.removeAll();
            singAlpha = new JLabel();
            singAlpha.setBounds(150,250,350,350);
            Image bigI = Y.getImage();
            Image newBig = bigI.getScaledInstance(350,350,Image.SCALE_SMOOTH);
            Y = new ImageIcon(newBig);
            singAlpha.setIcon(Y);
            pic.add(singAlpha);
            pic.setVisible(true);
        }

        if(f.getSource()==z){
            JOptionPane.showMessageDialog(null,"No exercises in 'Z'","No Exercise",JOptionPane.INFORMATION_MESSAGE);
        }

        if(f.getSource()==back){
            list.setVisible(false);
            pic.setVisible(false);
            alpha.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
    public void stateChanged(ChangeEvent f){
        tf2.setText(String.valueOf(slider.getValue()));
    }

    public static double calcBMI(double height, double weight){
        double bmi;
        bmi = weight/((height/100)*(height/100));
        return bmi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int rowIndex = table.getSelectedRow();

        int sr = (int)model.getValueAt(rowIndex,0);
        String d = (String) model.getValueAt(rowIndex,1);
        String newDate = (String)model.getValueAt(rowIndex,2);
        String m = (String)model.getValueAt(rowIndex,3);
        String dish1 = (String)model.getValueAt(rowIndex,4);
        int cal = (int)model.getValueAt(rowIndex,5);

        serial.setText(String.valueOf(sr));
        day.setSelectedItem(d);
        date.setText(String.valueOf(newDate));
        meal.setSelectedItem(m);
        dish.setText(String.valueOf(dish1));
        calories.setText(String.valueOf(cal));

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

//        try {
//            int height = Integer.parseInt(tf1.getText());
//            int weight = Integer.parseInt(tf2.getText());
//            dispAns = new JLabel("Your BMI is : " + calcBMI(height,weight));
//            dispAns.setFont(new Font("Consolas",Font.PLAIN,30));
//            dispAns.setBounds(25,250,300,50);
//        } catch (NumberFormatException ex) {
////            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter valid numeric values for height and weight.");
////            return; // Exit the method or handle the error accordingly
//        }

//        if (e.getSource() == b5) {
//            ans.setVisible(true);
//            ans.add(wait);
//            Timer timer = new Timer(3000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    ans.remove(wait);
//                    ans.add(dispAns);
//                    ans.revalidate();
//                    ans.repaint();
//                }
//            });
//            timer.start();
//        }

//        if (e.getSource() == b5) {
//            ans.setVisible(true);
//            ans.add(wait);
//            Timer timer = new Timer(3000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    ans.remove(wait);
//                    try {
//                        double height = Integer.parseInt(tf1.getText());
//                        double weight = Integer.parseInt(tf2.getText());
//                        double answer = calcBMI(height, weight);
//                        dispAns = new JLabel("Your BMI is : " + answer);
//                    } catch (NumberFormatException ex) {
//                        dispAns = new JLabel("Invalid input! Please enter valid numeric values for height and weight.");
//                    }
//                    ans.add(dispAns);
//                    ans.revalidate();
//                    ans.repaint();
//                }
//            });
//            timer.start();
//        }

//        if (e.getSource() == b5 && !resultDisplayed) {
//            resultDisplayed = true; // Set the flag to true
//            b5.setEnabled(false);
//
//            ans.setVisible(true);
//            ans.add(wait);
//            Timer timer = new Timer(3000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    ans.remove(wait);
//                    try {
//                        int height = Integer.parseInt(tf1.getText());
//                        int weight = Integer.parseInt(tf2.getText());
//                        dispAns = new JLabel("Your BMI is : " + calcBMI(height, weight));
//                    } catch (NumberFormatException ex) {
//                        dispAns = new JLabel("Invalid input! Please enter valid numeric values for height and weight.");
//                    }
//                    ans.add(dispAns);
//                    ans.revalidate();
//                    ans.repaint();
//                    b5.setEnabled(true);
//                }
//            });
//            timer.start();
//        }