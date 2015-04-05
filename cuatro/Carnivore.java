public class Carnivore extends Organism
{
    private int energy;
    private int x_cord;
    private int y_cord;

    public Carnivore()
    {
        this.x_cord = get_rand();
        this.y_cord = get_rand();
    }

    //get coordinates for an object
    public int getX()
    {
        return x_cord;
    }

    public int getY()
    {
        return y_cord;
    }

    public char getSymbol()
    {
        return 'C';
    }

    //movement should be randomized
    //create a radius
    public void move(char[][] matrix)
    {
        //clear current space
        matrix[this.x_cord][this.y_cord] = '.';

        //reposition symbol
        this.y_cord = this.y_cord + 1;
        matrix[this.x_cord][this.y_cord] = getSymbol();
    }

    //find location on a 3x3 grid and then move from there
    public int getLocation()
    {
        //works for the most part
        //sometimes the program doesn't run for some weird reason I can't figure out

        //starts at 0, then narrows down
        int location = 0;

        //start at the edges
        //if an extreme case, will fall unedr other if statements

        //positions
        // | 1 || 2 || 3 |
        // | 8 || 0 || 4 |
        // | 7 || 6 || 5 |

        //returns 0, if nothing hits, it can move anywhere

        //left side
        if(this.y_cord == 0)
        {
            location = 8;
        }

        //right side
        if(this.y_cord == 15)
        {
            location = 4;
        }

        //top edge, x = 0
        if(this.x_cord == 0)
        {
            location = 2;

            //check for two corner cases
            //top left corner
            if(this.y_cord == 0)
            {
                location = 1;
            }

            //top right
            if(this.y_cord == 15)
            {
                location = 3;
            }
        }

        //bottom, x = 15
        if(this.x_cord == 15)
        {
            location = 6;

            //check for lower corner cases
            //bottom left corner
            if(this.y_cord == 0)
            {
                location = 7;
            }

            //bottom right corner
            if(this.y_cord == 15)
            {
                location = 5;
            }
        }

        return location;

    }

}
