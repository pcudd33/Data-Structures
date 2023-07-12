import java.util.NoSuchElementException;



public interface MyQueue<E> {

    /**
     * Retrieves and removes the head of this queue.  This method throws an exception
     * if this queue is empty
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E remove();

    /**
     * Retrieves, but does not remove, the head of this queue. This method throws an
     * exception if this queue is empty.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E element();

    /**
     * Inserts the specified element into this queue
     * @param e the element to add
     */
    void add(E e);

    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in this queue
     */

    int size();

    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue contains no elements
     */

    boolean isEmpty();

}