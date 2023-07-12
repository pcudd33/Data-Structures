package Notes;

import java.util.*;

public class TestHeap {
    private static class ElementType implements Comparable<ElementType> {
        int value;
        ElementType(int v) {
            value = v;
        }

        @Override
        public int compareTo(ElementType o) {
            return value - o.value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object obj) {
            if(! (obj instanceof ElementType)) { return false; }
            return ((ElementType) obj).value == value;
        }
    }

    private static boolean testPush(List<ElementType> data, List<ElementType> sortedData) {
        MyHeapPQ<ElementType> pq = new MyHeapPQ<>();
        boolean valid = true;

        for (ElementType x : data) {
            pq.add(x);
        }

        for (int i = 0; i < data.size(); i++) {
            if (!(pq.element().equals(sortedData.get(i)))) {
                valid = false;
                System.out.println("Incorrect data: got " + pq.element() + ", expected " + sortedData.get(i));
                break;
            }
            pq.remove();
        }

        if (valid) {
            System.out.println(" push passed");
        }
        return valid;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<ElementType> data, sorted_data;

        System.out.print("Seed: ");
        int seed = in.nextInt();
        System.out.print("Number of Elements: ");
        int num_elts = in.nextInt();
        System.out.print("Maximum value: ");
        int max_value = in.nextInt();

        Random rand = new Random();
        rand.setSeed(seed);

        data = new ArrayList<>(num_elts);


        for (int i = 0; i < num_elts; i++) {
            data.add(new ElementType(rand.nextInt(max_value)));
        }

        sorted_data = new ArrayList<>(data);
        Collections.sort(sorted_data, Collections.reverseOrder());

        System.exit(testPush(data, sorted_data) ? 0 : 1);

    }
}
