import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BasicGUI extends JPanel implements ActionListener {
    // a UI where we can add other UI widgets eg buttons
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;


    public BasicGUI(int width, int height, Car car) {
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);

        button1 = new JButton("Mileage Calculator");
        button1.setBounds(200, 75, 200, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Budgeting sheet");
        button2.setBounds(200, 150, 200, 40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Record Adder");
        button3.setBounds(200, 225, 200, 40);
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("Settings");
        button4.setBounds(200, 300, 200, 40);
        button4.addActionListener(this);
        add(button4);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // respond to button clicks
        System.out.println(e.getActionCommand() + " was clicked");
        if (e.getActionCommand().equals("Mileage Calculator")) { //If the Mileage calculator
            MileageDiaryGUI mGUI = new MileageDiaryGUI(600, 400);
        }if (e.getActionCommand().equals("Settings")) {
                SettingsGUI sGUI = new SettingsGUI(600, 400);
        }if (e.getActionCommand().equals("Record Adder")) {
                RecordAdderGUI rGUI = new RecordAdderGUI(600, 400);
    }
        }




    }
