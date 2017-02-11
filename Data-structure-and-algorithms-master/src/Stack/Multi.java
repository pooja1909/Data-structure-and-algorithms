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
public class Multi {
    
    
    
    public static void main(String args[])throws IOException
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the value for row of the first matrix");
        int m = Integer.parseInt(br.readLine());
        System.out.println("enter the value for column of the first matrix");
        int n = Integer.parseInt(br.readLine());
        System.out.println("enter the value for column of the second matrix");
        int p = Integer.parseInt(br.readLine());
        double a[][]= new double[m][n];
        double b[][]= new double[n][p];
        double c[][]= new double[m][p];
        System.out.println("enter the first matrix");
        for(int i = 0; i < m ; i++)
        {
            for(int j =0 ;j < n ; j++)
            {
                a[i][j] = Double.parseDouble(br.readLine());
            }
        }
         for(int i = 0; i < m ; i++)
         {
            for(int j =0 ;j < n ; j++)
            
                System.out.print(a[i][j]+" ");
                 System.out.println();
         }
        
         System.out.println("enter the second matrix");
                for(int i = 0; i < n ; i++)
        {
            for(int j =0 ;j < p ; j++)
            {
                b[i][j] = Double.parseDouble(br.readLine());
            }
        }
         for(int i = 0; i < n ; i++)
        {
            for(int j =0 ;j < p ; j++)
            
                System.out.print(b[i][j]+" ");
                 System.out.println();
            
        }
         
        System.out.println("calculating the resultant matrix:");
        
       for(int i =0 ; i < m ; i++)
       {
           for(int j =0; j < p ; j++)
           {
               c[i][j]=0;
               for(int k =0 ; k < n ; k++)
               c[i][j] += a[i][k]*b[k][j];
           }
       }
       long end_time = System.currentTimeMillis();
         long diff = end_time - start_time;
         System.out.println("the difference:"+diff);
         for(int i = 0; i < m ; i++)
        {
            for(int j =0 ;j < p ; j++)
            
                System.out.print(c[i][j]+" ");
                 System.out.println();
            
        }
         
         
       
        
    }
    
    
}
