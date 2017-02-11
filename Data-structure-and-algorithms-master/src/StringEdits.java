/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class StringEdits {
    public static void main(String args[])
    {
        String first = "pale";
        String second = "ple";
        Boolean flag = false;
        flag = OneEditAway(first,second);
    }
    
    static boolean OneEditAway(String first, String second)
    {
        if(Math.abs(first.length()- second.length()) > 1)
        {
            return false;
        }
        
        String s1 = first.length()>second.length()? first : second ;//get the shorter string
        String s2 = second.length()> first.length()? second: first     ;                    //get the longer string
        
       int index1=0;
       int index2= 0;
       
       boolean foundDifference = false;
       
       while(index2 < s2.length() && index1 < s1.length())
       {
           if(s1.charAt(index1)!=s2.charAt(index2))
           {
               if(foundDifference)return false;
               
               foundDifference = true;
               
               if(s1.length()==s2.length()){
                   index1++;
               }
       
           }   
           
           
           else
           {
               index1++;
           }
           
           
           index2++;
       }
       
        return true;
    }
}
