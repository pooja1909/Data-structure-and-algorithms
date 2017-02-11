/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
//import java.util.Iterator;
public class DuplicateChar {
    
    public static void main(String args[])
    {
      //  printDuplicateChar("programming");
        printDuplicateChar("Combination");
        printDuplicateChar("java");
    }
    
    
    
    static void printDuplicateChar(String str)
    {
        char characters[] = str.toCharArray();
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(char ch : characters)
        {
            if(hmap.containsKey(ch) )
            {
                hmap.put(ch,hmap.get(ch)+1);
            }
            else
            {
            hmap.put(ch,1);
        }
        }
        
        Set<Map.Entry<Character,Integer>> entryset = hmap.entrySet();
        for(Map.Entry<Character,Integer> mp : entryset)
        {
            if(mp.getValue()>1)
            {
                System.out.println("The letter " +mp.getKey()+ "  the count is " +mp.getValue());
            }
        }
    }
}
