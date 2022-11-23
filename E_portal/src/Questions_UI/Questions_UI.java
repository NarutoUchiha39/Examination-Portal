package Questions_UI;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import MainFile.Examination_portal;
import Login_page.Login_page;
import Piechart.PieChart_AWT;
import Piechart.PieChart_AWT.*;
public class Questions_UI extends Examination_portal implements ActionListener
{
    static public int n=1;
    static public HashMap<Integer,JLabel> map= new HashMap<>();
    static public JFrame frame;
    static public JPanel panel;
    static public JLabel Questions;
    static public JLabel Option1;
    static public JLabel Option2;
    static public JLabel Option3;
    static public JLabel Option4;
    static public JTextArea Area;
    static public JLabel Option5;
    static public JButton button;
    static public java_UI obj = new java_UI();
    static public DS obj2 = new DS();
    public static void start_quiz() 
    {
        java_UI.Question_display();
    }

    static void set_questions(String questions,String[]opt)
    {
    
        panel = new JPanel();
        frame = new JFrame("EXAMINATION PORTAL");
        frame. setExtendedState(JFrame. MAXIMIZED_BOTH); 
        ImageIcon imgicon = new ImageIcon("E://Desktop//Examination-Portal//E_portal//portal.jpg");
        frame.setIconImage(imgicon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.decode("#00FFFF"));
        frame.add(panel);
        panel.setLayout(null);

        Questions = new JLabel(questions);
        Questions.setBounds(50,50,1200,25);
        Questions.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(Questions);

        Option1 = new JLabel(opt[0]);
        Option1.setBounds(50,190,1200,25);
        Option1.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(Option1);

        Option2 = new JLabel(opt[1]);
        Option2.setBounds(50,280,1200,25);
        Option2.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(Option2);

        Option3 = new JLabel(opt[2]);
        Option3.setBounds(50,370,1200,25);
        Option3.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(Option3);
        

        Option4 = new JLabel(opt[3]);
        Option4.setBounds(50,460,1200,25);
        Option4.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(Option4);

        Option5 = new JLabel("Enter Choice: ");
        Option5.setBounds(50,550,700,25);
        Option5.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(Option5);

        Area =new JTextArea();
        Area.setBounds(250,550,165,25);
        Area.setFont(new Font("Verdana",Font.BOLD,20));
        panel.add(Area);
         
        button =new JButton("Submit");
        button.setBounds(600,640,165,25);
        button.setFont(new Font("Verdana",Font.BOLD,20));
        button.setForeground(new Color(0,0,255));
        button.addActionListener(new Questions_UI());
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        map.put(1, Option1);
        map.put(2, Option2);
        map.put(3, Option3);
        map.put(4, Option4);
        if(n<=5)
        {
            map.get(Integer.parseInt(java_UI.answers.get(n))).setForeground(new Color(0,0,255));
            if(!(Area.getText().equals(java_UI.answers.get(n))))
            {
                map.get(Integer.parseInt(Area.getText())).setForeground(new Color(255,0,0));
            }
            else
            {
                obj.score+=1;
            }
        }
        else if(n<=10 && n>5)
        {
            map.get(Integer.parseInt(DS.answers.get(n%6+1))).setForeground(new Color(0,0,255));
            if(!(Area.getText().equals(DS.answers.get(n%6+1))))
            {
                map.get(Integer.parseInt(Area.getText())).setForeground(new Color(255,0,0));
            }
            else
            {
                obj2.score+=1;
            }
        }
                  
        Timer timer = new Timer();
        TimerTask task= new TimerTask() 
        {
            @Override
            public void run() 
            {
                
                n+=1;
                System.out.println((n));
                if(n<=5)
                {
                    set_questions(java_UI.Question_list.get(n),java_UI.Options.get(n));
                }
                else if(n<=10 && n>5)
                {
                    if(n==6)
                    {
                        System.out.println(obj.score);
                        DS.Question_display();
                    }
                    else
                    {
                        set_questions(DS.Question_list.get(n%6+1),DS.Options.get(n%6+1));
                    }
                   
                }
               else
               {
                    frame.dispose();
                    result_Screen.display();
               }
                
            }
        };
        timer.schedule(task, 3000);
        
        
    }
}
class result_Screen extends Questions_UI
{
    static void display()
    {

        panel = new JPanel();

        frame = new JFrame("EXAMINATION PORTAL");
        frame. setExtendedState(JFrame. MAXIMIZED_BOTH); 
        ImageIcon imgicon = new ImageIcon("E://Desktop//Examination-Portal//E_portal//portal.jpg");
        frame.setIconImage(imgicon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.decode("#00FFFF"));
        frame.add(panel);
        panel.setLayout(null);

        Option1 = new JLabel("Results");
        Option1.setBounds(550, 10, 600,90);
        Option1.setFont(new Font("Verdana",Font.BOLD,60));
        panel.add(Option1);
        
        Option2 = new JLabel("Name:    "+Login_page.User_Text.getText());
        Option2.setBounds(80,230,1200,65);
        Option2.setFont(new Font("Verdana",Font.BOLD,30));
        panel.add(Option2);

        Option3 = new JLabel("Roll Number:  "+Login_page.Password_Text.getText());
        Option3.setBounds(80,370,1200,65);
        Option3.setFont(new Font("Verdana",Font.BOLD,30));
        panel.add(Option3);

        Option4 = new JLabel("Java Marks:  "+obj.score+" /5");
        Option4.setBounds(830,230,1200,65);
        Option4.setFont(new Font("Verdana",Font.BOLD,30));
        panel.add(Option4);

        Option5 = new JLabel("Data Structure Marks:  "+obj2.score+" /5");
        Option5.setBounds(830,370,1200,65);
        Option5.setFont(new Font("Verdana",Font.BOLD,30));
        panel.add(Option5);

        JLabel Option6 = new JLabel("Percentage:  "+(((obj.score+obj2.score)/10)*100)+" %");
        Option6.setBounds(550,570,1200,65);
        Option6.setFont(new Font("Verdana",Font.BOLD,30));
        panel.add(Option6);

        button =new JButton("Performance review");
        button.setBounds(520,640,350,25);
        button.setFont(new Font("Verdana",Font.BOLD,20));
        button.setForeground(new Color(0,0,255));
        button.addActionListener(new result_Screen());
        panel.add(button);

        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) 
    {
        PieChart_AWT.score1=obj.score;
        PieChart_AWT.Score2=obj2.score;
        PieChart_AWT.start();

    }
}
class java_UI extends Questions_UI
{
    public Double score;
    static HashMap<Integer,String> Question_list = new HashMap<Integer,String>();
    static HashMap<Integer,String[]> Options = new HashMap<Integer,String[]>();
    static HashMap<Integer,String> answers = new HashMap<Integer,String>();
    static JLabel label;

    java_UI()
    {
        score=0.0;
    }
    static void assign_question()
    {
        Question_list.put(1,"What is the implicit return type of constructor?");
        Options.put(1,new String[]{"1) No Return Type","2) A Class object in which it is defined","3) Void","4) None"});
        answers.put(1, "2");

        Question_list.put
        (2,"Automatic type conversion is possible in which of the possible cases? ");
        Options.put(2,new String[]{"1) Byte storing int","2) int storing long","3) long storing int","4) short storing int"});
        answers.put(2, "3");

        Question_list.put
        (3,"When an array is passed to a method, what does the method receive?");
        Options.put(3,new String[]{"1) The reference of the array","2) Copy of the array","3) Length of the array","4) Copy of the first element"});
        answers.put(3, "1");

        Question_list.put
        (4,"When is the finalize() method called?");
        Options.put(4,new String[]{"1) Before Garbage Collection","2) Before Object goes out of Scope","3) Before Variable goes out of scope","4) None"});
        answers.put(4, "1");


        Question_list.put
        (5,"Where is System class defined?");
        Options.put(5,new String[]{"1) Java.Lang","2) Java.util.package","3) Java.util.IO","4) None"});
        answers.put(5, "1");
    }

    
    static void Question_display()
    {
        assign_question();
        
        set_questions(Question_list.get(n),Options.get(n));
    
    }
}

class DS extends Questions_UI
{
    public Double score;
    static HashMap<Integer,String> Question_list = new HashMap<Integer,String>();
    static HashMap<Integer,String[]> Options = new HashMap<Integer,String[]>();
    static HashMap<Integer,String> answers = new HashMap<Integer,String>();
    static JLabel label;

    DS()
    {
        score=0.0;
    }
    static void assign_question()
    {
        Question_list.put(1,"How is the 2nd element in an array accessed based on pointer notation?");
        Options.put(1,new String[]{"1) *a + 2","2) *(a + 2)","3) *(*a + 2)","4) &(a + 2)"});
        answers.put(1, "2");

        Question_list.put
        (2,"Which of the following is not the type of queue? ");
        Options.put(2,new String[]{"1) Priority queue","2) Single-ended queue","3) Circular queue","4) Ordinary queue"});
        answers.put(2, "2");

        Question_list.put
        (3,"What is the disadvantage of array data structure?");
        Options.put(3,new String[]{"1) memory to be allocated should be known","2)Elements can be accessed in constant time","3) Elements are stored in contiguous memory blocks","4) None"});
        answers.put(3, "1");

        Question_list.put
        (4,"How are String represented in memory in C?");
        Options.put(4,new String[]{"1) An array of characters.","2) The object of some class","3) Same as other primitive data types.","4) LinkedList of characters"});
        answers.put(4, "1");


        Question_list.put
        (5,"When a pop() operation is called on an empty queue, what is the condition called?");
        Options.put(5,new String[]{"1) Overflow","2) Underflow","3) Syntax Error","4) Garbage Value"});
        answers.put(5, "2");
    }

    
    static void Question_display()
    {
        assign_question();
        
        set_questions(Question_list.get(n%5),Options.get(n%5));
    
    }
}