public class MergeSort extends SortAlgorithm{
    public MergeSort(AlgorithmDelegate del, DelayedArray<Integer> array)
    {
        super(del,array);
    }
    /**
     * Exchanges values at locations a & b. Note: this causes four delays - two for access and two for updates.
     * @param a
     * @param b
     */
    public void swap(int a, int b)
    {
        Integer temp = array.getValueAtLocation(a);
        array.setValueAtLocation(array.getValueAtLocation(b), a);
        array.setValueAtLocation(temp, b);
    }
    void merge(DelayedArray<Integer> arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i){
            left[i] = arr.getValueAtLocation(l+i);
        }
        for (int j = 0; j < n2; ++j){
            right[j] = arr.getValueAtLocation(m+1+j);
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr.setValueAtLocation(left[i], k);
                i++;
            }
            else {
                arr.setValueAtLocation(right[j], k);
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr.setValueAtLocation(left[i], k);
            i++;
            k++;
        }
        while (j < n2) {
            arr.setValueAtLocation(right[j], k);
            j++;
            k++;
        }
    }

    void sort(DelayedArray<Integer> arr, int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /**
     * algorithm that does this particular sort, in this case, the Merge sort.
     */
    public void run()
    {
        sort(array, 0, array.length()-1);
        tellDelegateSortIsComplete();
    }
}
// https://www.geeksforgeeks.org/merge-sort/#