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
}
