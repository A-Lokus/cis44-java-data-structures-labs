import java.util.ArrayList;
import java.util.LinkedList;

// --- 1. Entry ADT ---
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}

        // --- 2. Common Map Interface ---
interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- 4. Implementation: Separate Chaining Hash Map ---
// Time Complexity: get/put/remove are O(1) expected (Amortized)
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // Use a prime number for table capacity

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // done
    public V get(K key) {
        // 1. Calculate the hash index (bucket).
        int h = hash(key);
        LinkedList<Entry<K, V>> l = table.get(h);

        // 2. Search linearly within the bucket's linked list for the key.
        for(int i = 0; i < l.size(); i++) {
            if(l.get(i).getKey().equals(key)) {
                return l.get(i).getValue();
            }
        }

        // 3. If key is not found in the bucket, return null.
        return null;
    }

    public LinkedList<Entry<K,V>> getBucket(K key){
        int h = hash(key);
        LinkedList<Entry<K, V>> l = table.get(h);
        return l;
    }

    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Check if key already exists in the bucket
        for(int i = 0; i < bucket.size(); i++) {
            if(bucket.get(i).getKey().equals(key)) {
                V old = bucket.get(i).getValue();
                bucket.get(i).setValue(value);
                return old;
            }
        }

        // Key is new: add to the front of the list
        bucket.add(0, new Entry<>(key, value));
        return null;
    }

    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }
        return null;
    }
}


public class SeparateChainingMapTester {
    public static void main(String[] args) {
        SeparateChainingMap<Integer, String> chainMap = new SeparateChainingMap<>();
        chainMap.put(9, "1");
        chainMap.put(20, "2");
        chainMap.put(31, "3");
        System.out.println(chainMap.get(9));
        System.out.println(chainMap.get(20));
        System.out.println(chainMap.get(31));

        chainMap.put(7, "4");
        chainMap.put(18, "5");
        System.out.println(chainMap.get(7));
        System.out.println(chainMap.get(18));

        chainMap.put(31, "R3");
        System.out.println(chainMap.get(31));


        for(int i = 0; i < chainMap.getBucket(9).size(); i++) {
            System.out.print(chainMap.getBucket(9).get(i).getValue() + " ");
        }
        System.out.println("\n");


        for(int i = 0; i < chainMap.getBucket(20).size(); i++) {
            System.out.print(chainMap.getBucket(20).get(i).getValue() + " ");
        }
        System.out.println("\n");


        for(int i = 0; i < chainMap.getBucket(31).size(); i++) {
            System.out.print(chainMap.getBucket(31).get(i).getValue() + " ");
        }
        System.out.println("\n");


        for(int i = 0; i < chainMap.getBucket(7).size(); i++) {
            System.out.print(chainMap.getBucket(7).get(i).getValue() + " ");
        }
        System.out.println("\n");


        for(int i = 0; i < chainMap.getBucket(18).size(); i++) {
            System.out.print(chainMap.getBucket(18).get(i).getValue() + " ");
        }
    }
}