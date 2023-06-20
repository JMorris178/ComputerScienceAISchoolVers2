import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MileageDiaryGUI extends JPanel {
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    private JFrame frame;{

    }
    public MileageDiaryGUI(int width, int height) {
        frame = new JFrame("Mileage Diary");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        frame.getContentPane().add(this);
        frame.setVisible(true);

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
