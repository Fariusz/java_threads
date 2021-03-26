
public class Magazyn {

    String towar;
    boolean jestTowar = false;

    synchronized void set (String towar) throws InterruptedException
    {
        while (jestTowar)
        {
            this.wait();
        }

        this.towar = towar;
        jestTowar = true;
        notifyAll();
    }

    synchronized String get() throws InterruptedException
    {
        while (!jestTowar) {
            this.wait();
        }

        jestTowar = false;
        notifyAll();
        return towar;
    }
}
