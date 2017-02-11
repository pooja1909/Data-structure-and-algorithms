/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class ReverseWords {
    public static void main(String args[])
    {
        String str = "Sony is going to introduce Internet TV soon"; // original string
        System.out.println("the orginal string is "+str);
        
       String reverse_string= Reverse(str);
       System.out.println(reverse_string);
    }
    
    public static String Reverse(String sentence)
    {
        List<String> Words = Arrays.asList(sentence.split(" "));
        Collections.reverse(Words);
        System.out.println(Words);
        StringBuilder sb = new StringBuilder(sentence.length());
        
        for(int i = 0; i < Words.size() ; i++)
        {
            sb.append(Words.get(i));
            sb.append(' ');
        }
        
        return sb.toString();
    }
}
