/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author pooja
 */


public class Graph
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter the number of nodes:");
        String input = new String(br.readLine());
          int nodes = Integer.parseInt(input);
          int a[][]=new int[nodes][nodes];
        int visted[]=new int[nodes];
        System.out.println("enter the values of nodes");
        for(int i=0; i<nodes ; i++)
        {
        
        String input1 = new String(br.readLine());
        }
        
        System.out.println("enter the adjustancy matrix values");
        for(int i =0 ; i < nodes ; i++)
        {
            for(int j=0; j < nodes ; j++)
            {
                if(i==j)
                {
                    a[i][j]=0;
                }
                else
                {
                   
                     a[i][j]=a[j][i]= Integer.parseInt(br.readLine());
                }
                
            }
        }
        for(int i =0 ; i < nodes ; i++)
        {
            for(int j=0; j< nodes ; j++)
            {
               System.out.print(a[i][j]);
            }
        System.out.println();
        }       
    }
            
}