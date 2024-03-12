import java.util.Scanner;

class A extends Thread
{
    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            System.out.println("A called");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
//    public void aaa()
//    {
//        System.out.println("Hiii");
//    }
}
class B extends Thread
{
    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            System.out.println("B called");
//            try {
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}

public class ibm {
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
    public static void main(String[] args) throws InterruptedException {
        A obj1=new A();
        B obj2=new B();
//        obj1.setPriority(3);


                    obj1.start();
//                    obj2.start();
                    for (int i=0;i<1000;i++)
                        System.out.println(obj1.getState());







    }
}
