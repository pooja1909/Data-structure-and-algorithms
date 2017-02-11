/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.util.LinkedHashSet;
import java.util.HashSet;
public class RemoveduplicateChar {
    public static void main(String args[])
    {
     RemoveDuplicate("bananas");
    }
    
    public static void RemoveDuplicate(String str)
    {
        HashSet<Character> hs = new LinkedHashSet<Character>(str.length());
        
        char duplicatechar[] = str.toCharArray();
        for(int i = 0 ; i < duplicatechar.length ; i++)
        {
            hs.add(duplicatechar[i]);
        }
        System.out.print(hs);
        
    }
}
