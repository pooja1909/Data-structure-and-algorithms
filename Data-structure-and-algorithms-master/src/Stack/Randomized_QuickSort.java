package Stack;

/**
 *
 * @author pooja
 */
import java.util.Random;
public class Randomized_QuickSort {
    
    public static int N = 10;
    public static int[] num = new int[N];
 
    public static void QuickSort(int low, int high) 
    {
        if (low >= high) {
        } else 
        {
            Random rand = new Random();
            int pivotIndex = low + rand.nextInt(high - low + 1);// generates a pivot within the range of low and high
            swap(pivotIndex, high); // swaps the value of the random pivot to the last position
 
            int random_pivot = num[high];
            int partition_index = partition(low, high, random_pivot);
            QuickSort(low, partition_index - 1); //recursively sorts left subarray
            QuickSort(partition_index + 1, high);//recursively sorts right subarray
        }
    }
 
    public static int partition(int low, int high, long random_pivot) 
    {
        int index_low = low - 1;
        int index_high = high;
        while (true) 
        {
            while (num[++index_low] < random_pivot);
            while (index_high > 0 && num[--index_high] > random_pivot);
            if (index_low >= index_high)
                break;
            else
                swap(index_low, index_high);
        }
         swap(index_low, high);
        return index_low;
    }
 
    public static void swap(int first, int second) 
    {
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }
 
    static void display(int[] sorted_array) 
    {
        for (int i = 0; i < sorted_array.length; i++)
            System.out.print(sorted_array[i] + " ");
    }
 
    public static void main(String args[]) 
    {
        System.out.println("Generating random numbers");
        Random random = new Random();
        for (int i = 0; i < N; i++)
        num[i] = Math.abs(random.nextInt(100));
        System.out.println("Original Array:");
        display(num);
        System.out.println("Sorted Array:");
        QuickSort(0, N - 1);
        display(num);
    }
}



