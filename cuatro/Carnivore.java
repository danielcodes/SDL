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

        this.x_cord = this.x_cord + addx;
        this.y_cord = this.y_cord + addy;

        //can move or stay in the same place
        while( !((this.x_cord > 0 && this.x_cord < 15) && (this.y_cord > 0 && this.y_cord < 15)) )
        {

            addx = (int)(Math.random()*4 -2 );
            addy = (int)(Math.random()*4 -2 );

            this.x_cord = this.x_cord + addx;
            this.y_cord = this.y_cord + addy;
        }

        //now reposition
        matrix[this.x_cord][this.y_cord] = getSymbol();
    }



}
