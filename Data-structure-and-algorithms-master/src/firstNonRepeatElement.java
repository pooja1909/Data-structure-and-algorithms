/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
public class firstNonRepeatElement {
    public static void main(String args[])
    {
        printFirstUniqueElement("Swiss");
        printFirstUniqueElement("hello");
    }
    
 static void printFirstUniqueElement(String str)
    {
        char uniqueElement[] = str.toCharArray();
        Map<Character,Integer> mp = new LinkedHashMap();
        
        for(char ch: uniqueElement)
        {
            if(mp.containsKey(ch))
            {
                mp.put(ch,mp.get(ch)+1);
                
            }
            
            else
            {
                mp.put(ch,1);
            }
        }
        
        Set<Map.Entry<Character,Integer>> entryset = mp.entrySet();
        for(Map.Entry<Character,Integer> m : entryset)
        {
            if(m.getValue()==1)
                System.out.println("the unique char is :" +m.getKey()+ "the value is" +m.getValue());
        }
    }
}
