
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        int n = 10;

        String[] files = { "/Users/Radek/Desktop/Nauka_PRIR_LAB/rozwiazanie_Radek/plik1.txt", "/Users/Radek/Desktop/Nauka_PRIR_LAB/rozwiazanie_Radek/plik2.txt", "/Users/Radek/Desktop/Nauka_PRIR_LAB/lab10/rozwiazanie_Radek/plik3.txt", "/Users/Radek/Desktop/Nauka_PRIR_LAB/lab10/rozwiazanie_Radek/plik4.txt", "/Users/Radek/Desktop/Nauka_PRIR_LAB/lab10/rozwiazanie_Radek/plik5.txt"};
        Semaphore[] semaphores = new Semaphore[files.length];
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i<n; i++)
        {
            System.out.println("Tworze watki, watek: " + i);
            threads.add(new Filozof(files,semaphores, i));
        }

        threads.forEach(t -> t.start());
        System.out.println("Wątki wystartowały!");
        Thread.sleep(100);
        System.out.println("Zaczynam przerywanie!");
        threads.forEach(t-> t.interrupt());

    }
}
