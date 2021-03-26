
public interface Magazyn<T> {
    /**
     * Dodanie produktu do magazynu
     * @param product
     */

    public void add(T product);
    /**
     * Wyciągnięcie produktu z magazynu
     * * @return
     */
    public T get();
}
