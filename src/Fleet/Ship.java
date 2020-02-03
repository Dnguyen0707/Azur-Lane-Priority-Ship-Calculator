package Fleet;
/**
 * A template to create ships object to use
 *
 * Every variables are unchangeable except for retrofit (required user input)
 */

import java.util.Scanner;

public class Ship
{
    private String name;
    private String type;
    private boolean retrofit;
    private String rarity;
    private String modifier;
    private int limitBreak;

    /**
     * Constructor to make a Ship object
     *
     * @param name
     * @param modifier
     * @param rarity
     * @param retrofit
     * @param type
     */
    public Ship(String name, String type, String retrofit, String rarity, String modifier)
    {
        this.name = name;
        this.type = type;
        this.retrofit = isRetrofit(retrofit);
        this.rarity = rarity;
        this.modifier = modifier;
        this.limitBreak = limitBreak();
    }

    /**
     * Ask user if they retrofitted their ship then store that information
     */
    public boolean isRetrofit(String retrofit)
    {
        //check the excel retrofit box
        if (retrofit.equalsIgnoreCase("yes"))
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Did you retrofitted your ship? yes/no");
            String input;

            //prevent user from putting other answer
            boolean pass = false;
            while (!pass)
            {
                input = sc.nextLine();
                if (input.equalsIgnoreCase("yes"))
                {
                    break;
                }
                else if(input.equalsIgnoreCase("no"))
                {
                    return false;
                }
                System.out.println("Please enter a valid answer");
            }
            //return true if passed
            return true;
        }
        //return false if no retrofit
        return false;
    }

    /**
     * Ask user to see if they limit break
     */
    public int limitBreak()
    {
        int output = 0;
        Scanner sc = new Scanner(System.in);

        if (rarity.equalsIgnoreCase("Priority"))
        {
            output = 6;
        }

        System.out.println("What is the star level/limit break of your ship?");
        System.out.println("Please enter a number");
        int input;
        boolean pass = false;

        //preventing from user to enter other number
        while (!pass)
        {
            input = sc.nextInt();
            switch (rarity)
            {
                case "Common":
                {
                    if (input >= 1 && input <= 4)
                    {
                        output = input;
                        pass = true;
                    }
                    break;
                }
                case "Rare":
                case "Elite":
                {
                    if (input >= 2 && input <= 5)
                    {
                        output = input;
                        pass = true;
                    }
                    break;
                }
                case "SSR":
                {
                    if (input >= 3 && input <= 6)
                    {
                        output = input;
                        pass = true;
                    }
                    break;
                }
                default:
                {
                    System.out.println("This program is bugged");
                }
            }
            System.out.println("Please enter a correct number");
        }

        return output;
    }

    @Override
    public String toString()
    {
        String name = "Name: " + this.name;
        String type = "Ship Type: " + this.type;
        String rarity = this.rarity;
        String limitbreak = "Limit Break Level: " + this.limitBreak;

        if (retrofit)
        {
            switch (rarity)
            {
                case "Common":
                {
                    rarity = "Rarity: Rare";
                    break;
                }
                case "Rare":
                {
                    rarity = "Rarity: Elite";
                    break;
                }
                case "Elite":
                {
                    rarity = "Rarity: SSR";
                    break;
                }
                default:
                {
                    rarity = "Rarity: " + this.rarity;
                }
            }
        }
        else
        {
            rarity = "Rarity: " + this.rarity;
        }

        return name + " | " + type + " | " + rarity + " | " + limitbreak;
    }
}
