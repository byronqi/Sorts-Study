public class InsertionSort extends SortAlgorithm{
    public InsertionSort(AlgorithmDelegate del, DelayedArray<Integer> array)
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
     * algorithm that does this particular sort, in this case, the Insertion sort.
     */
    public void run()
    {
        int N = array.length();
        for (int i = 0; i < N; i++){
            int key = array.getValueAtLocation(i);
            int j = i-1;

            while(j>=0 && array.getValueAtLocation(j) > key){
                array.setValueAtLocation(array.getValueAtLocation(j), j+1);
                j = j-1;
            }
            array.setValueAtLocation(key, j+1);
        }
        tellDelegateSortIsComplete();
    }
}
// https://www.geeksforgeeks.org/insertion-sort/
