package task1.sortingTask;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int l ,int r){
        int idx = partition(arr, l , r);

        if (l < idx - 1){ // if something went wrong  idx - 1
            quickSort(arr, l, idx - 1);
        }
        if (r > idx){
            quickSort(arr, idx, r);
        }
    }
    public static int partition(int[] arr, int l, int r){
        int pivot = arr[l];
        while (l <= r){
            while (pivot > arr[l]){
                l++;
            }
            while (pivot < arr[r]){
                r--;
            }

            if (l <= r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

                l++;
                r--;
            }
        }
        return l;
    }
}
