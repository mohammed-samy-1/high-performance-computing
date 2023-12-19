package sort;

import java.util.Arrays;

public class BitonicSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4, 6, 8, 7, 9};
        System.out.println(Arrays.toString(arr));
        bitonicSort(arr, 0, arr.length, 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void bitonicSort(int[] arr, int low, int n, int dir) {
        if (n > 1) {
            if (isBase2(arr.length)) {
                int k = n / 2; // divide the number of items to be sorted by 2
                bitonicSort(arr, low, k, 1); // call bitonic on left items ascending
                bitonicSort(arr, low + k, k, 0); // call bitonic on right side descending

                bitonicMarge(arr, low, n, dir); // marge the array that was divided
            } else {
                System.out.println("cant be sorted by bitonic sort :\\");
            }
        }

    }

    public static void bitonicMarge(int[] arr, int low, int n, int dir) {
        if (n > 1) {

            int k = n / 2; // divide the number of items to be sorted by 2
            //  comp each item on the lest side to its equivalent on the right side
            for (int i = low; i < low + k; i++) {
                compAndSwap(arr, i, i + k, dir);
            }
            // call marge on the left side and right side
            bitonicMarge(arr, low, k, dir);
            bitonicMarge(arr, low + k, k, dir);

        }
    }


    /**
     * 1 2 3 4 5 6 7 8
     * i       j
     * i       j
     * i       j
     * i       j
     * if i > j and dir is asc then swap
     * or if i < j amd dir is desc
     */
    private static void compAndSwap(int[] arr, int i, int j, int dir) {
        if (
                (arr[i] > arr[j] && dir == 1) ||
                        (arr[i] < arr[j] && dir == 0)
        ) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static boolean isBase2(int n) {
        //  log_a(b) = log_e(a) / log_e(a)
        double log_2 = Math.log(n) / Math.log(2);
        return log_2 == Math.floor(log_2);
    }
}
