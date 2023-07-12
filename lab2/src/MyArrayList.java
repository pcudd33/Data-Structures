public class MyArrayList<E> implements MyList<E>{

    private E[] data;
    //size is the number elements stored in the ArrayList
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        this.size = 0;
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public void add(E e) {
        //check that we have space
        if(size == data.length) {
            //we don't have space
            reallocate();
        }
        //add to the end of the array list\
        //next available
        data[size++] = e;

    }

    @Override
    public void add(int index, E e) {
        if (size == data.length){
            reallocate();
        }
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("the size of your array was too small or out of bounds ");
        }

        for (int i = size; i > index; i--){
           data[i] = data[i - 1];
        }
        data[index] = e;
        size = size + 1;
    }

    @Override
    public E get(int i) {
        if (i >= size || i < 0 ){
            throw new IndexOutOfBoundsException("the size of your array was too small ");
        }
        return data[i];

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void reallocate(){
        //TODO implement
        //make a new array of double the length
        //copy over all the old data
        E[] temp = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++){
            temp[i] = data[i];
        }
        data = temp;


    }
}


