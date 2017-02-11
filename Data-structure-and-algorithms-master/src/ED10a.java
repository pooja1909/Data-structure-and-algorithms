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
class ED10a1 implements Serializable{
    
    int num;
    String name;
    int ePan;
    ED10a1()
    {
        num = 10;
        name = "kumar";
        ePan = 1122;
        
    }
    
    void showInfo()
    {
        System.out.println("enum = "+num +"name="+name  + "ePan="+ePan);
    }
}

class ED10a
{
    public static void main(String agrs[])throws IOException
    {
        ED10a a = new ED10a();
        try
        {
        FileOutputStream fr = new FileOutputStream("employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fr);
        out.writeObject(a);
        out.close();
        fr.close();
        System.out.println("ED10A Serialization complete");
        
    }
        catch(Exception i)
                {
                    System.out.println(i);
                }
   
   
    try
    {
        FileInputStream input = new FileInputStream("employee.ser");
        ObjectInputStream oi = new ObjectInputStream(input);
       a= (ED10a)oi.readObject();
       oi.close();
       input.close();
        
    }
    
     catch(Exception i)
             {
                 System.out.println(i);
             }
}
}