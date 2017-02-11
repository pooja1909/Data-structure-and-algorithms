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
public class ran_num {
    
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
        System.out.println("enter the value for row of the first matrix");
        int m = Integer.parseInt(br.readLine());
        double p[][]= Random_gen(m);
        
         for(int i = 0; i < m ; i++)
        {
            for(int j =0 ;j < m ; j++)
            
                System.out.print(p[i][j]+" ");
                 System.out.println();
            
        }
   
        
    }
    
}

