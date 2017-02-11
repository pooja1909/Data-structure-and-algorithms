/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */


class Node
{
    
    Node left;
    Node right;
    int data;
    
    Node(int item)
    {
        left = null;
        right = null;
        data = item;
    }
    
    
}
public class BSTimplementation {
   Node root;
    
    BSTimplementation()
    {
        root = null;
    }
    
    
    void insert(int key)
    {
     root = insertRec(root,key);   
    }
    
    Node insertRec(Node root, int key)
    {
      if(root==null)
      {
          root = new Node(key);
      return root;
    }
    
    if(key < root.data)
     root.left = insertRec(root.left,key);
    else 
        if(key > root.data)
       root.right = insertRec(root.right,key);
    return root;
    }
    
    void inorder()
    {
        inorderRec(root);
                
    }
 void inorderRec(Node root)
 {
     if(root==null) return ;
     if(root!=null)
     {
         inorderRec(root.left);
         System.out.println(root.data);
         inorderRec(root.right);
     }
 
         
         
 }
 
 void secondLargestUtil(Node root, int c)
 {
     if(root==null || c>=2)
         return;
     secondLargestUtil(root.right,c);
     
     c++;
     
     if(c==2)
     {
         System.out.println(root.data);
         return;
     }
     
     secondLargestUtil(root.left,c);
     
 }
 
 
 void secondlargest()
 {
     int c=0;
     secondLargestUtil(root,c);
 }
    int count(int l , int h)
    {
       int c = getcount(root,l,h);
       return c;
    }
 
 
 int getcount(Node root, int l, int h)
         {
             
             
             if(root==null)
                 
                 return 0;
             if(root.data==l && root.data==h) return 1;
             
             if(root.data <= h && root.data >= l)
                 
                 return 1+getcount(root.left,l,h)+getcount(root.right,l,h);
             
             else if(root.data < l)
                 return getcount(root.right,l,h);
             else 
                 return getcount(root.left,l,h);
             
             
             
             
             
             
             
             
             
             
             
         }
    public static void main(String args[])
    {
        BSTimplementation bs = new BSTimplementation();
        bs.insert(40);
        bs.insert(70);
        bs.insert(80);
        bs.insert(50);
        bs.insert(60);
        bs.insert(90);
      //bs.inorder();
        bs.secondlargest();
        int l = 10;
        int h = 90;
        int c = bs.count(l,h);
        System.out.println(c);
    }
}
