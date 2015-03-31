public class environment
{
    public static void main (String[] args)
    {
        System.out.println("hello");

        Organism bird = new Organism();

        //can't do subclass = new class
        //can do class = new subclass
        Organism blah = new Plant();
        Organism lion = new Animal();

    }

}
