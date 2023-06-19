import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {
    private JFrame frame;

    public GUI(int width, int height) {
        frame = new JFrame("Simple Graph");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        // create a canvas for the graphics
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        int left = 50;
        int top = 80;
        int width = 40;
        int height = 150;
        g.setColor(Color.BLUE);
        g.fillRect(left,top,width,height);
    }
}
