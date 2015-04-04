public class environment
{
    public static void main (String[] args)
    {

        Herbivore rabbit = new Herbivore();
        //Carnivore lion = new Carnivore();

        //uninitialized chars are NULL
        char[][] field = new char[5][5];

        //filling the field
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                field[i][j] = '.'; //dots are grass
            }
        }

        //change the field
        //field[0][0] = lion.getSymbol();

        //array of carnivores
        Carnivore[] c_array = new Carnivore[6];

        for(int i=0; i<c_array.length; i++)
        {
            c_array[i] = new Carnivore();
            int x_cord = c_array[i].getX();
            int y_cord = c_array[i].getY();
            field[x_cord][y_cord] = c_array[i].getSymbol();
        }




        //print the field to see result again
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static int rand_place()
    {
        return ((int)(Math.random() * 5));

    }
}
