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
public class Palindrome {
    public static void main(String args[])throws IOException
    {
        String str = "pooja";
        int len = str.length();
        boolean flag = false;
        for(int i =0,j=len-1;i<len/2;i++,j--)
        {
            if(str.charAt(i)==str.charAt(j))
            {
                flag=true;
                break;
            }
            }
    
    if(flag==true)
    {
        System.out.println("the given string " +str+ "is a palindrome");
    }
    else
    {
        System.out.println("the string" +str+ "is not a palindrome");
    }
}
}