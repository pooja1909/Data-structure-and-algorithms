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
import java.util.*;

public class Graph_Imp {

    private int vertices;
    LinkedList<Integer> adj[];

    Graph_Imp(int v) {
        vertices = v;
        adj = new LinkedList[vertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
    }

    public void display() {
        for (int i = 0; i < adj.length; i++) {
            Iterator it = adj[i].listIterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }

            System.out.println("");
        }
    }

    public void bfs(int s) {
        boolean visited[] = new boolean[vertices]; // 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s + " ");
            Iterator<Integer> it = adj[s].listIterator();

            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
    }

    public void dfs_Util(int s, boolean visited[]) {
        visited[s] = true;
        System.out.println(s + " ");

        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                dfs_Util(n, visited);
            }
        }

    }

    public void dfs(int s) {

        boolean visited[] = new boolean[vertices];

        dfs_Util(s, visited);

    }

    boolean isCyclicUtil(int i, boolean visited[], boolean resstack[]) {
        if (visited[i] == false) {
            visited[i] = true;
            resstack[i] = true;
        }

        Iterator<Integer> i1 = adj[i].listIterator();
         
        while (i1.hasNext()) {
            int n = i1.next();
            System.out.println(n);
            if (!visited[n] && isCyclicUtil(n, visited, resstack)) {
                return true;
            } else if (resstack[n]) {
                return true;
            }

        }
        resstack[vertices] = false;
        return false;
    }
    
   

    boolean IsCyclic() {

        boolean visited[] = new boolean[vertices + 1];
        boolean resstack[] = new boolean[vertices + 1];

        for (int i = 1; i <= vertices; i++) {
            visited[i] = false;
            resstack[i] = false;
        }

        for (int i = 1; i <= vertices; i++) {
            if (isCyclicUtil(i, visited, resstack)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertices:");
        int i = sc.nextInt();
        Graph_Imp gi = new Graph_Imp(i);
        gi.addEdge(1, 2);
        gi.addEdge(1, 4);
        gi.addEdge(1, 3);
        gi.addEdge(2, 5);

        gi.display();
//        gi.bfs(1);
        //      gi.dfs(1);

        if (gi.IsCyclic()) {
            System.out.println("the graph contains cycle");
        } else {
            System.out.println("the graph does not contain any cycle");
        }
    }
}
