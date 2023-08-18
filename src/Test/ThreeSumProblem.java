package Test;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] arr = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
        Arrays.sort(arr);
        Stopwatch s1 = new Stopwatch();
        int count = slowThreeSumAlgo(arr);
        System.out.println("Time is " + s1.elapsedTime() + "\nCount is " + count);
        Stopwatch s2 = new Stopwatch();
        count = fastThreeSumAlgo(arr);
        System.out.println("Time is " + s2.elapsedTime() + "\nCount is " + count);
    }

    private static int slowThreeSumAlgo(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) count++;
                }
            }
        }
        return count;
    }

    private static int fastThreeSumAlgo(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int k = binarySearch(arr, -(arr[i] + arr[j]));
                if (k != -1) {
                    if (arr[i] < arr[j] && arr[j] < arr[k] && arr[i] + arr[j] == -arr[k]) count++;
                }
            }
        }
        return count;
    }

    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > a[mid]) lo = mid + 1;
            else if (key < a[mid]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}
