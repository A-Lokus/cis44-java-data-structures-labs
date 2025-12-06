import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{
    Comparator<K> comp;

    protected static class DefaultComparator<K> implements Comparator<K> {
        @SuppressWarnings("unchecked")
        public int compare(K a, K b) throws ClassCastException {
            return ((Comparable<K>) a).compareTo(b);
        }
    }

    public AbstractPriorityQueue(){
        comp = new DefaultComparator<K>();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    protected int compare(Entry<K,V> a, Entry<K,V> b){
        return comp.compare(a.key(),b.key());
    }
}