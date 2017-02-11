/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.io.*;
public class Stand_Matrix {
    
    public static double[][] Random_gen(int n)
    {
        double random_sqr_matrix[][]= new double[n][n];
        
        for (int i = 0; i < n; i++) {   

            for (int j = 0; j < n; j++) {
               Double r = Math.random()*n; 
               random_sqr_matrix[i][j] = r;
              //  random_sqr_matrix[i][j] = Math.random();
            }

        }

        return random_sqr_matrix;
    }
        
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the order for first and second matrix");
        int m = Integer.parseInt(br.readLine());
        double p[][]= Random_gen(m);
        double q[][] = Random_gen(m);
        double r[][]= new double[m][m];
        
        long start_time = System.currentTimeMillis();
         for(int i =0 ; i < m ; i++)
       {
           for(int j =0; j < m ; j++)
           {
               r[i][j]=0;
               for(int k =0 ; k < m ; k++)
               r[i][j] += p[i][k]*q[k][j];
           }
       }
         long end_time = System.currentTimeMillis();
         long diff = end_time - start_time;
         System.out.println("the difference:"+diff);
         
         for(int i = 0; i < m ; i++)
        {
            for(int j =0 ;j < m ; j++)
            
                System.out.print(r[i][j]+" ");
                 System.out.println();
            
        }
         
   
        
    }
    
}

