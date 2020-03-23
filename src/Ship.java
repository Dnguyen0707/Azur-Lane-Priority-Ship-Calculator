import java.util.Scanner;

/**
 * Ship class creates objects that will be used in others classes. Information
 * will be taken from Ships.xlsx and processed through a Reader class.
 *
 * @author Dai Nguyen
 * @version 1.0
 */
public class Ship
{
    private String name;
    private String type;
    private boolean retrofit;
    private String rarity;
    private String modifier;
    private int limitBreak;
    private int oilCost;    //TODO: need to calculate the oil cost

    /**
     * Constructor to make a Ship object by taking in informations from the
     * excel and store that information. Everything that is stored will be
     * immutable except for rarity, which is changed depending on the
     * information that retrofit contain. Limitbreak information will requires
     * user input using Java's built-in Scanner.
     *
     * @param name Ship name
     * @param modifier Any modifier on ship
     * @param rarity Rarity of the ship
     * @param retrofit If the ship is retrofitable
     * @param type Ship type
     * @param modifier Oil modification
     */
    public Ship(String name, String type, String retrofit, String rarity, String modifier)  //add in oil cost for the variable
    {
        this.name = name;
        this.type = type;
        this.retrofit = isRetrofit(retrofit);
        this.rarity = rarityCheck(this.retrofit, rarity);
        this.modifier = modifier;
        this.limitBreak = limitBreak();
        this.oilCost = ShipCalculation.oilCalculator(type, rarity, modifier, this.limitBreak);

    }

    /**
     * Ask user if they retrofitted their ship then store that information.
     *
     * @param retrofit Information on if ships is retrofitable
     * @return True or false depending on the condition
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
            boolean pass = true;
            while (pass)
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
     * Checking a ship rarity if retrofitted and change rarity accordingly.
     *
     * @param rarity The ship original rarity
     * @param retrofitted If the user retrofitted the ship
     * @return Either the same imported rarity or updated
     */
    public String rarityCheck(boolean retrofitted, String rarity)
    {
        String ret = "";
        if (retrofitted)
        {
            switch (rarity)
            {
                case "Common":
                {
                    ret = "Rare";
                    break;
                }
                case "Rare":
                {
                    ret = "Elite";
                    break;
                }
                case "Elite":
                {
                    ret = "SSR";
                    break;
                }
                case "SSR":
                {
                    ret = "Priority";  //TODO: check if it's right
                    break;
                }
                default:
                {
                    System.out.println("This program is bugged");
                }
            }
        }
        else
        {
            ret = rarity;
        }
        return ret;
    }

    /**
     * Ask user to see if they limit break and store the information that will
     * be used to calculate oil cost.
     *
     * @return The user input
     */
    public int limitBreak()
    {
        int output = 0;
        Scanner sc = new Scanner(System.in);

        if (this.rarity.equalsIgnoreCase("Priority") || this.rarity.equalsIgnoreCase("Decisive"))
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
            switch (this.rarity)
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
            if (!pass)
            {
                System.out.println("Please enter a correct number");
            }
        }

        return output;
    }

    /**
     * Print out the ship information
     *
     * @return String of ship's information.
     */
    @Override
    public String toString()
    {
        String name = "Name: " + this.name;
        String type = "Ship Type: " + this.type;
        String rarity = "Rarity: " + this.rarity;
        String limitbreak = "Limit Break Level: " + this.limitBreak;
        String oilcost = "Oil cost: " + this.oilCost;

        return name + " | " + type + " | " + rarity + " | " + limitbreak + " | " + oilcost;
    }
}
