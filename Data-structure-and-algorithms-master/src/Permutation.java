/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class Permutation {
    public static void main(String args[])
    {
        permutation("123");
    }
    
    public static void permutation(String s)
    {
        permutation(" ",s);
    }
    
    private static void permutation(String perm, String str)
    {
        if(str.length()<=0)
            System.out.println(perm+str);
        else
        {
            for(int i = 0 ; i <str.length();i++)
            {
             permutation( perm+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));   
            }
        }
    }
}
