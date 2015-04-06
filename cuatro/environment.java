public class environment
{
    public static void main (String[] args)
    {
        System.out.println();

        //uninitialized chars are 0
        char[][] field = new char[16][16];

        //filling the field
        for(int i=0; i<16; i++)
        {
            for(int j=0; j<16; j++)
            {
                field[i][j] = '.'; //dots are grass
            }
        }


        Carnivore[] c_array = new Carnivore[10];
        getCarnivore(field, c_array);

        Herbivore[] h_array = new Herbivore[10];
        getHerbivore(field, h_array);



        //print the field to see result
        for(int i=0; i<16; i++)
        {
            for(int j=0; j<16; j++)
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //movement here
        for(int i=0; i<c_array.length; i++)
        {
            c_array[i].move(field);
        }


        //print the field to see result again
        for(int i=0; i<16; i++)
        {
            for(int j=0; j<16; j++)
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }


    //methods
    //place carnivores in the matrix
    public static void getCarnivore(char[][] matrix, Carnivore[] carnivores)
    {

        int x_cord, y_cord;

        for(int i=0; i<carnivores.length; i++)
        {
            carnivores[i] = new Carnivore();
            x_cord = carnivores[i].getX();
            y_cord = carnivores[i].getY();

            //while loop, to prevent overlapping
            while(matrix[x_cord][y_cord] != '.')
            {
                x_cord = carnivores[i].changeX();
                y_cord = carnivores[i].changeY();
            }

            //place only empty place
            matrix[x_cord][y_cord] = carnivores[i].getSymbol();
        }

    }

    public static void getHerbivore(char[][] matrix, Herbivore[] herbivore)
    {
        int x_cord, y_cord;

        for(int j=0; j<herbivore.length; j++)
        {
            herbivore[j] = new Herbivore();
            x_cord = herbivore[j].getX();
            y_cord = herbivore[j].getY();

            //while loop, to prevent overlapping
            while(matrix[x_cord][y_cord] != '.')
            {
                x_cord = herbivore[j].changeX();
                y_cord = herbivore[j].changeY();

            }

            //place only empty place
            matrix[x_cord][y_cord] = herbivore[j].getSymbol();
        }

    }



}
