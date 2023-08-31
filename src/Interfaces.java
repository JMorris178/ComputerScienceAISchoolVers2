import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

public class Interfaces {
    public static void settingsInterface(Double input, int choice) {
        Car car = Utilisation.constructorSetup();
        if (choice == 0) {
            FileUtilisation.replaceLines(0, input); //line 0 is always the MPG, so it can easily be accessed and changed.
            car.setMPG(input); //updates it in the constructor
        } else if (choice == 1) {
            FileUtilisation.replaceLines(3, input);//Also sets the new max Capacity on line 3 & in the constructor
            car.setMaxCap(input);
        } else if (choice == 2) {
            FileUtilisation.replaceLines(2, input);
            car.setPrices(input);
        }
    }

    public static void mileageCalcInterface(int day, int month, int year, double miles, boolean refuel) {
        boolean repeat = true;
        Car car = Utilisation.constructorSetup();

        //All the necessary variables are defined here so they're reset at the start of each cycle
        ArrayList record = new ArrayList<>();
        ArrayList sortingPasser = new ArrayList<>(); //Passer specifically for sorting
        ArrayList<String> passer = new ArrayList<>(); //creates a new arraylist to pass data through that isn't the records
        boolean refillRequired = false;
        boolean extraValue = false;
        boolean replaceLines = false;
        boolean fullRefillRequired = false;
        Double remainderInTank = 0.0;
        Double offset;
        Double originalValue;
        double cost = 0;
        Double newValue;
        Double overshoot = 0.0;

        //adds the date to the record and the passer
        record.add(day);
        record.add(month);
        record.add(year);
        sortingPasser.add(day);
        sortingPasser.add(month);
        sortingPasser.add(year);
        for (int i = 0; i < 3; i++) {
            passer.add(String.valueOf(record.get(i))); //converts the date into strings and adds them to passer for later checks
        }
        Double MPG = FileUtilisation.readFromFileDouble(0);
        Double fuelCon = Utilisation.findFuelConsumption(miles, MPG);
        if (FileUtilisation.findInFile(sortingPasser) == true) { //Checks if the dates are already in the database. If true, a different method needs to be carried out to replace the lines.
            offset = Double.valueOf((String) FileUtilisation.returnFromFile(passer, 4)); //Takes the current fuel consumption in the record already in the file
            newValue = car.getFuelTank() + offset;
            if (newValue > car.getMaxCap()) {//checks to see if the new value has exceeded the capacity
                overshoot = newValue - car.getMaxCap(); //Finds the overshoot
            }
            newValue = newValue - overshoot;
            car.setFuelTank(newValue); //sets the fuel tank in the car back to what it was before the change
            FileUtilisation.replaceLines(1, newValue);//uses originalValue to avoid a logic error
            replaceLines = true; //sets to true so the if statement later is carries out
        }
        car.setFuelTank((car.getFuelTank()) - fuelCon);
        FileUtilisation.replaceLines(1, car.getFuelTank());
        if (car.getFuelTank() <= 0) {
            fullRefillRequired = true; //sets the refill to true
            cost = car.getPrices() * (Math.abs(car.getFuelTank()) + 20);
            Utilisation.carOutOfFuel(car); //resets the fuel capacity, with the remainder taken away


        } else {
            if (refuel) {
                remainderInTank = car.getFuelTank(); //sets a value to remainderInTank
                refillRequired = true;
                extraValue = true;
                Utilisation.carRefuel(car);
            }
        }
        record.add(miles);
        record.add(fuelCon);
        record.add(refillRequired);

        if (extraValue == true) { //Calculates the cost to then be added
            record.add(Utilisation.costCalculator(car, remainderInTank));

        }else if (fullRefillRequired){
                record.add(cost);
        }else if (refuel){
            record.add(Utilisation.costCalculator(car));
        } else {
            record.add(0);
        }
        if (replaceLines) {
            int lineNum = FileUtilisation.findLineNum(passer);
            FileUtilisation.replaceLines((lineNum + 1), record); //replaces the line that had the same date originally.
        } else {
            FileUtilisation.addToFile(record);
        }
    }

    public static String budgetingSheetInterface(int choice, int day, int month, int year) {
        Scanner userInput = new Scanner(System.in);
        boolean repeat = true;
        Car car = Utilisation.constructorSetup();

        Calendar calendar = Calendar.getInstance(); //resets the calendar back to the current date to reset any changes made during one of the methods
        ArrayList<String> passer = new ArrayList<>(); //creates a new arraylist to pass data through that isn't the records
        Double total = 0.0;

         //Uses the costOverTime method to calculate the cost
        if (choice == 1) {
               double returnValue = Utilisation.costOverTime(car, day, month, year, passer);
               if (returnValue == 0){
                   return("N/A");
               }else{
                   return(Double.toString(returnValue));
               }

        } else if (choice == 2) {

            if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {//checks the month and then depending on the current month it will seperate this based on the number of days in the month. This line is for all the months with 31 days
               return(Double.toString(Utilisation.costOverTime(car, calendar, passer, 31)));
            } else if (month == 3 || month == 5 || month == 8 || month == 10) { //30 days
                return(Double.toString(Utilisation.costOverTime(car, calendar, passer, 30)));
            } else if (month == 1 && (year % 4) == 0) { //checks to see if the year is a leap year and the month is Febuary to check if it needs 28 or 29 days. Done before the regular febuary check on purpose
                return(Double.toString(Utilisation.costOverTime(car, calendar, passer, 29)));
            } else if (month == 1) {//28 days for a normal Febuary
                return(Double.toString(Utilisation.costOverTime(car, calendar, passer, 28)));
            }
        } else if (choice == 6) {
            System.out.println("Please input a date within the month you would like to look at. (For example, 02-01-2023 for January of 2023");
            System.out.println("Please input the following in numerical form - the date of the month (eg : 02, 20, 30)");

            System.out.println("Please input the following in numerical form - the month (eg : 02, 10, 08)");
            //the months start at 0 so this is done to offset that
            System.out.println("Please input the following in numerical form - the year (eg : 2023, 1973)");

            calendar.set(year, month, day);//Sets the calendar to the date inputted, so the program can use a different date so a different month can be viewed
            if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {//checks the month and then depending on the current month it will seperate this based on the number of days in the month. This line is for all the months with 31 days
                System.out.println("Over the past month, you have spent £" + Utilisation.costOverTime(car, calendar, passer, 31));
            } else if (month == 3 || month == 5 || month == 8 || month == 10) { //30 days
                System.out.println("Over the past month, you have spent £" + Utilisation.costOverTime(car, calendar, passer, 30));
            } else if (month == 1 && (year % 4) == 0) { //checks to see if the year is a leap year and the month is Febuary to check if it needs 28 or 29 days. Done before the regular febuary check on purpose
                System.out.println("Over the past month, you have spent £" + Utilisation.costOverTime(car, calendar, passer, 29));
            } else if (month == 1) {//28 days for a normal Febuary
                System.out.println("Over the past month, you have spent £" + Utilisation.costOverTime(car, calendar, passer, 28));
            } else {

            }
        }
        return null;
    }
}
