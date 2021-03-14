public class IterativeSearch {

    public static int binarySearch(int arr[], int x) {
        InsertSort.sort(arr);
        int index = 0;
        int last = arr.length - 1;
        while (index <= last) {
            int mid = index + (last - index) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                index = mid + 1;
            else
                last = mid - 1;
        }
        return -1;
    }
}
