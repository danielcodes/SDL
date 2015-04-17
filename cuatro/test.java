public class test
{
    public static void main (String[] args)
    {
        //testing switch
        int x, y;
        x = 0;
        y = 0;


        /*
        for(int i=1; i<=1; i++)
        {
            x = 1;
            y = 1;
            move(i, x, y);
            System.out.println("The new coordinates are: " + x + " " + y);
        }
        */

        int[] dummy = {1,2,3};
        // dummy = new int[3];
        //dummy = {1,2,3};

        System.out.println(dummy.length);
        for (int i=0; i<dummy.length; i++)
        {
            System.out.println(dummy[i]);
        }




    }

    public static void move (int place, int x, int y)
    {
        //movement patterns
        // | 1,1 | 1,2 | 1,3 |
        // | 2,1 | 2,2 | 2,3 |
        // | 3,1 | 3,2 | 3,3 |

        //in terns of adding and subbing the main term (middle)
        // | -1,-1 | -1,0 | -1,1 |
        // | 0,-1  | 0,0  | 0,1  |
        // | 1,-1  | 1,0  | 1,1  |

        //cases that I will use
        // | 1 | 2 | 3 |
        // | 4 |   | 5 |
        // | 6 | 7 | 8 |

        //number will range from 1 - 8 (possible moves)
        switch (place)
        {
            case 1:
            System.out.println("UNO");
            x = x - 1;
            y = y - 1;
            break;

            case 2:
            System.out.println("DOS");
            x = x - 1;
            break;

            case 3:
            System.out.println("TRES");
            x = x - 1;
            y = y + 1;
            break;

            case 4:
            System.out.println("CUATRO");
            y = y - 1;
            break;

            case 5:
            System.out.println("CINCO");
            y = y + 1;
            break;

            case 6:
            System.out.println("SEIS");
            x = x + 1;
            y = y - 1;
            break;

            case 7:
            System.out.println("SIETE");
            x = x + 1;
            break;

            case 8:
            System.out.println("OCHO");
            x = x + 1;
            y = y + 1;
            break;

            default:
            System.out.println("NINGUN");
            break;
        }

    }

}
