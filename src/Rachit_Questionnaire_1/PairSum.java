package Rachit_Questionnaire_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class PairSum
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size of array");
        int n=sc.nextInt();

        TreeMap<Integer,Integer> t=new TreeMap<>();
        System.out.println("Enter Array Elements");
        for(int i=0;i<n;i++)
        {
            int a= sc.nextInt();
            t.put(a,t.getOrDefault(a,0)+1);

        }
        int key= sc.nextInt();
        ArrayList<ArrayList<Integer>>a=new ArrayList<>() ;
       while (t.size()>0)
       {
           int aa=t.firstKey();
           if(t.containsKey(key-aa))
           {
               boolean check= aa != key - aa || t.get(aa) != 1;
               if (check) {
                   ArrayList<Integer> x = new ArrayList<>();
                   x.add(aa);
                   x.add(key - aa);
                   a.add(x);
               }

           }
           t.remove(aa);
       }
        System.out.println(a);


    }
}
