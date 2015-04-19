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

    //for operations
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

    public final void setDesign() {

        try
        {
            UIManager.setLookAndFeel(
              "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e) {}
    }

    public void actionPerformed(ActionEvent ae) {

    }








    public static void main (String[] args)
    {
        cal c = new cal();
    }
}
