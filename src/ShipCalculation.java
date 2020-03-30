/**
 * This class will calculate oil cost for each ship
 *
 * @author Dai Nguyen
 * @version 1.0
 */
public class ShipCalculation
{
    private static int maxCostHull;
    private static int maxCostRarity;
    private static int maxCostLimit;

    /**
     * This calculate how much oil a ship cost
     *
     * Variable that is required: Hull type, Rarity, Limit Break, Modifier
     */
    public static int oilCalculator(String type, String rarity, String modifier, int limitbreak)
    {
        //getting max cost for Hull type
        switch (type)
        {
            case "DD":
            {
                maxCostHull = 1;
                break;
            }
            case "CL":
            {
                maxCostHull = 2;
                break;
            }
            case "CA":
            {
                maxCostHull = 3;
                break;
            }
            case "CV":
            {
                maxCostHull = 4;
                break;
            }
            case "BC":
            {
                maxCostHull = 5;
                break;
            }
            case "BB":
            {
                maxCostHull = 6;
                break;
            }
            default:
            {
                System.out.println("fucked");
            }

        }

        //getting max cost for rarity
        if (rarity.equalsIgnoreCase("Priority"))
        {
            maxCostRarity = 4;
        }
        else if (rarity.equalsIgnoreCase("Decisive"))
        {
            maxCostRarity = 7;
        }
        else
        {
            switch (rarity)
            {
                case "Common":
                {
                    maxCostRarity = 0;
                    break;
                }
                case "Rare":
                {
                    maxCostRarity = 1;
                    break;
                }
                case "Elite":
                {
                    maxCostRarity = 2;
                    break;
                }
                case "SSR":
                {
                    maxCostRarity = 3;
                    break;
                }
                default:
                {
                    System.out.println("Fucked");
                }
            }
        }
        //TODO: remember to time 2 for every limit break, max up to 6, total of 3 limit break allowed.
        //TODO: retrofit does not change limit break
        if (rarity.equalsIgnoreCase("Priority") || rarity.equalsIgnoreCase("Decisive"))
        {
            maxCostLimit = 6;
        }
        else
        {
            switch (rarity)
            {
                case "Common":
                {
                    maxCostLimit = (limitbreak - 1) * 2;
                    break;
                }
                case "Rare":
                case "Elite":
                {
                    maxCostLimit = (limitbreak - 2) * 2;
                    break;
                }
                case "SSR":
                {
                    maxCostLimit = (limitbreak - 3) * 2;
                    break;
                }
                default:
                {
                    System.out.println("Fucked");
                }
            }
        }

        //taking care of modifier
        System.out.println(modifier);
        int mod = Integer.parseInt(modifier);

        int output = maxCostHull + maxCostLimit + maxCostRarity + mod;
        return output;
    }
}
