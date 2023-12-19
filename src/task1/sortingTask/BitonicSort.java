package task1.sortingTask;

import java.util.Arrays;

public class BitonicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,6,2,1,8,7, 3, 6};
        System.out.println(Arrays.toString(arr));
        bitonicSort(arr, 0, arr.length, 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void bitonicSort(int[] arr,int  l,int n, int dir){
        if (n > 1){
            int k = n / 2;

            bitonicSort(arr, l,  k, 1);
            bitonicSort(arr, l + k,  k, 0);

            bitonicMarge(arr, l, n, dir);
        }

    }
     public static void bitonicMarge(int[] arr, int l, int n, int dir){
        if (n > 1) {
            int k = n / 2;
            for (int i = l; i < l + k; i++) {
                compAndSwap(arr , i , i + k, dir);
            }
            bitonicMarge(arr, l, k, dir);
            bitonicMarge(arr, l + k, k, dir);
        }
     }
     public static void compAndSwap(int[] arr, int i, int j, int dir){
         if (
                 (arr[i] > arr[j] && dir == 1) ||
                         (arr[i] < arr[j] && dir == 0)
         ) {
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         }
     }
}
