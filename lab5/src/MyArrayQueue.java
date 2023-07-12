import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayQueue<E> implements MyQueue {

    private E[] data;
    private int size, front, back;
    private static final int DEFAULT_SIZE = 10;

    public MyArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public MyArrayQueue(int initialCapacity) {
        data = (E[]) new Object[initialCapacity];
        size = front = back = 0;
    }

    /**
     * Retrieves and removes the head of this queue.  This method throws an exception
     * <p>
     * if this queue is empty
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */

    // we want to use poll because its retrieves and removes the first data point in queue
    @Override
    public Object remove() {

        if(size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        data[front] = null;

        front++;

        if(front == data.length && size != data.length){
            front = 0;
        }
        size--;
        return data[front];
    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method throws an
     * <p>
     * exception if this queue is empty.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */

    // we want to use peek to look at the beginning element without removing
    @Override
    public Object element() {

        if(size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        System.out.println(data[front]);

        return data[front];
    }

    /**
     * Inserts the specified element into this queue
     * @param o the element to add
     */
    // we want to use an offer to add to the end of the queue linked list
    @Override
    public void add(Object o) {
        // reallocate (which checks over inputting to the queue)
        if (size == data.length) {
           reallocate();
        }

        back++;
        if (back == data.length) {
            back = 0;
        }
        data[back] = (E) o;
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

public void reallocate(){
        E[] temp = (E[]) new Object[size = size * 2];
        if (front != 0){
            System.arraycopy(data, front, temp, 0, data.length - front);

        }else if(size - front > data.length){
            System.arraycopy(data, 0, temp, data.length - front, back);
        }else{
            for (int i = 0; i < data.length; i++) {
                data[i]= temp[i];
        }
        data = temp;
        }
    }

    public static void main(String[] args) {

         MyArrayQueue data = new MyArrayQueue(5);

        data.add(1);
        data.add(3);
        data.add(4);
        data.add(5);
        data.remove();
        data.remove();
        data.remove();
        data.add(2);
        data.add(6);
        data.add(4);
        data.add(9);
        data.add(8);
        data.add(5);
        data.remove();
        data.element();
        data.remove();
        data.element();

    }
}


