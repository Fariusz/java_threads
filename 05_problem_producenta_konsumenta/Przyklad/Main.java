
public class Main {
    public static void main(String[] args) throws InterruptedException{

        Magazyn m = new Magazyn();

        Thread t1 = new Thread(new Producent(m));
        Thread t2 = new Thread(new Konsument(m));

        t1.start();
        t2.start();

        Thread.sleep(10000);

        t1.interrupt();
        t2.interrupt();

        System.out.println("Koniec");
    }
}
