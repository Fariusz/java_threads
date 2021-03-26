
class mojThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 1; i<=20; i++)
        {
            System.out.println(i);
        }
    }
}
class mojThread2 implements Runnable{

    Thread th;

    mojThread2(Thread th){
        this.th = th;
    }

    @Override
    public void run() {
        for(int i = 100; i<=120; i++)
        {
            System.out.println(i);
        }
        th.start();
    }
}

public class zad2 {

    public static void main(String[] args) {

        mojThread1 th1 = new mojThread1();
        Thread t1 = new Thread(th1);
        mojThread2 th2 = new mojThread2(t1);
        Thread t2 = new Thread(th2);
        t2.start();
    }


}
