package Notes;

import Lab7.MyMap;

public class MyBSTMap<K, V> implements MyMap<K, V> {

    private Node<K, V> root;
    private int size;

    //constructor
    public MyBSTMap(){
        root = null;
        size = 0;

    }
    /**
     * Insert a new key value pair
     *
     * @param key
     * @param value
     * @return the old value if we are overwritting something
     */
    @Override
    public V put(K key, V value) {
        if (value == null){
            //require actual data in the tree
            throw new UnsupportedOperationException("Can't insert a null value");
        }
        //get old value
        V old = get(key);

        //insert the new key value pair
        //helper method that returns back an updated tree
        root = putHelper(root, key, value);

        //return the old value;
        return old;
    }

    private Node<K,V> putHelper(Node<K,V> root, K key, V value) {
        //recursively search for the spot to put data and rebuild
        //the tree as needed

        //if root is null, that means we just need to make a node
        // and return it
        if (root == null) {
            size++;
            return new Node<>(key, value);
        }

        //check if the root node's key matcher
        if (key.equals(root.key)){
            //overwrite value in current node
            root.value = value;
            return root;
        }

        //Do the search
        Comparable<? super K> k = (Comparable<? super K>) key;
        if (k.compareTo(root.key) < 0){
            root.left = putHelper(root.left, key, value);
        }else{
            //recursively update/insert into the right subtree
            root.right = putHelper(root.right, key, value);
        }

        //return the updated node
        return root;
    }

    /**
     * Find a value given a key
     *
     * @param key
     * @return the value associated with the key or null
     */
    @Override
    public V get(Object key) {
        Node<K, V> curr = root;
        while(curr != null && !key.equals(curr.key)){
            //keep searching the tree
            Comparable<? super K> k = (Comparable<? super K>) key;
            if (k.compareTo(curr.key) < 0){
                //less than --> go left
                curr = curr.left;
            }else{
                //go right
                curr = curr.right;
            }
        }


        //curr either is null or the key matches
        if (curr == null)
            return null;
        else
            return curr.value;
    }

    /**
     * Remove an item from the hashtable
     *
     * @param key
     * @return the removed value or null
     */
    @Override
    public V remove(Object key) {
       V old = get(key);
       if (old == null){return null;}

       //we found a value ... remove it!
        root = removeHelper(root, key);

       size--;
       return old;
    }

    private Node<K,V> removeHelper(Node<K,V> root, Object key) {
        if (root == null){
            return null;// empty tree nothing to do
        }

        //search for the element
        Comparable<? super K> k = (Comparable<? super K>) key;

        if (k.compareTo(root.key) < 0){
            //need to go left
            root.left = removeHelper(root.left, key);
        }else if (k.compareTo(root.key) > 0){
            //need to go right
            root.right = removeHelper(root.right, key);
        }else{
            // we have found the node to remove
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else{
                //two children
                //find inorder successor
                Node<K, V> inorderSuccessor = minKey(root.right);
                //swap in the data
                root.key = inorderSuccessor.key;
                root.value = inorderSuccessor.value;
                //remover the IS from the right child
                root.right = removeHelper(root.right, inorderSuccessor.key);
            }
        }
        //return the updated tree
        return root;
    }

    /**
     * Check if hte key is in the hash table
     *
     * @param key
     * @return true if the key is there
     */
    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Finds the smallest key in the subtree rooted at curr
     * and returns that node
     * @param curr is the root od some subtree (or null)
     * @return node with the smallet key (or null) from the subtree
     */
    private Node<K, V> minKey(Node<K, V> curr){
        if (curr == null) return null;

        //keep going left while there is a subtree
        while (curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    private static class Node<K, V>{
        K key;
        V value;
        //references to our children
        Node<K,V> left, right;

        Node(K k, V v){
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }
}
