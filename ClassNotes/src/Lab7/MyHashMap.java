package Lab7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

//Explore the separate chaining approach
public class MyHashMap<K, V> implements MyMap<K, V> {

    //member variable to store array of linked lists

    private ArrayList<LinkedList<MapEntry<K, V>>> slots;
    private double maxLoadFactor = 0.75;
    private int size = 0;

    public MyHashMap(int initialCapacity) {
        slots = new ArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            //create LL to store MapEntries for this slot
            slots.add(new LinkedList<>());
        }
    }

    /**
     * Insert a new key value pair
     *
     * @param key
     * @param value
     * @return the old value if we are overwriting something
     */
    @Override
    public V put(K key, V value) {
        /*
         *steps
         * 1. hash to a slot
         * 2. search through the slot to see if we are replacing a
         * existing K-V pair
         * 3. if not, add end
         */
        int hash = hash(key);
        LinkedList<MapEntry<K, V>> slot = slots.get(hash);

        for (MapEntry<K, V> entry : slot) {
            if (entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        //not found -- brand new key
        //add a new MapEntry
        slot.add(new MapEntry<>(key, value));
        size++;

        //check if we exceeded load factor
        if (size / slot.size() > maxLoadFactor) {
            growAndRehash();
        }
        return null;
    }

    private void growAndRehash() {
        ArrayList<LinkedList<MapEntry<K, V>>> tmp = slots;
        int oldSize = size;

        //reset size
        size = 0;

        //double the length of the slots
        slots = new ArrayList<>(slots.size() * 2);
        for (int i = 0; i < tmp.size() * 2; i++) {
            slots.add(new LinkedList<>());
        }
        //re-insert all our data
        for (LinkedList<MapEntry<K, V>> slot : tmp) {
            for (MapEntry<K, V> entry : slot) {
                put(entry.key, entry.value);
            }
        }

        assert (size == oldSize);
    }

    /**
     * Find a value given a key
     *
     * @param key
     * @return the value associated with the key or null
     */
    @Override
    public V get(Object key) {
        /*
         *Steps:
         * 1. has the key --> call key.hashcode() mod my length of slots
         * 2. search through LL at that slot
         * 3. if key is equal to an item, return its value
         */
        int hash = hash(key);
        LinkedList<MapEntry<K, V>> slot = slots.get(hash);

        for (MapEntry<K, V> entry : slot) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
        }
        return null;
    }

    /**
     * Remove an item from the hashtable
     *
     * @param key
     * @return the removed value or null
     */
    @Override
    public V remove(Object key) {
        int hash = hash(key);
        LinkedList<MapEntry<K, V>> slot = slots.get(hash);

        // we need to use a list iterator object so that we can remove the MapEntry from the list
        Iterator<MapEntry<K, V>> it = slot.iterator();
        while (it.hasNext()) {
            MapEntry<K, V> entry = it.next();
            if (entry.key.equals(key)) {
                //remove the item!
                V val = entry.value;
                it.remove();
                size--;
                return val;
            }
        }
        return null;
    }

    /**
     * Check if the key is in the hash table
     *
     * @param key
     * @return true if the key is there
     */
    @Override
    public boolean containsKey(Object key) {
//        int hash = hash(key);
//       LinkedList<MapEntry<K, V>> slot = slots.get(hash);
//
//        for (MapEntry<K, V> entry: slot){
//            if (key.equals(entry.key)){
//                return true;
//            }
//        }
//        return false;
        return get(key) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Convert an object into a slot index
     *
     * @param key
     * @return
     */
    private int hash(Object key) {
        int hashCode = key.hashCode();
        return Math.floorMod(hashCode, slots.size()); //works the way pythons mod does
    }


    private static class MapEntry<K, V> {
        K key;
        V value;


        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
