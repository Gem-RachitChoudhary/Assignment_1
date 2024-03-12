package Rachit_Questionnaire_1;

import java.util.*;
public class Anagram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First String ");
        String s=sc.nextLine();
        System.out.println("Enter Second String");
        String t=sc.nextLine();
//      int hash[]=new int[26] if string contains only english alphabets
        int hash[]=new int[257];  // since string can any character
        for(int i=0;i<s.length();i++)
        {
            hash[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++)
        {
            hash[t.charAt(i)]--;
        }
        for(int i=0;i<257;i++)
        {
            if(hash[i]!=0)
            {
                System.out.println("Not an anagrams");
                return;
            }
        }
        System.out.println("Both strings are anagrams");
    }
}
