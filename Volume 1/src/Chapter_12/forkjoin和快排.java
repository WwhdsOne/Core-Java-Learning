package Chapter_12;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/4 15:15
 * @description forkjoin快排
 **/
public class forkjoin和快排 {
    private static final int Size = 100000000;
    private static final Random r = new Random();

    public static void main(String[] args) {
        var arr = new int[Size];
        for (int i = 0; i < Size; i++) {
            arr[i] = r.nextInt(Size);
        }

        // System.out.println("排序前:"+ Arrays.toString(arr));
        QuickSort quickSort = new QuickSort(arr, 0, arr.length - 1);
        var pool = new ForkJoinPool();
        LocalDateTime begin = LocalDateTime.now();
        // 并发快排，不使用线程池也可以
        pool.invoke(quickSort);
        LocalDateTime end = LocalDateTime.now();
        // System.out.println("排序后:"+ Arrays.toString(arr));
        System.out.println("耗时：" + ChronoUnit.MILLIS.between(begin, end) + "毫秒");
    }
}

class QuickSort extends RecursiveAction {

    private final int[] arr;

    private final int left;

    private final int right;

    private static Random random = new Random();

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public QuickSort(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left >= right) {
            return;
        }
        int x = arr[left + right >> 1];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            do
                i++;
            while (arr[i] < x);
            do
                j--;
            while (arr[j] > x);
            if (i < j) {
                swap(i, j);
            }
        }
        QuickSort leftTask = new QuickSort(arr, left, j);
        QuickSort rightTask = new QuickSort(arr, j + 1, right);
        invokeAll(leftTask, rightTask);
    }
}
