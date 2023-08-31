import javax.swing.*;

public class RecordAdderGUI {
    private JFrame frame;

    public RecordAdderGUI(int width, int height) {
        frame = new JFrame("Mileage Diary");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        String day = JOptionPane.showInputDialog("What is the day (in the form 2, 20, 31, etc)");
        String month = JOptionPane.showInputDialog("What is the month (in the form 2, 7, 12, etc)");
        String year = JOptionPane.showInputDialog("What is the year (in the form 2005, 2010, 2031, etc)");
        String milesTravelled = JOptionPane.showInputDialog("How many miles did you travel?");
        String refuelChoice  = JOptionPane.showInputDialog("Did you refuel - 'true' or 'false'");
        boolean refuel = false;
        if(refuelChoice.equals("true")){
            refuel = true;
        }

        Interfaces.mileageCalcInterface(Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year),Double.parseDouble(milesTravelled),refuel);
    }
}
