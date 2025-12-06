public class PQEntry<K,V> implements Entry<K,V>{
    private K key;
    private V value;

    public PQEntry(K k, V v){
        key = k;
        value = v;
    }

    public K key(){ return key; }
    public V value(){ return value; }

    @Override
    public String toString(){
        return value.toString();
    }
}