import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Database	extends 	JFrame
 {
	// Instance attributes used in this example
	private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;

  //added
  // Create columns names
  private String columnNames[] = { "First name", "Last name", "Occupation", "Dept./Major", "Age" };

  // Create some data
  private String dataValues[][]	= new String[15][5];

  private static int counter = 0;

	// Constructor of main frame
	public Database()
	{
		// Set the frame characteristics
		setTitle( "DATABASE" );
		setSize( 500, 200 );
		setBackground( Color.gray );

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );


		// Create a new table instance
		table = new JTable( dataValues, columnNames );

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		topPanel.add( scrollPane, BorderLayout.CENTER );
	}

  public void addToDatabase(String first, String last, String job, String major, String age)
  {
      dataValues[counter][0] = first;
      dataValues[counter][1] = last;
      dataValues[counter][2] = job;
      dataValues[counter][3] = major;
      dataValues[counter][4] = age;

      //increase counter
      counter = counter + 1;

  }

}
