public class MyArrayList<E> implements MyList<E>{

    // ArrayList
    private E[] data;

    // number of elements stored in the ArrayList
    private int size;

    // The stored default size
    private static final int DEFAULT_SIZE = 10;

    // Constructor
    // This constructor allows there to be a default size unless user calls one
    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    // Constructor
    // This constructor fulfills the scenario if user were to pick size
    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        this.size = 0;
        this.data = (E[]) new Object[initialCapacity];
    }

    // Amortized 0(1) --> averages out to be super fast in the long run
    //Method
    //This method allows for used to add to the end of the array.
    @Override
    public void add(E e) {
        if (size == data.length) {
            reallocate();
        }
        // add to the end of the array list\
        // next available slot
        data[size++] = e;


    }

    // Method
    //This method allows addition @ specific index
    @Override
    public void add(int index, E e) {
        if (index > size) {
            throw new IndexOutOfBoundsException(index);
        }
        for (int i = size; i > index; i--) {
            data[i - 1] = data[i];
        }
        data[index] = e;
        size++;
    }
    // O(1)
    //Method
    //This method allows user to get at a specific index
    @Override
    public E get(int i) {
        if (i > size) {
            throw new IndexOutOfBoundsException(i);
        }
        return data[i];
    }

    // O(1)
    //Method
    //This method allows user to check the empty status of Array
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    //Method
    //Returns the size when called
    @Override
    public int size() {
        return size;
    }

    //Method
    //Creates an array of double the length
    // The feeds the data of old array into new one
    @SuppressWarnings("unchecked")
    private void reallocate() {
        // make a new array of double the length
        // copy over all the old data
        E[] array = data;
        int length = size * 2;
        this.data =(E[]) new Object[length];

        for (int i = 0; i < data.length; i++) {
            data[i]= array[i]; //
        }


    }
    // Testing of array
    public static void main(String[] args) {

        MyArrayList a = new MyArrayList();
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println(0);





    }
}

