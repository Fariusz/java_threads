
import java.util.Queue;

public interface Magazyn<T> {
    /**
     * Dodanie produktu do magazynu
     * @param product
     */
    public void add(T product) throws InterruptedException;

    /**
     * Wyciągnięcie produktu z magazynu
     * @return
     */
    public T get() throws InterruptedException;
}
