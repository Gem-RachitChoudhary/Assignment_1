package Assignment2;

import java.util.Scanner;

public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        long s=0;
        for(int i=1;i*i<=n;i++)
        {
            if(n%i==0)
            {
                s+=i;
                if(n/i!=i)
                {
                    s+=(n/i);
                }
            }
        }
        if(s>2*n)
        {
            System.out.println("Magic Number it is!!!!");
        }
        else
            System.out.println("Not a Magic number");
    }
}
