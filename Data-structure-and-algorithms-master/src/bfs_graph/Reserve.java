/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_graph;

/**
 *
 * @author pooja
 */


class Reserve1 implements Runnable{
    int available =1;
    int wanted ;
    Reserve1(int i)
    {
        wanted = i;
    }
}

synchronized public void run()
{
System.out.println("Available:"+available);
if(available >= wanted)
{
String name = Thread.currentThread().getName();
System.out.println(wanted+"Berths reserved for"+name);
}
}







public class Reserve{
    public static void main(String args[])
            {
                Reserve1 obj = new Reserve1(1);
                Thread t1 = new Thread(obj,"Ravi");
                Thread t2 = new Thread(obj , "Manoj");
                t1.start();
                t2.start();
            }
}
