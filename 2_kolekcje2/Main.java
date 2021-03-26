/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;

/**
 *
 * @author Marcin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IKsiazkaTelefoniczna kt = new KsiazkaTelefoniczna();
        IOsoba o1, o2, o3;
        //Dodajemy osoby
        o1 = new Osoba("Jan", "Kowalski", "31 123-345-543");
        kt.addOsoba(o1);
        o2 = new Osoba("Jan", "Nowak", "21 10-10-10-01");
        kt.addOsoba(o2);
        o3 = new Osoba("Marek", "Kowalski", "32 44-55-66-77");
        kt.addOsoba(o3);
        //Sprawdzamy wyszukiwanie po imieniu
        Collection<IOsoba> kol = kt.getByImie("Jan");
        for (IOsoba o : kol) {
            if (!"Jan".equals(o.getImie())) {
                System.out.println("Błąd");
                System.exit(1);
            }
        }
        //Sprawdzamy rozmiar
        if (kt.size()!=3){
            System.out.println("Błąd rozmiaru listy");
            System.exit(1);
        }
        //Usuwamy element
        kt.remove(o2.getId());
        //Sprawdzamy rozmiar
        if (kt.size()!=2){
            System.out.println("Błąd rozmiary Książki Adresowej");
            System.exit(1);
        }
        //Wyszukujemy po nazwisku - powinno być dwóch kowalskich
        String nazwisko = "Kowalski";
        kol = kt.getByNazwisko(nazwisko);
        int i = 0;
        for(IOsoba o : kol){
            if (!"Kowalski".equals(o.getNazwisko())){
                System.out.println("Błąd osoba powinna mieć innego nazwiska niż Kowalski ");
                System.exit(1);
            }
            i++;
        }
    }
}
