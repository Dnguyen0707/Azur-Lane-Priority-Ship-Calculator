

import java.net.URI;

public class Driver
{
    public static void main(String[] args)
    {

        Introduction.intro();

        while (true)
        {
            String option = Introduction.option();
            if(option.equalsIgnoreCase("calculate"))
            {
                System.out.println("Cool, let's get started");
                break;
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
            else
            {
                System.out.println("Type the option");
            }
        }

        String input = Introduction.shipinput();
    }
}