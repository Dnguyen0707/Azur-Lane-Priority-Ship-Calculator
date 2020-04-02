import java.util.HashMap;

/**
 * Store all usable ships.
 * Putting ships together to make a fleet.
 */
public class Fleet
{
    public static HashMap<String, Ship> stored = new HashMap<>();


    public static String print()
    {
        String ret = "";
        for (Ship s : stored.values())
        {
            ret += s + "\n";
        }

        return ret;
    }
}
