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
class Queue_Test {
    int front, rear;
    
    int queuearray[] = new int[10];
    Queue_Test()
            {
                front=-1;
                rear=-1;
            }
    public void insert(int d)
    {
       if(rear!=queuearray.length)
       {
            front = 0;
            rear= rear+1;
            queuearray[rear]=d;
            
             
          
           System.out.println(" Elements getting inserted"+queuearray[rear] );
       }
       
       else
       {
     
        System.out.println("queue is full");
                 
       }
    }
    
    public void display()
    {
        for(int i=front;i<=rear;i++)
        {
            System.out.print(queuearray[i]+" ");
        }
    }
    
    public void delete()
    {
     if(front!=rear)
     {
         front++;
         System.out.print("pop operation");
     }
     else
     {
         System.out.print("underflow operation");
     }
    }
    
    public void peek()
    {
        if(front!=rear)
        {
            System.out.print(queuearray[front]);
        }
        else
        {
            System.out.print("invalid");
        }
    }
    public void reverse()
    {
        for(int i=front,j=rear;i<=j;i++,j--)
        {
            int temp;
            temp = queuearray[j];
            queuearray[j]=queuearray[i];
            queuearray[i]=temp;
            
            
        }
    }
}
public class Queue
  {
    public static void main(String args[])
    {
        
        Queue_Test q = new Queue_Test();
        q.insert(10);
        q.insert(20);
        q.insert(25);
        q.insert(40);
        q.display();
        q.reverse();
        q.display();
       
    }

  }