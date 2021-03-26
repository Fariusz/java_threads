
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class zad4 {

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(new File("/Users/Radek/Desktop/Nauka_PRIR_LAB/src/lab3/dane.txt"));)
        {
            Map<String, String> map = new HashMap<String,String>();

            while(scanner.hasNext())
            {
                String data = scanner.nextLine();
                String[] split = data.split(";");
                map.put(split[0],split[1]);
            }

            String value = Collections.min(map.values());
            System.out.println("Najmniejszą wartością jest: " + value);
            System.out.println("ID najmniejszej wartości to: " + getKeyFromValue(map,value));
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }

    }
}
