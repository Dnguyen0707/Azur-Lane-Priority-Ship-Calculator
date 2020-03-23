/**
 * Tester driver to test the component of this program
 *
 * @author Dai Nguyen
 */
public class Test
{
    public static void main(String[] args)
    {
//        Ship bismarck = new Ship("Bismarck", "BB", "yes", "Common", "0");
//        System.out.println(bismarck.toString());

        Reader.read("Iron Blood", "Z23");
        System.out.println(Fleet.stored);

    }
}
