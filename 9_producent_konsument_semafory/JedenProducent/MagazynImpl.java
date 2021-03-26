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

    Semaphore semConsument = new Semaphore(0);
    Semaphore semProducent = new Semaphore(1);

    String towar = null;

    public MagazynImpl() {
    }

    @Override
    public void add(String product) throws InterruptedException {
        semProducent.acquire();
        this.towar = product;
        semConsument.release();
    }

    @Override
    public String get() throws InterruptedException {
        semConsument.acquire();
        semProducent.release();
        return towar;
    }
}
