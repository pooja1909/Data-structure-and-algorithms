/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
		String data_set = "F:/Ganesh/workspace/Project/src/breast-cancer-wisconsin.csv";
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

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of clusters ");
		int k = scanner.nextInt();

		System.out.println("Enter the value of L ");
		int l = scanner.nextInt();

		System.out.println("Enter the value of tau: ");

		double tau = scanner.nextDouble();

		System.out.println("Clustering------");

		// declaring clusters

		boolean flag=true;
		Cluster c[] = new Cluster[k];

		for (int i = 0; i < k; i++)
			c[i] = new Cluster(rows, col - 1, tau);

		// Creating domain for centroid values

		int max[] = new int[col - 1];
		int min[] = new int[col - 1];

		for (int i = 1; i < col - 1; i++) {

			max[i - 1] = d.maxColumn(data, i);
			min[i - 1] = d.minColumn(data, i);
		}

		// creating centroids

		for (int i = 0; i < k; i++)
			c[i].initiateCentroid(max, min);

		for (int i = 0; i < k; i++) {
			System.out.println("Centroid : " + (i + 1));
			c[i].displayCentroid();
		}

		MinDistances m = new MinDistances(l);
		double temp = 0;
		int Loops = 0;
		while (flag) {
			Loops++;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < k; j++) {
					temp = c[j].distance(data, i);
					m.insertIndex(temp, j);
				}
				for (int g = 0; g < m.distancesIndex.length; g++) {
					c[m.distancesIndex[g]].insert(data, i);
				}

				for (int g = 0; g < m.distancesIndex.length; g++)
					System.out.print(m.distancesIndex[g] + " ");

				m.empty();
			}

			for (int i = 0; i < k; i++) {
				System.out.println("Cluster :-..................." + (i + 1));
				c[i].display();
			}
			// Changing centroids
			
			for(int i=0;i<k;i++){
			c[i].newCentroid();
			c[i].bufferRow = 0;
			System.out.println("Centroid :--"+(i+1));
			c[i].displayCentroid();
			}
			for(int i=0;i<k;i++){
				if(!c[i].exitCondition())
					flag=false;
			}
		}
		
		System.out.println("Final---------------------");
		System.out.println("Loops---------------------"+(Loops+1));
		for (int i = 0; i < k; i++) {
			System.out.println("Cluster :-..................." + (i + 1));
			c[i].displayOld();
		}
		

	}
}

class Cluster {

	DataOperations d;
	double centroidOld[];
	double centroid[];
	int buffer[][];
	int bufferRow;
	int bufferRowOld;
	int two, four;
	int label;
	double ppv;
	double tau;
	double f1,f2;

	Cluster(int row, int column, double t) {

		d=new DataOperations();
		buffer = new int[row][column];
		centroid = new double[column - 1];
		centroidOld = new double[column - 1];
		bufferRow = 0;
		bufferRowOld = 0;
		four = 0;
		two = 0;
		ppv = 0;
		label = 0;
		tau = t;
		f1=0;
		f2=0;
	}

	void initiateCentroid(int max[], int min[]) {

		Random r = new Random();
		for (int i = 0; i < centroid.length; i++)
			centroid[i] = min[i] + r.nextInt(max[i] - min[i]);
		
		for (int i = 0; i < centroidOld.length; i++)
			centroidOld[i] = min[i] + r.nextInt(max[i] - min[i]);
	}

	double distance(int a[][], int row) {
		double ecludian = 0;
		for (int i = 1; i < a[row].length - 1; i++)
			ecludian += (centroid[i - 1] - a[row][i])
					* (centroid[i - 1] - a[row][i]);

		return Math.sqrt(ecludian);

	}

	void insert(int a[][], int row) {

		for (int j = 1; j < a[row].length; j++)
			buffer[bufferRow][j - 1] = a[row][j];

		if (buffer[bufferRow][buffer[bufferRow].length - 1] == 2)
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

	void newCentroid() {
		
		f1=d.distanceCentroids(centroidOld,centroid);
		double avg = 0;
		int temp = 0;
		
		for (int i = 0; i < centroid.length; i++)
			centroidOld[i] = centroid[i];

		for (int i = 0; i < centroid.length; i++) {
			for (int j = 0; j < bufferRow; j++)
				temp += buffer[j][i];

			avg = (double) temp / bufferRow;

			centroid[i] = avg;

			temp = 0;

		}
		two = 0;
		four = 0;
		bufferRowOld = bufferRow;
		bufferRow = 0;
		f2=d.distanceCentroids(centroidOld,centroid);
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

	void ppv() {
		if (two > four) {
			ppv = (double) two / (two + four);
			label = 2;
		} else {
			label = 4;
			ppv = (double) four / (two + four);
		}

	}

	boolean exitCondition(){
		boolean status=false;
		
		if((f2-f1)<(tau*f1))
			status=true;
		
		return status;
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

	void sort(double minDistances[]) {

		double swap = 0;
		for (int i = 0; i < minDistances.length - 1; i++)
			for (int j = 0; j < minDistances.length - i - 1; j++)
				if (minDistances[j] > minDistances[j + 1]) {
					swap = minDistances[j];
					minDistances[j] = minDistances[j + 1];
					minDistances[j + 1] = swap;
				}
	}

	int findMax(double distances[]) {
		int index = 0;
		double max = 0;
		for (int i = 0; i < distances.length; i++) {
			if (max < distances[i]) {
				max = distances[i];
				index = i;
			}
		}

		return index;

	}
	
	double distanceCentroids(double c[], double d[]) {

		double ecludian = 0;
		for (int i = 1; i < c.length - 1; i++)
			ecludian += (c[i] - d[i]) * (c[i] - d[i]);

		return Math.sqrt(ecludian);
	}

}

class MinDistances {

	DataOperations d;

	int distancesIndex[];
	double distances[];
	int maxIndex;
	int track;

	MinDistances(int l) {
		d = new DataOperations();
		distancesIndex = new int[l];
		distances = new double[l];
		maxIndex = 0;
		track = 0;
	}

	void insertIndex(double distance, int j) {
		if (j < distancesIndex.length) {
			distances[track] = distance;
			distancesIndex[track++] = j;
		} else if (distance < distances[maxIndex]) {
			distances[maxIndex] = distance;
			distancesIndex[maxIndex] = j;
		}
		maxIndex = d.findMax(distances);
	}

	void empty() {
		for (int i = 0; i < distances.length; i++) {
			distances[i] = 1000;
			distancesIndex[i] = -1;
		}
		track = 0;
		maxIndex = 0;
	}
}
