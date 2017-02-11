/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class StringPractise {
    public static void main(String args[])
    {
        String s1 = "pooja";
        StringBuffer sb = new StringBuffer(s1);
        String s2 = sb.reverse().toString();
        System.out.print(s2);
        String s3 = reverse(s1);
    }
    
    public static String reverse(String s1)
    {
        StringBuilder bldr = new StringBuilder();
        char chr[]=s1.toCharArray();
        for(int i= s1.length()-1; i > 0 ;i--)
        {
            bldr.append(chr[i]);
        }
        return  bldr.toString();
    }
}
