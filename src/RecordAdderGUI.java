import javax.swing.*;

public class RecordAdderGUI {
    private JFrame frame;

    public RecordAdderGUI(int width, int height) {
        frame = new JFrame("Mileage Diary");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        String day = JOptionPane.showInputDialog("What is the day (in the form 02, 20, 31, etc)");
        String month = JOptionPane.showInputDialog("What is the day (in the form 02, 20, 31, etc)");
        String year = JOptionPane.showInputDialog("What is the day (in the form 02, 20, 31, etc)");
        String milesTravelled = JOptionPane.showInputDialog("How many miles did you travel?");
        String refuel  = JOptionPane.showInputDialog("What is the day (in the form 02, 20, 31, etc)");
    }
}
