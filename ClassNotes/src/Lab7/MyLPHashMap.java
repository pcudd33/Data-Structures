/*package Lab7;

    // Adam Quarterman, Parker Cuddeback, Jane Baumer  / atquar19@stlaw.edu, pjcudd19@stlawu.edu, jmbaum19@stlawu.edu

// INSTRUCTIONS
// fill out the methods in the class below

// Do not add, remove, or change any of the class's member variables.
// The num_ghosts counter is *optional*. You might find it helpful, but it
// is not required to pass the project.

// Do not change the Bucket type.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

    public class MyLPHashMap<K,V> implements MyMap<K,V> {

        protected ArrayList<Bucket> buckets;

        protected int numElements = 0;
        protected int numGhosts = 0; // OPTIONAL: you don't need to use this to pass
        int initialCapacity = 20;


        public MyLPHashMap() {
            // TODO: a default constructor (possibly empty).

            // You can use the following to avoid needing to implement rehashing.
            // However, you will only pass the AG test cases ending in _C.
            // To pass the rest, start with at most 20 buckets and implement rehashing.

            buckets = new ArrayList<>(20);
            for (int i=0; i < 20; i++) {
                buckets.add(new Bucket());
            }
        }

        /**
         * Adds a key,value pair to the HashMap and returns
         * the existing value stored (or null if this is the first insertion)
         * @param key Key to store
         * @param value Value to store
         * @return previous value associated with key, otherwise null
         */
      /*  @Override
        public V put(K key, V value) {
            // TODO
            int hash = hash(key);
            Bucket slot = buckets.get(hash);
            for (Bucket entry: buckets) {
                //Bucket slot = buckets.get(hash);
                if (entry.key.equals(key)) {
                    // We found the key in the list
                    V old = entry.val;
                    entry.val = value;
                    return old;
                }
            }
            // Not found -- brand new key
            // add a new Bucket
            buckets.add(new Bucket());
            numElements++;


            // Chek if we exceedd load factor
           /* if (numElements / buckets.size() > initialCapacity) {
                growAndRehash();
            }
            return null;
        }

        /**
         * Return a value associated with a key (null if the key is not found)
         * @param key key to search
         * @return value associated with key or null
         */
       /* @Override
        public V get(Object key) {
            // TODO

            int hash = hash(key);
            Bucket slot = buckets.get(hash);

            for (Bucket entry : slot) {
                if(key.equals(entry.key)) {
                    return entry.val;
                }
            }
            return null;
        }

        /**
         * Check if a key exists in the HashMap
         * @param key key to search
         * @return true if the key is found; false otherwise
         */
      /*  @Override
        public boolean containsKey(Object key) {
            return get(key) != null;
        }

        /**
         * Removes a key-value pair from the HashMap
         * @param key key to search
         * @return the value that was removed or null if not found
         */
      /*  @Override
        public V remove(Object key) {
            // TODO
            int hash = hash(key);
            Bucket slot = buckets.get(hash);

            //We need to use a ListIterator object so that we can remove teh MapEntry from the list

            Iterator<Bucket> it = slot.iterator();
            while (it.hasNext()) {
                Bucket entry = it.next();
                if(entry.key.equals(key)) {
                    //remove the item
                    V val = entry.value;
                    it.remove();
                    numElements--;
                    return val;
                }
            }

            return null;
        }

        @Override
        public boolean containKey(Object key) {
            return get(key) != null;
        }

        @Override
        public int size() {
            return numElements;
        }

        @Override
        public boolean isEmpty() {
            if (numElements == 0) {
                return true;
            }
            return false;
        }

        private void growAndRehash() {
            buckets = new ArrayList<>(20);
            ArrayList<LinkedList<MapEntry<K,V>>> tmp = slots;
            int oldSize = size;

            //reset size
            size = 0;

            // Double length of the slots
            slots = new ArrayList<>(slots.size() * 2);
            for (int i = 0; i < tmp.size() * 2; i++){
                slots.add(new LinkedList<>());
            }

            // re insert all our data
            for (LinkedList<MapEntry<K,V>> slot : tmp) {
                for (MapEntry<K,V> entry : slot) {
                    put(entry.key, entry.value);
                }
            }

            assert(size == oldSize);
        }

        // TODO you can add methods here if you like

        // A bucket's status tells you whether it's filled, empty, or contains a ghost.
        protected enum Status {
            Empty,
            Filled,
            Ghost
        }

        // A bucket has a status, a key, and a value.
        protected class Bucket {
            // Do not modify Bucket
            Status status = Status.Empty;
            K key;
            V val;

            public Bucket(){
                this.key = key;
                this.val = val;
            }
        }

        private int hash(Object key) {
            int hashCode = key.hashCode();
            return desiredBucket = Math.floorMod(k.hashCode, buckets.size());
        }
}*/
