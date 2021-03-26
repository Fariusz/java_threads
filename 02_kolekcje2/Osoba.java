
public class Osoba implements IOsoba {

    int id;
    String imie;
    String nazwisko;
    String nrTelefonu;
    static int counter = 0;

    Osoba(String imie, String nazwisko, String nrTelefonu)
    {
     setImie(imie);
     setNazwisko(nazwisko);
     setNrTelefonu(nrTelefonu);
     counter++;
     id = counter;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getImie() {
        return this.imie;
    }

    @Override
    public String getNazwisko() {
        return this.nazwisko;
    }

    @Override
    public String getNrTelefonu() {
        return this.nrTelefonu;
    }

    @Override
    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }
}
