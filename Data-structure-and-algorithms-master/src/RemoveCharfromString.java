/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class RemoveCharfromString {
    public static void main(String args[])
    {
        String str = "abcdefddo";
//       String RemovedCharString= removeChar(str,'c');
        String RemovedCharString= recurRemoveChar(str,'d');
       System.out.println(RemovedCharString);
    }
    
    /*
    static String removeChar(String str,char ch)
    {
        // char findChar[]= str.toCharArray();
        StringBuilder br = new StringBuilder();
         char removeChar[] = str.toCharArray();
        for(int i = 0 ; i < removeChar.length;i++)
        {
            if(ch!=removeChar[i])
             br.append(removeChar[i]);
             
            
        }
         // first find the index of the given ch in a string
        // remove the characters from the given positions
        return br.toString();
       
    }
      */
    
    static String recurRemoveChar(String str, char ch)
    {
     int index = str.indexOf(ch);
     if(index==-1)
     {
         return str;  
    }
     
     return recurRemoveChar(str.substring(0,index)+str.substring(index+1,str.length()), ch);
    }
}
