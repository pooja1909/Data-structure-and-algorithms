/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
public class M_Sort {
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the number of elements to be sorted...");
        int n = Integer.parseInt(br.readLine());
        int a[]= new int[n];
        System.out.println("Enter the values of the given:");
        for(int i =0; i<n; i++)
        {
            a[i]= Integer.parseInt(br.readLine());
        }
        
        System.out.println(" The given array is as follows:");
        for(int i=0; i<n ; i++)
        {
            System.out.print(a[i]);
        }
        
        
       int result1[] = new int[n];
       result1 = mergeSort(a);
       
       System.out.println("the sorted array is as follows");
       for(int i=0; i<n ; i++)
        {
            System.out.print(result1[i]);
        }
    }
          
      static int [] mergeSort(int b[])
    {
        int input_length = b.length;
        if(input_length< 2)
        {
        return b;
        }
        int mid ;
        mid = input_length/2;
        int left_array_size= mid ;
        int left_array[] = new int[left_array_size];
        
        for(int i = 0; i <left_array_size;i++)
        {
           left_array[i] = b[i];
        }
        
        int right_array_size= (input_length-mid);
        int right_array[] = new int[right_array_size];
        int x =0;
        for(int j = mid ; j < right_array_size ; j++)
        {
           right_array[x] = b[j];
           x++;
        }
        int result [] = new int[input_length];
        left_array = mergeSort(left_array);
        right_array = mergeSort(right_array);
        result = merge(left_array,right_array);
      return result ;
    }
    
      static int[] merge( int left[], int right[])
     {
         int left_length = left.length;
         int right_length = right.length;
         int result = left_length + right_length;
         int result_length[] = new int[result];
         int i , j , k =0 ;
         
         for(k=0; k < result ; k++)
         {
             for(i=0,j=0;i<left_length&&j<right_length ; i++,j++)
             {
                while(left[i]<right[j])
                {
                   result_length[k] = left[i];
                    k= k+1;
                    i= i+1;
                }
                       result_length[k] = right[j];
                        k = k+1;
                        j= j+1;
             }
             
             if(left[i]<left_length)
             {
                result_length[k] = left[i];
                 k = k+1;
                 i= i+1;
             }
             
             else
             {
                result_length[k] = right[i];
                 k = k +1;
                 j = j +1;
             }
         }
         
         
         return result_length;
     }
}

