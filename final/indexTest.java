import javax.swing.JFrame;

public class indexTest
{
    public static void main(String[] args)
    {
        Index index = new Index();
        index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        index.setSize(300, 150);
        index.setVisible(true);

        //must compile a form too, so that button in the form work as well
        Form form = new Form();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setVisible(false);
    }
}
