/**
 *
 * @author nguye
 */
import java.util.*;

public class Bucket_Sort {

    private int inputSizeOfArray() {
        Validate ob = new Validate();
        return ob.checkInputInt("Enter number of array: ");
    }

    private void random(double[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextDouble();
        }
    }

    private void bucketSort(double[] arr) {
        int n = arr.length;
        List<Double>[] buckets = new List[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double value : arr) {
            int bucketIndex = (int) (value * n);
            buckets[bucketIndex].add(value);
        }

        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Double> bucket : buckets) {
            for (double value : bucket) {
                arr[index++] = value;
            }
        }
    }

    private void printArray(double[] arr, String str) {
        System.out.println(str + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Bucket_Sort obj = new Bucket_Sort();
        int n = obj.inputSizeOfArray();
        double[] arr = new double[n];
        obj.random(arr);
        obj.printArray(arr, "Unsorted array: ");
        obj.bucketSort(arr);
        obj.printArray(arr, "Sorted array: ");
    }
}
