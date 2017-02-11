/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author pooja
 */
import java.io.*;
import java.util.*;
public class Ll {
    public static void main(String args[]) throws IOException
    {
        LinkedList<String> ll = new LinkedList<String>();
        
        
        ll.add("item1");
         ll.add("item2");
          ll.add("item3");
           ll.add("item4");
           
           System.out.println(ll);
           
           ll.remove("item3");
           System.out.println(ll);
           
           ll.add(3,"hello");
           ll.removeFirst();
           ll.removeLast();
           
           ll.addFirst("fr");
           ll.addLast("sr");
           
           ll.remove(4);
           
           Object first_var = ll.get(0);
           System.out.println(first_var);
           ll.set(0,"changed first item");
           
           
           Iterator i = ll.iterator();
           while(i.hasNext())
           {
               System.out.println(i.next());
           }
    }
    
}
