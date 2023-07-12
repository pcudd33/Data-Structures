package Lab7;

public interface MyMap<K, V> {
    /**
     * Insert a new key value pair
     * @param key
     * @param value
     * @return the old value if we are overwritting something
     */
    V put(K key, V value);


    /**
     * Find a value given a key
     * @param key
     * @return the value associated with the key or null
     */
    V get(Object key);


    /**
     * Remove an item from the hashtable
     * @param key
     * @return the removed value or null
     */
    V remove(Object key);


    /**
     * Check if hte key is in the hash table
     * @param key
     * @return true if the key is there
     */
    boolean containsKey(Object key);

    int size();
    boolean isEmpty();
}
