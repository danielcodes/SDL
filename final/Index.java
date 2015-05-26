//Simple Information Management System for CCNY

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame
{
    private GridBagLayout layout;
    private GridBagConstraints constraints;


    public Index()
    {
        super("Main Page");
        initMain();

    }

    //a different method to initiate the main components (2)
    private void initMain()
    {
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);


        //create components for main page
        //need for three components, title and two buttons
        JLabel title = new JLabel("Management Information System for CCNY");
        addComponent(title, 1, 1, 5, 1);

        JButton addToDB = new JButton("Add to Database");
        //button functionality here
        addToDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Form form = new Form();
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setVisible(true);
                setVisible(false);
            }
        });
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
