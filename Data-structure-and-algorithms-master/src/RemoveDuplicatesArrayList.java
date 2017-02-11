/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class RemoveDuplicatesArrayList {
    public static void main(String args[])
    {
     List<String> duplicatelist = (List<String>) Arrays.asList("Android" , "Android", "iOS", "Windows mobile");
     
     System.out.println(""+duplicatelist.size());
     
     HashSet<String> nonduplicate = new HashSet<String>(duplicatelist);
     
     List<String> uniquelist = new ArrayList<String>(nonduplicate);
     
     System.out.println(""+uniquelist.size());
     
    }
}
