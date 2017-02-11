/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class Compression {
    public static void main(String args[])
    {
        String str = "abbbbbbbbbbbbdd";
        Compression c = new Compression();
       char ch = c.compress(str);
       System.out.println(ch);
    }
    
   char compress(String str)
    {
        //StringBuilder br = new StringBuilder();
        int count = Integer.MIN_VALUE ;
        int count_char = 0;
        char ch_max_freq = 0 ;
        for(int i = 0 ; i < str.length(); i++)
        {
            count_char++;
            
            if(i+1 >= str.length() || str.charAt(i)!= str.charAt(i+1)){
                
                if(count_char > count)
                {
                    
                    count = count_char;
                    ch_max_freq = str.charAt(i);
                   
                }
                count_char=0;
            }
        }
        return ch_max_freq;
    }
    
}
