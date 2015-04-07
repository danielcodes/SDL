public class Plant extends Organism
{
    //variables
    private int x_cord;
    private int y_cord;

    public Plant()
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
        return 'P';
    }

}
