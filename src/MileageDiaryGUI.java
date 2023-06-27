import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class MileageDiaryGUI extends JPanel implements ActionListener {
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton button1;
    JButton button2;
    JButton button3;
    Calendar calendar =  Calendar.getInstance();
    private JFrame frame;
    //Check date
    //Create calendar for the month
    //Checks through the file and if a date has data in then number blue
    //If a cell is clicked then display data for that day
    //If the arrow at the top is clicked, then repeat this
    //Have a searchbar at the top that lets a user search a date, and then display that month

    {

    }

    public MileageDiaryGUI(int width, int height) {
        frame = new JFrame("Mileage Diary");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        calendar.getTime();

        button1 = new JButton("Mileage Calculator");
        button1.setBounds(200, 100, 200, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Budgeting sheet");
        button2.setBounds(200, 175, 200, 40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Settings");
        button3.setBounds(200, 250, 200, 40);
        button3.addActionListener(this);
        add(button3);
    }

    public void actionPerformed(ActionEvent e) {
        // respond to button clicks
        System.out.println(e.getActionCommand() + " was clicked");
        if (e.getActionCommand().equals("Mileage Calculator")) { //If the Mileage calculator
            MileageDiaryGUI mGUI= new MileageDiaryGUI(600,400);


        }
    }
    }
