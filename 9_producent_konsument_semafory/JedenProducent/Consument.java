/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Queue;

/**
 *
 * @author Marcin
 */
public class Consument extends Thread {

    Magazyn<String> magazyn;

    public Consument(Magazyn<String> m) {
        this.magazyn = m;
    }

    public void run() {
        try {
            while (true) {
                String produkt = magazyn.get();
                System.out.println("Odczytałem z magazynu: " + produkt);
                Thread.sleep((int) (Math.random() * 50));
            }
        } catch (InterruptedException e) {
            System.out.println("Koniec wątku konsumenta");
        }
    }
}
