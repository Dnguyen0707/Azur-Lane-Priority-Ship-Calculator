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

        Reader.read("Iron Blood", "Bismarck");

        Reader.read("Iron Blood", "Graf Zeppelin");

        System.out.println("---------------------------");
        System.out.println(Fleet.print());

    }
}
