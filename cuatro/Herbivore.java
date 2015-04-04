public class Herbivore extends Organism
{
    private int energy;
    private int x_cord;
    private int y_cord;

    public Herbivore()
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
        return 'H';
    }

}
