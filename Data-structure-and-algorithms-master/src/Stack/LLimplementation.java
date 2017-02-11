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
class Node_a
    {
      
      Node_a next;
      int data;
      Node_a(int d)
      {
         data = d;
         next = null;
      }        
   }
public class LLimplementation
{
    Node_a head;
    
 
 public void print()
 {
     Node_a n = head;
     while(n!=null)
     {
         System.out.println(n.data);
         n = n.next;
     }
 }
 
 public void add(Node_a newnode)
 {
     Node_a curr = head;
     
     while(curr.next!=null)
     {
         curr = curr.next;
         
     }
     curr.next = newnode;
     newnode.next = null;
 }
 
 public void tail_del()
 {
  Node_a curr = head;
  
  while(curr.next.next!=null)
  {
      curr = curr.next;
  }
  
  curr.next = null;   
 }
 
 public void del_AtPos(int val)
 {
   
     Node_a curr = head;
     int len = 0;
     if(val==0)
     {
         head = head.next;
         return;
     }
     while(curr.next!= null && len != (val-1))
             {
                 curr = curr.next;
                 len++;
             }
             
             if(curr.next.next!=null)
             curr.next = curr.next.next;
             else
                 curr.next=null;      
 
 }
 
 void addAtPos(int val,Node_a n)
 
 {
     
     Node_a curr = head;
    Node_a Node_to_insert = n;
     int len= 0;
   if(val==0)
   {
    Node_to_insert.next = curr;
  //  curr = Node_to_insert;
    return;
   }
    
    while(curr.next!=null && len!=(val-1))
    {
        curr = curr.next;
        len++;
    }
    
    if(curr.next.next!=null)
    {
        Node_to_insert.next = curr.next;
        curr.next = Node_to_insert;
        
    }
        else
    {
          curr.next = Node_to_insert;
          Node_to_insert.next =null;
    }
 
 
 }
 
 public void sort()
 {
     Node_a curr = head.next;
     Node_a prev = head;
     int temp = 0;
   //  int len = 0;
     while(prev.next!=null)
     {
         curr = prev.next;
         while(curr!=null)
         {
             
         if(curr.data < prev.data)
         {
             temp = prev.data;
             prev.data = curr.data;
             curr.data = temp;
         }
         
         curr = curr.next;
         
         }        
             prev = prev.next;
             
     }
 }
 
 public void reverse()
 {
        
   Node_a prevNode = null;
   Node_a currNode = head;
 
  while (currNode != null) {
      Node_a nextNode = currNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = nextNode;
        }
    head = prevNode;
 }
 
 public static void main(String args[])
  {
          
  LLimplementation ll = new LLimplementation();
  ll.head= new Node_a(4);
  Node_a n = new Node_a(5);
   ll.add(n);
  /// ll.print();
  Node_a n1 = new Node_a(9);
  ll.add(n1);
  Node_a n2 = new Node_a(11);
  ll.add(n2);
  Node_a n3 = new Node_a(10);
  ll.add(n3);
//  ll.print();
  // ll.tail_del();
 // ll.print();
 // ll.del_AtPos(0);
// ll.print();
 Node_a n4 = new Node_a(3);
ll.addAtPos(3,n4);
// ll.print();
 ll.sort();
 //ll.print();
 ll.reverse();
 ll.print();
 
 
      }
      
}     
      
      
      
      
      
      
      
      
      
      
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
