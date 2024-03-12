class Aa implements Runnable
{
    @Override
    public void run() {

        System.out.println("Priyanka pagal h");
    }
}
class Ba extends Thread
{
    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            System.out.println("Jai Siya Ram");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class runnabl {
    public static void main(String[] args) {
        Runnable obj1=new Aa();

        Thread a=new Thread(obj1);

        a.start();
        System.out.println(Thread.currentThread());


        B aa=new B();
        aa.start();
//        b.start();


    }
}
