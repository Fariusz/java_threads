
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        int liczbaPaleczek =5;
        Semaphore[] paleczki = new Semaphore[liczbaPaleczek];
        Semaphore stol = new Semaphore(liczbaPaleczek-1);
        for(int i = 0; i<liczbaPaleczek; i++)
        {
            paleczki[i] = new Semaphore(1);
        }
        for(int i = 0; i<liczbaPaleczek; i++)
        {
            new Filozof(i, paleczki, stol).start();
        }

    }
}
