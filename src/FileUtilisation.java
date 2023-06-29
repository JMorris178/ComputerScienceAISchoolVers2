import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileUtilisation {

    public static void addToFile(Object input) { //General util code to add stuff to files. Uses object so it can be fit all
        try (
                FileWriter fw = new FileWriter("userData", true);
                PrintWriter pw = new PrintWriter(fw)
        ) {
            pw.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addToFile(ArrayList<Object> inputs) { //Polymorphic version of addToFile that takes arrayLists as a parameter
        try (
                FileWriter fw = new FileWriter("userData", true);
                PrintWriter pw = new PrintWriter(fw)
        ) {
            for(int i = 0; i < inputs.size(); i++){ //uses a for loop so array lists of different sizes can be used.
                pw.print(inputs.get(i));
                pw.print(", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countLines() { //General code to read all the lines from the file and count them
        try {
            int count = 0;
            FileReader fr = new FileReader("userData");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                line = br.readLine();
                count++;
            }
            return(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (0);
    }

    public static Object readFromFile(int lineNum) { //General code to read stuff from the file. Takes the line number of the line in the file that needs to be read
        int n = lineNum; // The line number
        String line;
        try (Stream<String> lines = Files.lines(Paths.get("userData"))) {
            line = lines.skip(n).findFirst().get();
            return (line);
        } catch (IOException e) {
            System.out.println(e);
        }
        return (0);


    }


    // read file one line at a time
    // replace line as you read the file and store updated lines in StringBuffer
    // overwrite the file with the new lines
    public static void replaceLines(int lineNum, Object replacementLine) {
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("userData"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            int count = 0;
            while ((line = file.readLine()) != null) {
                if (count == lineNum) {
                    line = replacementLine.toString();
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                } else {
                    line = readFromFile(count).toString(); // Finds the original line in the original file then copies it.
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                count++;
            }
            file.close();

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("userData");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        }

        catch(Exception e){
            System.out.println("Problem reading file.");
        }
    }

    public static void InsertLines(int lineNum, Object replacementLine) { //Inserts the inputted line where another line once was
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("userData"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            String passer = "";
            boolean offset = false;
            int count = 0;
            while ((line = file.readLine()) != null) {
                if (count == lineNum) {
                    passer = line;
                    offset = true;
                    line = replacementLine.toString();
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }else if (count == lineNum+1) {
                    line = passer;
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }else if (offset = true){
                    line = readFromFile(count-1).toString(); // Finds the original line on the original position.
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                } else {
                    line = readFromFile(count).toString(); // Finds the original line in the original file then copies it.
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                count++;
            }
            file.close();

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("userData");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        }

        catch(Exception e){
            System.out.println("Problem reading file.");
        }
    }


    public static void fileSorter(){ //sorts the lines into an array list in order so that the new file can be created.
        try {
            BufferedReader file = new BufferedReader(new FileReader("userData"));
            StringBuffer inputBuffer = new StringBuffer();
            ArrayList passer = new ArrayList();
            String line;
            boolean offset = false;
            int count = 0;
            while ((line = file.readLine()) != null) {

            }
        }catch(Exception e){
                System.out.println("Problem reading file.");
            }

    }

    public static void sortedFile(int lineNum, Object replacementLine) { //Creates a new file and then copies lines from the original file into this new file in the sorted order
        //Needs the list to be sorted
        try {
            // Creates the new file

            //Places the sorted records into the new file.
            BufferedReader file = new BufferedReader(new FileReader("userData"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            String passer = "";
            boolean offset = false;
            int count = 0;
            while ((line = file.readLine()) != null) {
                if (count == lineNum) {
                    passer = line;
                    offset = true;
                    line = replacementLine.toString();
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }else if (count == lineNum+1) {
                    line = passer;
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }else if (offset = true){
                    line = readFromFile(count-1).toString(); // Finds the original line on the original position.
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                } else {
                    line = readFromFile(count).toString(); // Finds the original line in the original file then copies it.
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                count++;
            }
            file.close();

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("userData");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        }

        catch(Exception e){
            System.out.println("Problem reading file.");
        }
    }


    public static void replaceLines(int lineNum, ArrayList<String> replacementLine) {
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("userData"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            int count = 0;

            while ((line = file.readLine()) != null) {
                if (count == lineNum) {
                    line = replacementLine.toString();
                    line = line.replace("[",""); //removes the two brackets so it's the same as the rest of the records
                    line = line.replace("]",",");//replaces the last one with a comma
                    inputBuffer.append(line);
                    inputBuffer.append('\n');

                } else {
                    line = readFromFile(count).toString(); // Finds the original line in the original file then copies it.
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                count++;
            }
            file.close();

            //writes the new string with the replaced line over the same file
            FileOutputStream fileOut = new FileOutputStream("userData");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        }

        catch(Exception e){
            System.out.println("Problem reading file.");
        }
    }

    public static void replaceLinesWithConstructor(int lineNum, ArrayList<String> replacementLine) {
        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("userData"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            int count = 0;

            while ((line = file.readLine()) != null) {
                if (count == lineNum) {
                    line = replacementLine.toString();
                    line = line.replace("[",""); //removes the two brackets so it's the same as the rest of the records
                    line = line.replace("]",",");//replaces the last one with a comma
                    inputBuffer.append(line);
                    inputBuffer.append('\n');

                } else {
                    line = readFromFile(count).toString(); // Finds the original line in the original file then copies it.
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                count++;
            }
            file.close();

            //writes the new string with the replaced line over the same file
            FileOutputStream fileOut = new FileOutputStream("userData");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        }

        catch(Exception e){
            System.out.println("Problem reading file.");
        }
    }

    public static boolean findInFile(ArrayList<String> searchedItem){
        try {
            FileReader fr = new FileReader("userData");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) { //Passes through every line in the file, and when it is found it returns the index where it was found
                line = br.readLine();
                if(line == null) { //avoids an error where the line being null clashes with the rest of the code
                } else {
                    String[] parts = line.split(", ");
                    if ((searchedItem.get(0)).equals(parts[0]) && (searchedItem.get(1)).equals(parts[1]) && (searchedItem.get(2)).equals(parts[2])) { //checks to see if the dates line up with the searched dates, meaning the dates act as an identifier
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int findLineNum(ArrayList<String> searchedItem) { //Variaton of FindInFile but returns the line number instead.
        try {
            FileReader fr = new FileReader("userData");
            BufferedReader br = new BufferedReader(fr);
            int count = 0;
            String line = br.readLine();
            while (line != null) { //Passes through every line in the file, and when it is found it returns the index where it was found
                line = br.readLine();
                if(line == null) { //avoids an error where the line being null clashes with the rest of the code
                } else {
                    String[] parts = line.split(", ");
                    if ((searchedItem.get(0)).equals(parts[0]) && (searchedItem.get(1)).equals(parts[1]) && (searchedItem.get(2)).equals(parts[2])) { //checks to see if the dates line up with the searched dates, meaning the dates act as an identifier
                        return count;
                    }
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Object returnFromFile (ArrayList<String> searchedItem, int index){
        try {
            FileReader fr = new FileReader("userData");
            BufferedReader br = new BufferedReader(fr);
            int count = 0;
            boolean found = false;
            String returnData = "";
            String line = br.readLine();
            while (line != null) { //Passes through every line in the file, and when it is found it returns the index where it was found
                line = br.readLine();
                if(line == null) { //avoids an error where the line being null clashes with the rest of the code
                } else {
                    String[] parts = line.split(", ");
                    if ((searchedItem.get(0)).equals(parts[0]) && (searchedItem.get(1)).equals(parts[1]) && (searchedItem.get(2)).equals(parts[2])) { //checks to see if the dates line up with the searched dates, meaning the dates act as an identifier
                        found = true;
                        int foundAtIndex = count;
                        returnData = parts[index];
                    }
                }
                count++;
            }
            if (found == true){
                return(returnData);
            }else{
                return(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return(null);
    }
}
