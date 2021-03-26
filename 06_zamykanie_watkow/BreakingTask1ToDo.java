
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Zmodyfikuj metodę run w klasie BreakingTask1ToDo tak aby po wystąpieniu przerwaniu wątka, metoda run zakończyła swoją
 * pracę a jednocześnie wypisała na ekranie zawartość mapy
 */
public class BreakingTask1ToDo implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BreakingTask1ToDo());
        t.start();
        Thread.sleep(500);
        t.interrupt();
        t.join();
        System.out.println("Koniec pracy ");
    }

    @Override
    public void run() {
        Map<String, Integer> map = new HashMap<>();
        Random r = new Random();

        while (true) {

            String key = "" + r.nextInt(10);
            Integer val = map.get(key);
            val = val == null ? 1 : val + 1;
            map.put(key, val);

            if(Thread.currentThread().isInterrupted())
            {
                for (Map.Entry s : map.entrySet())
                {
                    System.out.println(s);
                }
                break;
            }
        }
    }
}

