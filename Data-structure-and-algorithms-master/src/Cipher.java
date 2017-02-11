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
public class Cipher {
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the string value");
        String str = new String(br.readLine());
        int len = str.length();
        System.out.println("enter the offset value:");
        String str1 = new String(br.readLine());
        int offset = Integer.parseInt(str1);
        String ans = cipher(str,offset);
        System.out.println("the encrypted value is"+ans);
    }
        
  static String cipher(String sen, int offset) {  
      String s = " ";
        for(int i = 0; i<sen.length(); i++)
        {
             char ch = (char)(sen.charAt(i));
             if(ch >= 'A' && ch <= 'Z')
             {
               s += (char)((ch - 'A' + offset) % 26 +'A');
                 
             }
             else if(ch >= 'a' && ch <= 'z')
             {
                 s +=(char)((ch -'a' + offset) % 26 +'a');
             }
                     else
             {
                 s += ch;
             }
        }
        return s;

    }
}
    
