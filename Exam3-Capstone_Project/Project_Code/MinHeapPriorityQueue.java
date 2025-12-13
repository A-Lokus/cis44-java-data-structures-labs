import java.util.ArrayList;
import java.util.InputMismatchException;

public class MinHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    private ArrayList<Entry<K,V>> heap = new ArrayList<>();

    /**
     * All three methods provide useful indexes of the heap ArrayList given an index.
     * @param j An index within the heap.
     * @return the index associated based on the method name.
     */
    protected int parent(int j) { return (j-1)/2;}   //Methods returning indices in the heap array
    protected int left(int j) { return 2 * j + 1;}   //given @param j
    protected int right(int j) { return 2 * j + 2;}

    /**
     * Provides the size of the heap.
     * @return The size of the heap.
     */
    @Override
    public int size() { return heap.size(); }

    @Override
    /**
     * Checks if the heap is empty
     * @return Boolean of if the heap ArrayList is empty.
     */
    public boolean isEmpty() { return heap.isEmpty(); }

    /**
     * Inserts a new <Key, Value> entry into the heap ArrayList
     * @param key The priority key associated with the inserting element
     * @param value The value associated with the inserting element
     * @return The inserting Priority Queue Entry.
     */
    @Override
    public Entry<K,V> insert(K key, V value) {
        try{
            Entry<K,V> newest = new PQEntry<>(key, value);
            heap.add(newest);
            upheap(heap.size()-1);
            return newest;
        }
        catch(NumberFormatException e){
            System.err.println("Hello" + e);
            return null;
        }
    }

    /**
     * Returns the highest priority element
     * @return The minimum entry of the heap ArrayList
     */
    @Override
    public Entry<K, V> min(){
        if(heap.isEmpty()){ return null; }
        return heap.get(0);
    }

    /**
     * Removes and returns the highest priority element from the heap.
     * @return The highest priority element (smallest key indicates the highest priority).
     */
    @Override
    public Entry<K, V> removeMin() { //Removes the top first index of the heap and performs the
        if(min() == null){
            System.err.println("MinHeapPriorityQueue is empty");
            return null;
        }
        Entry<K,V> removedMin = min();
        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);
        downheap(0);
        return removedMin;
    }

    /**
     * Private helper method that swaps the indexes of two elements.
     * @param i The first index.
     * @param j The second index.
     */
    private void swap(int i, int j){
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Private helper method used to reorganize the heap after adding a new element.
     * @param j The index to upheap from.
     */
    private void upheap(int j) {
        while(j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0){
            swap(j, parent(j));
            j = parent(j);
        }
    }

    /**
     * Private helper method used to reorganize the heap after removing the highest priority element.
     * @param j The index to downheap from.
     */
    private void downheap(int j) {
        while(left(j) < heap.size()){
            int minChild = left(j);
            if(right(j) < heap.size() && compare(heap.get(right(j)), heap.get(minChild)) < 0){
                minChild = right(j);
            }
            swap(j, minChild);
            j = minChild;
        }
    }
}
