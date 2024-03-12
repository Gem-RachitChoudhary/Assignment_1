package Rachit_Questionnaire_1;

import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class PairSum
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        TreeMap<Integer,Integer> t=new TreeMap<>();
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
