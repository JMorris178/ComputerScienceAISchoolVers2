import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SettingsGUI extends JPanel implements ActionListener {
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    private JFrame frame;

    {

    }

    public SettingsGUI(int width, int height, Car car) {
        frame = new JFrame("Settings");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);

        button1 = new JButton("Change MPG");
        button1.setBounds(200, 100, 200, 40);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Change fuel tank capacity");
        button2.setBounds(200, 175, 200, 40);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Change fuel cost");
        button3.setBounds(200, 250, 200, 40);
        button3.addActionListener(this);
        add(button3);
    }

    @Override
    public void actionPerformed(ActionEvent e, Car car) {
        // respond to button clicks
        int choice = 0;
        if (e.getActionCommand().equals("Change MPG")) { //If the Mileage calculator
            String newMPG = JOptionPane.showInputDialog("");
            choice = 1;
            float floatPasser = parseFloat(newMPG);
            Interfaces.settingsInterface(newMPG,choice,car);
        } else if (e.getActionCommand().equals("Change fuel tank capacity")) { //If the Mileage calculator
            choice = 2;
            String newFTC = JOptionPane.showInputDialog("");
        } else if (e.getActionCommand().equals("Change fuel cost")) { //If the Mileage calculator
            choice = 3;
            String newFC = JOptionPane.showInputDialog("");
        }


    }
}
