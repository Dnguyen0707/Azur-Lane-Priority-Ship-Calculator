import java.util.Scanner;
import java.net.URI;

public class Driver
{
    private static String[] pr1 = new String[]{"Neptune", "Monarch", "Ibuki", "Izumo", "Roon", "Saint Louis"};
    private static String[] pr2 = new String[]{"Seattle", "Georgia", "Kitakaze", "Azuma", "Friedrich der Grosse", "Gascogne"};
    public static void main(String[] args)
    {

        Introduction.intro();

        while (true)
        {
            String option = Introduction.option();
            if(option.equalsIgnoreCase("calculate"))
            {
                System.out.println("Cool, let's get started");
                String goal = goalship();
                //TODO: add more


            }
            else if(option.equalsIgnoreCase("wiki"))
            {
                System.out.println("Wiki will be open in your browser, no virus :)");
                try
                {
                    URI uri= new URI("https://azurlane.koumakan.jp/Azur_Lane_Wiki");
                    java.awt.Desktop.getDesktop().browse(uri);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if(option.equalsIgnoreCase("close"))
            {
                System.out.println("Thanks for using the program :)");
                System.exit(0);
            }
            else
            {
                System.out.println("Type the option");
            }
        }
    }

    public static String goalship()
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nWhat PR are you doing? 1 or 2");

        int pr = sc.nextInt(); //TODO: put a checker

        if  (pr == 1)
        {
            System.out.println("What ship are you planning to work on?");
            for (String s : pr1)
            {
                if (s.isEmpty())
                {
                    //does nothing
                }
                else
                {
                    System.out.println(s);
                }
            }
        }
        else if (pr == 2)
        {
            System.out.println("What ship are you planning to work on?");
            for (String s : pr2)
            {
                if (s.isEmpty())
                {
                    //does nothing
                }
                else
                {
                    System.out.println(s);
                }
            }
        }
        else
        {
            System.out.println("Bugged at taking pr input at driver");
        }
        System.out.println();
        sc.nextLine();  //skipping leftover new line

        String goal = goalCheck(sc.nextLine(), pr);

        return goal;
    }

    private static String goalCheck(String input, int num)
    {
        while(true)
        {
            if (num == 1)
            {
                for (String s : pr1)
                {
                    if (input.equalsIgnoreCase(s))
                    {
                        return s;
                    }
                }
            }
            else if (num == 2)
            {
                for (String s : pr2)
                {
                    if (input.equalsIgnoreCase(s))
                    {
                        return s;
                    }
                }
            }
            else
            {
                System.out.println("Bugged at goalCheck");
            }
        }
    }
}