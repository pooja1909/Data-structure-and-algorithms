/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

class TestClass {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements:");
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        System.out.println("enter the elements in an array:");
        for(int i=0;i<N;i++)
        {
            a[i]= Integer.parseInt(br.readLine());
        }
        for(int i=0;i<N;i++)
        {
            System.out.println(a[i]);
        }
        
        
        for(int i=0;i<N;i++)
        {
        	for(int k=2;k<a[i];k++)
        	{
        		if(a[i]%k==0)
        		{
        			  if(!check(k,a))
                                  {
                                      System.out.println("the elements:"+a[i]+" ");
                                      break;
                                  }
        			
        		}
                        
                        else
                            if(a[i]%k!=0)
                        {
                            System.out.print("The elements which are prime:"+a[i]);
                            break;
                        }
        	}
        }
         
    }
    
    public static boolean check(int k , int a[])
    {
        
    	for(int i = 0; i < a.length;i++){
    		if(a[i]==k)
    		{
    			return true;
    			
    		}
    		
    	}
    	return false;
    }
}
