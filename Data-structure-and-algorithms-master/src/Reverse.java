/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class Reverse {
    public static void main(String args[])
    {
        String str = "Sony is going to introduce Internet TV soon"; // original string
        System.out.println("the orginal string is "+str);
        
        
        //using StringBuffer
        
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();
        System.out.println("the reverse string using stringbuffer  "+reverse);
        
       String reverseStr = reverse1(str);
       System.out.println("the reverse string using stringbuilder/iterative manner  "+reverse);
        
     String  reverseStr_recur = reverseRecursively(str);
        System.out.println("Reverse String in Java using Recursion: " + reverseStr_recur);
    }
    static String reverse1(String str1)
    {
        StringBuilder bldr = new StringBuilder();
        char strChars[] = str1.toCharArray();
        for(int i = strChars.length-1; i >= 0 ; i--)
        {
            bldr.append(strChars[i]);
        }
        
        return bldr.toString();
    }
    static String reverseRecursively(String str1)
    {
        if(str1.length()<2)
        {
            return str1;
        }
        
        return reverseRecursively(str1.substring(1)) + str1.charAt(0);
        
        
    }
    
}
