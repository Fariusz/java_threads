/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab2.IOsoba;

import java.util.*;

/**
 *
 * @author Marcin
 */
public class KsiazkaTelefoniczna implements IKsiazkaTelefoniczna {

    Map<Integer, IOsoba> mapId2Osoba = new HashMap<>();
    Map<String, List<Integer>> mapImie2Id = new HashMap<>();
    Map<String, List<Integer>> mapNazwisko2Id = new HashMap<>();

    @Override
    public Collection<IOsoba> getByImie(String imie) {

        List<IOsoba> wynik = new ArrayList<>();
        List<Integer> lista = mapImie2Id.get(imie);
        for(int id : lista)
        {
            IOsoba o = mapId2Osoba.get(id);
            wynik.add(o);
        }

        return wynik;
    }

    @Override
    public Collection<IOsoba> getByNazwisko(String nazwisko) {

        List<IOsoba> wynik = new ArrayList<>();
        List<Integer> lista = mapNazwisko2Id.get(nazwisko);
        for(int id : lista)
        {
            IOsoba o = mapId2Osoba.get(id);
            wynik.add(o);
        }

        return wynik;
    }

    @Override
    public IOsoba remove(int id) {
        IOsoba o = mapId2Osoba.remove(id);
        String imie = o.getImie();
        List<Integer> ids = mapImie2Id.get(imie);
        ids.remove(Integer.valueOf(id));

        return o;
    }

    @Override
    public void addOsoba(IOsoba osoba) {

        int id = osoba.getId();
        mapId2Osoba.put(id,osoba);

        String imie = osoba.getImie();
        String nazwisko = osoba.getNazwisko();
        if(!mapImie2Id.containsKey(imie))
        {
            mapImie2Id.put(imie,new ArrayList<>());
        }
        if(!mapNazwisko2Id.containsKey(nazwisko))
        {
            mapNazwisko2Id.put(nazwisko, new ArrayList<>());
        }
        List<Integer> lista = mapImie2Id.get(imie);
        List<Integer> lista2 = mapNazwisko2Id.get(nazwisko);
        lista.add(id);
        lista2.add(id);
    }

    @Override
    public int size() {
        return mapId2Osoba.size();
    }


}
