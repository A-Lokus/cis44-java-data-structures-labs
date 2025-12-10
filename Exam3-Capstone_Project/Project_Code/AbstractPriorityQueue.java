import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{
    Comparator<K> comp;

    /**
     * Creates a default comparator to initialize the comparator variable to
     * in order to have the compare function operate correctly.
     */
    protected static class DefaultComparator<K> implements Comparator<K> {

        /**
         * Compares two objects of generic type K and returns an
         * integer indicating the result of their comparison.
         * @param a The first object of type K.
         * @param b The second object of type K.
         * @return An int representing how the objects compare.
         * @throws ClassCastException
         */
        @SuppressWarnings("unchecked")
        public int compare(K a, K b) throws ClassCastException {
            return ((Comparable<K>) a).compareTo(b);
        }
    }

    /**
     * Initializes the Comparator<K> comp variable to the default comparator.
     */
    public AbstractPriorityQueue(){
        comp = new DefaultComparator<K>();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * Compares two objects of type Entry<K,V>.
     * @param a The first object of type Entry<K,V>
     * @param b The second object of type Entry<K,V>
     * @return An int representing how the objects compare.
     */
    protected int compare(Entry<K,V> a, Entry<K,V> b){
        return comp.compare(a.key(),b.key());
    }
}