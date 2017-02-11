/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */

/*

import java.io.*;
public class Str_upper_reverse {
   public static void main(String args[]) throws IOException
           
   {
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String s = new String(br.readLine());
       
       StringBuilder sb = new StringBuilder();
       for(String string : s.split(" ")){
        String s1 = new StringBuilder(string).reverse().toString().toLowerCase();
        s1 = Character.toUpperCase(s1.charAt(0))+ s1.substring(1);
        sb.append(s1).append(" ");
        
    }
       System.out.println(sb.toString()); 
   }
      
}
*/

import java.io.*;
public class Str_upper_reverse

{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original_string = new String(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        for(String string : original_string.split(" "))
        {
            String reverse_str = new StringBuffer(string).reverse().toString().toLowerCase();
            String first_char_upper = Character.toUpperCase(reverse_str.charAt(0))+ reverse_str.substring(1);
            sb.append(first_char_upper).append(" ");
            
        }
        
        System.out.print(sb.toString());
        
    }
}


















