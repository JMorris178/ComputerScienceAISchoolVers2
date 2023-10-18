import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class BudgetDiaryGUI extends JPanel implements ActionListener {
    private JFrame frame;

    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button10;
    JButton button11;
    JButton button12;


    Calendar calendar = Calendar.getInstance();
    ArrayList<Integer> date = new ArrayList<>();


    public BudgetDiaryGUI(int width, int height) {
        frame = new JFrame("Budget Diary");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);

        boolean firstTime = true;
        if (firstTime){ //creates the calendar ONLY for the first time
            date.add(calendar.get(Calendar.DAY_OF_MONTH));
            date.add(calendar.get(Calendar.MONTH)+1);
            date.add(calendar.get(Calendar.YEAR));
            firstTime = false;
        }




        button3 = new JButton("<----"); //One more dash in order to differentiate it from the other two
        button3.setBounds(75, 300, 75, 40);
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("---->");
        button4.setBounds(300, 300, 75, 40);
        button4.addActionListener(this);
        add(button4);



        button6 = new JButton(getMonth(date));
        button6.setBounds(150, 300, 150, 40);
        button6.addActionListener(this);
        add(button6);

        date.add(calendar.get(Calendar.DAY_OF_MONTH));
        date.add(calendar.get(Calendar.MONTH));
        date.add(calendar.get(Calendar.YEAR));

        button7 = new JButton("Miles travelled");
        button7.setBounds(400, 50, 150, 40);
        button7.addActionListener(this);
        add(button7);

        button8 = new JButton("Cost");
        button8.setBounds(600, 50, 150, 40);
        button8.addActionListener(this);
        add(button8);


        button10 = new JButton(Logic.budgetingSheetLogic(3, date.get(0),date.get(1),date.get(2))); //miles travelled month
        button10.setBounds(400, 300, 150, 40);
        button10.addActionListener(this);
        add(button10);


        button12 = new JButton(Logic.budgetingSheetLogic(2, date.get(0),date.get(1),date.get(2))); //Cost Month
        button12.setBounds(600, 300, 150, 40);
        button12.addActionListener(this);
        add(button12);

    }

    public void actionPerformed(ActionEvent e) {


        int day = date.get(0);
        int month = date.get(1);
        int year = date.get(2);

        if (e.getActionCommand().equals("<---")) {
            changeWeekBack(day, month, year);
        }
        if (e.getActionCommand().equals("--->")) {
            changeWeekAhead(day, month, year);
        }
        if (e.getActionCommand().equals("<----")) { //If the
            changeMonthBack(day, month, year);
        }
        if (e.getActionCommand().equals("---->")) { //If the
            changeMonthAhead(day, month, year);
        }

        calendar.set(date.get(2), date.get(1), date.get(0)); //updates the calendar
        button6.setText(getMonth(date));
        button12.setText(Logic.budgetingSheetLogic(2, date.get(0),date.get(1),date.get(2)));
        button10.setText(Logic.budgetingSheetLogic(3, date.get(0),date.get(1),date.get(2)));
    }


    public void changeMonthAhead(int day, int month, int year) { //changes the month by 1
        month = month + 1;
        if (month >= 12) { //if the month is past december, sets the year to the next, and then month to January
            year = year + 1;
            month = 0;
        }
        if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {//checks the month and then depending on the current month it will seperate this based on the number of days in the month. This line is for all the months with 31 days
            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);

        } else if (month == 3 || month == 5 || month == 8 || month == 10) { //30 days

            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);
        } else if (month == 1 && (year % 4) == 0) { //checks to see if the year is a leap year and the month is Febuary to check if it needs 28 or 29 days. Done before the regular febuary check on purpose

            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);
        } else if (month == 1) {//28 days for a normal Febuary

            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);
        }


    }

    public void changeMonthBack(int day, int month, int year) { //changes the month by 1
        month = month - 1;
        if (month <= 0) { //if the month is past december, sets the year to the next, and then month to January
            year = year - 1;
            month = 12;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {//checks the month and then depending on the current month it will seperate this based on the number of days in the month. This line is for all the months with 31 days
            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);

        } else if (month == 4 || month == 6 || month == 9 || month == 11) { //30 days

            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);
        } else if (month == 2 && (year % 4) == 0) { //checks to see if the year is a leap year and the month is Febuary to check if it needs 28 or 29 days. Done before the regular febuary check on purpose

            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);
        } else if (month == 2) {//28 days for a normal Febuary

            date.set(0, day); //changes the day value to the new updated one
            date.set(1, month);
            date.set(2, year);
        }



    }

    public void changeWeekAhead(int day, int month, int year) { //changes the month by 1
        day = day + 7;
        int remainder;
        if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {//checks the month and then depending on the current month it will seperate this based on the number of days in the month. This line is for all the months with 31 days
            if (day > 31) {
                remainder = day-31;
                month = month + 1;
                day = remainder;
            }
        } else if (month == 3 || month == 5 || month == 8 || month == 10) { //30 days
            if (day > 30) {
                remainder = day-31;
                month = month + 1;
                day = remainder;
            }
        } else if (month == 1 && (year % 4) == 0) { //checks to see if the year is a leap year and the month is Febuary to check if it needs 28 or 29 days. Done before the regular febuary check on purpose
            if (day > 29) {
                remainder = day-31;
                month = month + 1;
                day = remainder;
            }
        } else if (month == 1) {//28 days for a normal Febuary

            if (day > 1) {
                remainder = day-31;
                month = month + 1;
                day = remainder;
            }
        }

        if (month > 12) { //if the month is past december, sets the year to the next, and then month to January
            year = year + 1;
            month = 1;
        }
        date.set(0,day);
        date.set(1,month);
        date.set(2,year);


    }

    public void changeWeekBack(int day, int month, int year) { //changes the month by 1
        day = day - 7;
        if (day < 1) {
            month = month - 1;
            int remainder = day+7;
            if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {//checks the month and then depending on the current month it will seperate this based on the number of days in the month. This line is for all the months with 31 days
                day = 31 - remainder;
            } else if (month == 3 || month == 5 || month == 8 || month == 10) { //30 days
                day = 30 - remainder;
            } else if (month == 1 && (year % 4) == 0) { //checks to see if the year is a leap year and the month is Febuary to check if it needs 28 or 29 days. Done before the regular febuary check on purpose
                day = 29 - remainder;
            } else if (month == 1) {//28 days for a normal Febuary
                day = 28 - remainder;
            }
        }

        if (month <= 0) { //if the month is past december, sets the year to the next, and then month to January
            year = year - 1;
            month = 12;
        }
        date.set(0,day);
        date.set(1,month);
        date.set(2,year);

    }

    public String getMonth(ArrayList<Integer> date) {
        if (date.get(1) == 1) {
            return ("January " + date.get(2));
        } else if (date.get(1) == 2) {
            return ("February " + date.get(2));
        } else if (date.get(1) == 3) {
            return ("March " + date.get(2));
        } else if (date.get(1) == 4) {
            return ("April " + date.get(2));
        } else if (date.get(1) == 5) {
            return ("May "+ date.get(2));
        } else if (date.get(1) == 6) {
            return ("June "+ date.get(2));
        } else if (date.get(1)== 7) {
            return ("July "+ date.get(2));
        } else if (date.get(1)== 8) {
            return ("August "+ date.get(2));
        } else if (date.get(1) == 9) {
            return ("September "+ date.get(2));
        } else if (date.get(1) == 10) {
            return ("October "+ date.get(2));
        } else if (date.get(1) == 11) {
            return ("November "+ date.get(2));
        } else if (date.get(1) == 0) {
            return ("December " + (date.get(2)-1));
        }  else if (date.get(1) == 12) {
            return ("December " + (date.get(2)));
        }
        return (null);
    }

    public String getWeek(Calendar calendar) {
        int dayOfTheWeek = calendar.get(calendar.DAY_OF_WEEK);
        //Sets the day of the week back to the start onc the week that the user wants to see has been found. This will be useful when the GUI is made too
        if (dayOfTheWeek == 6) { //Saturday
            calendar.add(Calendar.DATE, -6);//sets it back to Sunday
            return ("Week starting " + calendar.get(calendar.DATE));
        } else if (dayOfTheWeek == 5) { //Friday
            calendar.add(Calendar.DATE, -5);//sets it back to Sunday
            return ("Week starting " + calendar.get(calendar.DATE));
        } else if (dayOfTheWeek == 4) { //Thursday
            calendar.add(Calendar.DATE, -4);//sets it back to Sunday
            return ("Week starting " + calendar.get(calendar.DATE));
        } else if (dayOfTheWeek == 3) { //Wednesday
            calendar.add(Calendar.DATE, -3);//sets it back to Sunday
            return ("Week starting " + calendar.get(calendar.DATE));
        } else if (dayOfTheWeek == 2) { //Tuesday
            calendar.add(Calendar.DATE, -2);//sets it back to Sunday
            return ("Week starting " + calendar.get(calendar.DATE));
        } else if (dayOfTheWeek == 1) { //Monday
            calendar.add(Calendar.DATE, -1);//sets it back to Sunday
            return ("Week starting " + calendar.get(calendar.DATE));
        } else if (dayOfTheWeek == 0) { //Sunday
            return ("Week starting " + calendar.get(calendar.DATE));
        }
    return null;
    }


}


