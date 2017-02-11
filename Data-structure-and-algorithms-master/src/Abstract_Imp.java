/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pooja
 */

abstract class Myclass
{
    abstract void calculate(double x);
}
class sub1 extends Myclass
{
    void calculate(double x)
    {
        System.out.println("square root is:"+Math.sqrt(x));
    }
}
class sub2 extends Myclass
{
    void calculate(double x)
    {
        System.out.println("square is:"+x*x);
    }
}













public class Abstract_Imp {
 public static void main(String args[])
 {
     sub1 sb = new sub1();
     sub2 sb1 = new sub2();
     sb.calculate(3);
     sb1.calculate(4);
     
 }
}
