import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
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
    private static int count = 0;

    //TODO: change it so that it take in the name and only look for that name
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
                System.out.println(save);  //check
                if (save.startsWith("Name"))
                {
                    //does nothing
                }
                else
                {
                    store(save);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Split up the string to store information TODO: remove later
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

            Ship ship = new Ship(name, type, retrofit, rarity, modifier);
            Fleet.quickstored.put(name, ship);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
