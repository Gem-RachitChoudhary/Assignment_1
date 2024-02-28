package Mock_test1;

import java.io.*;
import java.util.*;

public class wordCount {
    static  class pair
    {
        String c;
        int ct;
        pair(String c, int ct)
        {
            this.c=c;
            this.ct=ct;
        }
    }
    public static void main(String[] args) {
//        try {
//            FileWriter myWriter = new FileWriter("input.txt");   // Creating the object of FileWriter with file path
//            myWriter.write("here we have the mock test 1 of Java programming language" +
//                    "at the gemini solutions ");     //  writing the content in the file
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        }
//        catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
        TreeMap<String , Integer> t=new TreeMap<>();
        try {
            File obj = new File("input.txt");
            Scanner reader = new Scanner(obj);

            while (reader.hasNext()) {
                String data = reader.next(); // reading the file word by word
                data= data.toLowerCase();  // converting the word into lowercase format
              t.put(data, t.getOrDefault(data,0)+1);   // adding the word into the data if not exist , otherwise just increasing it frequency
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        System.out.println(t);
        PriorityQueue<pair>p=new PriorityQueue<>((a,b)->(a.ct==b.ct)?(a.c.compareTo(b.c)):(b.ct-a.ct));
        // priority queue that sort the pair according to the frequency but if it gets equal then sort according to the string
        while(t.size()>0)
        {
            p.offer(new pair(t.firstKey(),t.get(t.firstKey())));
            t.remove(t.firstKey());
        }

        while (!p.isEmpty())
        {
            pair x=p.poll();
            System.out.println(x.c+" "+x.ct); // printing the queue elements
        }



    }
}
