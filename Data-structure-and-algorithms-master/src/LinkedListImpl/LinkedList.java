/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListImpl;

/**
 *
 * @author pooja
 */
class Node {

        int data;
        Node next;
        
        Node(int d) {
            data = d;
            next = null;
        }

}
public class LinkedList {
    
    public static void main(String args[]) {
        LinkedList l = new LinkedList();
        Node first = new Node(4);
        Node second = new Node(6);
        first.next = second;
        Node a = new Node(12);
        Node b  = new Node(15);
        Node c = new Node(23);
        second.next=a;
        a.next=b;
        b.next=c;
        //l.display(first);
        Node t = new Node(24);
        l.append(first, t);
        l.display(first);
        Node t1 = new Node(3);
        l.appendBetween(b,t1);
        System.out.println();
        l.display(first);
        l.appendToEnd(first,new Node(4));
        l.display(first);
        
        
    }
    
    void display(Node first)
    {
       Node curr = first;
       while(curr!=null){
           System.out.print(curr.data+" ");
           curr = curr.next;
       }
    }
    
    void append(Node first, Node k)
    {
        Node curr = first;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = k;  
    }
    
    void appendBetween(Node ref, Node newnode)
    {
        Node temp = ref.next;
       
       ref.next=newnode;
       newnode.next= temp;
        
    }
    
    void appendToEnd(Node first,Node newnode)
    {
        Node curr = first;
        while(curr.next!=null)
        {
            curr= curr.next;
            
        }
        appendBetween(curr,newnode);
                
    }
    void delete(Node first, Node delnode)
    {
     Node curr = first;
     while(curr.next!=delnode)
     {
         curr.next=delnode.next;
     }
       
    }
}
