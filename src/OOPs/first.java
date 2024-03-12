package OOPs;

class calculator
{
    protected int add(int a,int b){
        return a+b;
    }
}

class calci extends calculator
{
    public void xx()
    {
        System.out.println(add(5,6));
    }
}

public class first {
    public static void main(String[] args) {

        int ans=new calculator().add(4,5);
        System.out.println(ans);
    }
}
