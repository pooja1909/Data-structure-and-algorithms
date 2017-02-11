/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.io.IOException;

/**
 *
 * @author pooja
 */
class Stack1 {
    
    int top;
    char a[]=new char[10];
    //Integer ab[] = new Integer[100];
    Stack1()
    {
        top=-1;
    }
    
    public void push(char x)
    {
        if (top==9)
            System.out.println("The stack is full");
        else
        {
        top++;
        a[top]=x;   
        
        
        
        }           
    
    }
    public char pop()
    {
        char topelement = 0;
            topelement=a[top];
            top--;
            System.out.print(topelement);
        return topelement;
    }
    
    public char peek()
    {
      //  int q=p;
        if (top==-1)
        {   
            return '0';
        }
        else
        {
            return a[top];
        }  
    }
    
    
}

public class Stack
{
    Stack1 st = new Stack1();
     public static void main(String args[])throws IOException
    {
       
        
    //    st.push(10);
    //    st.push(5);
     //   st.pop();
      //  System.out.println(st.peek());
       // System.out.println(st.peek());
      //  int p1 = st.search(10);
      //  System.out.print(p1);
       // st.pop;
        
       // System.out.println(st.peek());
        String userInput= "a+b";
        new Stack().Postfix(userInput);
        
       
    } 
 
     public void Postfix(String s2)
     {
         
         
         for(int i=0;i<s2.length();i++)
         {
             char s1=0;
             s1= s2.charAt(i);
             
           //  System.out.print(s1); // debugging purpose.
            
             if(s1=='+'||s1=='-'||s1=='*'||s1=='/'||s1=='(')
             {
                 char stack_element=st.peek();
                 
                if((stack_element=='+'|| stack_element=='-') && (s1=='*'))
                 {
                     st.push(s1);
                   
                 }
                 else
                 {
                    if(s1!='\0')
                        
                    {
                        
                    System.out.print(st.pop());
                    st.push(s1);
                  
                 }
                 else
                    {
                        System.out.print(st.pop());
                    }
                 
                  }
             }
             else
             {
                System.out.print(s1);
                
                
             }
             
            
         }
         
     }

  
    }