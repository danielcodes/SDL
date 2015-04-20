import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//change the name afte finished
public class cal extends JFrame implements ActionListener
{

    //Goal, a 5x5 gridded calculator
    // DISPLAY
    // | 7 | 8 | 9 | | / | MC |
    // | 4 | 5 | 6 | | x | MR |
    // | 1 | 2 | 3 | | - | M+ |
    // | 0 | . | = | | + | M- |

    //5 rows
    JPanel[] row = new JPanel[6];

    //buttons
    JButton[] button = new JButton[21];

    //button labels
    String[] buttonLabel = {"7", "8", "9", "/", "MC",
                             "4", "5", "6", "x", "MR",
                             "1", "2", "3", "-", "M+",
                             ".", "0", "=", "+", "M-",
                             "CLEAR"};

    //size of buttons, only two regular and display
    int[] width = {250, 50};
    int[] height = {35, 40};

    Dimension displayDim = new Dimension(width[0], height[0]);
    Dimension regularDim = new Dimension(width[1], height[1]);

    //for operations, +, -, x, /
    boolean[] operation = new boolean[4];

    //for results
    double[] temp = {0, 0};

    //display, parameters?
    JTextArea display = new JTextArea(1,20);

    //parameters?
    Font font = new Font("Times new Roman", Font.BOLD, 14);

    //constructor
    cal()
    {
        super("Calculator");
        setDesign();
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(6,5);
        setLayout(grid);

        //init operations
        for(int i=0; i<4; i++)
        {
            operation[i] = false;
        }

        //flow layout to place components in the grid
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);

        //fill row array and fill it with the created layouts
        for(int i = 0; i < 6; i++)
        {
            row[i] = new JPanel();
        }

        //first
        row[0].setLayout(f1);
        //subsequent rows
        for(int i = 1; i < 6; i++)
        {
            row[i].setLayout(f2);
        }

        //init buttons
        for(int i = 0; i < 21; i++)
        {
            button[i] = new JButton();
            button[i].setText(buttonLabel[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }

        //init display
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDim);

        //set button dimension
        for(int i=0; i<20; i++)
        {
            button[i].setPreferredSize(regularDim);
        }

        //panel.add(component)
        row[0].add(display);
        add(row[0]);

        //buttons, 4 rows of 5
        for(int i = 0; i < 5; i++)
            row[1].add(button[i]);
        add(row[1]);

        for(int i = 5; i < 10; i++)
            row[2].add(button[i]);
        add(row[2]);

        for(int i = 10; i < 15; i++)
            row[3].add(button[i]);
        add(row[3]);

        for(int i = 15; i < 20; i++)
            row[4].add(button[i]);
        add(row[4]);

        //adding in the clear button
        button[20].setPreferredSize(displayDim);
        row[5].add(button[20]);
        add(row[5]);

        setVisible(true);
    }

    //clears display
    public void clear() {
        try
        {
            display.setText("");
            for(int i = 0; i < 4; i++)
                operation[i] = false;
            for(int i = 0; i < 2; i++)
                temp[i] = 0;
        } catch (NullPointerException e) {}
    }

    public void getResult()
    {
        double result = 0; //result
        temp[1] = Double.parseDouble(display.getText()); //second operand

        try
        {
            if(operation[2] == true)  //multiplication
                result = temp[0] * temp[1];
            else if(operation[3] == true)  //divison
                result = temp[0] / temp[1];
            else if(operation[0] == true) //addition
                result = temp[0] + temp[1];
            else if(operation[1] == true) //subtraction
                result = temp[0] - temp[1];
            display.setText(Double.toString(result)); //display now has result
            for(int i = 0; i < 4; i++)
                operation[i] = false; //set all the functions back to false
        } catch(NumberFormatException e) {}
    }



    public final void setDesign()
    {
        try
        {
            UIManager.setLookAndFeel(
              "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e) {}
    }

    public void actionPerformed(ActionEvent event)
    {
        //adding functionality to the buttons in order
        //****************REPEATED CODE*********************
        if(event.getSource() == button[0])
            display.append("7");
        if(event.getSource() == button[1])
            display.append("8");
        if(event.getSource() == button[2])
            display.append("9");
        if(event.getSource() == button[3])
        {
            //division
            temp[0] = Double.parseDouble(display.getText());
            operation[3] = true;
            display.setText("");
        }
        //**************************************************

        //****************REPEATED CODE*********************
        if(event.getSource() == button[5])
            display.append("4");
        if(event.getSource() == button[6])
            display.append("5");
        if(event.getSource() == button[7])
            display.append("6");
        if(event.getSource() == button[8])
        {
            //multiplication
            temp[0] = Double.parseDouble(display.getText());
            operation[2] = true;
            display.setText("");
        }
        //**************************************************

        //****************REPEATED CODE*********************
        if(event.getSource() == button[10])
            display.append("1");
        if(event.getSource() == button[11])
            display.append("2");
        if(event.getSource() == button[12])
            display.append("3");
        if(event.getSource() == button[13])
        {
            //subtraction
            temp[0] = Double.parseDouble(display.getText());
            operation[1] = true;
            display.setText("");
        }
        //**************************************************

        //****************REPEATED CODE*********************
        if(event.getSource() == button[15])
            display.append(".");
        if(event.getSource() == button[16])
            display.append("0");
        if(event.getSource() == button[18])
        {
            //addition
            temp[0] = Double.parseDouble(display.getText());
            operation[0] = true;
            display.setText("");
        }
        //**************************************************

        //= button
        if(event.getSource() == button[17])
            getResult();
        //clear
        if(event.getSource() == button[20])
            clear();
    }


    public static void main (String[] args)
    {
        cal c = new cal();
    }
}
