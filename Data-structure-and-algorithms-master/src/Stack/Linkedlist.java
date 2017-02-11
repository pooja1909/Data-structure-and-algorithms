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
class Linkedlist {
    Node head;
    
  static class Node
    {
        int data;
        Node Next;
        Node(int i)
        {
            data = i;
            Next=null;
        }
    }
    
  public void printList()
  {
      Node n = head;
      while(n!=null)
      {
          System.out.print(n.data+"");
          n= n.Next;
      }
  }
    
    public static void main(String args[])
    {
        Linkedlist l = new Linkedlist();
        l.head = new Node(1);
        Node second= new Node(2);
        
        
        l.head.Next = second;
        l.printList();
        
    }
    
}


