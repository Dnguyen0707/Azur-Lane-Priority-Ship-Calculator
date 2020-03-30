import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;
/**
 * This class will read the excel file based on what ship the user is researching
 * on and only limit to that ship faction
 *
 * Iron Blood - Roon, Friedrich der Grosse
 * Royal Navy - Neptune, Monarch
 * Sakura Empire - Ibuki, Izumo, Kitakaze, Azuma
 * Eagle Union - Saint Louis, Seattle, Georgia
 *
 * Special unit
 * Gascogne - Iron Blood, Vichya Dominion, Iris Libre
 *
 *
 * @author Dai Nguyen
 * @version 1.0
 */
public class Reader
{
    /**
     * Store the information required from the excel
     *
     **/
    public static void read(String faction, String name)
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("Ships.xlsx"));

            //creating notebook and get the sheet
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = null;

            //depending on what faction is needed, read the sheet
            switch (faction)
            {
                case "Iron Blood":
                {
                    sheet = workbook.getSheetAt(0);
                    break;
                }
                case "Sakura Empire":
                {
                    sheet = workbook.getSheetAt(1);
                    break;
                }
                case "Eagle Union":
                {
                    sheet = workbook.getSheetAt(2);
                    break;
                }
                case "Vichya Dominion":
                {
                    sheet = workbook.getSheetAt(3);
                    break;
                }
                case "Royal Navy":
                {
                    sheet = workbook.getSheetAt(4);
                    break;
                }
                case "Iris Libre":
                {
                    sheet = workbook.getSheetAt(5);
                    break;
                }
                default:
                    System.out.println("This program is bugged");
            }

            //checking if there is a sheet or not
            assert sheet != null;

            //reading row and column
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                String save = "";
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();

                    //switch depending on the data
                    switch (cell.getCellType())
                    {
                        case NUMERIC:
                        {
                            save += cell.getNumericCellValue() + "/";
                            break;
                        }
                        case STRING:
                        {
                            save += cell.getStringCellValue() + "/";
                            break;
                        }
                        default:
                        {
                            System.out.println("fucked");
                        }
                    }
                }
                //turning user input to correct form
                name = correctInput(name);

                //check if the name is right
                if (save.startsWith(name))
                {
                    store(save);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Split up the string to store information
     */
    private static void store(String save)
    {
        try
        {
            String[] splited = save.split("/");

            String name = splited[0];
            String type = splited[1];
            String retrofit = splited[2];
            String rarity = splited[3];
            String modifier = splited[4];

            double change = Double.parseDouble(modifier);
            DecimalFormat format = new DecimalFormat("0.#");
            String changed = format.format(change);

            Ship ship = new Ship(name, type, retrofit, rarity, changed);

            //separating the main and vanguard
            String key = "";
            switch (type)
            {
                case "CA":
                case "CL":
                case "DD":
                {
                    key = "Vanguard";
                    break;
                }

                case "BB":
                case "CV":
                {
                    key = "Main";   //TODO: add in count here so key are different
                    break;
                }

                default:
                {
                    System.out.println("Bugged");
                }
            }
            Fleet.stored.put(key, ship);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Correct user input
     * */
    private static String correctInput(String str)
    {
        if (str == null || str.isEmpty())
        {
            System.out.println("Empty String");
            return str;
        }

        return Arrays.stream(str.split("\\s+")).map(t -> t.substring(0, 1).toUpperCase() + t.substring(1)).collect(
                Collectors.joining(" "));
    }
}
