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

    Calendar calendar =  Calendar.getInstance();
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

        frame.setLayout(new GridLayout(5,7,25,25));
        calendar.getTime();

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
        frame.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        // respond to button clicks
        System.out.println(e.getActionCommand() + "button was clicked");
        ArrayList<String> passer = new ArrayList();

        if (e.getActionCommand().equals("3")) { //If the
            passer.add("3");
            passer.add("4");
            passer.add("2023");
            JOptionPane.showMessageDialog(null, FileUtilisation.returnFromFile(passer,3));



        }
    }
    }
