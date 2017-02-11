/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 */
import java.io.*;

class TestClass1 {

    static int counter_zero = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the value");
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int f = fact(N);
        System.out.println(f);
        int c1 = check(f);
        System.out.println("counter_value:" + c1);

    }

    public static int fact(int n) {
        int fact_ans;
        if (n == 0) {
            return 1;
        }
        fact_ans = n * fact(n - 1);
        return fact_ans;

    }

    public static int check(int f) {
        if (f == 0)
        {
            return -1;
        }
        int i, j = 0;
        i = f % 10;
        if (i == 0) {
            counter_zero++;
        }
        else
        {
            return counter_zero;
        }
        j = f / 10;
        check(j);
        
        return counter_zero;
    }
}
