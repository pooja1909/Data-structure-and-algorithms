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
public class SingleTonClass {
    
    public static void main(String args[])
    {
        Abc obj = Abc.getInstance();
        Abc obj1 = Abc.getInstance();
    }
}
class Abc
{
    
   static Abc obj = new Abc();
   private Abc()
   {
       
   }
   public static Abc getInstance()
   {
       return obj;
   }
}