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
import java.util.HashMap;
public class map1 {
    
    public static void main(String args[])
    {
    Map<Integer,String> map1 = new HashMap<>();
    Integer i = new Integer(123);
    String s = "hello";
    map1.put(i,s);
    String value_s = map1.get(i);
    System.out.println(value_s);
}
}
