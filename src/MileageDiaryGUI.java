import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class MileageDiaryGUI extends JPanel implements ActionListener {
    ArrayList<JButton> buttons = new ArrayList<>();
    //Creates buttons for the max amount of dates possible in a month
    JButton button1;
    JButton button2;
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
    JButton button13;
    JButton button14;
    JButton button15;
    JButton button16;
    JButton button17;
    JButton button18;
    JButton button19;
    JButton button20;
    JButton button21;
    JButton button22;
    JButton button23;
    JButton button24;
    JButton button25;
    JButton button26;
    JButton button27;
    JButton button28;
    JButton button29;
    JButton button30;
    JButton button31;
    JButton button32;
    JButton button33;



    private JFrame frame;
    //Check date
    //Create calendar for the month
    //Checks through the file and if a date has data in then number blue
    //If a cell is clicked then display data for that day
    //If the arrow at the top is clicked, then repeat this
    //Have a searchbar at the top that lets a user search a date, and then display that month


    public MileageDiaryGUI(int width, int height) {
        frame = new JFrame("Mileage Diary");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(width, height);
        frame.getContentPane().add(this);

        frame.setLayout(new GridLayout(5, 7, 25, 25));
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get((calendar.MONTH));
        month = month+1;
        int year = calendar.get(calendar.YEAR);


        button1 = new JButton("1");
        button1.addActionListener(this);
        button2 = new JButton("2");
        button2.addActionListener(this);
        button3 = new JButton("3");
        button3.addActionListener(this);
        button4 = new JButton("4");
        button4.addActionListener(this);
        button5 = new JButton("5");
        button5.addActionListener(this);
        button6 = new JButton("6");
        button6.addActionListener(this);
        button7 = new JButton("7");
        button7.addActionListener(this);
        button8 = new JButton("8");
        button8.addActionListener(this);
        button9 = new JButton("9");
        button9.addActionListener(this);
        button10 = new JButton("10");
        button10.addActionListener(this);
        button11 = new JButton("11");
        button11.addActionListener(this);
        button12 = new JButton("12");
        button12.addActionListener(this);
        button13 = new JButton("13");
        button13.addActionListener(this);
        button14 = new JButton("14");
        button14.addActionListener(this);
        button15 = new JButton("15");
        button15.addActionListener(this);
        button16 = new JButton("16");
        button16.addActionListener(this);
        button17 = new JButton("17");
        button17.addActionListener(this);
        button18 = new JButton("18");
        button18.addActionListener(this);
        button19 = new JButton("19");
        button19.addActionListener(this);
        button20 = new JButton("20");
        button20.addActionListener(this);
        button21 = new JButton("21");
        button21.addActionListener(this);
        button22 = new JButton("22");
        button22.addActionListener(this);
        button23 = new JButton("23");
        button23.addActionListener(this);
        button24 = new JButton("24");
        button24.addActionListener(this);
        button25 = new JButton("25");
        button25.addActionListener(this);
        button26 = new JButton("26");
        button26.addActionListener(this);
        button27 = new JButton("27");
        button27.addActionListener(this);
        button28 = new JButton("28");
        button28.addActionListener(this);
        button29 = new JButton("29");
        button29.addActionListener(this);
        button30 = new JButton("30");
        button30.addActionListener(this);
        button31 = new JButton("31");
        button31.addActionListener(this);
        //arrows
        button32 = new JButton("<---");
        button32.putClientProperty( "calendar", calendar);
        button32.addActionListener(this);
        button33 = new JButton("--->");
        button33.putClientProperty( "calendar", calendar);
        button33.addActionListener(this);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button10);
        frame.add(button11);
        frame.add(button12);
        frame.add(button13);
        frame.add(button14);
        frame.add(button15);
        frame.add(button16);
        frame.add(button17);
        frame.add(button18);
        frame.add(button19);
        frame.add(button20);
        frame.add(button21);
        frame.add(button22);
        frame.add(button23);
        frame.add(button24);
        frame.add(button25);
        frame.add(button26);
        frame.add(button27);
        frame.add(button28);
        frame.add(button29);
        frame.add(button30);
        frame.add(button31);
        frame.add(button32);
        frame.add(button33);
        frame.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        // respond to button clicks
        System.out.println(e.getActionCommand() + "button was clicked");
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get((calendar.MONTH));
        month = month+1;
        int year = calendar.get(calendar.YEAR);


        if (e.getActionCommand().equals("1")) { //If the
            checkForData(1,month,year);
        }if (e.getActionCommand().equals("2")) { //If the
            checkForData(2,month,year);
        }if (e.getActionCommand().equals("3")) { //If the
            checkForData(3,month,year);
        }if (e.getActionCommand().equals("4")) { //If the
            checkForData(4,month,year);
        }if (e.getActionCommand().equals("5")) { //If the
            checkForData(5,month,year);
        }if (e.getActionCommand().equals("6")) { //If the
            checkForData(6,month,year);
        }if (e.getActionCommand().equals("7")) { //If the
            checkForData(7,month,year);
        }if (e.getActionCommand().equals("8")) { //If the
            checkForData(8,month,year);
        }if (e.getActionCommand().equals("9")) { //If the
            checkForData(9,month,year);
        }if (e.getActionCommand().equals("10")) { //If the
            checkForData(10,month,year);
        }if (e.getActionCommand().equals("11")) { //If the
            checkForData(11,month,year);
        }if (e.getActionCommand().equals("12")) { //If the
            checkForData(12,month,year);
        }if (e.getActionCommand().equals("13")) { //If the
            checkForData(13,month,year);
        }if (e.getActionCommand().equals("14")) { //If the
            checkForData(14,month,year);
        }if (e.getActionCommand().equals("15")) { //If the
            checkForData(15,month,year);
        }if (e.getActionCommand().equals("16")) { //If the
            checkForData(16,month,year);
        }if (e.getActionCommand().equals("17")) { //If the
            checkForData(17,month,year);
        }if (e.getActionCommand().equals("18")) { //If the
            checkForData(18,month,year);
        }if (e.getActionCommand().equals("19")) { //If the
            checkForData(19,month,year);
        }if (e.getActionCommand().equals("20")) { //If the
            checkForData(20,month,year);
        }if (e.getActionCommand().equals("21")) { //If the
            checkForData(21,month,year);
        }if (e.getActionCommand().equals("22")) { //If the
            checkForData(22,month,year);
        }if (e.getActionCommand().equals("23")) { //If the
            checkForData(23,month,year);
        }if (e.getActionCommand().equals("24")) { //If the
            checkForData(24,month,year);
        }if (e.getActionCommand().equals("25")) { //If the
            checkForData(25,month,year);
        }if (e.getActionCommand().equals("26")) { //If the
            checkForData(26,month,year);
        }if (e.getActionCommand().equals("27")) { //If the
            checkForData(27,month,year);
        }if (e.getActionCommand().equals("28")) { //If the
            checkForData(28,month,year);
        }if (e.getActionCommand().equals("29")) { //If the
            checkForData(29,month,year);
        }if (e.getActionCommand().equals("30")) { //If the
            checkForData(30,month,year);
        }if (e.getActionCommand().equals("31")) { //If the
            checkForData(31, month, year);
        }if (e.getActionCommand().equals("<---")) { //If the
            calendar = ((Calendar)((JButton)e.getSource()).getClientProperty( "calendar" ));
            month = calendar.get((calendar.MONTH));
            month = month+1;
            year = calendar.get(calendar.YEAR);
            checkForData(1, month, year);
        }if (e.getActionCommand().equals("--->")) { //If the
            calendar = ((Calendar)((JButton)e.getSource()).getClientProperty( "calendar" ));
            month = calendar.get((calendar.MONTH));
            month = month+1;
            year = calendar.get(calendar.YEAR);
            int day = calendar.get(calendar.DAY_OF_MONTH);
            changeMonthAhead(calendar,day,month,year);
        }
    }

    public void checkForData(int day, int month, int year){
        ArrayList<String> passer = new ArrayList();
        passer.add(String.valueOf(day));
        passer.add(String.valueOf(month));
        passer.add(String.valueOf(year));

        Object output = FileUtilisation.returnFromFile(passer, 3);
        if (output == null) {
            JOptionPane.showMessageDialog(null, "No data for this day");
        } else {
            Object output2 = FileUtilisation.returnFromFile(passer, 4);
            Object output3 = FileUtilisation.returnFromFile(passer, 5);
            JOptionPane.showMessageDialog(null, "Miles travelled : " + output + "   " + "Fuel used : " + output2 + "   " + "Refuel? : " + output3);
        }
    }

    public void changeMonthAhead(Calendar calendar,int day, int month, int year){ //changes the month by 1
        month = month+1;
        if(month>12) { //if the month is past december, sets the year to the next, and then month to January
            year = year + 1;
            month = 1;
        }
        calendar.set(day,month,year); //sets the calendar to the correct month
    }
}
