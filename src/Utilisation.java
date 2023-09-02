
import java.util.Calendar;
import java.util.ArrayList;

public class Utilisation {
    public static Double findFuelConsumption(Double MT, Double MPG) {
        Double temp;
        temp = MT/MPG; //Calculation to find the fuel consumption
        return (temp);
    }

    public static void carOutOfFuel(Car car) { //Resets the fuel tank of the car
        Double remainder = car.getFuelTank();
        Double maxCap = car.getMaxCap();
        car.setFuelTank(maxCap + remainder);
        FileUtilisation.replaceLines(1, maxCap + remainder); //sets both the file and constructor back so they're in sync
    }

    public static void carRefuel(Car car) { //alternate version of CarOutOfFuel if the user refuels on not a full tank
        car.setFuelTank(car.getMaxCap()); //As there was fuel still in the tank there was no need to carry over any remainder
        FileUtilisation.replaceLines(1, car.getMaxCap()); //sets both the file and constructor back so they're in sync

    }


    public static Double costCalculator(Car car) { //Calculates the cost of a full refuel
        Double total = car.getPrices() * car.getFuelTank(); //Multiplies the cost per gallon by the capacity of fuel tank to find the cost for a full refuel
        return total;
    }

    public static Double costCalculator(Car car, Double remainderInTank) { //Alternate version of costCalculator if the user refueled while their tank wasn't empty
        Double total = car.getPrices() * (car.getFuelTank() - remainderInTank); //Multiplies the cost per gallon by the capacity of fuel tank with the remainder in the tank subtracted to find the cost for a full refuel
        return total;
    }


    public static Double costOverTime(Calendar calendar, ArrayList<String> passer, int repeats) { //Slight variation of the above that uses inputted repeats
        Double total = 0.0;
        String holder;
        calendar.set(Integer.parseInt(passer.get(2)),(Integer.parseInt(passer.get(1))-1),Integer.parseInt(passer.get(0)));
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, -(day));//sets the calendar back to the start of the month
        for (int i = 0; i < repeats; i++) {
            passer = new ArrayList<>(); //resets Passer at the start of each loop

            calendar.add(Calendar.DATE, +1);
            passer.add(String.valueOf((calendar.get(Calendar.DAY_OF_MONTH))));
            passer.add(String.valueOf((calendar.get(Calendar.MONTH)) + 1));
            passer.add(String.valueOf(calendar.get(Calendar.YEAR)));
            if (FileUtilisation.returnFromFile(passer,5) == null){
                total = total + 0;
            } else if (String.valueOf(FileUtilisation.returnFromFile(passer,5)).equals("true")){
                holder = ((String) FileUtilisation.returnFromFile(passer,6));
                holder = holder.replace(",",""); //removes the comma from the number
                total = total +  Double.parseDouble(holder);
            } else {
                total = total + 0;
            }
        }
        return (Math.round(total * 100.0) / 100.0);
    }

    public static Double milesOverTime(Calendar calendar, ArrayList<String> passer, int repeats) { //Slight variation of the above that uses inputted repeats
        Double total = 0.0;
        String holder;
        calendar.set(Integer.parseInt(passer.get(2)),(Integer.parseInt(passer.get(1))-1),Integer.parseInt(passer.get(0)));
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, -(day));//sets the calendar back to the start of the month
        for (int i = 0; i < repeats; i++) {
            passer = new ArrayList<>(); //resets Passer at the start of each loop

            calendar.add(Calendar.DATE, +1);
            passer.add(String.valueOf((calendar.get(Calendar.DAY_OF_MONTH))));
            passer.add(String.valueOf((calendar.get(Calendar.MONTH)) + 1));
            passer.add(String.valueOf(calendar.get(Calendar.YEAR)));
            if (FileUtilisation.returnFromFile(passer,5) == null){
                total = total + 0;
            } else if (String.valueOf(FileUtilisation.returnFromFile(passer,5)).equals("true")){
                holder = ((String) FileUtilisation.returnFromFile(passer,3));
                holder = holder.replace(",",""); //removes the comma from the number
                total = total +  Double.parseDouble(holder);
            } else {
                total = total + 0;
            }
        }
        return (total);
    }


    public static Car constructorSetup() {
        Double MPG = FileUtilisation.readFromFileDouble(0);
        Double CurrentFuel = FileUtilisation.readFromFileDouble(1);
        Double Cost = FileUtilisation.readFromFileDouble(2);
        Double MaxCap = FileUtilisation.readFromFileDouble(3);
        Car car = new Car(MPG,CurrentFuel,Cost,MaxCap); //Sets up the constructor
        return (car);
    }


}
