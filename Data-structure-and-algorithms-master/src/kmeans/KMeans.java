/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

/**
 *
 * @author pooja
 */
import java.lang.Math;
import java.io.*;
import java.util.*;

public class KMeans {
	public static void main(String[] args) throws IOException {

		KMeansImplement k = new KMeansImplement();
		k.readData();
                // For all attributes
		k.kMeansCluster();           
	}
}

class KMeansImplement { 
	int rows, col;
	int data[][];
	public KMeansImplement() {
		rows = 0;
		col = 0;

	}

	public void readData() throws IOException {
		String data_set = "C:\\Users\\pooja\\Desktop\\breast-cancer-wisconsin_data.csv";
		BufferedReader rd = null;
		String line = "";
		String cvsSplitBy = ",";
		rd = new BufferedReader(new FileReader(data_set));
		int i = 0;
		String lineByLine[] = null;

		while ((line = rd.readLine()) != null)
			rows++;
		System.out.println("Rows: " + rows);

		rd = new BufferedReader(new FileReader(data_set));

		while ((line = rd.readLine()) != null) {

			lineByLine = line.split(cvsSplitBy);
		}
		col = lineByLine.length;
		System.out.println("Columns: " + col);
		data = new int[rows][col];

		rd = new BufferedReader(new FileReader(data_set));

		while ((line = rd.readLine()) != null) {

			lineByLine = line.split(cvsSplitBy);

			for (int j = 0; j < 11; j++) {
				if (lineByLine[j].equals("?"))
					data[i][j] = 0;
				else {
					data[i][j] = Integer.parseInt(lineByLine[j]);
				}

			}
			i++;
		}
		for (i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

	void kMeansCluster() {

		DataOperations d = new DataOperations();

		System.out.println("Enter the value of tau: ");
                Scanner scanner = new Scanner(System.in);
                double tau = scanner.nextDouble();

		System.out.println("Clustering------");

		// declaring clusters

		Cluster c1 = new Cluster(rows, col - 1);
		Cluster c2 = new Cluster(rows, col - 1);

		// Creating domain for centroid values

		int max[] = new int[col - 1];
		int min[] = new int[col - 1];

		for (int i = 1; i < col - 1; i++) {

			max[i - 1] = d.maxColumn(data, i);
			min[i - 1] = d.minColumn(data, i);
		}

		// creating centroids

		c1.initiateCentroid(max, min);
		c2.initiateCentroid(max, min);

		System.out.println("Centroid 1:--");
		c1.displayCentroid();

		System.out.println("Centroid 2:--");
		c2.displayCentroid();

		double temp1, temp2;
		int Loops=0;
		while (true) {
			Loops++;
			for (int i = 0; i < rows; i++) {
				temp1 = 0;
				temp2 = 0;

				temp1 = c1.distance(data, i);
				temp2 = c2.distance(data, i);

				if (temp1 < temp2) {
					c1.insert(data, i);
				} else {
				
					c2.insert(data, i);
				}
			}

			System.out.println("Cluster one :-...................");
			c1.display();
			System.out.println("Cluster two :-...................");
			c2.display();
			// Changing centroids
                        c1.ppv();
                        c2.ppv();
			if (c1.newCentroid() <= tau && c2.newCentroid() <=tau)
				break;
			else {
				c1.bufferRow=0;
				c2.bufferRow=0;
				System.out.println("Centroid 1:--");
				c1.displayCentroid();

				System.out.println("Centroid 2:--");
				c2.displayCentroid();
			}
		}

		System.out.println("Final----  Loops:"+Loops);

		System.out.println("Tau= " + tau);

		System.out.println("Centroid 1 :------------");
		c1.displayCentroidOld();

		System.out.println("Centroid 2 :------------");
		c2.displayCentroidOld();

		System.out.println("Cluster one :-...................");
		c1.displayOld();
		System.out.println("Cluster two :-...................");
		c2.displayOld();
                
                System.out.println("Cluster 1 Label: "+c1.label+" PPV :- "+c1.ppv);
                
                System.out.println("Cluster 2 Label: "+c2.label+" PPV :- "+c2.ppv);

	}

}

class Cluster {

	double centroidOld[];
	double centroid[];
	int buffer[][];
	int bufferRow;
	int bufferRowOld;
        int two,four;
        int label;
        double ppv;

	Cluster(int row, int column) {

		buffer = new int[row][column];
		centroid = new double[column-1];
		centroidOld = new double[column-1];
		bufferRow = 0;
		bufferRowOld=0;
                four=0;
                two=0;
                ppv=0;
                label=0;
	}

	void initiateCentroid(int max[], int min[]) {

		Random r = new Random();
		for (int i = 0; i < centroid.length; i++)
			centroid[i] = min[i] + r.nextInt(max[i] - min[i]);
	}

	double distance(int a[][], int row) {
		double ecludian = 0;
		for (int i = 1; i < a[row].length - 1; i++)
			ecludian += (centroid[i-1] - a[row][i])
					* (centroid[i-1] - a[row][i]);

		return Math.sqrt(ecludian);

	}

	void insert(int a[][], int row) {
		
		for (int j = 1; j < a[row].length; j++)
			buffer[bufferRow][j - 1] = a[row][j];
                
                                
		if(buffer[bufferRow][buffer[bufferRow].length-1]==2)
                    two++;
                else
                    four++;
                
                bufferRow++;
	}

	void display() {

		System.out.println("Size:   " + (bufferRow));
		for (int i = 0; i < bufferRow; i++) {
			for (int j = 0; j < buffer[i].length; j++) {

				System.out.print(buffer[i][j] + " ");

			}
			System.out.println();
		}
	}

	void displayOld() {

		System.out.println("Size:   " + (bufferRowOld));
		for (int i = 0; i < bufferRowOld; i++) {
			for (int j = 0; j < buffer[i].length; j++) {

				System.out.print(buffer[i][j] + " ");

			}
			System.out.println();
		}
	}

	
	double newCentroid() {
		double avg = 0;
		int temp = 0;

		for (int i = 0; i < centroid.length; i++)
			centroidOld[i] = centroid[i];

		for (int i = 0; i < centroid.length; i++) {
			for (int j = 0; j < bufferRow; j++)
				temp += buffer[j][i];

			avg = (double)temp / bufferRow;

			centroid[i] = avg;

			temp = 0;

		}
                two=0;
                four=0;
		bufferRowOld=bufferRow;
		bufferRow = 0;

		double ecludian = 0;

		for (int i = 0; i < centroid.length; i++)
			ecludian += (centroid[i] - centroidOld[i])
					* (centroid[i] - centroidOld[i]);

		return Math.sqrt(ecludian);
	}

	void displayCentroid() {
		for (int i = 0; i < centroid.length; i++)
			System.out.print(centroid[i] + " ");
		System.out.println();
	}

	void displayCentroidOld() {
		for (int i = 0; i < centroidOld.length; i++)
			System.out.print(centroidOld[i] + " ");
		System.out.println();
	}

        void ppv(){
            if(two>four){
                ppv=(double)two/(two+four);
                label=2;
            }
            else{
                label=4;
                ppv=(double)four/(two+four);
            }
                
        }

}

class DataOperations {
	int maxColumn(int a[][], int column) {
		int max = 0;

		for (int i = 0; i < a.length - 2; i++) {
			if (a[i][column] > max)
				max = a[i][column];
		}

		return max;
	}

	int minColumn(int a[][], int column) {
		int min = 0;

		for (int i = 0; i < a.length - 2; i++) {
			if (a[i][column] < min)
				min = a[i][column];
		}

		return min;
	}
}
