//Simple Information Management System for CCNY

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame
{
    private final GridBagLayout layout;
    private final GridBagConstraints constraints;


    public Index()
    {
        super("Main Page");
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);


        //create components for main page
        //need for three components, title and two buttons
        JLabel title = new JLabel("Management Information System for CCNY");
        addComponent(title, 1, 1, 5, 1);

        JButton addToDB = new JButton("Add to Database");
        addComponent(addToDB, 2, 2, 1, 5);

        JButton seeDB = new JButton("See Database");
        addComponent(seeDB, 3, 3, 1, 5);


    }

    //method to set constraints
    //5 parameters, comp, row, col, width, height
    private void addComponent(Component component,
      int row, int column, int width, int height)
    {
        constraints.gridx = row;
        constraints.gridy = column;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints); //setting them
        add(component);
    }
}
