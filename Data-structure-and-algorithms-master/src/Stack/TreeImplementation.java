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

class Node_1{
   
    Node_1 left ; 
    Node_1 right;
    int data;
    Node_1(int d)
    {
        
        data = d;
        left = null;
        right = null;
    }
}
public class TreeImplementation {
    static Node_1 root;
     static Node_1 root1;
     
     TreeImplementation(int key)
     {
       root = new Node_1(key);
     }
     
     
     TreeImplementation()
     {
         root = null;
     }
     /*
     public void add(Node_1 n)
    
     {
        Node_1 curr = root;
        while(curr.left!=null)
        {
            curr = curr.left;
        }  
        
        curr.left = n;
        n.left = null;
     }
     
     public void print()
     {
         Node_1 curr = root;
         while(curr!=null)
         {
             System.out.print(curr.data);
             curr = curr.left;
 
                     
             
             
         }
         
     }
     
    */ 
     
     static void inorder(Node_1 root)
     {
         if(root==null)
             return;
         inorder(root.left);
         System.out.print(root.data);
         inorder(root.right);
     }
     
   static void preorder(Node_1 root)
     {
         if(root==null)
             return;
         System.out.println(root.data);
         preorder(root.left);
         preorder(root.right);       
         
     }
     
     static void postorder(Node_1 root)
     {
         if(root==null)
             return;
        
         postorder(root.left);
         postorder(root.right);
         System.out.print(root.data);
         
     }
     
     static int height(Node_1 root1)
     { 
         int h =0;
         if(root1==null)
         return 0;
         else
         {
                int height_left =height(root1.left);
                int height_right = height(root1.right);
                
                return Math.max(height_left,height_right)+1;
             
                 
         
         }
        
     }
     
     static void levelOrderPrint()
     {
         int h = height(root);
         
         for(int i = 1 ; i <= h; i++)
         {
         LevelOrderTraversal(root,i);
         System.out.println();
     }
     }
     
     
     static void LevelOrderTraversal(Node_1 root,int level)
     {
         if(root==null)
             return;
         if(level==1)
             System.out.print(root.data);
         else
             if(level > 1)
                 {
                     LevelOrderTraversal(root.left,level-1);
                     LevelOrderTraversal(root.right,level-1);
                 }
         
             }
     static int size()
     {
         return size(root);
     }
     
     static int size(Node_1 root)
     {
         if(root==null)
             return 0;
         else
             return(size(root.left)+1+size(root.right));
                 
     }
     static boolean identicaltrees(Node_1 a,Node_1 b)
     {
         
         if(a==null && b==null) //if both trees are empty
             return true;
         if(a!=null && b!=null 
                 )
         {
             
             return(a.data==b.data && identicaltrees(a.left,b.left) && identicaltrees(a.right,b.right) );
         
         
         
         }
         return false;
     }
     
     static void delete(Node_1 root)
     {
      if(root==null)
      {
          return;
      }
      delete(root.left);
      delete(root.right);
      
      System.out.println("deleted node i"+root.data);
      root = null;
     }
     
     int sum(Node_1 root)
     {
         if(root==null)
         {
             return 0;
         }
             return sum(root.left)+root.data+sum(root.right);
     }
     
     int issumtree(Node_1 root)
     {
         int ls , rs;
         if((root==null) || (root.left==null && root.right==null))
         {
             return 1;
         }
         ls = sum(root.left);
         rs = sum(root.right);
         
         if((root.data==ls+rs) && (issumtree(root.left)!=0) && (issumtree(root.right)!=0))
         {
         return 1;
         
         }

         
         return 0;
     }
     static int leafcount(Node_1 root)
     {
         if(root==null) return 0;
         if(root.left==null && root.right==null) return 1;
         else
             
             {
                 
               return  leafcount(root.left) + leafcount(root.right);
             }
         
         
     }
     
     static int getdiameter(Node_1 root1)
     {
         if(root1==null) return 0;
         
         int lheight = height(root1.left);
         int rheight = height(root1.right);
         
         int ldiameter = getdiameter(root1.left);
         int rdiameter = getdiameter(root1.right);
         
         return Math.max((lheight+rheight+1),Math.max(ldiameter,rdiameter));
         
     }
    
     static int diameter()
     {
         return getdiameter(root1);
     }
     
     
     static int getMax(Node_1 root1)
     {
         
         if(root1==null) return Integer.MIN_VALUE;
         
         int res = root1.data;
         int lres = getMax(root1.left);
         int rres = getMax(root1.right);
         
         if(lres > res)
             res = lres;
         if(rres > res)
             res = rres;
         return res;
         
     }

     static int findMax()
     {
         return getMax(root1);
     }
     
     
     
     static boolean isbalanced(Node_1 root1)
     {
         if(root1==null)return true;
                 
         int lh = height(root1.left);
         int rh = height(root1.right);
         
         if(Math.abs(lh-rh)<=1 && isbalanced(root1.left) && isbalanced(root1.right))
         {
             return true;
         }
         
         
         
         return false;
     }
     
     
     
    static void printpaths(Node_1 root1)
     {
         
         int path[] = new int[1000];
         printpathRes(root1, path, 0);
     }
     
     static void printpathRes(Node_1 root1, int path[],int pathlen)
     {
         if(root1==null) return;
         
         path[pathlen]=root1.data;
         pathlen++;
         
         if(root1.left==null && root1.right==null)
         {
             printArray(path,pathlen);
         }
         else
         {
             printpathRes(root1.left,path,pathlen);
             printpathRes(root1.right,path,pathlen);
         }
         
         
         
         
         
     }
     
     static void printArray(int path[],int pathlen)
     {
         for(int i = 0 ; i < pathlen; i++)
         {
             System.out.print(path[i]+" ");
         }
         
         System.out.println(" ");
     }
     
 
     public static void main(String args[])
     {
         TreeImplementation tt = new TreeImplementation();
         tt.root = new Node_1(3);
         tt.root.left = new Node_1(4);
         tt.root.right = new Node_1(8);
         tt.root.left.left = new Node_1(5);
         tt.root.left.right = new Node_1(6);
         tt.root.right.left = new Node_1(7);
         tt.root.right.right = new Node_1(10);
         /* tt.inorder(root);
          tt.preorder(root);
          tt.postorder(root);
                 */
         tt.root1 = new Node_1(3);
         tt.root1.left = new Node_1(4);
         tt.root1.right = new Node_1(8);
         tt.root1.left.left = new Node_1(5);
         
         tt.root1.left.right = new Node_1(6);
         tt.root1.right.left = new Node_1(7);
         tt.root1.right.right = new Node_1(10);
         tt.root1.right.right.left = new Node_1(11);
         tt.root1.left.left.right = new Node_1(2);
         tt.root1.left.left.right.right = new Node_1(12);
           tt.root1.left.left.right.right.right = new Node_1(14);
          tt.levelOrderPrint();
          System.out.println("the size is :"+tt.size());
         boolean flag = tt.identicaltrees(root,root1);
          if(flag==true)
              System.out.println("trees are identical");
          else
              System.out.println("trees are not identical");
          
          tt.delete(root);
          root=null;
          System.out.println("Tree deleted");
          if(tt.issumtree(root)!=0)
          {
              System.out.println("the given tree is a sum tree");
          }
          else
          {
              System.out.println("the given tree is not a sum tree");
          }       
          
         int a =  tt.leafcount(root1);
                  System.out.println(a);
                 int dia= tt.diameter();
                 System.out.println(dia);
                 
         int b = tt.findMax();
         System.out.println(b);
         
        if(tt.isbalanced(root1))
        {
            System.out.println("the tree is balanced");
            
        }
        
        else
        {
            System.out.println("the tree is not balanced");
            
                }
        tt.printpaths(root1);
     }
}
