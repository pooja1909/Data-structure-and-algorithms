/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.util.LinkedList;
import java.util.ListIterator;
import java.io.*;
/**
 *
 * @author pooja
 */

public class Graph_Test {
   
    private LinkedList<Integer> adj_list[];
    private int no_of_vertices;
    
    Graph_Test(int n)
    { 
        no_of_vertices =n;
        adj_list = new LinkedList[n];
        for(int i = 0 ; i<n; i++)
            adj_list[i]= new LinkedList<Integer>();
            
    }
    
    public void addEdge(int a, int b)
    {
        adj_list[a].add(b);
    }
    
    public void display()
    {
        for(int i=0;i<adj_list.length;i++){
            ListIterator li = adj_list[i].listIterator();
            while(li.hasNext()){
                System.out.print(li.next());
            }
            System.out.println("");
        }
        
        
    }
    public static void main(String args[])throws IOException
    {
        Graph_Test gt = new Graph_Test(5);
        
        
        gt.addEdge(0,1);
        gt.addEdge(0,2);
        gt.addEdge(0,3);
        gt.addEdge(3,4);
        
        gt.display();
        
        
    }
}
