public class environment
{
    public static void main (String[] args)
    {
        System.out.println();

        //uninitialized chars are 0
        char[][] field = new char[32][32];

        //filling the field
        for(int i=0; i<32; i++)
        {
            for(int j=0; j<32; j++)
            {
                field[i][j] = '.'; //dots are grass
            }
        }

        //create objects and place them in the grid
        Carnivore[] c_array = new Carnivore[100];
        getCarnivore(field, c_array);

        Herbivore[] h_array = new Herbivore[100];
        getHerbivore(field, h_array);

        Plant[] p_array = new Plant[100];
        getPlant(field, p_array);

        //print the field to see result
        //this is after C's, H's and P's have been placed in the 2D field
        System.out.println("SPAWN ALL THE OBJECTS: ");
        for(int i=0; i<32; i++)
        {
            for(int j=0; j<32; j++)
            {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();


        //iterate here
        for(int k=1; k<=30; k++)
        {
            System.out.println("Iteration #" + k);
            //movement here
            for(int a=0; a<c_array.length; a++)
            {
                c_array[a].move(field);
            }

            for(int b=0; b<h_array.length; b++)
            {
                h_array[b].move(field);
            }

            //print the field to see result again
            for(int i=0; i<32; i++)
            {
                for(int j=0; j<32; j++)
                {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    //*********************** METHODS *********************************

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

    public static void getPlant(char[][] matrix, Plant[] plant)
    {
        int x_cord, y_cord;

        for(int j=0; j<plant.length; j++)
        {
            plant[j] = new Plant();
            x_cord = plant[j].getX();
            y_cord = plant[j].getY();

            //while loop, to prevent overlapping
            while(matrix[x_cord][y_cord] != '.')
            {
                x_cord = plant[j].changeX();
                y_cord = plant[j].changeY();

            }

            //place only empty place
            matrix[x_cord][y_cord] = plant[j].getSymbol();
        }
    }

}
