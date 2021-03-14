public class RecursiveSearch {

    public static int recursiveSearch(int[] input, int key) {
        MergeSort.mergeSort(input);
        return binarySearch(input, 0, input.length - 1, key);
    }

    public static int binarySearch(int arr[], int first, int last, int key){
        if (last>=first){
            int mid = first + (last - first)/2;
            if (arr[mid] == key){
                return mid;
            }
            if (arr[mid] > key){
                return binarySearch(arr, first, mid-1, key);
            }else{
                return binarySearch(arr, mid+1, last, key);
            }
        }
        return -1;
    }
}
