/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.io.*;
import java.util.*;
public class String_Buf {
    public static void main(String args[])throws IOException
    {
        String str = "india";
        StringBuilder sb = new StringBuilder(str);
        String[] list={"ab","AN","android","c++","c","oracle","php"};
      Arrays.sort(list);
    //    Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println("sorted array is");
        for(String s:list){
            System.out.println(s);      }
      //  sb.reverse();
      //  sb.append("love");
        System.out.println("the searching word in array is"+
        Arrays.binarySearch(list,"AB"));
            System.out.println("The referenced objects are equal"+sb);
        if(str.equals(sb.toString()))
            System.out.println("The given contents are same");
    }
    
}
