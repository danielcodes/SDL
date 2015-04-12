public class Carnivore extends Organism
{
    private int energy;
    private int x_cord;
    private int y_cord;

    public Carnivore()
    {
        this.x_cord = get_rand();
        this.y_cord = get_rand();
        this.energy = 20;
    }

    //get coordinates for an object
    public int getX()
    {
        return x_cord;
    }

    //new value for x
    public int changeX()
    {
        return this.x_cord = get_rand();
    }

    public int getY()
    {
        return y_cord;
    }

    public int changeY()
    {
        return this.y_cord = get_rand();
    }

    public char getSymbol()
    {
        return 'C';
    }

    //movement should be randomized
    //create a radius
    public void move(char[][] matrix)
    {
        //System.out.println("Element located at " + this.x_cord + " " + this.y_cord);
        //clear current space
        matrix[this.x_cord][this.y_cord] = '.';

        //incr or decr of 1
        int addx = (int)(Math.random()*4 -2 );
        int addy = (int)(Math.random()*4 -2 );

        //can move or stay in the same place
        while( !((this.x_cord+addx > 0 && this.x_cord+addx < 32) && (this.y_cord+addy > 0 && this.y_cord+addy < 32)) )
        {

            addx = (int)(Math.random()*4 -2 );
            addy = (int)(Math.random()*4 -2 );
        }

        this.x_cord = this.x_cord + addx;
        this.y_cord = this.y_cord + addy;

        //now reposition
        matrix[this.x_cord][this.y_cord] = getSymbol();

    }

    public void moveTo (char[][] matrix, int location)
    {
      //also have to clear previous spot
      matrix[this.x_cord][this.y_cord] = '.';

      //number will range from 1 - 8 (possible moves)
      switch (location)
      {
          case 1:
          System.out.println("UNO");
          this.x_cord = this.x_cord - 1;
          this.y_cord = this.y_cord - 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          case 2:
          System.out.println("DOS");
          this.x_cord = this.x_cord - 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          case 3:
          System.out.println("TRES");
          this.x_cord = this.x_cord - 1;
          this.y_cord = this.y_cord + 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          case 4:
          System.out.println("CUATRO");
          this.y_cord = this.y_cord - 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          case 5:
          System.out.println("CINCO");
          this.y_cord = this.y_cord + 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          case 6:
          System.out.println("SEIS");
          this.x_cord = this.x_cord + 1;
          this.y_cord = this.y_cord - 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          case 7:
          System.out.println("SIETE");
          this.x_cord = this.x_cord + 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          case 8:
          System.out.println("OCHO");
          this.x_cord = this.x_cord + 1;
          this.y_cord = this.y_cord + 1;
          System.out.println("The new coordinates are: " + this.x_cord + " " + this.y_cord);

          break;

          default:
          System.out.println("NINGUN");
          break;
      }

    }

    //this should be called after moveTo()
    public void rePosition (char[][] matrix)
    {
        matrix[this.x_cord][this.y_cord] = getSymbol();
    }

    //find location on a 3x3 grid and then move from there
    //if grid is adjusted, so must this function
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
        if(this.y_cord == 9)
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
            if(this.y_cord == 9)
            {
                location = 3;
            }
        }

        //bottom, x = 9
        if(this.x_cord == 9)
        {
            location = 6;

            //check for lower corner cases
            //bottom left corner
            if(this.y_cord == 0)
            {
                location = 7;
            }

            //bottom right corner
            if(this.y_cord == 9)
            {
                location = 5;
            }
        }

        System.out.println("This Carnivore's location is at: " + location);
        return location;
    }

    //new function that returns legal moves
    //returns an array for each location
    //another switch
    public int[] canMoveTo (int location)
    {
        // location grid   --------------- movement grid
        // | 1 || 2 || 3 | --------------- | 1 || 2 || 3 |
        // | 8 || 0 || 4 | --------------- | 4 || 0 || 5 |
        // | 7 || 6 || 5 | --------------- | 6 || 7 || 8 |

        //array to be returned
        int[] output;

        switch (location)
        {
            //9 cases, for all locations in grid
            //center, can go anywhere
            case 0:
            output = new int[8];
            output = {1, 2, 3, 4, 5, 6, 7, 8};
            break;

            //top left corner
            case 1:
            output = new int[3];
            output = {5, 7, 8};
            break;

            //top middle
            case 2:
            output = new int[5];
            output = {4, 5, 6, 7, 8};
            break;

            //top right corner
            case 3:
            output = new int[3];
            output = {4, 6, 7};
            break;

            //middle right
            case 4:
            output = new int[5];
            output = {1, 2, 4, 6, 7};
            break;

            //lower right corner
            case 5:
            output = new int[3];
            output = {1, 2, 4};
            break;

            //lower middle
            case 6:
            output = new int[5];
            output = {1, 2, 3, 4, 5};
            break;

            //lower left corner
            case 7:
            output = new int[3];
            output = {2, 3, 5};
            break;

            //left middle
            case 8:
            output = new int[8];
            output = {2, 3, 5, 7, 8};
            break;

            //can probably remove this
            //it should not hit the default
            default:
            break;

        }

        return output;

    }

}
