/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class ValidShuffle {

    public static void main(String args[]) {
        String str1 = "abc";
        String str2 = "def";
        String str3 = "adebcf";
        boolean flag = checkValidShuffle(str1, str2, str3);
        
            System.out.println(flag ? "valid" : "invalid");
    }

    public static boolean checkValidShuffle(String str1, String str2, String str3) {
        boolean flag1 = false;
        if (str3.length() != str1.length() + str2.length()) 
            return flag1;
       
        if (str3.equals(str1 + str2) || str3.equals(str2 + str1)) 
            return true;
        
        
        if(str3.charAt(0)!=str1.charAt(0) && str3.charAt(0)!=str2.charAt(0))
            return flag1;
        
        if (str3.charAt(0)==str1.charAt(0) && checkValidShuffle(str1.substring(1), str2, str3.substring(1)))
            return true;
        
        if (str3.charAt(0)==str2.charAt(0) && checkValidShuffle(str1, str2.substring(1), str3.substring(1)))
            return true;
            
        
        return flag1;
    }
}
