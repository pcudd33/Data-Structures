public class MyLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;


    public MyLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(E e){
        //create a new node with the next being the current head
        Node<E> newNode = new Node<>(e, head, null);
        //head's prev is newNode
        if (!isEmpty()) {
            head.prev = newNode;
        }else{
            //list was prev empty set this new node as the tail
            tail = newNode;
        }
        head = newNode;
        size++;
    }


    /**
     * Appends the specified element to the end of this list
     *
     * @param e element to be append to this list
     */
    @Override
    public void add(E e) {
        //special case if we are empty
        if (isEmpty()){
            addFirst(e);
            return;
        }
        //know there is at least one element and therefore tail is not null
        tail.next = new Node<>(e, null, tail);
        tail = tail.next;
        size++;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param e     element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, E e) {
        //check for an invalid index
        if (index < 0 || index > size){
           throw new IndexOutOfBoundsException(index);
        }

        //specific case first index
        if (index == 0){
            addFirst(e);
            return;
        }

        //count up indices
        int count = 0;
        Node<E> curr = head;

        while (count < index){
            curr = curr.next;
            count++;
        }

        //we have found the right postion
        // curr is the node right after where we should insert
        Node<E> newNode = new Node<>(e, curr, null);
        if (curr != null){
            curr.prev.next = newNode;
            newNode.prev = curr.prev;
            curr.prev = newNode;
        }else{
            //adding at the end because curr is null
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param i index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException(i);
        }
        Node<E> curr = head;
        int count = 0;

        while (count < i){
            curr = curr.next;
            count++;
        }

        //curr is the node at the specified index
        return curr.data;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    //inner class only our linkedList has access to this
    private class Node<E>{
        E data;
        Node<E> next, prev;

        public Node(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(E data, Node<E> n, Node<E> p){
            this.data = data;
            this.next = n;
            this.prev = p;
        }
    }

}
