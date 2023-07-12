public class Main {
    public static void main(String[] args) {

        MyArrayQueue arraryQueueData = new MyArrayQueue(5);
        MyLLQueue llQueue = new MyLLQueue();

        arraryQueueData.add(1);
        arraryQueueData.add(1);
        arraryQueueData.add(1);
        arraryQueueData.add(1);
        arraryQueueData.remove();
        arraryQueueData.remove();
        arraryQueueData.remove();
        arraryQueueData.add(1);
        arraryQueueData.add(1);
        arraryQueueData.add(1);
        arraryQueueData.add(1);
        arraryQueueData.add(6);
        arraryQueueData.add(5);
        arraryQueueData.remove();
        arraryQueueData.element();
        arraryQueueData.remove();
        arraryQueueData.element();

        llQueue.add(4);
        llQueue.add(2);
        llQueue.add(2);
        llQueue.add(2);
        llQueue.add(2);
        llQueue.add(2);
        llQueue.add(6);
        llQueue.element();





    }
}
