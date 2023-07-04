import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.stream.Stream;
import java.util.ArrayList;

public class Utilisation {
    public static Double findFuelConsumption(Double MT) {
        int n = 0; // Set to 0 because the MPG is always on line 1
        String line;
        Double temp;
        try (Stream<String> lines = Files.lines(Paths.get("userData"))) {
            line = lines.skip(n).findFirst().get();
            temp = MT / Double.valueOf(line); //Calculation to find the fuel consumption
            return (temp);
        } catch (IOException e) {
            System.out.println(e);
        }
        return (0.0);
    }

    public static void carOutOfFuel(Car car) { //Resets the fuel tank of the car
        Double remainder = car.getFuelTank();
        int n = 3; // The line number for the max capacity of the fuel tank
        String line;
        try (Stream<String> lines = Files.lines(Paths.get("userData"))) {
            line = lines.skip(n).findFirst().get();
            car.setFuelTank(Double.parseDouble(line) + remainder);
            FileUtilisation.replaceLines(1, Double.parseDouble(line) + remainder); //sets both the file and constructor back so they're in sync
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void carRefuel(Car car) { //alternate version of CarOutOfFuel if the user refuels on not a full tank
        int n = 3; // The line number for the max capacity of the fuel tank
        String line;
        try (Stream<String> lines = Files.lines(Paths.get("userData"))) {
            line = lines.skip(n).findFirst().get();
            car.setFuelTank(Double.parseDouble(line)); //As there was fuel still in the tank there was no need to carry over any remainder
            FileUtilisation.replaceLines(1, Double.parseDouble(line)); //sets both the file and constructor back so they're in sync
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static Double costCalculator(Car car) { //Calculates the cost of a full refuel
        Double total = car.getPrices() * car.getFuelTank(); //Multiplies the cost per gallon by the capacity of fuel tank to find the cost for a full refuel
        return total;
    }

    public static Double costCalculator(Car car, Double remainderInTank) { //Alternate version of costCalculator if the user refueled while their tank wasn't empty
        Double total = car.getPrices() * (car.getFuelTank() - remainderInTank); //Multiplies the cost per gallon by the capacity of fuel tank with the remainder in the tank subtracted to find the cost for a full refuel
        return total;
    }

    public static boolean refuelCheck(ArrayList<String> passer) { //Checks if a refuel was done by reading the file
        boolean returnValue;
        if (FileUtilisation.returnFromFile(passer, 6).equals("true")) {
            returnValue = true;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    public static Double costOverTime(Car car, Calendar calendar, ArrayList<String> passer) { //Calculates the cost over time
        Double total = 0.0;
        for (int i = 0; i < 7; i++) {
            passer = new ArrayList<>(); //resets Passer at the start of each loop
            calendar.add(Calendar.DATE, -1);
            passer.add(String.valueOf((calendar.get(Calendar.DAY_OF_MONTH))));
            passer.add(String.valueOf((calendar.get(Calendar.MONTH)) + 1));
            passer.add(String.valueOf(calendar.get(Calendar.YEAR))); //Adds the date to passer so it can be read later
            if (Utilisation.refuelCheck(passer)) { //checks if the index at 5 has a value, and if it does it carries out the following as there was a refuel
                if (FileUtilisation.returnFromFile(passer, 6).equals("true")) { //checks if index 6 is true. If it is then there's a remainder in index 7, which it will then pass through to the cost calculator
                    Double remainderInTank = Double.valueOf((String) FileUtilisation.returnFromFile(passer, 7)); //Casts the returned value to a string so it can then be converted into a float.
                    if (Utilisation.costCalculator(car) == 0) {
                        total = total + 0;
                    } else {
                        total = total + Utilisation.costCalculator(car, remainderInTank);
                    }
                } else {
                    if (Utilisation.costCalculator(car) == 0) {
                        total = total + 0;
                    } else {
                        total = total + Utilisation.costCalculator(car);
                    }
                }


            } else {
                total = total + 0;
            }
        }
        return total;
    }

    public static Double costOverTime(Car car, Calendar calendar, ArrayList<String> passer, int repeats) { //Slight variation of the above that uses inputted repeats
        Double total = 0.0;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, -(day));//sets the calendar back to the start of the month
        for (int i = 0; i < repeats; i++) {
            passer = new ArrayList<>(); //resets Passer at the start of each loop

            calendar.add(Calendar.DATE, +1);
            passer.add(String.valueOf((calendar.get(Calendar.DAY_OF_MONTH))));
            passer.add(String.valueOf((calendar.get(Calendar.MONTH)) + 1));
            passer.add(String.valueOf(calendar.get(Calendar.YEAR)));
            if (Utilisation.refuelCheck(passer)) { //checks if the index at 5 has a value, and if it does it carries out the following as there was a refuel
                if (FileUtilisation.returnFromFile(passer, 6).equals("true")) { //checks if index 6 is true. If it is then there's a remainder in index 7, which it will then pass through to the cost calculator
                    Double remainderInTank = Double.valueOf((String) FileUtilisation.returnFromFile(passer, 7)); //Casts the returned value to a string so it can then be converted into a float.
                    if (Utilisation.costCalculator(car) == 0) {
                        total = total + 0;
                    } else {
                        total = total + Utilisation.costCalculator(car, remainderInTank);
                    }
                } else {
                    if (Utilisation.costCalculator(car) == 0) {
                        total = total + 0;
                    } else {
                        total = total + Utilisation.costCalculator(car);
                    }
                }


            } else {
                total = total + 0;
            }
        }
        return (total);
    }

    public static Double costOverWeek(Car car, Calendar calendar, ArrayList<String> passer) { //Slight variation for choice=4
        Double total = 0.0;
        for (int i = 0; i < 7; i++) {
            passer = new ArrayList<>(); //resets Passer at the start of each loop
            passer.add(String.valueOf((calendar.get(Calendar.DAY_OF_MONTH))));
            passer.add(String.valueOf((calendar.get(Calendar.MONTH)) + 1));
            passer.add(String.valueOf(calendar.get(Calendar.YEAR)));
            if (Utilisation.refuelCheck(passer)) { //checks if the index at 5 has a value, and if it does it carries out the following as there was a refuel
                if (FileUtilisation.returnFromFile(passer, 6).equals("true")) { //checks if index 6 is true. If it is then there's a remainder in index 7, which it will then pass through to the cost calculator
                    Double remainderInTank = Double.valueOf((String) FileUtilisation.returnFromFile(passer, 7)); //Casts the returned value to a string so it can then be converted into a float.
                    if (Utilisation.costCalculator(car) == 0) {
                        total = total + 0;
                    } else {
                        total = total + Utilisation.costCalculator(car, remainderInTank);
                    }
                } else {
                    if (Utilisation.costCalculator(car) == 0) {
                        total = total + 0;
                    } else {
                        total = total + Utilisation.costCalculator(car);
                    }
                }


            } else {
                total = total + 0;
            }
        }
        return total;
    }

    public static void sortingAlgorithm(ArrayList<Integer> passer) { //Reads through each element in the file, compares the year first, then the month, then the day in passer. Will then rewrite the file and slot in the record in the appropriate place
        boolean repeat = true;
        int numLines = FileUtilisation.countLines();
        String linePasser;
        int count = 4; //Starts on 4 so it skips the first 4 non record items in the file
        while (repeat == true) {
            linePasser = ((String) FileUtilisation.readFromFile(count));
            String[] parts = linePasser.split(", "); //puts the parts of the line read into the list parts
            Integer floatPasser = passer.get(2); //Starts as a string
            Integer floatPasser2 = Integer.parseInt(parts[2]);
            //Compares the two years of the two records, if they're the same then it checks the months
            if (floatPasser < floatPasser2) { //if the year is less than the year in the next section, you know it's less than it so you can swap it
                FileUtilisation.InsertLines(count, passer);
            } else if (floatPasser == floatPasser2) { //if it's equal year, it can still be smaller but further steps need to be taken to check
                floatPasser = passer.get(1);
                floatPasser2 = Integer.parseInt(parts[1]);
                if (floatPasser < floatPasser2) {
                    FileUtilisation.InsertLines(count, passer);
                } else if (floatPasser == floatPasser2) {
                    floatPasser = passer.get(0);
                    floatPasser2 = Integer.parseInt(parts[0]);
                    if (floatPasser < floatPasser2) { //It will only need to be swapped if it's smaller - an equal date would have been picked up by now so nothing else is needed to be checked past this.
                        FileUtilisation.InsertLines(count, passer); //inserts the line where it should be in the order
                    }
                }
            }
            count++;
            if (count >= numLines) {
                repeat = false;
            }


        }

    }

    public static Car constructorSetup() {
        Car car = new Car(FileUtilisation.readFromFileDouble(0),FileUtilisation.readFromFileDouble(1),FileUtilisation.readFromFileDouble(2), FileUtilisation.readFromFileDouble(3)); //Sets up the constructor
        return (car);
    }


}
