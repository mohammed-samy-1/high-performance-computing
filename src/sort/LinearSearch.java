package sort;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(linearSearch(arr, 7));
        System.out.println(linearSearch(arr, 10));
    }
    public static int linearSearch(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
}
