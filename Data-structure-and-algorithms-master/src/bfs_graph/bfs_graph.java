/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.ArrayList;


/**
 *
 * @author pooja
 */
public class bfs_graph {
    int a;
     private ArrayList<Integer> array_list[];
    bfs_graph(int vertices)
    {
       int b = vertices;
       array_list= new ArrayList[vertices];
       for(int i = 0; i <array_list.length;i++)
       {
         array_list[i]= new ArrayList<Integer>();
       }
    }
    
    public void addEgde(int a, int b)
    {
        array_list[a].add(b);
    }
}
