/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
public class UNIQUE{
    public static void main(String args[])
    { 
        String s = "swiss";
        char uniqueElement[] = s.toCharArray();
       // char char1;
       HashMap<Character,Integer> mp = new HashMap();
        
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
        /*
        Set<Map.Entry<Character,Integer>> entryset = mp.entrySet();
        for(Map.Entry<Character,Integer> m : entryset)
        {
            if(m.getValue()==1)
                System.out.println("the unique char is :" +m.getKey()+ "the value is" +m.getValue());
        }
                */
        for(int i = 0 ; i < s.length(); i++)
        {
            char ch1  = s.charAt(i);
            if(mp.get(ch1)==1)
            {
                System.out.println(ch1);
            }
        }
        
       
    }
}
