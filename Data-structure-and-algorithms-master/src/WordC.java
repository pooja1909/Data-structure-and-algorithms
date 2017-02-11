/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.io.*;
import java.util.HashSet;
import java.util.Set;
public class WordC {
    public static void main(String args[])throws IOException
    {
      int wordcount=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println("Enter the input text in which unique words are to be counted:");
        String inputString=new String(br.readLine());
        String inputArray[];
        char sp[]= {',','.','!','?',':','"','<','>'};
        String line[]= new String[10000]; // 2.	Text will not be longer than 10000 words
        line = inputString.split(" "); // 1.	Words separated by hyphen is considered as one word
         int len = line.length;
         System.out.println(len);
        for(int i =0; i <len;i++)
        {
           System.out.print(line[i]);
        } 
        HashSet<String> hs = new HashSet<String>();
        
        for(int j=0;j<len;j++)
        {
            hs.add(line[j]);
        }
         System.out.println("wordcount"+hs.size());
       

        }
     
    }
    
