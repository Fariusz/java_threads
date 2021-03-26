/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Marcin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Magazyn m = new MagazynImpl();
        Thread producent = new Producent(m);
        Thread konsument = new Consument(m);
        producent.start();
        konsument.start();        
        Thread.sleep(1 * 1000);
        producent.interrupt();
        konsument.interrupt();
    }
    
}
