public class Organism
{
    //variables
    private int age;



    //methods
    public Organism()
    {
        this.age = 10;
    }

    //to create positioning
    public int get_rand()
    {
        return ((int)(Math.random() * 32));
    }


}
