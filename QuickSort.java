public class QuickSort extends SortAlgorithm{
    public QuickSort(AlgorithmDelegate del, DelayedArray<Integer> array)
    {
        super(del,array);
    }

    public static void swap(DelayedArray<Integer>arr, int a, int b)
    {
        int swapTemp = arr.getValueAtLocation(a);
        arr.setValueAtLocation(arr.getValueAtLocation(b), a);
        arr.setValueAtLocation(swapTemp, b);
    }

    static int partition(DelayedArray<Integer> arr, int low, int high)
    {
        int pivot = arr.getValueAtLocation(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr.getValueAtLocation(j) < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr,i+1, high);
        return i + 1;
    }

    static void quickSort(DelayedArray<Integer> arr, int low, int high)
    {
        if (low < high) {
            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    /**
     * algorithm that does this particular sort, in this case, the Quick sort.
     */
    public void run()
    {
        quickSort(array, 0, array.length() - 1);
        tellDelegateSortIsComplete();
    }
}
//  https://www.geeksforgeeks.org/quick-sort/#
