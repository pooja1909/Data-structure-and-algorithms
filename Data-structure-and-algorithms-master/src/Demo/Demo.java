/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

/**
 *
 * @author pooja
 */
public class Demo {
    
    public static void main(String args[])
    {
        int a[]={7,6,2,1,4,5,8};
        
      
        int min_i = Calculate(a);
        System.out.println("the smallest element:"+min_i);
    }
    public static int Calculate(int a[])
    {
      int min_val = 0;
      int min_index = 0;
        
        int j = a.length-1;
        for(int i=0;i<a.length;i++)
        {
         
         while(j>=0 && a[j]> a[i])
         {
             j--;
             
         }
         
         min_val = a[j];
         min_index = j;
             
        }
        
        
        return min_val;
    }
    
}
