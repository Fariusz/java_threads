/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Marcin
 */
public class MagazynImpl implements Magazyn<String> {

    int size;
    int idZapis =0;
    String [] produkty = null;
    Semaphore semProducent;
    Semaphore semKonsument;
    Semaphore semDodaj = new Semaphore(1);
    Semaphore semWez = new Semaphore(1);

    public MagazynImpl(int size) {
        semProducent = new Semaphore(size);
        semKonsument = new Semaphore(0);
        this.size = size;
        produkty = new String[size];
    }


    @Override
    public void add(String produkt) throws InterruptedException {

        semProducent.acquire();

        semDodaj.acquire();
        this.produkty[idZapis] = produkt;
        idZapis++;
        idZapis = idZapis % size;
        semDodaj.release();

        semKonsument.release();
    }

    @Override
    public String get() throws InterruptedException {
        semKonsument.acquire();

        semWez.acquire();
        String s = produkty[idZapis];
        semWez.release();

        semProducent.release();
        return s;
    }

}
