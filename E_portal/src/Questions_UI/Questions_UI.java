package Questions_UI;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import MainFile.Examination_portal;

public class Questions_UI extends Examination_portal implements ActionListener
{
    static public int n=1;
    static private HashMap<Integer,JLabel> map= new HashMap<>();
    static private JFrame frame;
    static private JPanel panel;
    static private JLabel Questions;
    static private JLabel Option1;
    static private JLabel Option2;
    static private JLabel Option3;
    static private JLabel Option4;
    static private JTextArea Area;
    static private JLabel Option5;
    static private JButton button;
    public static void start_quiz() 
    {
        
        java_UI.Question_display();
    }
    static void set_questions(String questions,String[]opt)
    {
    
        panel = new JPanel();
        frame = new JFrame("EXAMINATION PORTAL");
        frame.setSize(1980,790);
        ImageIcon imgicon = new ImageIcon("E://Desktop//Examination-Portal//E_portal//portal.jpg");
        frame.setIconImage(imgicon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.decode("#00FFFF"));
        frame.add(panel);
        panel.setLayout(null);

        Questions = new JLabel(questions);
        Questions.setBounds(390,50,1200,25);
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
        System.out.println(n);
        if(n<=5)
        {
            map.get(Integer.parseInt(java_UI.answers.get(n))).setForeground(new Color(0,0,255));
            if(!(Area.getText().equals(java_UI.answers.get(n))))
            {
                map.get(Integer.parseInt(Area.getText())).setForeground(new Color(255,0,0));
            }
        }
        else
        {
            map.get(Integer.parseInt(DS.answers.get(n%5))).setForeground(new Color(0,0,255));
            if(!(Area.getText().equals(DS.answers.get(n%5))))
            {
                map.get(Integer.parseInt(Area.getText())).setForeground(new Color(255,0,0));
            }
        }
                  
        Timer timer = new Timer();
        TimerTask task= new TimerTask() 
        {
            @Override
            public void run() 
            {
                n+=1;
                if(n<=5)
                {
                    set_questions(java_UI.Question_list.get(n),java_UI.Options.get(n));
                }
                else
                {
                    if(n==6)
                    {
                        DS.Question_display();
                    }
                    set_questions(DS.Question_list.get(n%5),DS.Options.get(n%5));
                }
               
                
            }
        };
        timer.schedule(task, 3000);
        
        
    }
}
class java_UI extends Questions_UI
{
    int score;
    static HashMap<Integer,String> Question_list = new HashMap<Integer,String>();
    static HashMap<Integer,String[]> Options = new HashMap<Integer,String[]>();
    static HashMap<Integer,String> answers = new HashMap<Integer,String>();
    static JLabel label;

    java_UI()
    {
        score=0;
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
    int score;
    static HashMap<Integer,String> Question_list = new HashMap<Integer,String>();
    static HashMap<Integer,String[]> Options = new HashMap<Integer,String[]>();
    static HashMap<Integer,String> answers = new HashMap<Integer,String>();
    static JLabel label;

    DS()
    {
        score=0;
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
        answers.put(5, "1");
    }

    
    static void Question_display()
    {
        assign_question();
        
        set_questions(Question_list.get(n%5),Options.get(n%5));
    
    }
}