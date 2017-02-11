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
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;
public class AL {
    public static void main(String arg[])throws IOException
    {
        ArrayList<String> al = new ArrayList<String>();
        al.add("bangalore");
        al.add("mumbai");
        al.add("hyd");
        
        System.out.println("the values are:"+al);
        
        ArrayList<String> al2 = new ArrayList<String>(al.subList(1,2));
        System.out.println("the values are:"+al2);
        
        List<String> list = al.subList(1,2);
        
        ArrayList<String> al3 = new ArrayList<String>();
        al3.addAll(al);
        al3.addAll(al2);
        
        System.out.println("sublist stored"+al3);
        
        for(String temp : al)
       
      al3.add(al2.contains(temp) ? "yes" : "no");
        System.out.println(al3);
        
        
        Iterator itr = al3.iterator();
        
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        
        Collections.sort(al3);
        
        
        String arr[]= {"ABC","BCD","BCV"};
        
        ArrayList<String> citylist = new ArrayList<String>(Arrays.asList(arr));
        System.out.println(citylist);
        
        String arr1[]= new String[citylist.size()];
        
        for(int i = 0 ; i < arr1.length; i++)
            arr1[i] = citylist.get(i);
        
        for(String s : arr1)
        {
            System.out.println(s);
        }
        String ar1[] = citylist.toArray(new String[citylist.size()]);
        
    }
}
