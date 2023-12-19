public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 0, arr.length, 5));
        System.out.println(binarySearch(arr, 0, arr.length, 10));
    }


    public static int binarySearch(int[] arr, int l, int r, int key) {
        if (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                return binarySearch(arr, mid + 1, r, key);
            } else {
                return binarySearch(arr, l, mid - 1, key);
            }
        }
        return -1;
    }

}