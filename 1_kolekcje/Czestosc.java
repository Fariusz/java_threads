
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Czestosc {

    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<>();

        try(Scanner scanner = new Scanner(new File("/Users/Radek/Desktop/Nauka_PRIR_LAB/src/lab1/tekst.txt"));)
        {
            while(scanner.hasNext())
            {
                String word = scanner.next();
                word = word.toLowerCase();

                if(map.containsKey(word))
                {
                    int i = map.get(word);
                    i++;
                    map.put(word,i);
                }
                else
                {
                    map.put(word,1);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("e");
        }

        int i = 0;
        for (Map.Entry<String,Integer> e : map.entrySet())
        {
            i++;
            if(i>10)
            {
                break;
            }
            System.out.println(e);
        }
    }
}
