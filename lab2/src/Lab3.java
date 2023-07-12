import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Lab3 {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(0,2);
        test.add(1,1);
        test.add(2,2);
        test.add(3,2);
        test.add(4,2);
        test.add(5,2);
        test.add(6,5);

        for (int i = 0; i < test.size(); i++){
            System.out.println(test.get(i));
        }

        System.out.println("----------");

        reverseList(test);
        for (int i = 0; i < test.size(); i++){
            System.out.println(test.get(i));
        }
    }
    public static <E> void reverseList(List<E> values) {

        ArrayDeque<E> stack = new ArrayDeque<>();
        for (E e : values){
            stack.addFirst(e);
        }
        for(int i = 0; i < values.size(); i++){
            E val = stack.removeFirst();
            values.set(i, val);
        }
    }
}
