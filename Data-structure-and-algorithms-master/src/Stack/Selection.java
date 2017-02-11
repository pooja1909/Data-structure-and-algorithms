/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
public class Selection {
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
        
        for(int i =0 ; i<n; i++)
        {
            int min = i;
            
            for(int j=i+1;j<n-1;j++)
            {
                if(a[j] < a[min])
                    min = j;
            }
            
            int temp;
            temp = a[min];
            a[min]= a[i];
            a[i]=temp;
            
        }
        
       System.out.println("the sorted array is as follows");
       for(int i=0; i<n ; i++)
        {
            System.out.print(a[i]);
        }
    }
    
    
}
