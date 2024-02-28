package Mock_test1;

import java.util.Scanner;

public class IntToBinary {
    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        int a= Sc.nextInt();  // input the number
        StringBuilder bin= new StringBuilder();  // creating a string builder object
        while(a>0)
        {
            bin.insert(0, a % 2);  // prepending the last most bit to the bin
            a/=2;
        }
        System.out.println(bin); // printing the bin
        
    }
}
