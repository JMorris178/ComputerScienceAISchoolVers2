import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean repeat = true;
        Car car = new Car(0,0,0, 0); //Sets up the constructor
        InitialSetup.createNewFile(car); //Checks if the user has a file already. If they don't, it performs an initial set up
        Calendar calendar =  Calendar.getInstance(); //Sets up the calendar to today's date
        while (repeat) { //While loop used to repeat the core of the program over and over until
            System.out.println("Hello user. Would you like to go to 1. The Mileage Calculator, or 2. Settings, or 3. The Budgeting Sheet");
            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            if(choice == 1){
                Interfaces.mileageCalcInterface(calendar,car); //Takes the user to the mileage calculator section
            }
            else if(choice == 2){
                Interfaces.settingsInterface(car); //Takes the user to the settings section
            }
            else if(choice == 3){
                Interfaces.budgetingSheetInterface(car,calendar); //Takes the user to the Budgeting Sheet interface
            }else{
                repeat = false; //ends the loop
            }
        }

    }
}
