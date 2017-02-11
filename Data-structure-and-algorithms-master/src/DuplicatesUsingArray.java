/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.util.Arrays;
public class DuplicatesUsingArray {
    public static void main(String args[])
    {
            int[][] test = new int[][]{
            {1, 1, 2, 2, 3, 4, 5},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 1, 1, 1, 1, 1},};
            
            for(int input[]: test)
            {
                System.out.println("Arrays without duplicates"+Arrays.toString(input));
                System.out.println("Arrays without duplicates"+Arrays.toString(removeDuplicates(input)));
            }
            
}
   public static int[] removeDuplicates(int[] numberWithDuplicates)
   {
       Arrays.sort(numberWithDuplicates);
       int result[] = new int[numberWithDuplicates.length];
       
       int prev = numberWithDuplicates[0];
       result[0]=prev;
       
       for(int i=1; i < numberWithDuplicates.length; i++)
       {
           int ch = numberWithDuplicates[i];
           if(prev!=ch)
               result[i]=ch;
           else
               prev = ch;
       }
       return result;
   }
}
