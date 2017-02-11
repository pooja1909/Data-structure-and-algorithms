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
class A implements Runnable
{
    public void run()
    {
        for(int i=1; i <=5 ; i++)
        {
            System.out.println("value="+i);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
                    {
                        System.out.println(e);
                    }
        }
    }
}






class Threadimp {
    public static void main(String args[])
    {
        A a_OBJ = new A();
        Thread t1 = new Thread(a_OBJ);
        t1.start();
        System.out.println("started");
    }

    private void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
