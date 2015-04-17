import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class JavaGUI extends JFrame
{
    public JavaGUI()
    {
        initComponents();
    }

    private void initComponents()
    {
        //place button in container?
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3,2,10,10));
        setSize(400, 300);

        //otherwise program still runs in the background
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        final JTextField num1 = new JTextField();
        final JTextField num2 = new JTextField();

        JButton addbutton = new JButton("+");
        JButton subbutton = new JButton("-");
        JButton mulbutton = new JButton("*");
        JButton divbutton = new JButton("/");


        //sub button is on top of ok button
        contentPane.add(addbutton);
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                double number1 = Double.parseDouble(num1.getText());
                double number2 = Double.parseDouble(num2.getText());
                JOptionPane.showMessageDialog(null, "The result of adittion is : " + (number1 + number2));

            }
        });



        contentPane.add(subbutton);
        subbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                double number1 = Double.parseDouble(num1.getText());
                double number2 = Double.parseDouble(num2.getText());
                JOptionPane.showMessageDialog(null, "The result of subtraction is : " + (number1 - number2));

            }
        });





        contentPane.add(num1);
        contentPane.add(num2);


        setVisible(true);

    }

    public static void main(String[] args)
    {
        JavaGUI sampleGUI = new JavaGUI();

    }

}
