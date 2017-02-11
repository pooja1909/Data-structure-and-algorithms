/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */
public class LongestSubsequence {
    public int calculate(char str_char[])
    {
       
        int str_length = str_char.length;
        int T[][]= new int[str_length][str_length];
        for(int i=0 ; i < str_length ; i++)
        {
            T[i][i] = 1;
        }
        
        for(int len = 2 ; len <= str_length ; len++)
        {
            for(int i=0 ; i< str_length-len ; i++)
            {
                 int j = i + len - 1;
                if(len==2 && str_char[i]==str_char[j])
                {
                    T[i][j]=2;
                }
                else if(str_char[i]==str_char[j])
                {
                    T[i][j] = T[i+1][j-1]+2 ;
                }
                
                else
                {
                    T[i][j] = Math.max(T[i+1][j],T[i][j-1]);
                }
        }
            
        
    }
    return T[0][str_length-1];
            }
    
    public static int cal_len_recur
    (char str[],int start, int len)
            
    {
        if(len ==1){
            return 1;
        }
        if(len==0){
            return 0;
        }
        if(str[start]==str[start+len-1]){
                return 2+cal_len_recur(str,start+1,len-2);
        }
        else
        {
            return Math.max(cal_len_recur(str,start+1,len-1),cal_len_recur(str,start,len-1));
        }
    }
    
    public static void main(String args[])
    {
        LongestSubsequence ls = new LongestSubsequence();
        String str = "agbdba";
        int r1 = ls.cal_len_recur(str.toCharArray(),0,str.length());
        int r2 = ls.calculate(str.toCharArray());
        System.out.print(r1 + " " + r2);
    }
}