import java.util.ArrayList;

public class MinHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    private ArrayList<Entry<K,V>> heap = new ArrayList<>();

    protected int parent(int j) { return (j-1)/2;}
    protected int left(int j) { return 2 * j + 1;}
    protected int right(int j) { return 2 * j + 2;}


    @Override
    public int size() { return heap.size(); }
    @Override
    public boolean isEmpty() { return heap.isEmpty(); }


    @Override
    public Entry<K,V> insert(K key, V value) {
        Entry<K,V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size()-1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        Entry<K,V> removedMin = min();
        swap(0, heap.size()-1);
        heap.remove(heap.size()-1);
        downheap(0);
        return removedMin;
    }


    private void swap(int i, int j){
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    private void upheap(int j) {
        while(j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0){
            swap(j, parent(j));
            j = parent(j);
        }
    }
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
