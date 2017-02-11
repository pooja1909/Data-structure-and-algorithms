/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;

public class Hash
{
  public static void main(String args[])
  {
      HashMap hm = new HashMap();
      
      hm.put(1,"hello");
      hm.put(2,"bye");
      hm.put(3, "sky");
      hm.put(4,"cloud");
      
      System.out.println("Print the values before the change:"+hm);
      
      String prev_value =(String) hm.put(3,"sorry");
      
      System.out.println("Print the values after the change:" +prev_value);
      
       System.out.println("Print the values after the change:"+hm);
      
  }
}