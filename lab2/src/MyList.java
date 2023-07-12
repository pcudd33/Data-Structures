public interface MyList<E> {

    /**
     * Appends the specified element to the end of this list
     * @param e element to be append to this list
     */
    void add(E e);

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    void add(int index, E e);

    /**
     * Returns the element at the specified position in this list.
     * @param i index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    E get(int i);

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */

    boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */

    int size();

}
