package Lab6;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQExample {

    /*public static void main(String[] args) {
        PriorityQueue<Integer> nums = new PriorityQueue<>();
        nums.add(45);
        nums.add(32);
        nums.add(-1);
        nums.add(4);

        while(!nums.isEmpty()){
            System.out.println(nums.remove());
        }
    */

    public static void main(String[] args) {

        //min PQ
        PriorityQueue<Integer> topHalf = new PriorityQueue<>();

        //max PQ
        PriorityQueue<Integer> bottomHalf = new PriorityQueue<>(Collections.reverseOrder());

        double median = 0;

        int[] data = {45, 67, 23, -1, 23, 4};

        for (int i : data){
            if (topHalf.isEmpty() && bottomHalf.isEmpty()){
                topHalf.add(i);
                median = 1;
            }else{
                //decide top half or bottom based on size relative to the median
                if (i <median){
                    bottomHalf.add(i);
                }else{
                    topHalf.add(i);
                }

                //balance the sizes of the PQs
                if (bottomHalf.size() - topHalf.size() == 2){
                    //shift one element from bottom to top
                    topHalf.add(bottomHalf.remove());
                }else if (topHalf.size() - bottomHalf.size() == 2){
                    //shift one element from top to bottom
                    bottomHalf.add(topHalf.remove());
                }

                //update median value
                if (bottomHalf.size() > topHalf.size()){
                    median = bottomHalf.peek();
                }else if (topHalf.size() > bottomHalf.size()){
                    median = topHalf.peek();
                }else{
                    median = (topHalf.peek() + bottomHalf.peek()) / 2.0;
                }
            }
        }
    }
}
