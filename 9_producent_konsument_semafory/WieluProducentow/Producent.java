/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Marcin
 */
public class Producent extends Thread {

    Magazyn magazyn;
    static AtomicInteger i = new AtomicInteger(0);

    public Producent(Magazyn m) {
        magazyn = m;
    }

    public void run() {
        try {
            while (true) {                
                String produkt = "" + i.getAndIncrement();
                magazyn.add(produkt);
                System.out.println("Wrzuciłem do magazynu: " + produkt);
                Thread.sleep((int) (Math.random() * 10));
            }
        } catch (InterruptedException e) {
            System.out.println("Koniec wątu Producenta");
        }
    }

}
