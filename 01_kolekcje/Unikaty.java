
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Unikaty {

    public static void main(String[] args) throws FileNotFoundException {

        Set<String> set = new HashSet<>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("/Users/Radek/Desktop/Nauka_PRIR_LAB/src/1_kolekcje/baza.txt"));

            while(scanner.hasNext())
            {
                scanner.next();
                String s = scanner.next();
                scanner.next();
                set.add(s);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        finally {
            if(scanner != null)
            {
                scanner.close();
            }
        }

        for (String s:set
             ) {
            System.out.println(s);

        }
    }
}
