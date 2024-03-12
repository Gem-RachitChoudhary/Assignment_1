package Rachit_Questionnaire_1;

abstract class A extends Exception
{
    int a,b;
    public A()
    {
        a=4;b=5;
        System.out.println("TMKC");
    }

    public A(int a,int b) {
        this.a = a;
        this.b=b;
        System.out.println("ho gya a call");
    }





}
class  B extends A
{
    int a=7,b=8;
    public B() {
        super(9,9);
    }

    public B(int a1, int b1) {



        this.a = a1;
        this.b = b1;
    }
}
public class Word_distance {
    public static int sum(int a,int b)
    {
        return a+b;
    }
    public static void main(String ...args) {
        B a=new B(5,6);
        sum(4,5);


        //System.out.println(a);

    }
}
