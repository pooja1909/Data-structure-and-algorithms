/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.util.List;
import java.util.ArrayList;
public class Radix {
    
    void radixsort(int input[])
    {
        final int bucket = 10;
        List<Integer> li[] = new ArrayList[bucket];
        for(int i = 0; i < li.length ; i++)
        {
            li[i]= new ArrayList<Integer>();
        }
        
    
    boolean maxlen = false;
    int temp = -1,
    placement = 1;
            while(!maxlen)
            {
                maxlen =true;
               for(Integer i : input)
               {
                   temp = i/placement;
                   li[temp % bucket].add(i);
                   if(maxlen && temp > 0){
                       maxlen = false;
                   }
               }
            }
            
            int a =0;
            for(int b = 0 ; b < bucket; b++)
            {
                for(Integer i : li[b])
                {
                    input[a++]=i;
                }
                li[b].clear();
            }
            placement = placement*bucket; // move to thenext number
}
    
    public static void main(String args[])
    {
        Radix rd = new Radix();
        int a[] = {20,33,233,44,566,777,898};
        rd.radixsort(a);
        
        
    }
}