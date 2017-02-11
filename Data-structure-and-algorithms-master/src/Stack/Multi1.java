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
import java.io.*;

public class Multi1 {

    public double[][] multiply(double x[][], double y[][]) //multiply method
    {
        
        int r = x.length;
        double R[][] = new double[r][r];
        if (r == 1) {
            R[0][0] = x[0][0] * y[0][0];
            return R;
        } else {
            double a11[][] = new double[r / 2][r / 2];
            double a12[][] = new double[r / 2][r / 2];
            double a21[][] = new double[r / 2][r / 2];
            double a22[][] = new double[r / 2][r / 2];
            double b11[][] = new double[r / 2][r / 2];
            double b12[][] = new double[r / 2][r / 2];
            double b21[][] = new double[r / 2][r / 2];
            double b22[][] = new double[r / 2][r / 2];

            divide(x, a11, 0, 0);  // 
            divide(x, a12, 0, r / 2);
            divide(x, a21, r / 2, 0);
            divide(x, a22, r / 2, r / 2);
            
            divide(y, b11, 0, 0);
            divide(y, b12, 0, r / 2);
            divide(y, b21, r / 2, 0);
            divide(y, b22, r / 2, r / 2);

            double M1[][] = multiply(add(a11, a22), add(b11, b22));
            double M2[][] = multiply(add(a21, a22), b11);
            double M3[][] = multiply(a11, sub(b12, b22));
            double M4[][] = multiply(a22, sub(b21, b11));
            double M5[][] = multiply(add(a11, a12), b22);
            double M6[][] = multiply(sub(a21, a11), add(b11, b12));
            double M7[][] = multiply(sub(a12, a22), add(b21, b22));

            double C11[][] = add(sub(add(M1, M4), M5), M7);
            double C12[][] = add(M3, M5);
            double C21[][] = add(M2, M4);
            double C22[][] = add(sub(add(M1, M3), M2), M6);

            combine(C11, R, 0, 0);
            combine(C12, R, 0, r / 2);
            combine(C21, R, r / 2, 0);
            combine(C22, R, r / 2, r / 2);
        }
        return R;

    }

    public double[][] add(double x[][], double y[][]) //add method
    {
        int r = x.length;
        double c[][] = new double[r][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                c[i][j] = x[i][j] + y[i][j];
            }
        }
        return c;
    }

    public double[][] sub(double x[][], double y[][]) //substract method
    {
        int r = x.length;
        double c[][] = new double[r][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                c[i][j] = x[i][j] - y[i][j];
            }
        }
        return c;

    }

    public void divide(double X[][], double C[][], int m, int n) {  //Divide method
        for (int i = 0, i1 = m; i < C.length; i++, i1++) {
            for (int j = 0, j1 = n; j < C.length; j++, j1++) {
                C[i][j] = X[i1][j1];
            }
        }
    }

    public void combine(double C[][], double X[][], int m, int n) {  //combine method
        for (int i = 0, i1 = m; i < C.length; i++, i1++) {
            for (int j = 0, j1 = n; j < C.length; j++, j1++) {
                X[i1][j1] = C[i][j];
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Multi1 m = new Multi1();
        System.out.println("enter the order of the matrix");
        int n = Integer.parseInt(br.readLine());
        double a[][] = new double[n][n];
        double b[][] = new double[n][n];
        System.out.println("enter the first matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Double.parseDouble(br.readLine());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("enter the second matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = Double.parseDouble(br.readLine());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("calculating the resultant matrix:");
         long start_time = System.currentTimeMillis();
        double c[][] = m.multiply(a, b);
        long end_time = System.currentTimeMillis();
        long diff = end_time - start_time;
        System.out.println("the difference:"+diff);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();

        }

    }
}
