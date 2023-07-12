import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLLQueue<E> implements MyQueue<E> {
    private LinkedList<E> data;
    private int size;

    public MyLLQueue() {
        data = new LinkedList<E>();
    }

    /**
     * Retrieves and removes the head of this queue.  This method throws an exception
     * <p>
     * if this queue is empty
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */

    @Override
    public E remove() {

        if (size == 0){
            throw new NoSuchElementException("why is the queue empty you stupid person");
        }

        size--;
        return data.remove();

    }


    /**
     * Retrieves, but does not remove, the head of this queue. This method throws an
     * <p>
     * exception if this queue is empty.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */

    @Override
    public E element() {

        if (size == 0){
            throw new NoSuchElementException("why is the queue empty you stupid person");
        }
        System.out.println(data.peek());
        return data.peek();

    }

    /**
     * Inserts the specified element into this queue
     * @param e the element to add
     */

    @Override
    public void add(E e) {
        data.addLast(e);
        size++;
    }

    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in this queue
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue contains no elements
     */

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
