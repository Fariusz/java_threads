
public class MagazynImpl implements Magazyn {

    boolean jestTowar = false;
    int towarID = 0;

    int rozmiarMagazynu;
    int licznik = 0;
    String[] towary = new String[rozmiarMagazynu];

    public MagazynImpl(int rozmiar) {
        this.rozmiarMagazynu = rozmiar;
    }

    @Override
    public synchronized void add(Object product) {
        jestTowar = true;
        towarID ++;
    }

    @Override
    public synchronized Object get() {
        jestTowar = false;
        return towarID;
    }

    public boolean isJestTowar() {
        return jestTowar;
    }

    public int getTowarID() {
        return towarID;
    }
}
