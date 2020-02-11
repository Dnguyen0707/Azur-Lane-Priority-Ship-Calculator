import Fleet.Ship;
/**
 * Tester driver to test the component of this program
 *
 * @author Dai Nguyen
 */
public class Driver
{
    public static void main(String[] args)
    {
        Ship bismarck = new Ship("Bismarck", "BB", "yes", "Common", "0");

        System.out.println(bismarck.toString());
    }
}
