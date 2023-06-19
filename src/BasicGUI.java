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
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;


    public BasicGUI(int width, int height) {
        System.out.println("SEQUENCE: Basic Form constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);

        button1 = new JButton("Milage Calculator");
        button1.setBounds(0, 0, 100, 40);
        button1.addActionListener(this);
        add(button1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // respond to button clicks
        System.out.println(e.getActionCommand() + " was clicked");
        if (e.getActionCommand().equals("view graph")) {
            GUI myGraph = new GUI(300, 300);
        }
    }
}