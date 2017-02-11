/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_graph;
import java.util.Queue;

/**
 *
 * @author pooja
 */
public class bfs_new {
    
    protected bfs_new origin;
    protected int depth;
    protected boolean visited;
    Queue q ;
    
    public void visit(bfs_new vertex)
    {
        this.origin= vertex;
        if(vertex==null)
            
        {
           this.depth = 0;
        }
        
        else
        {
            this.depth = vertex.depth +1;
            
        }
    }
    
    public void bfs(bfs_new v)
    {
        v.visit(null);
        v.visited = true;
       
        q = new Queue(v);
        q.enqueue(v);
        while(q!=0)
        {
            v = q.dequeue();
        }
        
    }
}
