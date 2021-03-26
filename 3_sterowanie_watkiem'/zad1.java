
class myThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 1; i<=20; i++)
        {
            System.out.println(i);
        }
    }
}
class myThread2 implements Runnable{

    @Override
    public void run() {
        for(int i = 100; i<=120; i++)
        {
            System.out.println(i);
        }
    }
}

public class zad1 {

    public static void main(String[] args) {

        myThread1 th1 = new myThread1();
        Thread t1 = new Thread(th1);
        myThread2 th2 = new myThread2();
        Thread t2 = new Thread(th2);
        t1.start();
        t2.start();
    }


}
