
public class MonitorImpl implements Monitor
{
    private volatile boolean flag1 = false;
    private volatile boolean flag2 = false;
    private volatile int turn = 0  ;

    @Override
    public void proceduraWejsciowaWatek1() {
        flag1 = true;
        turn = 2;
        do{

        } while(!(turn == 1 || !flag2));
    }

    @Override
    public void proceduraWejsciowaWatek2() {
        flag2=true;
        turn =1;
        do{

        } while(!(turn == 2 || !flag1));
    }

    @Override
    public void proceduraWyjsciowaWatek1() {
        flag1 = false;
    }

    @Override
    public void proceduraWyjsciowaWatek2() {
        flag2 = false;
    }
}
