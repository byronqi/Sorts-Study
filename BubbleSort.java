public class BubbleSort extends SortAlgorithm{
    public BubbleSort(AlgorithmDelegate del, DelayedArray<Integer> array)
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
     * algorithm that does this particular sort, in this case, the Bubble sort.
     */
    public void run()
    {
        int N = array.length();
        for (int i = N-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (array.getValueAtLocation(j) > array.getValueAtLocation(j+1))
                    swap(j, j+1);
                if (!keepRunning){
                    return;
                }
            }
        }
        tellDelegateSortIsComplete();
    }
}
