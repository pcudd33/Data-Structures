public class TestLL {
    public static void main(String[] args) {
        MyLinkedList<Integer> testList = new MyLinkedList<>();

        testList.add(3);
        testList.add(5);
        testList.add(7);
        testList.add(1, 10);



        for (int i = 0; i < testList.size(); i++){
            System.out.println(testList.get(i));
        }

    }
}
