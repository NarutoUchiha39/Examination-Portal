package Login_page;
import Questions_UI.*;
import MainFile.Examination_portal;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;
public class Login_page extends Examination_portal implements ActionListener 
{
    static Timer timer;
    static private JPanel panel;
    static private JFrame frame;
    static private JLabel Heading;
    static private JLabel user_name;
    static private JTextField User_Text;
    static private JLabel password;
    static private JTextField Password_Text;
    static private JLabel print;
   public static void MakeLoginPage ()
    {
        panel = new JPanel();
        frame = new JFrame("EXAMINATION PORTAL");
        frame.setSize(1980,720);
        ImageIcon imgicon = new ImageIcon("E://Desktop//Examination-Portal//E_portal//portal.jpg");
        frame.setIconImage(imgicon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.decode("#00FFFF"));
        frame.add(panel);
        panel.setLayout(null);
        
        Heading = new JLabel("WELCOME TO EXAMINATION PORTAL");
        Heading.setBounds(280,20, 890, 50);
        Heading.setFont(new Font("Verdana",Font.BOLD,40));
        panel.add(Heading);
       
        
        user_name = new JLabel("User Name: ");
        user_name.setBounds(400,200,200,25);
        user_name.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(user_name);

        User_Text = new JTextField(20);
        User_Text.setFont(new Font("Verdana",Font.PLAIN,18));
        User_Text.setBounds(600,200,165,25);
        panel.add(User_Text);


        password = new JLabel("Student ID: ");
        password.setBounds(400,300,200,25);
        password.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(password);

        Password_Text = new JTextField(20);
        Password_Text.setFont(new Font("Verdana",Font.PLAIN,18));
        Password_Text.setBounds(600,300,165,25);
        panel.add(Password_Text);
       
        JButton button = new JButton("Login");
        button.setFont(new Font("Verdana",Font.BOLD,18));
        button.setBounds(600,380,170,40);
        button.setForeground(new Color(0,0,255));
        button.addActionListener(new Login_page());
        panel.add(button);

        print = new JLabel("");
        print.setBounds(570,450,300,25);
        print.setFont(new Font("Verdana",Font.BOLD,20));
        print.setForeground(new Color(255,0,0));
        panel.add(print);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) 
    {
        String User_text = User_Text.getText();
        String password = Password_Text.getText();
        if(Examination_portal.hashMap.containsKey(User_text) && Examination_portal.hashMap.get(User_text).equals(password))
        {
            Questions_UI.start_quiz();
        }
        else
        {
            print.setText("Login Unsuccessful !!");
            Timer timer = new Timer();
            TimerTask task= new TimerTask() 
            {
                @Override
                public void run() 
                {
                    print.setText("");
                    
                }
            };
            timer.schedule(task, 5000);
            System.out.println("Hi");
        
            
        }
    }
}
