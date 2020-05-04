import java.util.InputMismatchException;
import java.util.Scanner;
public class Introduction
{
    public static void intro()
    {
        System.out.println("Welcome to Azur Lane Priority Calculator (ALPC)");
        System.out.println("All of the character belong to Yostar and Manjuu");
        System.out.println();
        System.out.println("I'm doing this because why not?");
        System.out.println("More practice on coding the better");
        System.out.println("Anyway, this program may be redo with a different programming language");
        System.out.println("Enjoy knowing how much oil and run you need to do");
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("Disclaimer Section");
        System.out.println("I used the equation given in the the wiki and did not test any");
        System.out.println("This might be a very rough estimate of what you have");
        System.out.println("The ship list may or my not be update that frequently");
        System.out.println("");
        System.out.println("Lord know how long I spent on this");
        System.out.println();
        System.out.println("----------------------------------------------------");
    }

    public static String option()
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        return input;
    }

    public static String shipinput()
    {
        return "";
    }
}
