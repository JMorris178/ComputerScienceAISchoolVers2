import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class InitialSetup { //Checks to see if a file exists, but if it doesn't it runs a setup process to make sure the program works.
    public static void createNewFile(Car car){
        Scanner input = new Scanner(System.in);
        ArrayList tempRecord = new ArrayList<>();
        ArrayList<Double> tempToAddToFile = new ArrayList<>(); //allows the program to push the settings data to the file if needed
        try {
            File fileCreate = new File("userData");
            if (fileCreate.createNewFile()) { //If the file doesn't exist

                System.out.println("File created: " + fileCreate.getName());
                System.out.println("Since this is the first time you are using this, please input some basic data for this program to function");
                String MPG = JOptionPane.showInputDialog("What is your cars MPG?");
                Double tempMPG = Double. parseDouble(MPG);
                System.out.println();
                String FuelTank = JOptionPane.showInputDialog("What is your fuel tanks max capacity?");
                Double tempFuelTank =  Double. parseDouble(FuelTank);
                String Cost = JOptionPane.showInputDialog("What is the current cost of fuel?");
                Double tempFuelCost = Double. parseDouble(Cost);
                tempToAddToFile.add(tempMPG); //adds these to the file.
                tempToAddToFile.add(tempFuelTank);
                tempToAddToFile.add(tempFuelCost);
                for (int i = 0; i < 3; i++){ //Loop allows each part of the users input to be added to the database
                    Object x = tempToAddToFile.get(i);
                    FileUtilisation.addToFile(x);
                }
                FileUtilisation.addToFile(tempFuelTank); //adds a copy of the fuel tank as a max
                // - so it will return to this if it runs out

            } else {
                System.out.println("File exists"); //If the file exists.
            }
            //different settings are saved to the constructor which have been saved in the file
            String tempPassMPG = String.valueOf(FileUtilisation.readFromFileDouble(0));
            String tempPassFuelTank = String.valueOf(FileUtilisation.readFromFileDouble(1));
            String tempPassFuelCost = String.valueOf(FileUtilisation.readFromFileDouble(2));
            String tempPassMaxCap = String.valueOf(FileUtilisation.readFromFileDouble(3));
            car.setMPG(Double.parseDouble(tempPassMPG));
            car.setFuelTank(Double.parseDouble(tempPassFuelTank));
            car.setPrices(Double.parseDouble(tempPassFuelCost));
            car.setMaxCap(Double.parseDouble(tempPassMaxCap));
            //Now on restart it will add a placeholder date at the start to avoid an error
            tempRecord.add(1);
            tempRecord.add(1);
            tempRecord.add(1);
            tempRecord.add(0);
            tempRecord.add(0);
            tempRecord.add("false");
            tempRecord.add(0);
            FileUtilisation.addToFile(tempRecord);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
