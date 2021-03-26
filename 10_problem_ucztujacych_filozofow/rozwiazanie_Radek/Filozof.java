
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;



public class Filozof extends Thread {

    int ID;
    String[] files = null;
    static Semaphore[] semaphores = null;
    private static Random random = new Random();

    public Filozof(String[] f, Semaphore[] s, int i) {
        this.files = f;
        semaphores = s;
        this.ID = i;
        for(int j = 0; j<semaphores.length; j++)
        {
            semaphores[j] = new Semaphore(1);
        }
    System.out.println("Konstruktor watku " + this.ID + " sie melduje!");
    }

    public void run() {
        while (true)
        {
            System.out.println("Pozdrawiam z petli while w metodzie run w watku: " + this.getId());
            int fileA = (random.nextInt(files.length));
            int fileB;
            do {
                fileB = (random.nextInt(files.length));
            } while (fileB == fileA);

            int file1 = fileA > fileB ? fileB : fileA;
            int file2 = fileB > fileA ? fileA : fileB;

            BufferedReader reader = null;
            BufferedWriter writer = null;
            try {
                semaphores[file1].acquire();
                semaphores[file2].acquire();

                reader = new BufferedReader(new InputStreamReader(new FileInputStream(files[file1])));
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(files[file2])));

                writer.append("Odczyt: " + reader.readLine() + "\t\t\tprzez watek nr: " + Thread.currentThread());
            } catch (Exception ex) {
                System.out.println(ex);
            } finally {
                if(reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            semaphores[file1].release();
            semaphores[file2].release();
        }
    }
}
