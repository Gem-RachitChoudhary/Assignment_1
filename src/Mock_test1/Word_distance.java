package Rachit_Questionnaire_1;

import java.util.Scanner;

public class Word_distance {
    public static void main(String[] args) {
        Scanner asc=new Scanner(System.in);
        String s=asc.nextLine();
        String word1=asc.next();
        String word2=asc.next();
        s=s.replaceAll("\\s+"," ").trim();
        int min=Math.min(s.indexOf(word1),s.indexOf(word2));
        int max=Math.max(s.indexOf(word1),s.indexOf(word2));
        int ans=0;

        while(min<=max)
        {
            if(s.charAt(min)==' ')
                ans++;
            min++;
        }
        System.out.println(ans);


    }
}
