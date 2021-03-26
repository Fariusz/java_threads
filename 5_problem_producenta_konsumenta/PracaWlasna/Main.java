
public class Main {
    public static void main(String[] args) throws InterruptedException {

        MagazynImpl m = new MagazynImpl(5);
        Konsument k = new Konsument(m);
        Producent p = new Producent(m);

        Thread konsumentThread = new Thread(k);
        Thread producentThread = new Thread(p);

        producentThread.start();
        konsumentThread.start();

        Thread.sleep(1);

        konsumentThread.interrupt();
        producentThread.interrupt();
    }
}
