public class SelectionSort extends SortAlgorithm {
    public SelectionSort(AlgorithmDelegate del, DelayedArray<Integer> array)
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

    /**
     * algorithm that does this particular sort, in this case, the Selection sort.
     */
    public void run()
    {
        int N = array.length();
        for (int i = 0; i < N-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < N; j++)
                if (array.getValueAtLocation(j) < array.getValueAtLocation(min_idx))
                    min_idx = j;

            int temp = array.getValueAtLocation(min_idx);
            array.setValueAtLocation(array.getValueAtLocation(i), min_idx);
            array.setValueAtLocation(temp, i);
        }
        tellDelegateSortIsComplete();
    }
}
// https://www.geeksforgeeks.org/selection-sort/#
