package Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/13 下午12:10
 * @description 优先队列
 **/
public class 优先队列 {
    public static void main(String[] args) {
        var priorityQueue = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));
        var list = new ArrayList<Integer>();
        var random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        priorityQueue.addAll(list);
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
