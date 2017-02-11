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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
public class Selection1 {
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the number of elements to be sorted...");
        int n = Integer.parseInt(br.readLine());
        Double a[]= new Double[n];
        System.out.println("Enter the values of the given:");
        for(int i =0; i<n; i++)
        {
            a[i]= Double.parseDouble(br.readLine());
        }
         
        Double max_number = Double.MIN_VALUE;

        for(Double val : a) {
            if(val > max_number) {
                max_number = val;
		    }
        }

        System.out.println("Largest number in array is : " +max_number);
        
        
        Double min_number = Double.MAX_VALUE;

        for(Double val : a) {
            if(val < min_number) {
                min_number = val;
		    }
        }

        System.out.println("smallest number in array is : " +min_number);

      
        }
       
    }
  