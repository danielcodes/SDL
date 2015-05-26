import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame
{

    public Form()
    {
        super("Form");
        initComponents();
    }

    private void initComponents()
    {

        JPanel contentPane = new JPanel();
        GridBagLayout layout = new GridBagLayout();

        contentPane.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

		//DON'T KNOW WHAT THIS DOES
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(1,2,1,2);

		//FIRST NAME
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        JLabel firstNameL = new JLabel("First name:");
        layout.setConstraints(firstNameL, constraints);
        contentPane.add(firstNameL);

		//TEXT FIELD
        constraints.gridx = 6;
        constraints.gridy = 1;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;
        final JTextField firstNameT = new JTextField(10);
        layout.setConstraints(firstNameT, constraints);
        contentPane.add(firstNameT);

		//LAST NAME
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        JLabel lastNameL = new JLabel("Last name:");
        layout.setConstraints(lastNameL, constraints);
        contentPane.add(lastNameL);

		//TEXT FIELD
        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;
        final JTextField lastNameT = new JTextField();
        layout.setConstraints(lastNameT, constraints);
        contentPane.add(lastNameT);

		//JOB
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        JLabel jobL = new JLabel("Occupation: ");
        layout.setConstraints(jobL, constraints);
        contentPane.add(jobL);

		//TEXT FIELD
        constraints.gridx = 6;
        constraints.gridy = 3;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;
        final JTextField jobT = new JTextField();
        layout.setConstraints(jobT, constraints);
        contentPane.add(jobT);

    //Department or major
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        JLabel majorL = new JLabel("Dept./Major: ");
        layout.setConstraints(majorL, constraints);
        contentPane.add(majorL);

		//TEXT FIELD
        constraints.gridx = 6;
        constraints.gridy = 4;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;
        final JTextField majorT = new JTextField();
        layout.setConstraints(majorT, constraints);
        contentPane.add(majorT);

    //Age
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        JLabel ageL = new JLabel("Age: ");
        layout.setConstraints(ageL, constraints);
        contentPane.add(ageL);

		//TEXT FIELD
        constraints.gridx = 6;
        constraints.gridy = 5;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;
        final JTextField ageT = new JTextField();
        layout.setConstraints(ageT, constraints);
        contentPane.add(ageT);


    //********************** BUTTONS BEGIN

		//DON'T KNOW WHAT THIS DOES
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(30,0,0,0);

        constraints.gridx = 1;
        constraints.gridy = 10;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;

        JButton backB = new JButton("Back");
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Index index = new Index();
                index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                index.setSize(300, 150);
                index.setVisible(true);
                setVisible(false);
            }
        });
        layout.setConstraints(backB, constraints);
        contentPane.add(backB);

		//SET UP FOR INSERT BUTTON
        constraints.gridx = 7;
        constraints.gridy = 10;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;

        JButton insertB = new JButton("Insert");
        insertB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BOStudent std = new BOStudent(firstNameT.getText(),
                        lastNameT.getText());
                        std.write();
            }
        });
        layout.setConstraints(insertB, constraints);
        contentPane.add(insertB);


		////DON'T KNOW WHAT THIS DOES
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPane);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();

    }


}
