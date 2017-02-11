/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author pooja
 */
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;
public class GraphPractise {
    
    private int n;
    private LinkedList<Integer> adj[];
    GraphPractise(int v)
    {
        adj = new LinkedList[v];
        for(int i =0 ; i < adj.length; i++)
        {
            adj[i]= new LinkedList();
        }
        
    }
    public void addEdge(int a , int b)
    {
        adj[a].add(b);
    }
    
    public void display()
    {
        
        for(int j = 0 ; j < adj.length ; j++)
        {
                Iterator it = adj[j].listIterator();
                while(it.hasNext())
                {
                    System.out.println(it.next());
                }
        }
        
    }
    
    
    public static void main(String args[])
    {
        GraphPractise g = new GraphPractise(10);
        g.addEdge(0,1);
        g.display();
        
    }
}
