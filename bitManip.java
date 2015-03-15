//some bit manip problems

import java.util.Scanner;

public class bitManip
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int number = in.nextInt();

        oddEven(number);

        //*******************************************************

        System.out.println("Please enter an IP address: ");
        int address = in.nextInt();

        System.out.println("Please enter a mask: ");
        int mask = in.nextInt();

        ipBelong(address,mask);

        //*******************************************************

        System.out.println("Please enter a color: ");
        int color1 = in.nextInt();

        System.out.println("Please enter a second color: ");
        int color2 = in.nextInt();

        mixColor(color1, color2);



    }

    //***************************************************************
    //determine if number is odd or even
    //if it is a power of two
    public static void oddEven (int number)
    {
        //if it's odd or even
        System.out.print("_ODD OR EVEN: ");

        if( (number & 1) > 0 )
        {
            System.out.println("ODD");
        }
        else
        {
            System.out.println("EVEN");
        }

        //if it's a power of two
        System.out.print("POWER OF TWO: ");

        if( ((number-1) & number) == 0 )
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        System.out.println();
    }

    //***************************************************************
    //IPv4 address
    public static void ipBelong (int ip, int mask)
    {

        String address = Integer.toBinaryString(ip);
        String subnet = Integer.toBinaryString(mask);

        System.out.printf("The address is %s, the subnet mask is %s. %n", address, subnet);

        System.out.print("IP ADDRESS BELONGS TO THE NETWORK: ");
        //find least significant 1, then log to get the index
        int index = (int)(Math.log(mask & (-mask)) / Math.log(2));

        //shif both ip and mask and compare
        if( (ip >> index) == (mask >> index) )
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        System.out.println();
    }

    //***************************************************************
    //32-bit color system
    public static void mixColor (int color_1, int color_2)
    {

        String first_c = Integer.toBinaryString(color_1);
        String second_c = Integer.toBinaryString(color_2);

        System.out.printf("The first color is %s, the second color is %s. %n", first_c, second_c);

        int avg = (color_1 + color_2) / 2;

        String result = Integer.toBinaryString(avg);
        System.out.printf("The mix of these two colors is, %s. %n",result);

    }


}
