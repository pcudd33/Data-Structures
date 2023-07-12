package Notes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

public class MyHeapPQ<E extends Comparable<E>> implements MyQueue<E>{

    private ArrayList<E> heap;
    private int size;


    public MyHeapPQ(){
        heap = new ArrayList<>();
        heap.add(null);
        size = 0;
    }

    public MyHeapPQ(Collection<E> other){
        //FIXME make a priority queue with all od the values in "other"
        this();
        heap.addAll(other);
        size = other.size();
        for (int i = (Math.floorDiv(size, 2) +1); i >= 1; i --){
            fixDown(heap, i);
        }
    }

    /**
     * Retrieves and removes the head of this queue.  This method throws an exception
     * if this queue is empty
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Collections.swap(heap, 1, size);
        E old = heap.remove(size);
        size--;
        fixDown(heap, 1);
        return old;

    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method throws an
     * exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E element() {
        return heap.get(1);
    }

    /**
     * Inserts the specified element into this queue
     *
     * @param e the element to add
     */
    @Override
    public void add(E e) {
        heap.add(e);
        size++;
        fixUp(heap, size);
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void fixDown(ArrayList<E> heap, int k){
        int heapSize = heap.size() - 1; //1-indexed
        while (2*k <= heapSize){
            int j = 2*k; //start with left child
            //j < heapSize && heap.get(j) < heap.get(j + 1)
            if (j < heapSize && heap.get(j).compareTo(heap.get(j + 1)) < 0){
                j++;
            }
            //heap.get(k) >= heap.get(j))
            if (heap.get(k).compareTo(heap.get(j)) >= 0){
                break; //heap restored
            }
            Collections.swap(heap, k, j);
            k = j; //move down
        }//while
    }//fixDown()

    public void fixUp(ArrayList<E> heap, int k){
        //k > 1 && heap.get(k / 2) < heap.get(k)
        while (k > 1 && heap.get(k / 2).compareTo(heap.get(k)) < 0){
            Collections.swap(heap, k, k / 2);
            k /= 2; //move up to parent
        }//while
    }//fixUp()
}
