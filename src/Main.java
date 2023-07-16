import java.util.Calendar;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static BasicGUI menuGUI;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 400;
    public static void main(String[] args) {

        boolean repeat = true;
        Car car = Utilisation.constructorSetup();
        InitialSetup.createNewFile(car); //Checks if the user has a file already. If they don't, it performs an initial set up
        Calendar calendar =  Calendar.getInstance(); //Sets up the calendar to today's date
        JFrame frame = new JFrame("Program Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        menuGUI = new BasicGUI(WINDOW_WIDTH, WINDOW_HEIGHT, car);
        frame.add(menuGUI);
        while (repeat) { //While loop used to repeat the core of the program over and over until
            frame.pack(); // tell window to resize to fit components
            frame.setVisible(true);
            System.out.println("Hello user. Would you like to go to 1. The Mileage Calculator, or 2. Settings, or 3. The Budgeting Sheet");
            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();

            //Takes the user to the Budgeting Sheet interface

        }
//
    }
}
