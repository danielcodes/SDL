public class environment
{
    public static void main (String[] args)
    {

        Herbivore rabbit = new Herbivore();
        //Carnivore lion = new Carnivore();

        //uninitialized chars are NULL
        char[][] field = new char[16][16];

        //filling the field
        for(int i=0; i<16; i++)
        {
            for(int j=0; j<16; j++)
            {
                field[i][j] = '.'; //dots are grass
            }
        }


        //getCarnivore(field, 10);
        Carnivore[] c_array = new Carnivore[20];
        getCarnivore(field, c_array);



        System.out.println();

        // Herbivore[] h_array = new Herbivore[6];
        //
        // for(int j=0; j<h_array.length; j++)
        // {
        //     h_array[j] = new Herbivore();
        //     int x_cord = h_array[j].getX();
        //     int y_cord = h_array[j].getY();
        //
        //     //while loop, to prevent overlapping
        //     while(field[x_cord][y_cord] != '.')
        //     {
        //         x_cord = h_array[j].getX();
        //         y_cord = h_array[j].getY();
        //
        //     }
        //
        //     //place only empty place
        //     field[x_cord][y_cord] = h_array[j].getSymbol();
        // }




        //print the field to see result again
        for(int i=0; i<16; i++)
        {
            for(int j=0; j<16; j++)
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //test movement here

        // for(int i=0; i<c_array.length; i++)
        // {
        //     System.out.println(i + " Located at " + c_array[i].getX() +  " " + c_array[i].getY() + " " + c_array[i].getLocation());
        // }


        //print the field to see result again
        // for(int i=0; i<16; i++)
        // {
        //     for(int j=0; j<16; j++)
        //     {
        //         System.out.print(field[i][j] + " ");
        //     }
        //     System.out.println();
        // }


    }


    //methods

    public static void getCarnivore(char[][] matrix, Carnivore[] carnivores)
    {

        int x_cord;
        int y_cord;

        for(int i=0; i<carnivores.length; i++)
        {
            carnivores[i] = new Carnivore();
            x_cord = carnivores[i].getX();
            y_cord = carnivores[i].getY();

            //while loop, to prevent overlapping
            while(matrix[x_cord][y_cord] != '.')
            {
                x_cord = carnivores[i].getX();
                y_cord = carnivores[i].getY();
            }

            //place only empty place
            matrix[x_cord][y_cord] = carnivores[i].getSymbol();
        }

    }



}
